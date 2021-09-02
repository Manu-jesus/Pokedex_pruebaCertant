package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class pokedexTest {
    private Pokedex pokedex;

    @BeforeEach
    public void ejecutarPokedex(){
        pokedex = new Pokedex("pokemones.csv");

        assertTrue(pokedex.agregarPokemon("Pichu", "Electrico", 5));

        assertTrue(pokedex.agregarPokemon("Pikachu", "Electrico", 5));

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

        assertEquals(datos, "Nombre: Pikachu\nTipo: Electrico\nNivel: 5");

        //No es mecesario actualizar la base de datos.
    }

    @Test
    public void sePuedenAgregarYQuitarHabilidadesALosPokemones(){

        //Agrego las habilidades.
        pokedex.agregarHabilidadA("Pikachu", "Inpactrueno");
        pokedex.agregarHabilidadA("Pikachu", "Ataque Rapido");

        //System.out.println(habili);
        assertEquals(pokedex.conseguirHabilidadesDe("Pikachu"), "Habilidades: " +
                "Inpactrueno, Ataque Rapido");

        //Vuelvo a agregar otra habilidad
        pokedex.agregarHabilidadA("Pikachu", "Bola De Fuego");

        assertEquals(pokedex.conseguirHabilidadesDe("Pikachu"), "Habilidades: " +
                "Inpactrueno, Ataque Rapido, Bola De Fuego");

        //Elimino alguna habilidad
        pokedex.quitarHabilidadA("Pikachu", "Bola De Fuego");

        assertEquals(pokedex.conseguirHabilidadesDe("Pikachu"), "Habilidades: " +
                "Inpactrueno, Ataque Rapido");

        //Agrego otras habilidades.

        //A Magikarp.
        pokedex.agregarHabilidadA("Magikarp", "Salpicadura");
        pokedex.agregarHabilidadA("Magikarp", "Placaje");

        assertEquals(pokedex.conseguirHabilidadesDe("Magikarp"), "Habilidades: " +
                "Salpicadura, Placaje");

        //A Bulbasaur.
        pokedex.agregarHabilidadA("Bulbasaur", "Latigo Cepa");
        pokedex.agregarHabilidadA("Bulbasaur", "Placaje");
        pokedex.agregarHabilidadA("Bulbasaur", "Hoja Afilada");

        assertEquals(pokedex.conseguirHabilidadesDe("Bulbasaur"), "Habilidades: " +
                "Latigo Cepa, Placaje, Hoja Afilada");

        //A Charizard.
        pokedex.agregarHabilidadA("Charizard", "Ataque Ala");
        pokedex.agregarHabilidadA("Charizard", "Garra Dragon");

        assertEquals(pokedex.conseguirHabilidadesDe("Charizard"), "Habilidades: " +
                "Ataque Ala, Garra Dragon");

        //Actualizo la base de datos.
        pokedex.actualizarBaseDeDatos();
    }

    @Test
    public void conseguirLasEvoluciones(){
        //Consideraciones iniciales:

        //1): Un Pokemon no puede tener dos evoluciones.
        //2): Dos Pokemones diferentes no pueden evolucionar a un mismo pokemon.

        //Magikarp
        //Sin evoluciones.

        //Solo pasa una vez;
        //assertEquals(pokedex.conseguirEvolucionesDe("Magikarp"), "Evoluciones:" +
        //       "\nNombre: Magikarp\nTipo: Agua\nNivel: 20");

        //Con una evolucion.
        pokedex.agregarEvolucionA("Magikarp", "Gyarados");

        //Agrego el nuevo pokemon despues, aún así deberia funcionar bien.
        assertTrue(pokedex.agregarPokemon("Gyarados", "Agua, Volador", 5));

        String actual = "Evoluciones:" +
                "\nNombre: Magikarp\nTipo: Agua\nNivel: 20" +
                "\nNombre: Gyarados\nTipo: Agua, Volador\nNivel: 5";

        assertEquals(pokedex.conseguirEvolucionesDe("Magikarp"), actual);

        //Las evoluciones del otro pokemon deberian ser las mismas.
        assertEquals(pokedex.conseguirEvolucionesDe("Gyarados"), actual);


        //AHORA PRUEBO CON OTROS POKEMONES PREVIAMENTE AGREGADOS

        //Agrego la evolución de dos pokemones que son evolucion
        pokedex.agregarEvolucionA("Bulbasaur", "Ivysaur");
        pokedex.agregarEvolucionA("Ivysaur", "Venusaur");


        //Los tres deberían tener las mismas evoluciones.
        actual = "Evoluciones:" +
                "\nNombre: Bulbasaur\nTipo: Planta, Veneno\nNivel: 6" +
                "\nNombre: Ivysaur\nTipo: Planta, Veneno\nNivel: 6" +
                "\nNombre: Venusaur\nTipo: Planta, Veneno\nNivel: 6";

        assertEquals(pokedex.conseguirEvolucionesDe("Bulbasaur"), actual);

        assertEquals(pokedex.conseguirEvolucionesDe("Ivysaur"), actual);

        assertEquals(pokedex.conseguirEvolucionesDe("Venusaur"), actual);


        //Debería funcionar con otros Pokemones.
        //Agrego a la evolución de Pikachu y Pichu, además los agrego en forma inversa.
        pokedex.agregarPokemon("Raichu", "Electrico", 15);

        pokedex.agregarEvolucionA("Pikachu", "Raichu");
        pokedex.agregarEvolucionA("Pichu", "Pikachu");

        actual = "Evoluciones:" +
                "\nNombre: Pichu\nTipo: Electrico\nNivel: 5" +
                "\nNombre: Pikachu\nTipo: Electrico\nNivel: 5" +
                "\nNombre: Raichu\nTipo: Electrico\nNivel: 15" ;

        assertEquals(pokedex.conseguirEvolucionesDe("Pichu"), actual);

        assertEquals(pokedex.conseguirEvolucionesDe("Pikachu"), actual);

        assertEquals(pokedex.conseguirEvolucionesDe("Raichu"), actual);

        pokedex.actualizarBaseDeDatos();

        //Agrego las evoluciones de charmander, charmeleon, charizard.
        pokedex.agregarEvolucionA("Charmander", "Charmeleon");
        pokedex.agregarEvolucionA("Charmeleon", "Charizard");

        actual = "Evoluciones:" +
                "\nNombre: Charmander\nTipo: Fuego\nNivel: 6" +
                "\nNombre: Charmeleon\nTipo: Fuego\nNivel: 6" +
                "\nNombre: Charizard\nTipo: Fuego\nNivel: 6" ;

        assertEquals(pokedex.conseguirEvolucionesDe("Charmander"), actual);

        assertEquals(pokedex.conseguirEvolucionesDe("Charmeleon"), actual);

        assertEquals(pokedex.conseguirEvolucionesDe("Charizard"), actual);

        pokedex.actualizarBaseDeDatos();
    }

    @Test
    public void pruebaCambiarDeNombre(){
        //Charmander

        //Prueba pre;
        assertEquals(pokedex.conseguirDatosDe("Charmander"),
                "Nombre: Charmander\nTipo: Fuego\nNivel: 6");

        pokedex.cambiarNombre("Charmander", "Manuel");

        //Tiene los mismos datos con diferente nombre.
        assertEquals(pokedex.conseguirDatosDe("Manuel"),
                "Nombre: Manuel\nTipo: Fuego\nNivel: 6");

        //Tiene las mismas habilidades
        assertEquals(pokedex.conseguirHabilidadesDe("Manuel"), "Habilidades: " +
                "Desconocidas");

        //Tiene las mismas evoluciones
        assertEquals(pokedex.conseguirEvolucionesDe("Manuel"), "Evoluciones:" +
                "\nNombre: Manuel\nTipo: Fuego\nNivel: 6" +
                "\nNombre: Charmeleon\nTipo: Fuego\nNivel: 6" +
                "\nNombre: Charizard\nTipo: Fuego\nNivel: 6" );

        //Regreso a la normalidad.
        pokedex.cambiarNombre("Manuel", "Charmander");

        //No actualizo la base de datos porque no cambie nada.
    }
    @Test
    public void pruebaEliminarUnTipoYTodoSigueEjecutandoseBien(){

        //Charmeleon

        //Prueba pre.
        assertEquals(pokedex.conseguirDatosDe("Charmeleon"),
                "Nombre: Charmeleon\nTipo: Fuego\nNivel: 6");

        pokedex.eliminarTipo("Charmeleon", "Fuego");

        //Cambia los tipos que es el pokemon.
        assertEquals(pokedex.conseguirDatosDe("Charmeleon"),
                "Nombre: Charmeleon\nTipo: Desconocidas\nNivel: 6");

        //Tiene las mismas habilidades
        assertEquals(pokedex.conseguirHabilidadesDe("Charmeleon"), "Habilidades: Desconocidas");

        //Tiene las mismas evoluciones pero el pokemon no tiene su tipo.
        assertEquals(pokedex.conseguirEvolucionesDe("Charmeleon"), "Evoluciones:" +
                "\nNombre: Charmander\nTipo: Fuego\nNivel: 6" +
                "\nNombre: Charmeleon\nTipo: Desconocidas\nNivel: 6" +
                "\nNombre: Charizard\nTipo: Fuego\nNivel: 6");


        //Vuelvo a agregar el tipo.
        pokedex.agregarTipo("Charmeleon", "Fuego");

        //Prueba post.
        assertEquals(pokedex.conseguirDatosDe("Charmeleon"),
                "Nombre: Charmeleon\nTipo: Fuego\nNivel: 6");

        //No actualizo la base de datos porque no cambie nada.
    }

    @Test
    public void cambiarElNivel(){
        //Charizard

        //Prueba pre.
        assertEquals(pokedex.conseguirDatosDe("Charizard"),
                "Nombre: Charizard\nTipo: Fuego\nNivel: 6");

        //Cambió de nivel.
        pokedex.cambiarNivelDe("Charizard", 9);

        //Cambia el nivel del pokemon.
        assertEquals(pokedex.conseguirDatosDe("Charizard"),
                "Nombre: Charizard\nTipo: Fuego\nNivel: 9");

        //Tiene las mismas habilidades
        assertEquals(pokedex.conseguirHabilidadesDe("Charizard"), "Habilidades: " +
                "Ataque Ala, Garra Dragon");

        String esperado = "Evoluciones:" +
                "\nNombre: Charmander\nTipo: Fuego\nNivel: 6" +
                "\nNombre: Charmeleon\nTipo: Fuego\nNivel: 6" +
                "\nNombre: Charizard\nTipo: Fuego\nNivel: 9";

        //Tiene las mismas evoluciones pero el nivel de Charizard cambió.
        assertEquals(pokedex.conseguirEvolucionesDe("Charizard"), esperado );

        //Una de sus evoluciones reconoce los cambios.
        assertEquals(pokedex.conseguirEvolucionesDe("Charmander"), esperado );

        //Vuelvo al nivel anterior.
        pokedex.cambiarNivelDe("Charizard", 6);

        //Prueba post.
        assertEquals(pokedex.conseguirDatosDe("Charizard"),
                "Nombre: Charizard\nTipo: Fuego\nNivel: 6");

        //No actualizo la base de datos, ya que no cambie nada.
    }

    @Test
    public void regresoAlaNormalidad(){
        //ajajajqa
    }
}
