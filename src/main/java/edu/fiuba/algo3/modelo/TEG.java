package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.lang.String;

public class TEG {
    private final ArrayList<Pais> paises;

    public TEG() {
        paises = new ArrayList<Pais>();
        Pais Arg = new Pais("Argentina", 3);
        Pais Bra = new Pais("Brasil", 2);
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

    public int cantidadDeEjercitosDe(String nombrePais){
        Pais pais = this.buscarPais(nombrePais);
        return pais.cantidadDeEjercitos();
    }

    private Pais buscarPais(String nombrePais){
        for (int i = 0; i < this.paises.size(); i++) {
            if (this.paises.get(i).compararNombre(nombrePais)){
                return this.paises.get(i);
            };
        };
        return this.paises.get(0);
    }

}
