package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Stage aCerrar = new Stage();
        Label label = new Label("Nombre del archivo nuevo: ");

        TextField texto = new TextField();

        Button botonInit = new Button("** Empezar a Registrar Pokemones **");
        BotonInit iniciarEvent = new BotonInit(stage,aCerrar, texto);
        botonInit.setOnAction(iniciarEvent);
        botonInit.setMinSize(100, 100);

        InformacionDeUsuarioEventHandler textoEvent = new InformacionDeUsuarioEventHandler(botonInit);
        texto.setOnKeyPressed(textoEvent);

        HBox datosIniciales = new HBox(label, texto);
        datosIniciales.setSpacing(5);

        VBox botones = new VBox(datosIniciales, botonInit);
        botones.setMargin(botonInit,new Insets(10,0,0,100));
        botones.setSpacing(20);
        botones.setPadding(new Insets(35));

        var menu = new Scene(botones, 450, 220);

        stage.setScene(menu);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}