package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Dados {
    //private boolean esAtacante;
    private ArrayList<int> tirada;

    public Dados(int n){
        this.tirarVeces(n);
    }

    public void tirarVeces(int n){
        ArrayList<int> datos = new ArrayList<int>();
        for (int i = 0; i < n; i++) {
            datos.add(Math.floor(Math.random()*5+1));
        }
        this.tirada = datos;
    }

    public int comparar( Dados dados2){
        ArrayList<int> second = dados2.obtenerTiros();
        Collections.sort(this.tirada, Collections.reverseOrder());
        Collections.sort(second, Collections.reverseOrder())

        int ejercitosPerdidos = 0;
        int i = 0;
        while(){
            if(this.tirada(i) < second(i)){
                ejercitosPerdidos += 1;
            }
        }
        return ejercitosPerdidos;
    }

    private ArrayList<int> obtenerTiros(){
        return this.tirada;
    }
}
