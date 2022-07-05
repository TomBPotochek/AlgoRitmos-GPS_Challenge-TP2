package edu.fiuba.algo3;

import javax.security.auth.callback.ConfirmationCallback;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import edu.fiuba.algo3.MenuPrincipal;

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

    String botonAntesDeSerPresionado = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: #717D8C; -fx-text-fill: #BDB69C";
    String botonNormal = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";

    String formatoTexto = "-fx-border-width: 0px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";

    @Override
    public void start(Stage stage) {
        stage.setTitle("GPS Challenge");
        stage.setResizable(true);
        //stage.setMaximized(true);
        //stage.setFullScreen(true);
        Image logo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/logo-gps-challenge.png");
        stage.getIcons().add(logo);

        MenuPrincipal menuPrincipal = new MenuPrincipal(stage);
        

        //color violeta oscuro: #1b004b
        //color violeta claro: #7f00b2

        //color crema ---> 255, 227, 179
        //color azul oscuro marino---> 38, 121, 142
        //color verde claro----> 99, 202, 167 
        //color dorado ---> 255, 193, 114

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
        
        Label preguntaSalir = new Label("¿Estás seguro que querés salir?");
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

        Scene  escenaSalir = new Scene(menuSalir , 370 , 200);
        Image logo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/logo-gps-challenge.png");
        ventanaSalir.getIcons().add(logo);
        ventanaSalir.setScene(escenaSalir);
        ventanaSalir.showAndWait();
        return(respuesta);
    }
}