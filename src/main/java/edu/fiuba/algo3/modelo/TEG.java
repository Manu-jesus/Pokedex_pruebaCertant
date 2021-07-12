package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.lang.String;

public class TEG {
    private ArrayList<Pais> paises;

    public TEG() {
        Pais Arg = new Pais( 'Argentina', 2);
        Pais Bra = new Pais('Brasil', 2);
        Bra.agregarPaisLimitrofes(Arg);
        Arg.agregarPaisLimitrofes(Bra);
        paises.add(Arg);
        paises.add(Bra);
    }

    public void atacarConA(Jugador atacante, String ataque, String defensa, int cantEjercitos){
        Pais paisAtacante = this.buscarPais(ataque);
        Pais paisDefensor = this.buscarPais(defensa);
        atacante.atacarDeA(paisAtacante, paisDefensor, cantEjercitos);
    }
    
    private Pais buscarPais(String nombrePais){
        for (int i = 0; i < this.paises.size(); i++) {
            if (this.paises(i).compararNombres(nombrePais)){
                return this.paises(i);
            };
        };
        //no existe pais!
    }
}
