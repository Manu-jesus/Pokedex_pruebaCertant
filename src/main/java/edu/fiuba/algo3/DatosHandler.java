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
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class DatosHandler implements EventHandler<ActionEvent> {
    private String datos;

    public DatosHandler(String datos) {
        this.datos = datos;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Stage vistaDatos = new Stage();
        Label datos = new Label(this.datos);

        Button botonCerrar = new Button("Cerrar");
        CerrarHandler cerrarEvent = new CerrarHandler(vistaDatos);
        botonCerrar.setOnAction(cerrarEvent);


        VBox caja = new VBox(datos, botonCerrar);
        VBox.setMargin(botonCerrar, new Insets(10,0,0,150));
        caja.setSpacing(20);
        caja.setPadding(new Insets(20));

        Scene scene = new Scene(caja, 400,220);
        vistaDatos.setScene(scene);
        vistaDatos.showAndWait();
    }
}
