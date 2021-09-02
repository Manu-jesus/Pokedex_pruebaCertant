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

public class CambioNombreHandler implements EventHandler<ActionEvent> {
    private Pokedex pokedex;
    private Pokemon pokemon;

    public CambioNombreHandler(Pokedex pokedex, Pokemon pokemon) {
        this.pokedex = pokedex;
        this.pokemon = pokemon;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage nuevo = new Stage();

        Label label = new Label("nuevo nombre: ");

        TextField texto = new TextField();

        Button botonTerminarCambioNombre = new Button("Cambiar");
        TerminarCambioNombreHandler terminarEvent = new TerminarCambioNombreHandler(nuevo, pokedex, pokemon.obtenerNombre(), texto);
        botonTerminarCambioNombre.setOnAction(terminarEvent);

        InformacionDeUsuarioEventHandler textoEvent = new InformacionDeUsuarioEventHandler(botonTerminarCambioNombre);
        texto.setOnKeyPressed(textoEvent);

        HBox cajaHorizontal = new HBox(label, texto);
        VBox cajaVertical = new VBox(cajaHorizontal, botonTerminarCambioNombre);
        cajaVertical.setSpacing(20);
        cajaVertical.setPadding(new Insets(20));

        Scene scene = new Scene(cajaVertical, 400, 100);

        nuevo.setScene(scene);
        nuevo.show();
    }
}
