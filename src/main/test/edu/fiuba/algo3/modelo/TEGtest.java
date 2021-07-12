package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class TEGtest {
    @Test
    public void atacarPaises(){
        TEG teg = new TEG();
        Jugador albiceleste = new Jugador();

        teg.atacarConA(albiceleste, "Argentina", "Brasil", 2);
        assertEquals(1, teg.cantidadDeEjercitosDe("Brasil"));
    }
    @Test
    public void atacarPaisesFalse(){
        TEG teg = new TEG();
        Jugador albiceleste = new Jugador();

        teg.atacarConA(albiceleste, "Argentina", "Brasil", 2);
        assertNotEquals(2, teg.cantidadDeEjercitosDe("Brasil"));
    }
}
