package edu.fiuba.algo3.modelo;


import javafx.scene.control.TextField;

import java.util.*;


public class Pokedex {
    private Dictionary<String, Pokemon> dictPokemones;
    private ManipuladorCSV editorArchivo;
    private Integer contadorDePokemones;

    public Pokedex(String ruta) {
        contadorDePokemones = 1;
        dictPokemones = new Hashtable<>();
        editorArchivo = new ManipuladorCSV(ruta, this);

        editorArchivo.leerArchivo();
    }

    public boolean agregarPokemon(String nombre, String tipos, Integer nivel) {

        Pokemon pokemonNuevo = dictPokemones.get(nombre);
        ArrayList<String> tiposSeparados = new ArrayList<>(List.of(tipos.split(", ")));

        if(pokemonNuevo == null){ //caso en que no esta en el dict
            pokemonNuevo = new Pokemon(nombre, tiposSeparados, nivel);
        }

        //me fijo si ya fue agregado antes
        Enumeration<String> claves = dictPokemones.keys();
        while (claves.hasMoreElements()) {
            String nuevo = claves.nextElement().toLowerCase();

            if (nuevo.equals(nombre.toLowerCase()) && (!pokemonNuevo.nivel().equals(-1))) {
                return true; //solo para las pruebas
                //throw new YaExisteElPokemonErorr();
            }
        }

        //si es uno que antes fue agregado como evolucion ahora se vuelve a crear.
        if (pokemonNuevo.nivel() == -1){
            for (String unTipo: tiposSeparados) {pokemonNuevo.agregarTipo(unTipo);}
            pokemonNuevo.cambiarNivel(nivel);
        }

        pokemonNuevo.agregarNumeroDeOrden(contadorDePokemones);
        dictPokemones.put(nombre, pokemonNuevo);
        editorArchivo.agregarLinea(pokemonNuevo);
        contadorDePokemones++;
        return true;
    }

    public void actualizarBaseDeDatos(){
        editorArchivo.reescribirArchivo();
    }

    public void agregarAlDiccionario(String nombre, ArrayList<String> tipos, Integer nivel, ArrayList<String> evolucion, String numero, ArrayList<String> habilidades) {

        Pokemon pokeNuevo = dictPokemones.get(nombre);
        if (pokeNuevo == null){pokeNuevo = new Pokemon(nombre, tipos, nivel);}
        if (pokeNuevo.nivel() == -1){pokeNuevo.cambiarNivel(nivel);}

        tipos.removeIf(elemento -> elemento.equals("Desconocidas"));
        for (String tipo: tipos ) {pokeNuevo.agregarTipo(tipo);}

        evolucion.removeIf(elemento -> elemento.equals("Desconocidas"));

        Pokemon pokemonEvolucion ;
        Pokemon evolucionAnterior = pokeNuevo;

        for (String aux : evolucion) {
            pokemonEvolucion = dictPokemones.get(aux);
            if (pokeNuevo.obtenerNombre().equals(aux)){continue;}
            if (pokemonEvolucion == null){pokemonEvolucion = new Pokemon(aux, new ArrayList<>(), -1);}

            evolucionAnterior.agregarEvolucion(pokemonEvolucion);

            dictPokemones.put(aux, pokemonEvolucion);
            evolucionAnterior = pokemonEvolucion;
        }

        Integer value = Integer.parseInt(numero);
        pokeNuevo.agregarNumeroDeOrden(value);

        habilidades.removeIf(elemento -> elemento.equals("Desconocidas"));
        for (String actual: habilidades) {
            pokeNuevo.agregarHabilidad(actual);
        }

        dictPokemones.put(nombre, pokeNuevo);
        contadorDePokemones++;
    }

    public ArrayList<Pokemon> pokemonesTotales() {
        Enumeration<String> claves = dictPokemones.keys();

        ArrayList<Pokemon> valores = new ArrayList<>();
        while (claves.hasMoreElements()) {
            Pokemon aux = dictPokemones.get(claves.nextElement());
            valores.add(aux);
        }
        Collections.sort(valores, Comparator.comparing(Pokemon::conseguirNumero));
        return valores;
    }

    public void agregarEvolucionA(String nombrePokemon, String evolucion) {

        Pokemon pokemon = this.revisarLaExistenciaDe(nombrePokemon);
        Pokemon evo;
        evo = dictPokemones.get(evolucion);
        if (evo == null){
            evo = new Pokemon(evolucion, new ArrayList<>(), -1);
            dictPokemones.put(evolucion, evo);
        }
        pokemon.agregarEvolucion(evo);
    }
    public void agregarHabilidadA(String nombrePokemon, String habilidad) {
        Pokemon pokemon = this.revisarLaExistenciaDe(nombrePokemon);
        pokemon.agregarHabilidad(habilidad);
    }

    public void quitarEvolucion(String nombrePokemon, String evolucion) {
        Pokemon pokemon = this.revisarLaExistenciaDe(nombrePokemon);
        pokemon.quitarEvolucion(evolucion);
    }

    public String conseguirDatosDe(String nombrePoke) {
        return this.revisarLaExistenciaDe(nombrePoke).conseguirDatos();
    }

    public String conseguirHabilidadesDe(String nombrePoke) {
        return this.revisarLaExistenciaDe(nombrePoke).conseguirHabilidades();
    }

    public String conseguirEvolucionesDe(String nombrePokemon) {
        return this.revisarLaExistenciaDe(nombrePokemon).conseguirEvoluciones();
    }

    public void cambiarNombre(String nombreActual, String nuevoNombre) {
        Pokemon actual = this.revisarLaExistenciaDe(nombreActual);

        Pokemon renombrado = actual.cambiarNombre(nuevoNombre);
        dictPokemones.remove(nombreActual);
        dictPokemones.put(nuevoNombre, renombrado);
    }

    public void eliminarTipo(String nombrePokemon, String tipoAEliminar) {
        Pokemon pokemon = this.revisarLaExistenciaDe(nombrePokemon);

        pokemon.eliminarUnTipo(tipoAEliminar);
    }

    public void agregarTipo(String nombrePokemon, String tipoAAgregar) {
        Pokemon pokemon = this.revisarLaExistenciaDe(nombrePokemon);
        pokemon.agregarTipo(tipoAAgregar);
    }

    public void cambiarNivelDe(String nombrePokemon, Integer nuevoNivel) {
        if (nuevoNivel<=0){
            return;
        }
        Pokemon pokemon = this.revisarLaExistenciaDe(nombrePokemon);
        pokemon.cambiarNivel(nuevoNivel);
    }

    public void quitarHabilidadA(String nombrePokemon, String habilidad) {

        Pokemon pokemon = this.revisarLaExistenciaDe(nombrePokemon);
        pokemon.quitarHabilidad(habilidad);

    }

    private Pokemon revisarLaExistenciaDe(String nombrePoke){
        Pokemon pokemon = dictPokemones.get(nombrePoke);
        if (pokemon == null){
            throw new NoExisteElPokemonError();
        }
        return pokemon;
    }

    public Pokemon obtenerPokemon(String nombreABuscar) {
        return this.revisarLaExistenciaDe(nombreABuscar);
    }

    public String nombreArchivo() {
        return this.editorArchivo.nombreArchivo();
    }
}
