package edu.fiuba.algo3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class JuegoVista extends Group{
    static String respuesta;
    static Scene juegoVista;

    public JuegoVista(Stage stage, Scene pantallaDeInicio, int ancho, int alto, String nombreJugador){
        this.setJuego(stage, pantallaDeInicio, ancho, alto, nombreJugador);
    }
    public Scene getJuegoVista(){
        return juegoVista;
    }
    private void setJuego(Stage stage, Scene pantallaDeInicio, int ancho, int alto, String nombreJugador){
        HBox encabezado = new HBox();
        encabezado.setAlignment(Pos.CENTER_LEFT);
        encabezado.setSpacing(150);

        //BOTON SIGUIENTE
        Button salir = new Button("Salir");
        salir.setFont(Font.font("Visage Bold", 20));
        salir.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-background-color: #26798E; -fx-font-size: 2em; -fx-text-fill: #FFC172");
     
        salir.setOnAction(e-> {
            String a = volverAlMenu(stage);
            if(a =="Volver"){
                stage.setScene(pantallaDeInicio);
            }
        });

        //NOMBRE DEL JUGADOR
        Label nombreDelJugador = new Label("Jugador: " + nombreJugador);
        nombreDelJugador.setFont(Font.font("Visage Bold", 20));
        nombreDelJugador.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 2em; -fx-text-fill: #FFC172");
        
        //Puntuacion
        Label puntajeActual = new Label("Puntaje: 0");
        puntajeActual.setFont(Font.font("Visage Bold", 20));
        puntajeActual.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 2em; -fx-text-fill: #FFC172");
        
        encabezado.getChildren().add(salir);
        encabezado.getChildren().add(nombreDelJugador);
        encabezado.getChildren().add(puntajeActual);
        
        this.getChildren().add(encabezado);
        this.insertarCuadras(ancho, alto);

        juegoVista = new Scene(this,640, 580, Color.rgb(38, 121, 142));
    }

    private void insertarCuadras(int ancho, int alto){
        int posicionActualAncho = 50;
        int posicionActualAlto = 50;
        for(int i = 0; i<alto; i++){
            for(int j = 0; j<ancho; j++){
                Rectangle cuadra = new Rectangle(40, 40, Color.rgb(255, 227, 179));
                cuadra.setX(posicionActualAncho);
                cuadra.setY(posicionActualAlto);
                this.getChildren().add(cuadra);
                posicionActualAncho = posicionActualAncho + 50;
            }
            posicionActualAncho = 50;
            posicionActualAlto = posicionActualAlto + 50;
        }
    }

    private String volverAlMenu(Stage stage){
        Stage ventanaVolver = new Stage();
        ventanaVolver.setResizable(false);
        ventanaVolver.setTitle("Volver al Menu");
        
        Button botonVolver = new Button("Volver al Menu Principal");
        botonVolver.setFont(Font.font("Visage Bold", 15));
        botonVolver.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-font-size: 20px; -fx-background-color: #26798E; -fx-text-fill: #FFC172");
        
        Button botonQuedarse = new Button("Quedarse");
        botonQuedarse.setFont(Font.font("Visage Bold", 15));
        botonQuedarse.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-font-size: 20px; -fx-background-color: #26798E; -fx-text-fill: #FFC172");
        
        VBox menuVolver = new VBox(20);
        
        Label preguntaVolver = new Label("¿Estás seguro que querés ir al Menu Principal?");
        preguntaVolver.setFont(Font.font("Visage Bold", 20));
        preguntaVolver.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 20px; -fx-text-fill: #FFC172");
        
        Label advertenciaDatos = new Label("Todo tu progreso se perdera");
        advertenciaDatos.setFont(Font.font("Visage Bold", 20));
        advertenciaDatos.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 20px; -fx-text-fill: #FFC172");
        
        ventanaVolver.setMinWidth(280);
        ventanaVolver.initModality(Modality.APPLICATION_MODAL);
        
        menuVolver.getChildren().addAll(preguntaVolver, advertenciaDatos, botonVolver, botonQuedarse);
        menuVolver.setAlignment(Pos.CENTER);
        menuVolver.setStyle("-fx-border-color: #26798E; -fx-background-color: #26798E");
        
        botonVolver.setOnAction(e-> {
            respuesta = "Volver";
            ventanaVolver.close();
        });
        
        botonQuedarse.setOnAction(e->{
            respuesta  = "Quedarse";
            ventanaVolver.close();
        });

        Scene  escenaVolver = new Scene(menuVolver , 480 , 300);
        ventanaVolver.setScene(escenaVolver);
        ventanaVolver.showAndWait();
        return(respuesta);
    }
}
