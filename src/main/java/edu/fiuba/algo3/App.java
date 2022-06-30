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
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
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

    @Override
    public void start(Stage stage) {
        stage.setTitle("GPS Challenge");
        stage.setResizable(false);

        MenuPrincipal menuPrincipal = new MenuPrincipal (stage);
    
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
        botonSalir.setFont(Font.font("Visage Bold", 15));
        botonSalir.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-font-size: 20px; -fx-background-color: #26798E; -fx-text-fill: #FFC172");
        
        Button botonQuedarse = new Button("NO");
        botonQuedarse.setFont(Font.font("Visage Bold", 15));
        botonQuedarse.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-font-size: 20px; -fx-background-color: #26798E; -fx-text-fill: #FFC172");
        
        VBox menuSalir = new VBox(20);
        
        Label preguntaSalir = new Label("¿Estás seguro que querés salir?");
        preguntaSalir.setFont(Font.font("Visage Bold", 20));
        preguntaSalir.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 20px; -fx-text-fill: #FFC172");
        
        
        ventanaSalir.setMinWidth(280);
        ventanaSalir.initModality(Modality.APPLICATION_MODAL);
        
        menuSalir.getChildren().addAll(preguntaSalir , botonSalir ,botonQuedarse);
        menuSalir.setAlignment(Pos.CENTER);
        menuSalir.setStyle("-fx-border-color: #26798E; -fx-background-color: #26798E");
        
        botonSalir.setOnAction(e-> {
            respuesta = "Salir";
            ventanaSalir.close();
        });
        
        botonQuedarse.setOnAction(e->{
            respuesta  = "Quedarse";
            ventanaSalir.close();
        });

        Scene  escenaSalir = new Scene(menuSalir , 280 , 200);
        ventanaSalir.setScene(escenaSalir);
        ventanaSalir.showAndWait();
        return(respuesta);
    }
}