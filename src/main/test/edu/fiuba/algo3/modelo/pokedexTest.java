package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class pokedexTest {
    private Pokedex pokedex;

    @BeforeEach
    public void ejecutarPokedex(){pokedex = new Pokedex("poke.csv");}

    @Test
    public void agregarPokemonesSeEjecutaDeManeraCorrecta(){
        assertTrue(pokedex.agregarPokemon("Pikachu", "electrico", 5));

        assertTrue(pokedex.agregarPokemon("Pichu", "electrico", 5));

        assertTrue(pokedex.agregarPokemon("Raichu", "electrico", 5));

        assertTrue(pokedex.agregarPokemon("Magikarp", "Agua", 20));

        assertTrue(pokedex.agregarPokemon("Bulbasaur", "Planta, Veneno", 6));

        assertTrue(pokedex.agregarPokemon("Ivysaur", "Planta, Veneno", 6));

        assertTrue(pokedex.agregarPokemon("Venusaur", "Planta, Veneno", 6));

        assertTrue(pokedex.agregarPokemon("Charmander", "Fuego", 6));

        assertTrue(pokedex.agregarPokemon("Charmeleon", "Fuego", 6));

        assertTrue(pokedex.agregarPokemon("Charizard", "Fuego", 6));

        assertTrue(pokedex.agregarPokemon("Totodile", "Agua", 6));

        assertTrue(pokedex.agregarPokemon("Croconaw", "Agua", 6));

        assertTrue(pokedex.agregarPokemon("Feraligatr", "Agua", 6));

    }

    @Test
    public void conseguirLosDatosDeLosPokemones() {
        //Pikachu

        String datos = pokedex.conseguirDatosDe("Pikachu");
        //System.out.println(datos);
        assertEquals(datos, "Nombre: Pikachu\nTipo: trueno\nNivel: 5");

        //Agrego las habilidades.
        pokedex.agregarHabilidadA("Pikachu", "Inpactrueno");
        pokedex.agregarHabilidadA("Pikachu", "Corrida Mortal");

        //System.out.println(habili);
        assertEquals(pokedex.conseguirHabilidadesDe("Pikachu"), "Habilidades: " +
                "Inpactrueno, Corrida Mortal");

        pokedex.agregarHabilidadA("Chaizar", "Bola De Fuego");

        assertEquals(pokedex.conseguirHabilidadesDe("Chaizar"), "Habilidades: " +
                "Bola De Fuego");

        //Actualizo la base de datos.
        pokedex.actualizarBaseDeDatos();
    }

    @Test
    public void conseguirLasEvoluciones(){
        //Magikarp
        //Sin evoluciones.
        //System.out.println(pokedex.conseguirEvolucionesDe("Magikarp"));
        //assertEquals(pokedex.conseguirEvolucionesDe("Magikarp"), "Evoluciones:" +
        //       "\nNombre: Magikarp\nTipo: Agua\nNivel: 20");

        //Con una evolucion.
        pokedex.agregarEvolucionA("Magikarp", "Gyarados");

        assertTrue(pokedex.agregarPokemon("Gyarados", "Agua, Volador", 5));


        //System.out.println(pokedex.conseguirEvolucionesDe("Magikarp"));
        assertEquals(pokedex.conseguirEvolucionesDe("Magikarp"), "Evoluciones:" +
                "\nNombre: Magikarp\nTipo: Agua\nNivel: 20" +
                "\nNombre: Gyarados\nTipo: Agua, Volador\nNivel: 5");

        assertEquals(pokedex.conseguirEvolucionesDe("Gyarados"), "Evoluciones:" +
                "\nNombre: Magikarp\nTipo: Agua\nNivel: 20" +
                "\nNombre: Gyarados\nTipo: Agua, Volador\nNivel: 5");


        //AHORA PRUEBO CON PTRPS POKEMONES YA AGREGADOS

        pokedex.agregarEvolucionA("Bulbasaur", "Ivysaur");


        //System.out.println(pokedex.conseguirEvolucionesDe("Magikarp"));
        //assertEquals(pokedex.conseguirEvolucionesDe("Bulbasaur"), "Evoluciones:" +
        //        "\nNombre: Bulbasaur\nTipo: Planta, Veneno\nNivel: 6" +
        //        "\nNombre: Ivysaur\nTipo: Planta, Veneno\nNivel: 6");

        pokedex.agregarEvolucionA("Ivysaur", "Venusaur");

        assertEquals(pokedex.conseguirEvolucionesDe("Bulbasaur"), "Evoluciones:" +
                "\nNombre: Bulbasaur\nTipo: Planta, Veneno\nNivel: 6" +
                "\nNombre: Ivysaur\nTipo: Planta, Veneno\nNivel: 6" +
                "\nNombre: Venusaur\nTipo: Planta, Veneno\nNivel: 6");


        pokedex.agregarPokemon("Raichu", "Rayo", 15);
        pokedex.agregarEvolucionA("Pikachu", "Raichu");

        assertEquals(pokedex.conseguirEvolucionesDe("Pikachu"), "Evoluciones:" +
                "\nNombre: Pikachu\nTipo: trueno\nNivel: 5" +
                "\nNombre: Raichu\nTipo: Rayo\nNivel: 15");

        pokedex.actualizarBaseDeDatos();
    }

    @Test
    public void pruebaCambiarDeNombre(){

        //System.out.println(datos);
        assertEquals(pokedex.conseguirDatosDe("Pikachu"),
                "Nombre: Pikachu\nTipo: trueno\nNivel: 5");

        pokedex.cambiarNombre("Pikachu", "Manuel");

        //Agrego las habilidades.
        //pokedex.agregarHabilidadA("Manuel", "Comer");

        //Tiene los mismos datos
        assertEquals(pokedex.conseguirDatosDe("Manuel"),
                "Nombre: Manuel\nTipo: trueno\nNivel: 5");

        //Tiene las mismas habilidades
        assertEquals(pokedex.conseguirHabilidadesDe("Manuel"), "Habilidades: " +
                "Inpactrueno, Corrida Mortal");

        //Tiene las mismas evoluciones
        assertEquals(pokedex.conseguirEvolucionesDe("Magikarp"), "Evoluciones:" +
                "\nNombre: Magikarp\nTipo: Agua\nNivel: 20" +
                "\nNombre: Gyarados\nTipo: Agua, Volador\nNivel: 5");

        //Actualizo la base de datos.
        pokedex.actualizarBaseDeDatos();
    }
    @Test
    public void pruebaEliminarUnTipoYTodoSigueEjecutandoseBien(){

        //Prueba pre.
        assertEquals(pokedex.conseguirDatosDe("Magikarp"),
                "Nombre: Magikarp\nTipo: Agua\nNivel: 20");

        pokedex.eliminarTipo("Magikarp", "Agua");

        //Cambia los tipos que es el pokemon.
        assertEquals(pokedex.conseguirDatosDe("Magikarp"),
                "Nombre: Magikarp\nTipo: Desconocidas\nNivel: 20");

        //Tiene las mismas habilidades
        assertEquals(pokedex.conseguirHabilidadesDe("Magikarp"), "Habilidades: Desconocidas");

        //Tiene las mismas evoluciones
        assertEquals(pokedex.conseguirEvolucionesDe("Magikarp"), "Evoluciones:" +
                "\nNombre: Magikarp\nTipo: Desconocidas\nNivel: 20" +
                "\nNombre: Gyarados\nTipo: Agua, Volador\nNivel: 5");

        //Actualizo la base de datos.
        pokedex.actualizarBaseDeDatos();
    }

    @Test
    public void cambiarElNivel(){
        //Prueba pre.
        assertEquals(pokedex.conseguirDatosDe("Chaizar"),
                "Nombre: Chaizar\nTipo: Fuego\nNivel: 6");

        pokedex.cambiarNivelDe("Chaizar", 9);

        //Cambia los tipos que es el pokemon.
        assertEquals(pokedex.conseguirDatosDe("Chaizar"),
                "Nombre: Chaizar\nTipo: Fuego\nNivel: 9");

        //Tiene las mismas habilidades
        assertEquals(pokedex.conseguirHabilidadesDe("Chaizar"), "Habilidades: " +
                "Bola De Fuego");

        //Tiene las mismas evoluciones
        assertEquals(pokedex.conseguirEvolucionesDe("Chaizar"), "Evoluciones:" +
                "\nNombre: Chaizar\nTipo: Fuego\nNivel: 9" );

        //Actualizo la base de datos.
        pokedex.actualizarBaseDeDatos();
    }

    @Test
    public void regresoAlaNormalidad(){
        //pokedex.cambiarNombre("Manuel", "Pikachu");
        pokedex.agregarTipo("Magikarp", "Agua");
        pokedex.cambiarNivelDe("Chaizar", 6);

        pokedex.actualizarBaseDeDatos();
    }
}
