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
    private Stage paraCerrar;
    private Stage vista;
    private Pokedex pokedex;
    private TextField nombreABuscar;

    public BuscarPokemonEventHandler(Stage stage, Stage paraCerrar, Stage vista,Pokedex pokedex, TextField texto) {
        this.stage = stage;
        this.paraCerrar = paraCerrar;
        this.vista = vista;
        this.pokedex = pokedex;
        this.nombreABuscar = texto;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        paraCerrar.close();
        Pokemon buscado = null;
        try {
            buscado = pokedex.obtenerPokemon(nombreABuscar.getText());
        }catch (NoExisteElPokemonError exception){
            this.tratarError("El Pokemon no se encontro en los datos");
        }

        if (buscado == null) {
            return;
        }
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

        Button botonCerrarGuardar = new Button("Cerrar y Guardar");
        CerrarGuardarHandler cerrarGuardarEvent = new CerrarGuardarHandler(stage, vista, pokedex);
        botonCerrarGuardar.setOnAction(cerrarGuardarEvent);

        Button botonCambiarNombre = new Button("Cambiar nombre");
        CambioNombreHandler cambioNombreEvent = new CambioNombreHandler(stage,vista,pokedex, buscado);
        botonCambiarNombre.setOnAction(cambioNombreEvent);

        Button botonCambiarNivel = new Button("Cambiar nivel");
        CambioNivelHandler cambioNivelEvent = new CambioNivelHandler(stage, vista, pokedex, buscado);
        botonCambiarNivel.setOnAction(cambioNivelEvent);

        Button botonAgregarTipo = new Button("Agregar tipo");
        AgregarTipoHandler agregarTipoEvent = new AgregarTipoHandler(stage, vista, pokedex, buscado);
        botonAgregarTipo.setOnAction(agregarTipoEvent);

        Button botonEliminarTipo = new Button("Eliminar tipo");
        EliminarTipoHandler eliminarTipoEvent = new EliminarTipoHandler(stage,vista, pokedex, buscado);
        botonEliminarTipo.setOnAction(eliminarTipoEvent);

        Button botonAgregarHabilidad = new Button("Agregar habilidad");
        AgregarHabilidadHandler agregarHabilidadEvent = new AgregarHabilidadHandler(stage, vista, pokedex, buscado);
        botonAgregarHabilidad.setOnAction(agregarHabilidadEvent);

        Button botonEliminarHabilidad = new Button("Eliminar habilidad");
        EliminarHabilidadHandler eliminarHabilidadEvent = new EliminarHabilidadHandler(stage, vista,pokedex, buscado);
        botonEliminarHabilidad.setOnAction(eliminarHabilidadEvent);

        Button botonAgregarEvolucion = new Button("Agregar evolucion");
        AgregarEvolucionHandler agregarEvolucionEvent = new AgregarEvolucionHandler(stage, vista,pokedex, buscado);
        botonAgregarEvolucion.setOnAction(agregarEvolucionEvent);



        VBox cajaCambios = new VBox(botonCambiarNombre, botonCambiarNivel, botonAgregarTipo, botonEliminarTipo, botonAgregarHabilidad, botonEliminarHabilidad);
        cajaCambios.setSpacing(20);
        cajaCambios.setPadding(new Insets(20));

        VBox cajaNombre = new VBox(label, botonDatos, botonHabilidades, botonEvoluciones);
        cajaNombre.setSpacing(20);
        cajaNombre.setPadding(new Insets(20));

        VBox botonesParaCerrar = new VBox(botonCerrar, botonCerrarGuardar);
        botonesParaCerrar.setSpacing(20);
        botonesParaCerrar.setPadding(new Insets(70));

        HBox cajaGrande = new HBox(cajaNombre, cajaCambios, botonesParaCerrar);

        Scene camara = new Scene(cajaGrande, 600, 400);
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
