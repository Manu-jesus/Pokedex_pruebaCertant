package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pokemon {
    private String nombre;
    private ArrayList<String> tipo;
    private Integer nivel;
    private ArrayList<Pokemon> evoluciones;
    private ArrayList<String> habilidades;
    private Integer numeroDeOrden;

    public Pokemon (String nombre, ArrayList<String> tipos, Integer nivel){
        this.nombre = nombre;
        this.tipo = new ArrayList<>(tipos);
        this.habilidades = new ArrayList<>();
        this.evoluciones = new ArrayList<>();
        this.evoluciones.add(this);
        this.nivel = nivel;
    }

    public String lineaAEscribir(){
        ArrayList <String> cadenaDeEvoluciones = new ArrayList<>();
        for (Pokemon evo: evoluciones) {
            cadenaDeEvoluciones.add(evo.nombre);
        }
        return numeroDeOrden + ", " + nombre + ", " + this.obtenerEnCadena(tipo, " - ") + ", " + nivel + ", " + this.obtenerEnCadena(cadenaDeEvoluciones, " - ") + ", " + this.obtenerEnCadena(habilidades, " - ") + "\n";
    }


    private String obtenerEnCadena(ArrayList<String> tipo, String separador) {
        StringBuilder returnable = new StringBuilder("Desconocidas");
        for (int i = 0; i < tipo.size(); i++) {
            if (i == 0){
                returnable = new StringBuilder(tipo.get(i));
                continue;
            }
            returnable.append(separador).append(tipo.get(i));
        }

        return returnable.toString();
    }

    public void agregarNumeroDeOrden(Integer contadorDePokemones) {
        numeroDeOrden = contadorDePokemones;
    }

    public void agregarEvolucion(Pokemon evolucion) {

        int j = 0;

        for (Pokemon aux: evoluciones) {
            if (aux.nombre.equals(this.nombre)){j=evoluciones.indexOf(aux);}
            if (aux.nombre.equals(evolucion.nombre)){return;}
        }
        this.evoluciones.add(j+1, evolucion);

        for (Pokemon actual : evoluciones) {
            if (actual.nombre.equals(this.nombre)){continue;}
            actual.actualizasEvoluciones(evoluciones);
        }
    }

    private void actualizasEvoluciones(ArrayList<Pokemon> datosACopiar) {
        evoluciones.clear();
        evoluciones.addAll(datosACopiar);
    }

    public void agregarHabilidad(String habilidad) {
        if(habilidades.contains(habilidad)){return;}
        this.habilidades.add(habilidad);
    }

    public Integer conseguirNumero() {
        return numeroDeOrden;
    }

    public void quitarEvolucion(String evolucion) {
        this.evoluciones.remove(evolucion);
    }

    public String conseguirDatos() {
        return "Nombre: " + nombre + "\n" + "Tipo: " + this.obtenerEnCadena(tipo, ", ") + "\n"+ "Nivel: " + nivel;
    }

    public String conseguirHabilidades() {
        return "Habilidades: " + this.obtenerEnCadena(habilidades, ", ");
    }

    public String conseguirEvoluciones() {
        StringBuilder returnable = new StringBuilder("Evoluciones:");

        for (Pokemon evo: evoluciones) {
            returnable.append("\n");
            returnable.append(evo.conseguirDatos());
        }
        return returnable.toString();
    }

    public void agregarTipo(String elemento) {
        if (this.tipo.contains(elemento)){return;}
        this.tipo.add(elemento);
    }

    public Integer nivel() {return nivel;}

    public void cambiarNivel(Integer nivel) { this.nivel = nivel;}

    public Pokemon cambiarNombre(String nuevoNombre) {
        this.nombre = nuevoNombre;
        return this;
    }

    public void eliminarUnTipo(String tipoAEliminar) {
        if (!tipo.contains(tipoAEliminar)){
            throw new ElTipoNoSeEncontroError();
        }
        tipo.remove(tipoAEliminar);
    }
}
