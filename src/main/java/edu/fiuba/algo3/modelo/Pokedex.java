package edu.fiuba.algo3.modelo;


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

        Pokemon pokemonNuevo = new Pokemon(nombre, new ArrayList<>(List.of(tipos.split(", "))), nivel);

        pokemonNuevo.agregarNumeroDeOrden(contadorDePokemones);
        Enumeration<String> claves = dictPokemones.keys();

        while (claves.hasMoreElements())
            if (claves.nextElement().toLowerCase() == (pokemonNuevo.nombre().toLowerCase())) {
                throw new YaExisteElPokemonErorr();
            }
        dictPokemones.put(nombre, pokemonNuevo);
        contadorDePokemones++;
        return true;
    }

    public void actualizarBaseDeDatos(){
        editorArchivo.escribirArchivo();
    }

    public void agregarAlDiccionario(String nombre, ArrayList<String> tipos, Integer nivel, ArrayList<String> evolucion, String numero) {

        Pokemon pokeNuevo = new Pokemon(nombre, tipos, nivel);
        for (String aux : evolucion) {
            pokeNuevo.agregarEvolucion(aux);
        }

        Integer value = Integer.parseInt(numero) ;
        pokeNuevo.agregarNumeroDeOrden(value);

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
        return valores;
    }

    public void agregarEvolucion(String nombrePokemon, String evolucion) {
        Pokemon pokemon = dictPokemones.get(nombrePokemon);

        if (pokemon == null){
            throw new NoExisteElPokemonError();
        }
        pokemon.agregarEvolucion(evolucion);
    }

    public void quitarEvolucion(String nombrePokemon, String evolucion) {
        Pokemon pokemon = dictPokemones.get(nombrePokemon);
        pokemon.quitarEvolucion(evolucion);
    }
}
