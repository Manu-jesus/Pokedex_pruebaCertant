package edu.fiuba.algo3.modelo;

public class Jugador {

    public void atacarDeA(Pais atacante, Pais defensor, int cantidadEjercitos){
        //if (!this.estaPais(atacante)){ return };
        atacante.atacarA(defensor, cantidadEjercitos);
    }

    //private boolean estaPais(Pais p){
        //return (if p paises);
    //}
}
