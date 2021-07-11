package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Pais{
    private int cantidadDeEjercitos;
    private final ArrayList<Pais> paisesLimitrofes;

    public Pais(int cantEjercitos){
        this.cantidadDeEjercitos
    }

    public atacarA(Pais defensor, int n){
        if (!this.esPaisLimitrofe(defensor)){
            return;
        };
        Dados dados = new Dados();
        dados.tirarVeces(n);

        defensor.defenderseDe(dados, n);
    }

    private boolean esPaisLimitrofe(Pais p){
        return p in paises;
    }

    public void defenderseDe(Dados dados1){ //no sabemos cuantas veces tira dados el defensor
        Dados dados2 = new Dados();
        dados2.tirarVeces(n);

        int ejercitosPerdidosPorElDefensor = dados2.comparar(dados1);
        ejercitos -= ejercitosPerdidosPorElDefensor;
    }
}
