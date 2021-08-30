package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class pokedexTest {
    private Pokedex pokedex;

    @BeforeEach
    public void pokedex(){
        pokedex = new Pokedex("pokem.csv");
    }

    @Test
    public void agregarPokemonesSeEjecutaDeManeraCorrecta(){

        //assertTrue(pokedex.agregarPokemon("Pikachu", "trueno", 5));
        //pokedex.agregarEvolucion("Pikachu", "Raichu");

        //assertTrue(pokedex.agregarEvolucion("Gyarados", "GryadosMejorado"));
        //pokedex.agregarEvolucion("Gyarados", "otroMas");

        //assertTrue(pokedex.agregarPokemon("Chaizar", "Fuego", 6));

    }

    @Test
    public void conseguirLosDatosDeLosPokemones() {


        //assertEquals(pokedex.conseguirDatosDe("Pikachu"), "");
    }

    @AfterEach
    public void finalmente(){
        pokedex.actualizarBaseDeDatos();
    }
}
