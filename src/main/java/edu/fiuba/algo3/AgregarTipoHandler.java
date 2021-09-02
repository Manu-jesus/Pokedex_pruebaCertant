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

public class AgregarTipoHandler implements EventHandler<ActionEvent> {
    private Pokedex pokedex;
    private Pokemon pokemon;
    private Stage original;
    private Stage principal;

    public AgregarTipoHandler(Stage principal, Stage stage, Pokedex pokedex, Pokemon pokemon) {
        this.pokedex = pokedex;
        this.pokemon = pokemon;
        this.original = stage;
        this.principal = principal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage nuevo = new Stage();

        Label label = new Label("Tipo a agregar: ");

        TextField texto = new TextField();

        Button botonTerminarAgregarTipo = new Button("Agregar");
        ParteFinalAgregarTipoHandler agregarTipoEvent = new ParteFinalAgregarTipoHandler(principal, original, nuevo, pokedex, pokemon.obtenerNombre(), texto);
        botonTerminarAgregarTipo.setOnAction(agregarTipoEvent);

        InformacionDeUsuarioEventHandler textoEvent = new InformacionDeUsuarioEventHandler(botonTerminarAgregarTipo);
        texto.setOnKeyPressed(textoEvent);

        HBox cajaHorizontal = new HBox(label, texto);
        VBox cajaVertical = new VBox(cajaHorizontal, botonTerminarAgregarTipo);
        cajaVertical.setSpacing(20);
        cajaVertical.setPadding(new Insets(20));

        Scene scene = new Scene(cajaVertical, 400, 100);

        nuevo.setScene(scene);
        nuevo.show();
    }
}
