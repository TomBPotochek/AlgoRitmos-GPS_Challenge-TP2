package edu.fiuba.algo3;

import java.util.Map;

import edu.fiuba.algo3.modelo.juego.Ranking;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class TablaDePosiciones extends BorderPane{
    static String respuesta;
    Scene TablaPosiciones;

    String botonAntesDeSerPresionado = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: #717D8C; -fx-text-fill: #BDB69C";
    String botonNormal = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";

    String formatoTexto = "-fx-border-width: 0px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";

    public TablaDePosiciones(Stage stage, Scene pantallaDeInicio){
        this.setTablaDePosiciones(stage, pantallaDeInicio);
        stage.setMaximized(true);
        Image fondoLogo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/fondo-gps-3.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(fondoLogo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }
    
    public Scene getTablaDePosiciones(){
        this.actualizarTabla();
        return TablaPosiciones;
    }
    
    private void actualizarTabla(){
        VBox tabla = new VBox();
        Ranking ranking = Ranking.getRanking();
        
        for(Map.Entry<String,Integer> entrada: ranking.obtenerRanking()){
            Label jugadorNuevo = new Label(String.format("%s %d", entrada.getKey(), entrada.getValue()));
            jugadorNuevo.setStyle(formatoTexto);
            jugadorNuevo.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 35));
            tabla.getChildren().add(jugadorNuevo);
        }

        tabla.setAlignment(Pos.TOP_CENTER);
        this.setCenter(tabla);
    }

    private void setTablaDePosiciones(Stage stage, Scene pantallaDeInicio){
        HBox encabezado = new HBox();
        encabezado.setAlignment(Pos.CENTER_LEFT);
        encabezado.setSpacing(150);
    
        //BOTON SIGUIENTE
        Button volverMenuPrincipal = new Button("Volver al Menu");
        volverMenuPrincipal.setStyle(botonNormal);
        volverMenuPrincipal.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 35));
        volverMenuPrincipal.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-volver.png")));
        volverMenuPrincipal.setOnMouseEntered(e -> volverMenuPrincipal.setStyle(botonAntesDeSerPresionado));
        volverMenuPrincipal.setOnMouseExited(e -> volverMenuPrincipal.setStyle(botonNormal));

        volverMenuPrincipal.setOnAction(e-> {
            String a = volverAlMenu(stage);
            if(a =="Volver"){
                stage.setScene(pantallaDeInicio);
            }
        });
    
    
        //NOMBRE DEL JUGADOR
        Label mejoresPuntajes = new Label("Mejores Puntajes");
        mejoresPuntajes.setLayoutX(300);
        mejoresPuntajes.setLayoutY(60);
        mejoresPuntajes.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 45));
        mejoresPuntajes.setStyle(formatoTexto);
        
        encabezado.getChildren().add(volverMenuPrincipal);
        encabezado.getChildren().add(mejoresPuntajes);
        this.setTop(encabezado);

        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        TablaPosiciones = new Scene(this, screenSize.getWidth(), screenSize.getHeight(), Color.rgb(47, 52, 58));
        }

    private String volverAlMenu(Stage stage){
        Stage ventanaVolver = new Stage();
        ventanaVolver.setResizable(false);
        ventanaVolver.setTitle("Volver al Menu");
        
        Button botonVolver = new Button("Volver al Menu Principal");
        botonVolver.setFont(Font.font("Impact", 25));
        botonVolver.setStyle(botonNormal);
        botonVolver.setOnMouseEntered(e -> botonVolver.setStyle(botonAntesDeSerPresionado));
        botonVolver.setOnMouseExited(e -> botonVolver.setStyle(botonNormal));
        
        Button botonQuedarse = new Button("Quedarse");
        botonQuedarse.setFont(Font.font("Impact", 25));
        botonQuedarse.setStyle(botonNormal);
        botonQuedarse.setOnMouseEntered(e -> botonQuedarse.setStyle(botonAntesDeSerPresionado));
        botonQuedarse.setOnMouseExited(e -> botonQuedarse.setStyle(botonNormal));

        VBox menuVolver = new VBox(20);
        
        Label preguntaVolver = new Label("¿Estás seguro que querés ir al Menu Principal?");
        preguntaVolver.setFont(Font.font("Impact", 30));
        preguntaVolver.setStyle(formatoTexto);
        
        Label advertenciaDatos = new Label("Todo tu progreso se perdera");
        advertenciaDatos.setFont(Font.font("Impact", 30));
        advertenciaDatos.setStyle(formatoTexto);
        
        ventanaVolver.setMinWidth(280);
        ventanaVolver.initModality(Modality.APPLICATION_MODAL);
        
        menuVolver.getChildren().addAll(preguntaVolver, advertenciaDatos, botonVolver, botonQuedarse);
        menuVolver.setAlignment(Pos.CENTER);
        menuVolver.setStyle("-fx-border-color: #2F343A; -fx-background-color: #2F343A");
        
        botonVolver.setOnAction(e-> {
            respuesta = "Volver";
            ventanaVolver.close();
        });
        
        botonQuedarse.setOnAction(e->{
            respuesta  = "Quedarse";
            ventanaVolver.close();
        });

        Scene  escenaVolver = new Scene(menuVolver , 580 , 300);
        Image logo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/logo-gps-challenge.png");
        ventanaVolver.getIcons().add(logo);
        ventanaVolver.setScene(escenaVolver);
        ventanaVolver.showAndWait();
        return(respuesta);
    }

}
