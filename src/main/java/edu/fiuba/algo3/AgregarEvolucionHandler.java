package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pokedex;
import edu.fiuba.algo3.modelo.Pokemon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AgregarEvolucionHandler implements EventHandler<ActionEvent> {
    private Pokedex pokedex;
    private Pokemon pokemon;
    private Stage original;
    private Stage principal;

    public AgregarEvolucionHandler(Stage principal,Stage original, Pokedex pokedex, Pokemon pokemon) {
        this.pokedex = pokedex;
        this.pokemon = pokemon;
        this.original = original;
        this.principal = principal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage nuevo = new Stage();

        Label label = new Label("Nombre de la evolución de este pokemon: ");

        TextField texto = new TextField();

        Button botonTerminarAgregarEvolucion = new Button("agregar");
        ParteFinalAgregarEvolucionHandler agregarEvolucionEvent = new ParteFinalAgregarEvolucionHandler(principal, original, nuevo, pokedex, pokemon.obtenerNombre(), texto);
        botonTerminarAgregarEvolucion.setOnAction(agregarEvolucionEvent);

        InformacionDeUsuarioEventHandler textoEvent = new InformacionDeUsuarioEventHandler(botonTerminarAgregarEvolucion);
        texto.setOnKeyPressed(textoEvent);

        HBox cajaHorizontal = new HBox(label, texto);
        VBox cajaVertical = new VBox(cajaHorizontal, botonTerminarAgregarEvolucion);
        cajaVertical.setSpacing(20);
        cajaVertical.setPadding(new Insets(20));

        Scene scene = new Scene(cajaVertical, 300, 100);

        nuevo.setScene(scene);
        nuevo.show();
    }

}

