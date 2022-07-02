package edu.fiuba.algo3;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
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
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuPrincipal extends FlowPane{
    static Scene pantallaDeInicio;
    static String respuesta;

    String botonAntesDeSerPresionado = "-fx-border-width: 0px; -fx-border-color: #2F343A; -fx-background-color: #717D8C; -fx-text-fill: #BDB69C";
    String botonNormal = "-fx-border-width: 0px; -fx-border-color: #2F343A; -fx-background-color: #2F343A; -fx-text-fill: #80CEB9";

    public MenuPrincipal (Stage stage) {
        this.setMenu(stage);
        this.setOrientation(Orientation.VERTICAL);
        this.setStyle(" -fx-padding: 70 100 20 70");
        Image fondoLogo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/fondo-gps.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(fondoLogo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }
    private void setMenu(Stage stage){
        Image tituloFoto = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/titulo-gps.png");
        ImageView nombreDelJuego = new ImageView(tituloFoto);
        nombreDelJuego.setFitHeight(210);
        nombreDelJuego.setFitWidth(400);

        //BOTON DE JUGAR
        Button jugar = new Button(" Jugar");
        jugar.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-jugar.png")));
        jugar.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 55));
        jugar.setStyle(botonNormal);
        jugar.setOnMouseEntered(e -> jugar.setStyle(botonAntesDeSerPresionado));
        jugar.setOnMouseExited(e -> jugar.setStyle(botonNormal));


        //BOTON DE SALIR
        Button salir = new Button(" Salir");
        salir.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 55));
        salir.setStyle(botonNormal);
        salir.setOnMouseEntered(e -> salir.setStyle(botonAntesDeSerPresionado));
        salir.setOnMouseExited(e -> salir.setStyle(botonNormal));
        salir.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-salir.png")));

        salir.setOnAction(e-> {
            String a = cerrarJuego(stage);
            if(a =="Salir"){
                stage.close();
            }
        });
        
        //BOTON DE TABLA DE POSICIONES
        Button tablaPosiciones = new Button(" Tabla de Posiciones");
        tablaPosiciones.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 55));
        tablaPosiciones.setStyle(botonNormal);
        tablaPosiciones.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-tabla.png")));
        tablaPosiciones.setOnMouseEntered(e -> tablaPosiciones.setStyle(botonAntesDeSerPresionado));
        tablaPosiciones.setOnMouseExited(e -> tablaPosiciones.setStyle(botonNormal));


        //PARTE INFERIOR
        HBox parteInferior = new HBox();
        
        //BOTON PANTALLA COMPLETA
        Button pantallaCompleta = new Button("");
        pantallaCompleta.setStyle(botonNormal);
        pantallaCompleta.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-pantalla-completa.png")));
        pantallaCompleta.setOnMouseEntered(e -> pantallaCompleta.setStyle(botonAntesDeSerPresionado));
        pantallaCompleta.setOnMouseExited(e -> pantallaCompleta.setStyle(botonNormal));
        pantallaCompleta.setOnAction(e -> stage.setFullScreen(!stage.isFullScreen()));
        
        //BOTON COMO JUGAR
        Button comoJugar = new Button(" Como Jugar ");
        comoJugar.setStyle(botonNormal);
        comoJugar.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
        comoJugar.setOnMouseEntered(e -> comoJugar.setStyle(botonAntesDeSerPresionado));
        comoJugar.setOnMouseExited(e -> comoJugar.setStyle(botonNormal));
        comoJugar.setOnAction(e -> comoJugar());

        //BOTON ACERCA DE
        Button acercaDe = new Button(" Acerca De ");
        acercaDe.setStyle(botonNormal);
        acercaDe.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
        acercaDe.setOnMouseEntered(e -> acercaDe.setStyle(botonAntesDeSerPresionado));
        acercaDe.setOnMouseExited(e -> acercaDe.setStyle(botonNormal));

        parteInferior.getChildren().add(pantallaCompleta);
        parteInferior.getChildren().add(comoJugar);
        parteInferior.getChildren().add(acercaDe);
        parteInferior.setPadding(new Insets(70, 0, 0, 0));


        this.getChildren().add(nombreDelJuego);
        this.getChildren().add(jugar);
        this.getChildren().add(tablaPosiciones);
        this.getChildren().add(salir);
        this.getChildren().add(parteInferior);
        
        pantallaDeInicio = new Scene(this, 1366, 768);
        
        //BOTON DE TABLA DE POSICIONES FUNCION
        TablaDePosiciones tablaDePosiciones = new TablaDePosiciones(stage, pantallaDeInicio);
        tablaPosiciones.setOnAction(e-> {
            stage.setScene(tablaDePosiciones.getTablaDePosiciones());
        });
        
        //BOTON JUGAR FUNCION
        MenuPreguntas menuPreguntas = new MenuPreguntas(stage, pantallaDeInicio);
        jugar.setOnAction(e -> stage.setScene(menuPreguntas.getMenuPreguntas()));
    }
    
    public Scene getMenu(){
        return pantallaDeInicio;
    }

    private void comoJugar(){
        Stage ventanaComoSalir = new Stage();
        ventanaComoSalir.setResizable(false);
        ventanaComoSalir.setTitle("Como se Juega");
        
        Button botonOK = new Button("OK");
        botonOK.setStyle(botonNormal);
        botonOK.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
        botonOK.setOnMouseEntered(e -> botonOK.setStyle(botonAntesDeSerPresionado));
        botonOK.setOnMouseExited(e -> botonOK.setStyle(botonNormal));
        
        VBox menuSalir = new VBox(20);
        
        Label instrucciones = new Label("aca deberia haber un texto q explique como jugar, \n aparte no debe ser un label");
        instrucciones.setStyle(botonNormal);
        instrucciones.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
        
        menuSalir.getChildren().addAll(instrucciones , botonOK);
        menuSalir.setAlignment(Pos.CENTER);
        menuSalir.setStyle("-fx-border-color: #2F343A; -fx-background-color: #2F343A");
        
        botonOK.setOnAction(e-> {
            respuesta = "Salir";
            ventanaComoSalir.close();
        });

        Scene  escenaSalir = new Scene(menuSalir , 600 , 400);
        Image logo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/logo-gps-challenge.png");
        ventanaComoSalir.getIcons().add(logo);
        ventanaComoSalir.setScene(escenaSalir);
        ventanaComoSalir.showAndWait();
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
        preguntaSalir.setStyle(botonNormal);
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
