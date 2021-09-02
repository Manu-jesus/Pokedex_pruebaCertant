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

public class BotonInit implements EventHandler<ActionEvent> {
    private Stage stage;
    private Stage aCerrar;
    private Pokedex juego;
    private TextField archivo;

    public BotonInit (Stage stage, Stage aCerrar, TextField texto){
        this.stage = stage;
        this.aCerrar = aCerrar;
        this.archivo = texto;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        aCerrar.close();

        juego = new Pokedex(archivo.getText());

        Label pregunta = new Label("Que desea realizar: ");

        Button agregarPokemon = new Button("Agregar nuevo Pokemon a la base de datos");
        AgregarPokemonEventHandler agregarPokemonEvent = new AgregarPokemonEventHandler(stage, juego);
        agregarPokemon.setOnAction(agregarPokemonEvent);

        TextField nombre = new TextField();

        Stage nuevo = new Stage();
        Stage paraCerrar = new Stage();

        Button buscarPokemon = new Button("Buscar Pokemon");
        BuscarPokemonEventHandler buscarPokemonEvent = new BuscarPokemonEventHandler(stage, paraCerrar, nuevo, juego, nombre);
        buscarPokemon.setOnAction(buscarPokemonEvent);

        InformacionDeUsuarioEventHandler buscarTextoEvent = new InformacionDeUsuarioEventHandler(buscarPokemon);
        nombre.setOnKeyPressed(buscarTextoEvent);

        Integer contador = 1;
        StringBuilder datosPrevios = new StringBuilder();
        for (Pokemon poke: juego.pokemonesTotales()) {
            datosPrevios.append(contador).append(") ");
            datosPrevios.append(poke.obtenerNombre());
            datosPrevios.append("\n");
            contador++;
        }
        Label todosActualizados = new Label(datosPrevios.toString());

        HBox cajabuscar = new HBox(nombre, buscarPokemon);

        VBox cajaAgregar = new VBox(pregunta, agregarPokemon, cajabuscar, todosActualizados);
        cajaAgregar.setSpacing(20);
        cajaAgregar.setPadding(new Insets(20));

        Scene menu = new Scene(cajaAgregar, 450,520);

        stage.setScene(menu);
        stage.show();

    }
}
