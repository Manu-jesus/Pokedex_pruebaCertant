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

public class EliminarHabilidadHandler implements EventHandler<ActionEvent> {
    private Pokedex pokedex;
    private Pokemon pokemon;
    private Stage original;
    private Stage principal;

    public EliminarHabilidadHandler(Stage principal,Stage original, Pokedex pokedex, Pokemon pokemon) {
        this.pokedex = pokedex;
        this.pokemon = pokemon;
        this.original = original;
        this.principal = principal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage nuevo = new Stage();

        Label label = new Label("Habilidad a agregar: ");

        TextField texto = new TextField();

        Button botonTerminarEliminarHabilidad = new Button("Eliminar");
        ParteFinalEliminarHabilidadHandler eliminarHabilidadEvent = new ParteFinalEliminarHabilidadHandler(principal, original, nuevo, pokedex, pokemon.obtenerNombre(), texto);
        botonTerminarEliminarHabilidad.setOnAction(eliminarHabilidadEvent);

        InformacionDeUsuarioEventHandler textoEvent = new InformacionDeUsuarioEventHandler(botonTerminarEliminarHabilidad);
        texto.setOnKeyPressed(textoEvent);

        HBox cajaHorizontal = new HBox(label, texto);
        VBox cajaVertical = new VBox(cajaHorizontal, botonTerminarEliminarHabilidad);
        cajaVertical.setSpacing(20);
        cajaVertical.setPadding(new Insets(20));

        Scene scene = new Scene(cajaVertical, 300, 100);

        nuevo.setScene(scene);
        nuevo.show();
    }
}
