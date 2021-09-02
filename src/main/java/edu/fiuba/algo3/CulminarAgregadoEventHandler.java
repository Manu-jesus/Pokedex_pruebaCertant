package edu.fiuba.algo3;

import edu.fiuba.algo3.modelo.Pokedex;
import edu.fiuba.algo3.modelo.YaExisteElPokemonErorr;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CulminarAgregadoEventHandler implements EventHandler<ActionEvent> {
    private Stage stage;
    private Stage principal;
    private TextField nombre;
    private TextField tipos;
    private TextField nivel;
    private Pokedex pokedex;

    public CulminarAgregadoEventHandler (Stage principal, Stage stage, TextField nombreIngresado,TextField tiposIngresados,TextField nivelIngresado, Pokedex pokedex){
        this.nombre = nombreIngresado;
        this.tipos = tiposIngresados;
        this.nivel = nivelIngresado;

        this.stage = stage;
        this.principal = principal;
        this.pokedex = pokedex;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (nombre.getText().equals("")){
            this.tratarError("No puedes ingresar un nombre vacio");
        }

        if (!this.esNumero(nivel.getText())){
            this.tratarError("El nivel debe ser un número");
        }
        int intNivel = Integer.parseInt(nivel.getText());
        if (intNivel < 0){
            this.tratarError("El nivel no puede ser negativo");
        }

        try {
            pokedex.agregarPokemon(nombre.getText(), tipos.getText(), intNivel);
        }catch (YaExisteElPokemonErorr exception){
            tratarError("Ya existe el Pokemon");
        }

        TextField texto = new TextField(pokedex.nombreArchivo());

        Button botonInit = new Button("** Continuar registrando Pokemones **");
        BotonInit iniciarEvent = new BotonInit(principal,stage, texto);
        botonInit.setOnAction(iniciarEvent);
        botonInit.setMinSize(100, 100);

        Scene scene = new Scene(botonInit);
        stage.setScene(scene);
        stage.show();
    }

    private void tratarError(String mensaje) {
        Stage casoError = new Stage();
        var label = new Label(mensaje);
        Scene scene = new Scene(label, 400,100);
        casoError.setScene(scene);
        casoError.showAndWait();
    }
    public boolean esNumero(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }
}
