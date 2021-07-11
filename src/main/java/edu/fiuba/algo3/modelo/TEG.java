package edu.fiuba.algo3.modelo;

public class TEG {
    private Paises paises;

    public TEG() {
        //aca los paises inicializados.
    }

    public atacarConA(Jugador atacante, Pais ataque, Pais defensa){
        atacante.atacarDeA(ataque, defensa);
    }
}
