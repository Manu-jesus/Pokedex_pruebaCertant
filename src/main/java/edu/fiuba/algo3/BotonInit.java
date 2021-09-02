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

public class BotonInit implements EventHandler<ActionEvent> {
    private Stage stage;
    private Pokedex juego;
    private TextField archivo;

    public BotonInit (Stage stage, TextField texto){
        this.stage = stage;
        this.archivo = texto;
    }

    @Override
    public void handle(ActionEvent actionEvent) {

        juego = new Pokedex(archivo.getText());

        Label pregunta = new Label("Que desea realizar: ");

        Button agregarPokemon = new Button("Agregar nuevo Pokemon a la base de datos");
        AgregarPokemonEventHandler agregarPokemonEvent = new AgregarPokemonEventHandler(stage, juego);
        agregarPokemon.setOnAction(agregarPokemonEvent);

        TextField nombre = new TextField();

        Button buscarPokemon = new Button("Buscar Pokemon");
        BuscarPokemonEventHandler buscarPokemonEvent = new BuscarPokemonEventHandler(stage, juego, nombre);
        buscarPokemon.setOnAction(buscarPokemonEvent);

        InformacionDeUsuarioEventHandler buscarTextoEvent = new InformacionDeUsuarioEventHandler(buscarPokemon);
        nombre.setOnKeyPressed(buscarTextoEvent);

        Button conseguirDatos = new Button("Conseguir datos de un Pokemon");
        Button conseguirHabilidades = new Button("Conseguir habilidades de un Pokemon");
        Button conseguirEvoluciones = new Button("Conseguir evoluciones de un Pokemon");

        Button cambiarNombre = new Button("Cambiar el nombre de algún Pokemon");
        Button cambiarNivel = new Button("Cambiar el nivel de algún Pokemon");

        Button eliminarTipo = new Button("Eliminar el tipo de algún Pokemon");
        Button agregarTipo = new Button("Agregar el tipo de algún Pokemon");

        Button eliminarHabilidad = new Button("Eliminar habilidad de algún Pokemon");
        Button agregarHabilidad = new Button("Agregar el tipo de algún Pokemon");

        HBox cajabuscar = new HBox(nombre, buscarPokemon);

        VBox cajaAgregar = new VBox(pregunta, agregarPokemon, cajabuscar);
        cajaAgregar.setSpacing(20);
        cajaAgregar.setPadding(new Insets(20));

        Scene menu = new Scene(cajaAgregar, 450,220);

        stage.setScene(menu);
        stage.show();

    }
}
