package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pokemon {
    private String nombre;
    private  ArrayList<String> tipo;
    private Integer nivel;
    private ArrayList<String> evoluciones;
    private Integer numeroDeOrden;

    public Pokemon (String nombre, ArrayList<String> tipos, Integer nivel){
        this.nombre = nombre;
        this.tipo = new ArrayList<>(tipos);
        this.evoluciones = new ArrayList<>();
        this.nivel = nivel;
    }

    public String nombre() { return nombre;}

    public String lineaAEscribir(){
        return numeroDeOrden + " , " + nombre + " , " + this.obtenerEnCadena(tipo) + " , " + nivel + " , " + this.obtenerEnCadena(evoluciones) + "\n";
    }

    private String obtenerEnCadena(ArrayList<String> tipo) {
        StringBuilder returnable = new StringBuilder("null");
        for (int i = 0; i < tipo.size(); i++) {
            if (i == 0){
                returnable = new StringBuilder(tipo.get(i));
                continue;
            }
            returnable.append(" - ").append(tipo.get(i));
        }

        return returnable.toString();
    }

    public void agregarNumeroDeOrden(Integer contadorDePokemones) {
        numeroDeOrden = contadorDePokemones;
    }

    public void agregarEvolucion(String evolucion) {
        this.evoluciones.add(evolucion);
    }

    public Integer conseguirNumero() {
        return numeroDeOrden;
    }

    public void quitarEvolucion(String evolucion) {
        this.evoluciones.remove(evolucion);
    }
}
