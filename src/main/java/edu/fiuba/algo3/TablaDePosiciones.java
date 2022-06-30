package edu.fiuba.algo3;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class TablaDePosiciones extends Group{
    //stage.setScene(tablaDePosicionesHistorial);
    static String respuesta;
    Scene TablaPosiciones;

    public TablaDePosiciones(Stage stage, Scene pantallaDeInicio){
        this.setTablaDePosiciones(stage, pantallaDeInicio);
    }

    public Scene getTablaDePosiciones(){
        return TablaPosiciones;
    }
        
    private void setTablaDePosiciones(Stage stage, Scene pantallaDeInicio){
        HBox encabezado = new HBox();
        encabezado.setAlignment(Pos.CENTER_LEFT);
        encabezado.setSpacing(150);
    
        //BOTON SIGUIENTE
        Button volverMenuPrincipal = new Button("Volver al Menu principal");
        volverMenuPrincipal.setFont(Font.font("Visage Bold", 20));
        volverMenuPrincipal.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-background-color: #26798E; -fx-font-size: 2em; -fx-text-fill: #FFC172");     
        
        volverMenuPrincipal.setOnAction(e-> {
            String a = volverAlMenu(stage);
            if(a =="Volver"){
                stage.setScene(pantallaDeInicio);
            }
        });
    
    
        //NOMBRE DEL JUGADOR
        Label mejoresPuntajes = new Label("Mejores Puntajes");
        mejoresPuntajes.setLayoutX(220);
        mejoresPuntajes.setLayoutY(60);
        mejoresPuntajes.setFont(Font.font("Visage Bold", 20));
        mejoresPuntajes.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 2em; -fx-text-fill: #FFC172");
            
            
        encabezado.getChildren().add(volverMenuPrincipal);
        //encabezado.getChildren().add(mejoresPuntajes);
            
        this.getChildren().add(mejoresPuntajes);
        this.getChildren().add(encabezado);
        TablaPosiciones = new Scene(this,640, 580, Color.rgb(38, 121, 142));
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
