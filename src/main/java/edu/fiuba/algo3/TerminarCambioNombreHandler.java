package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pokedex;
import edu.fiuba.algo3.modelo.Pokemon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TerminarCambioNombreHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private Stage original;
    private Stage principal;
    private String nombreActual;
    private TextField nuevoNombre;
    private Pokedex pokedex;

    public TerminarCambioNombreHandler(Stage principal, Stage original, Stage stage,Pokedex pokedex, String nombreActual, TextField texto) {
        this.stage = stage;
        this.original = original;
        this.principal = principal;
        this.pokedex = pokedex;
        this.nuevoNombre = texto;
        this.nombreActual = nombreActual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        pokedex.cambiarNombre(nombreActual, nuevoNombre.getText());

        Button cargarDatosAPokedex = new Button("Cargar Datos a Pokedex");
        BuscarPokemonEventHandler buscarPokemonEvent = new BuscarPokemonEventHandler(principal, stage, original, pokedex, new TextField(nuevoNombre.getText()));
        cargarDatosAPokedex.setOnAction(buscarPokemonEvent);

        VBox caja = new VBox(cargarDatosAPokedex);
        Scene scene = new Scene(caja, 300,100);

        stage.setScene(scene);
        stage.show();
    }
}
