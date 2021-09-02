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

public class EliminarTipoHandler implements EventHandler<ActionEvent> {
    private Pokedex pokedex;
    private Pokemon pokemon;

    public EliminarTipoHandler(Pokedex pokedex, Pokemon pokemon) {
        this.pokedex = pokedex;
        this.pokemon = pokemon;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage nuevo = new Stage();

        Label label = new Label("Tipo a eliminar: ");

        TextField texto = new TextField();

        Button botonTerminarEliminarTipo = new Button("Eliminar");
        FinalizarEliminarTipoHandler eliminarTipoEvent = new FinalizarEliminarTipoHandler(nuevo, pokedex, pokemon.obtenerNombre(), texto);
        botonTerminarEliminarTipo.setOnAction(eliminarTipoEvent);

        InformacionDeUsuarioEventHandler textoEvent = new InformacionDeUsuarioEventHandler(botonTerminarEliminarTipo);
        texto.setOnKeyPressed(textoEvent);

        HBox cajaHorizontal = new HBox(label, texto);
        VBox cajaVertical = new VBox(cajaHorizontal, botonTerminarEliminarTipo);
        cajaVertical.setSpacing(20);
        cajaVertical.setPadding(new Insets(20));

        Scene scene = new Scene(cajaVertical, 400, 100);

        nuevo.setScene(scene);
        nuevo.show();
    }
}
