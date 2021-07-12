package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dados {
    //private boolean esAtacante;
    private int[] tirada;

    public Dados(int n){
        tirada = new int[3];
        this.tirarVeces(n);
    }

    public void tirarVeces(int n){
        //int[] datos = [n];
        /*for (int i = 0; i < n; i++) {
            datos.add(Math.floor(Math.random()*5+1));
        }*/
        //datos[0] = n;
        this.tirada[0] = n;
    }

    public int comparar( Dados dados2){
        int[] second = dados2.obtenerTiros();
        //List.sort(this.tirada);
        //List.sort(second);

        int ejercitosPerdidos = 0;
        int i = 0;
        while(i<1){
            if(this.tirada[i] < second[i]){
                ejercitosPerdidos += 1;
            }
            i++;
        }
        return ejercitosPerdidos;
    }

    private int[] obtenerTiros(){
        return this.tirada;
    }
}
