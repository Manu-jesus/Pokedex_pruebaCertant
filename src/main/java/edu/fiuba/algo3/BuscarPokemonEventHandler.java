package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.NoExisteElPokemonError;
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

public class BuscarPokemonEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private Pokedex pokedex;
    private TextField nombreABuscar;

    public BuscarPokemonEventHandler(Stage stage,Pokedex pokedex, TextField texto) {
        this.stage = stage;
        this.pokedex = pokedex;
        this.nombreABuscar = texto;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Pokemon buscado = null;
        try {
            buscado = pokedex.obtenerPokemon(nombreABuscar.getText());
        }catch (NoExisteElPokemonError exception){
            this.tratarError("El Pokemon no se encontro en los datos");
        }

        Stage vista = new Stage();
        Label label = new Label(buscado.obtenerNombre());

        Button botonDatos = new Button("DATOS");
        DatosHandler datosEvent = new DatosHandler(buscado.conseguirDatos());
        botonDatos.setOnAction(datosEvent);

        Button botonHabilidades = new Button("HABILIDADES");
        DatosHandler habilidadesEvent = new DatosHandler(buscado.conseguirHabilidades());
        botonHabilidades.setOnAction(habilidadesEvent);

        Button botonEvoluciones = new Button("EVOLUCIONES");
        DatosHandler evolucionesEvent = new DatosHandler(buscado.conseguirEvoluciones());
        botonEvoluciones.setOnAction(evolucionesEvent);

        Button botonCerrar = new Button("Cerrar");
        CerrarHandler cerrarEvent = new CerrarHandler(vista);
        botonCerrar.setOnAction(cerrarEvent);

        Button botonCambiarNombre = new Button("Cambiar nombre");
        CambioNombreHandler cambioNombreEvent = new CambioNombreHandler(pokedex, buscado);
        botonCambiarNombre.setOnAction(cambioNombreEvent);

        Button botonAgregarTipo = new Button("Agreagar tipo");
        AgregarTipoHandler agregarTipoEvent = new AgregarTipoHandler(pokedex, buscado);
        botonAgregarTipo.setOnAction(agregarTipoEvent);

        Button botonEliminarTipo = new Button("Eliminar tipo");
        EliminarTipoHandler eliminarTipoEvent = new EliminarTipoHandler(pokedex, buscado);
        botonEliminarTipo.setOnAction(eliminarTipoEvent);

        VBox cajaCambios = new VBox(botonCambiarNombre, botonAgregarTipo, botonEliminarTipo);
        cajaCambios.setSpacing(20);
        cajaCambios.setPadding(new Insets(20));

        VBox cajaNombre = new VBox(label, botonDatos, botonHabilidades, botonEvoluciones, botonCerrar);
        cajaNombre.setSpacing(20);
        cajaNombre.setPadding(new Insets(20));

        HBox cajaGrande = new HBox(cajaNombre, cajaCambios);

        Scene camara = new Scene(cajaGrande, 500, 220);
        vista.setScene(camara);
        vista.show();
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
