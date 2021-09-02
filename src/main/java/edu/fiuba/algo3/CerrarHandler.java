package edu.fiuba.algo3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;

public class CerrarHandler implements EventHandler<ActionEvent> {
    private Stage stage;

    public CerrarHandler(Stage stage) {
        this.stage = stage;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        stage.close();
    }
}
