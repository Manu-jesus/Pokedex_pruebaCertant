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

public class FinalizarEliminarTipoHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private Stage original;
    private Stage principal;
    private String nombreActual;
    private TextField tipoAEliminar;
    private Pokedex pokedex;

    public FinalizarEliminarTipoHandler(Stage principal, Stage original, Stage stage,Pokedex pokedex, String nombreActual, TextField texto) {
        this.stage = stage;
        this.original = original;
        this.principal = principal;
        this.pokedex = pokedex;
        this.tipoAEliminar = texto;
        this.nombreActual = nombreActual;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        try {
            pokedex.eliminarTipo(nombreActual, tipoAEliminar.getText());
        }catch (ElTipoNoSeEncontroError exception){
            this.tratarError("No se encontro el tipo");
        }
        Button cargarDatosAPokedex = new Button("Cargar Datos a Pokedex");
        BuscarPokemonEventHandler buscarPokemonEvent = new BuscarPokemonEventHandler(principal, stage, original, pokedex, new TextField(nombreActual));
        cargarDatosAPokedex.setOnAction(buscarPokemonEvent);

        VBox caja = new VBox(cargarDatosAPokedex);
        Scene scene = new Scene(caja, 100,100);

        stage.setScene(scene);
        stage.show();
    }

    private void tratarError(String mensaje){
        Stage casoError = new Stage();
        var label = new Label(mensaje);

        Button botonCerrar = new Button("Cerrar");
        CerrarHandler cerrarEvent = new CerrarHandler(casoError);
        botonCerrar.setOnAction(cerrarEvent);

        VBox caja = new VBox(label, botonCerrar);
        caja.setSpacing(20);

        Scene scene = new Scene(caja, 400,100);
        casoError.setScene(scene);
        casoError.showAndWait();
    }
}
