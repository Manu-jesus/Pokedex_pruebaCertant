package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pokedex;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CerrarGuardarHandler implements EventHandler<ActionEvent> {
    private Pokedex pokedex;
    private Stage stage;
    private Stage principal;

    public CerrarGuardarHandler(Stage principal, Stage vista, Pokedex pokedex) {
        this.stage = vista;
        this.principal = principal;
        this.pokedex = pokedex;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        pokedex.actualizarBaseDeDatos();

        TextField texto = new TextField(pokedex.nombreArchivo());

        Button botonInit = new Button("** Continuar Registrando Pokemones **");
        BotonInit iniciarEvent = new BotonInit(principal, texto);
        botonInit.setOnAction(iniciarEvent);
        botonInit.setMinSize(100, 100);


        VBox caja = new VBox(botonInit);
        Scene scene = new Scene(caja, 400,100);
        stage.setScene(scene);
        stage.show();
    }

}
