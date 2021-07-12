package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.lang.String;

public class Pais{
    private final String nombre;
    private int ejercitos;
    private final ArrayList<Pais> paisesLimitrofes;

    public Pais(String nombre, int cantEjercitos){
        this.nombre = nombre;
        this.ejercitos = cantEjercitos;
        this.paisesLimitrofes = new ArrayList<>();
    }

    public boolean compararNombre(String nombre){
        return (this.nombre.equals(nombre));
    }

    public void agregarPaisLimitrofes(Pais p){
        this.paisesLimitrofes.add(p);
    }
    public void atacarA(Pais defensor, int n){
        if (!this.esPaisLimitrofe(defensor)){
            return; //Error
        };
        Dados dados1 = new Dados(n);
        //dados.tirarVeces(n);

        Dados dados2 = defensor.defenderseDe(dados1, n);
        int ejercitosPerdidosPorElDefensor = dados1.comparar(dados2);
        ejercitos -= ejercitosPerdidosPorElDefensor;
    }

    private boolean esPaisLimitrofe(Pais p){
        return paisesLimitrofes.contains(p);
    }

    public Dados defenderseDe(Dados dados1, int n){
        Dados dados2 = new Dados(n-1);
        //dados2.tirarVeces(n);

        int ejercitosPerdidosPorElDefensor = dados2.comparar(dados1);
        ejercitos -= ejercitosPerdidosPorElDefensor;
        return dados2;
    }

    public int cantidadDeEjercitos(){
        return ejercitos;
    }
}
