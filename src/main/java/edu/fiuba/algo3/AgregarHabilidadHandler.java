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

public class AgregarHabilidadHandler implements EventHandler<ActionEvent> {
    private Pokedex pokedex;
    private Pokemon pokemon;
    private Stage vistaDelPokemon;
    private Stage principal;

    public AgregarHabilidadHandler(Stage principal,Stage stage, Pokedex pokedex, Pokemon pokemon) {
        this.vistaDelPokemon = stage;
        this.principal = principal;
        this.pokedex = pokedex;
        this.pokemon = pokemon;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage nuevo = new Stage();

        Label label = new Label("Habilidad a agregar: ");

        TextField texto = new TextField();

        Button botonTerminarAgregarHabilidad = new Button("Agregar");
        ParteFinalAgregarHabilidadHandler agregarHabilidadEvent = new ParteFinalAgregarHabilidadHandler(principal,vistaDelPokemon, nuevo, pokedex, pokemon.obtenerNombre(), texto);
        botonTerminarAgregarHabilidad.setOnAction(agregarHabilidadEvent);

        InformacionDeUsuarioEventHandler textoEvent = new InformacionDeUsuarioEventHandler(botonTerminarAgregarHabilidad);
        texto.setOnKeyPressed(textoEvent);

        HBox cajaHorizontal = new HBox(label, texto);
        VBox cajaVertical = new VBox(cajaHorizontal, botonTerminarAgregarHabilidad);
        cajaVertical.setSpacing(20);
        cajaVertical.setPadding(new Insets(20));

        Scene scene = new Scene(cajaVertical, 400, 100);

        nuevo.setScene(scene);
        nuevo.show();
    }
}
