package edu.fiuba.algo3;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


/*
 * JavaFX App
 */
public class App extends Application {
    static String respuesta;
    static String a;
    Boolean confirmacionDatos;
    Scene pantallaDeInicio;
    Scene preguntaDatos;
    Scene mapaDelJuego;
    Scene tablaDePosicionesHistorial;
	
	private Image logoGpsChallenge;
	private String botonAntesDeSerPresionado = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: #717D8C; -fx-text-fill: #BDB69C";
    private String botonNormal = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";

    private String formatoTexto = "-fx-border-width: 0px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";

    @Override
    public void start(Stage stage) {
        stage.setTitle("GPS Challenge");
        stage.setResizable(true);

		String pathLogo = this.getClass().getResource("/imagenes/logo-gps-challenge.png").toString();
		this.logoGpsChallenge = new Image(pathLogo);
        stage.getIcons().add(this.logoGpsChallenge);

        MenuPrincipal menuPrincipal = new MenuPrincipal(stage);

        stage.setOnCloseRequest(e-> {
            e.consume();
            a = cerrarJuego(stage);
            if(a =="Salir"){
                stage.close();
            }
        });

        stage.setScene(menuPrincipal.getMenu());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private String cerrarJuego(Stage stage){
        Stage ventanaSalir = new Stage();
        ventanaSalir.setResizable(false);
        ventanaSalir.setTitle("Salir del Juego");
        
        Button botonSalir = new Button("SI");
        botonSalir.setStyle(botonNormal);
        botonSalir.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
        botonSalir.setOnMouseEntered(e -> botonSalir.setStyle(botonAntesDeSerPresionado));
        botonSalir.setOnMouseExited(e -> botonSalir.setStyle(botonNormal));
        
        Button botonQuedarse = new Button("NO");
        botonQuedarse.setStyle(botonNormal);
        botonQuedarse.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
        botonQuedarse.setOnMouseEntered(e -> botonQuedarse.setStyle(botonAntesDeSerPresionado));
        botonQuedarse.setOnMouseExited(e -> botonQuedarse.setStyle(botonNormal));
        
        VBox menuSalir = new VBox(20);
        
        Label preguntaSalir = new Label("??Est??s seguro que quer??s salir?");
        preguntaSalir.setStyle(formatoTexto);
        preguntaSalir.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
        
        menuSalir.getChildren().addAll(preguntaSalir , botonSalir ,botonQuedarse);
        menuSalir.setAlignment(Pos.CENTER);
        menuSalir.setStyle("-fx-border-color: #2F343A; -fx-background-color: #2F343A");
        
        botonSalir.setOnAction(e-> {
            respuesta = "Salir";
            ventanaSalir.close();
        });
        
        botonQuedarse.setOnAction(e->{
            respuesta  = "Quedarse";
            ventanaSalir.close();
        });

        Scene escenaSalir = new Scene(menuSalir , 370 , 200);
        
        ventanaSalir.getIcons().add(this.logoGpsChallenge);
        ventanaSalir.setScene(escenaSalir);
        ventanaSalir.showAndWait();
        return(respuesta);
    }
}