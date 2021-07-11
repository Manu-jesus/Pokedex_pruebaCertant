package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Dados {
    private ArrayList<int> tirada;

    public Dados()
    public void tirarVeces(int n){
        List<int> datos = new ArrayList<int>();
        for (int i = 0; i < n; i++) {
            datos.add(Math.floor(Math.random()*5+1));
        }
        this.tirada = datos;
    }

    public int comparar( ArrayList<int> second, ){
        Collections.sort(this.tirada, Collections.reverseOrder());
        Collections.sort(second, Collections.reverseOrder())

        int ejerPerdidos = 0;
        int i = 0
        while(){
            if(first(i) < second(i)){
                ejerPerdidos += 1;
            }
        }
    }
}
