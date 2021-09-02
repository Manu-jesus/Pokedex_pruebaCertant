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
    private String nombreActual;
    private TextField tipoAEliminar;
    private Pokedex pokedex;

    public ParteFinalAgregarTipoHandler(Stage stage,Pokedex pokedex, String nombreActual, TextField texto) {
        this.stage = stage;
        this.pokedex = pokedex;
        this.tipoAEliminar = texto;
        this.nombreActual = nombreActual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        pokedex.agregarTipo(nombreActual, tipoAEliminar.getText());

        stage.close();
    }
}
