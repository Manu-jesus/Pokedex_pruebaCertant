package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.ElTipoNoSeEncontroError;
import edu.fiuba.algo3.modelo.Pokedex;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ParteFinalAgregarTipoHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private Stage original;
    private Stage principal;
    private String nombreActual;
    private TextField tipoAEliminar;
    private Pokedex pokedex;

    public ParteFinalAgregarTipoHandler(Stage principal,Stage original,Stage stage,Pokedex pokedex, String nombreActual, TextField texto) {
        this.stage = stage;
        this.original = original;
        this.principal = principal;
        this.pokedex = pokedex;
        this.tipoAEliminar = texto;
        this.nombreActual = nombreActual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        pokedex.agregarTipo(nombreActual, tipoAEliminar.getText());

        Button cargarDatosAPokedex = new Button("Cargar Datos a Pokedex");
        BuscarPokemonEventHandler buscarPokemonEvent = new BuscarPokemonEventHandler(principal,stage, original, pokedex, new TextField(nombreActual));
        cargarDatosAPokedex.setOnAction(buscarPokemonEvent);

        VBox caja = new VBox(cargarDatosAPokedex);
        Scene scene = new Scene(caja,300,100);

        stage.setScene(scene);
        stage.show();
    }
}
