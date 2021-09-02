package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pokedex;
import edu.fiuba.algo3.modelo.Pokemon;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class TerminarCambioNombreHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private String nombreActual;
    private TextField nuevoNombre;
    private Pokedex pokedex;

    public TerminarCambioNombreHandler(Stage stage,Pokedex pokedex, String nombreActual, TextField texto) {
        this.stage = stage;
        this.pokedex = pokedex;
        this.nuevoNombre = texto;
        this.nombreActual = nombreActual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        pokedex.cambiarNombre(nombreActual, nuevoNombre.getText());

        stage.close();
    }
}
