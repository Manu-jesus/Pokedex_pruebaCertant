package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pokedex;
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

public class AgregarPokemonEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private Pokedex pokedex;

    public AgregarPokemonEventHandler (Stage stage,Pokedex pokedex){
        this.stage = stage;
        this.pokedex = pokedex;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage nuevo = new Stage();

        Label nombre = new Label("Ingrese el nombre: ");
        Label tipo = new Label("Ingrese el tipo: ");
        Label nivel = new Label("Ingrese el nivel: ");

        TextField nombreIngresado = new TextField();
        TextField tiposIngresados = new TextField();
        TextField nivelIngresado = new TextField();

        Button botonDatosCompletos = new Button("Continuar");
        CulminarAgregadoEventHandler botonDatosCompletosEvent = new CulminarAgregadoEventHandler(stage, nuevo, nombreIngresado, tiposIngresados, nivelIngresado, pokedex);
        botonDatosCompletos.setOnAction(botonDatosCompletosEvent);

        InformacionDeUsuarioEventHandler nombreIngresadoEvent = new InformacionDeUsuarioEventHandler(botonDatosCompletos);
        nombreIngresado.setOnKeyPressed(nombreIngresadoEvent);

        HBox cajaNombres = new HBox(nombre, nombreIngresado);
        HBox cajaTipos = new HBox(tipo, tiposIngresados);
        HBox cajaNiveles = new HBox(nivel, nivelIngresado);

        VBox cajaDeMenu = new VBox(cajaNombres, cajaTipos, cajaNiveles, botonDatosCompletos);
        cajaDeMenu.setSpacing(20);
        cajaDeMenu.setPadding(new Insets(20));

        Scene scene = new Scene(cajaDeMenu, 450, 220);

        nuevo.setScene(scene);
        nuevo.show();
    }
}
