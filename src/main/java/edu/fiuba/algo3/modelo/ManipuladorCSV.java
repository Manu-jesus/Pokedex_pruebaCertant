package edu.fiuba.algo3.modelo;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;


public class ManipuladorCSV {
    private BufferedReader lector; //lee el archivo
    private FileWriter escritor; //escribe el archivo
    private String linea; //recibe la linea de cada fila
    private String[] partes; //almacena cada linea leida.
    private Pokedex pokedex;
    private String rutaArchivo;


    public ManipuladorCSV(String ruta, Pokedex pokedex){

        this.rutaArchivo = ruta;
        this.pokedex = pokedex;
    }

    public void leerArchivo(){
        try {
            lector = new BufferedReader(new FileReader(rutaArchivo));
            while ((linea = lector.readLine()) != null){
                partes = linea.split(", ");
                String numeroDeOrden = partes[0];
                //System.out.println(numeroDeOrden);
                String nombre = partes[1];
                //System.out.println(nombre);
                String tipoEnString = partes[2];
                //System.out.println(tipoEnString);
                String nivel = partes[3];
                //System.out.println(nivel);
                String evolucionEnString = partes[4];
                //System.out.println(evolucionEnString);
                String habilidades = partes[5];

                ArrayList<String> tipos = new ArrayList<>(Arrays.asList(tipoEnString.split(" - ")));
                Integer intNivel = Integer.parseInt(nivel);
                ArrayList<String> evolucion = new ArrayList<>(Arrays.asList(evolucionEnString.split(" - ")));
                ArrayList<String> habilidadesSep = new ArrayList<>(Arrays.asList(habilidades.split(" - ")));

                pokedex.agregarAlDiccionario(nombre, tipos, intNivel, evolucion, numeroDeOrden, habilidadesSep);
            }
            lector.close();
            linea = null;
            partes = null;

        } catch (FileNotFoundException e){
            File statText = new File(rutaArchivo);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void reescribirArchivo(){
        try {
            escritor = new FileWriter(rutaArchivo);

            ArrayList<Pokemon> pokemonesTotales = pokedex.pokemonesTotales();
            Collections.sort(pokemonesTotales, Comparator.comparing(Pokemon::conseguirNumero));
            for (Pokemon pokeActual : pokemonesTotales) {
                escritor.write(pokeActual.lineaAEscribir());
            }

            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void agregarLinea(Pokemon pokemonNuevo) {
        try {
            escritor = new FileWriter(rutaArchivo, true);

            escritor.write(pokemonNuevo.lineaAEscribir());

            escritor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String nombreArchivo() {
        return rutaArchivo;
    }

}
