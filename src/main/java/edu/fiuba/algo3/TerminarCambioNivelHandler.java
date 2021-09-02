package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pokedex;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TerminarCambioNivelHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private Stage original;
    private Stage principal;
    private TextField nombreActual;
    private TextField nuevoNivel;
    private Pokedex pokedex;

    public TerminarCambioNivelHandler(Stage principal,Stage original,Stage stage,Pokedex pokedex, TextField nombreActual, TextField texto) {
        this.stage = stage;
        this.original = original;
        this.principal = principal;
        this.pokedex = pokedex;
        this.nuevoNivel = texto;
        this.nombreActual = nombreActual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (!esNumero(nuevoNivel.getText())){
            this.tratarError("El nivel ingresado debe ser un número");
        }
        int intNivel = Integer.parseInt(nuevoNivel.getText());
        if (intNivel < 0){
            this.tratarError("El nivel deberia ser positivo");
        }

        pokedex.cambiarNivelDe(nombreActual.getText(), intNivel);


        Button cargarDatosAPokedex = new Button("Cargar Datos a Pokedex");
        BuscarPokemonEventHandler buscarPokemonEvent = new BuscarPokemonEventHandler(principal, stage, original, pokedex, nombreActual);
        cargarDatosAPokedex.setOnAction(buscarPokemonEvent);


        VBox boton = new VBox(cargarDatosAPokedex);
        Scene scene = new Scene(boton,300,100);
        stage.setScene(scene);
        stage.show();
    }

    private void tratarError(String mensaje) {
        Stage casoError = new Stage();
        var label = new Label(mensaje);
        Scene scene = new Scene(label, 400,100);
        casoError.setScene(scene);
        casoError.showAndWait();
    }
    public boolean esNumero(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }


}
