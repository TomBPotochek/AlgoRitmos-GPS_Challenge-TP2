package edu.fiuba.algo3;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import edu.fiuba.algo3.modelo.casillero.azar.Azar;
import edu.fiuba.algo3.modelo.juego.Juego;

import java.util.ArrayList;
import java.util.Arrays;

import edu.fiuba.algo3.MoverseALaDerechaEventHandler;

public class JuegoVista extends BorderPane {
    static String respuesta;
    static Scene juegoVista;
    static ToolBar barra;
    static Juego juego;
    static VBox contenedorCentral;
    static GridPane grilla;

    String botonAntesDeSerPresionado = "-fx-border-width: 0px; -fx-border-color: #2F343A; -fx-background-color: #717D8C; -fx-text-fill: #BDB69C";
    String botonNormal = "-fx-border-width: 0px; -fx-border-color: transparent; -fx-background-color: transparent; -fx-text-fill: #80CEB9";


    public JuegoVista(Stage stage, Scene pantallaDeInicio, int ancho, int alto, String nombreJugador){
        this.setJuego(stage, pantallaDeInicio, ancho, alto, nombreJugador);
        this.setCentro();
        stage.setMaximized(true);
        // Image fondoLogo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/fondo-gps.png");
        // BackgroundImage imagenDeFondo = new BackgroundImage(fondoLogo, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        // this.setBackground(new Background(imagenDeFondo));
        this.setStyle("-fx-background-color: #2F343A");
    }
    public void setCentro(){
        //Canvas grilla = new Canvas(460,220);
        Canvas grilla = new Canvas();
        contenedorCentral = new VBox(grilla);
        contenedorCentral.setAlignment(Pos.CENTER);
        contenedorCentral.setSpacing(20);
        contenedorCentral.setPadding(new Insets(25));
        this.setCenter(contenedorCentral);
    }
    public Scene getJuegoVista(){
        return juegoVista;
    }
    private void setJuego(Stage stage, Scene pantallaDeInicio, int ancho, int alto, String nombreJugador){
        MenuBar barraSuperior = new MenuBar();

        Menu archivo = new Menu("Archivo");
        barraSuperior.getMenus().add(archivo);
        this.setAlignment(barraSuperior, Pos.CENTER);

        Menu ver = new Menu("Ver");
        barraSuperior.getMenus().add(ver);
        
        Menu ayuda = new Menu("Ayuda");
        barraSuperior.getMenus().add(ayuda);

        MenuItem archivoSalir = new MenuItem("Salir");
        archivoSalir.setOnAction(e-> {
            String a = volverAlMenu(stage);
            if(a =="Volver"){
                stage.setScene(pantallaDeInicio);
            }
        });
        archivo.getItems().addAll(archivoSalir);

        MenuItem ayudaAcercaDe = new MenuItem("Acerca De");
        MenuItem ayudaComoJugar = new MenuItem("Como Jugar");
        ayudaComoJugar.setOnAction(e -> comoJugar());
        ayudaAcercaDe.setOnAction(e -> acercaDe());

        ayuda.getItems().addAll(ayudaComoJugar, new SeparatorMenuItem(), ayudaAcercaDe);

        MenuItem pantallaCompleta = new MenuItem("Pantalla Completa");
        pantallaCompleta.setOnAction(e -> stage.setFullScreen(!stage.isFullScreen()));
        ver.getItems().addAll(pantallaCompleta);
        
        
        this.setTop(barraSuperior);


        //NOMBRE DEL JUGADOR
        Label nombreDelJugador = new Label("Jugador: " + nombreJugador);
        nombreDelJugador.setFont(Font.font("Impact", 40));
        nombreDelJugador.setStyle(botonNormal);
        
        //Puntuacion
        Label puntajeActual = new Label("Puntaje: 0");
        puntajeActual.setFont(Font.font("Impact", 40));
        puntajeActual.setStyle(botonNormal);

        //this.insertarCuadras(ancho, alto);

        juego = new Juego(nombreJugador, new Azar());
        //aca van los sets de mapa
        JugadorVista jugadorVista = new JugadorVista(juego);
        juego.setDimensionesMapa(7, 11);

        this.getChildren().add(jugadorVista.getDibujo());
        //this.setCenter(jugadorVista.getDibujo());
        //this.
        //VBox dibujoJugador = new VBox();
        //dibujoJugador.getChildren().add(jugadorVista.getDibujo());

        //Boton DERECHA
        Button moverseDerecha = new Button("");
        moverseDerecha.setFont(Font.font("Impact", 35));
        moverseDerecha.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-boton-derecha.png")));
        moverseDerecha.setStyle(botonNormal);
        moverseDerecha.setOnMouseEntered(e -> moverseDerecha.setStyle(botonAntesDeSerPresionado));
        moverseDerecha.setOnMouseExited(e -> moverseDerecha.setStyle(botonNormal));
        
        Button moverseAbajo = new Button("");
        moverseAbajo.setFont(Font.font("Impact", 35));
        moverseAbajo.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-boton-abajo.png")));
        moverseAbajo.setStyle(botonNormal);
        moverseAbajo.setOnMouseEntered(e -> moverseAbajo.setStyle(botonAntesDeSerPresionado));
        moverseAbajo.setOnMouseExited(e -> moverseAbajo.setStyle(botonNormal));
        
        Button moverseIzquierda = new Button("");
        moverseIzquierda.setFont(Font.font("Impact", 35));
        moverseIzquierda.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-boton-izqueirda.png")));
        moverseIzquierda.setStyle(botonNormal);
        moverseIzquierda.setOnMouseEntered(e -> moverseIzquierda.setStyle(botonAntesDeSerPresionado));
        moverseIzquierda.setOnMouseExited(e -> moverseIzquierda.setStyle(botonNormal));
        
        Button moverseArriba = new Button("");
        moverseArriba.setFont(Font.font("Impact", 35));
        moverseArriba.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-boton-arriba.png")));
        moverseArriba.setStyle(botonNormal);
        moverseArriba.setOnMouseEntered(e -> moverseArriba.setStyle(botonAntesDeSerPresionado));
        moverseArriba.setOnMouseExited(e -> moverseArriba.setStyle(botonNormal));
        
        VBox botonesMovimiento = new VBox();
        botonesMovimiento.setAlignment(Pos.CENTER);
        
        MoverseALaDerechaEventHandler moverseDerechaHandler = new MoverseALaDerechaEventHandler(jugadorVista);
        moverseDerecha.setOnAction(moverseDerechaHandler);
        
        MoverseALaIzquierdaEventHandler moverseIzquierdaHandler = new MoverseALaIzquierdaEventHandler(jugadorVista);
        moverseIzquierda.setOnAction(moverseIzquierdaHandler);
        
        MoverseAbajoEventHandler moverseAbajoHandler = new MoverseAbajoEventHandler(jugadorVista);
        moverseAbajo.setOnAction(moverseAbajoHandler);
        
        MoverseArribaEventHandler moverseArribaHandler = new MoverseArribaEventHandler(jugadorVista);
        moverseArriba.setOnAction(moverseArribaHandler);
        
        botonesMovimiento.getChildren().add(moverseArriba);
        
        HBox botonesID = new HBox();
        botonesID.getChildren().add(moverseIzquierda);
        botonesID.getChildren().add(moverseDerecha);
        botonesID.setAlignment(Pos.CENTER);
        botonesID.setSpacing(5);
        
        botonesMovimiento.getChildren().add(botonesID);
        botonesMovimiento.getChildren().add(moverseAbajo);

        //this.setCenter(dibujoJugador);

        VBox bordeIzquierdo = new VBox();
        bordeIzquierdo.getChildren().addAll(nombreDelJugador, puntajeActual,botonesMovimiento);
        bordeIzquierdo.setSpacing(100);
        bordeIzquierdo.setPadding(new Insets(50, 0, 50, 80));
        this.setAlignment(bordeIzquierdo, Pos.CENTER_LEFT);
        this.setLeft(bordeIzquierdo);


        Label controlPolical = new Label(": Control Policial");
        controlPolical.setFont(Font.font("Impact", 30));
        controlPolical.setStyle("-fx-border-width: 0px; -fx-border-color: transparent; -fx-background-color: transparent; -fx-text-fill: #BDB69C");

        Label pozo = new Label(": Pozo");
        pozo.setFont(Font.font("Impact", 30));
        pozo.setStyle("-fx-border-width: 0px; -fx-border-color: transparent; -fx-background-color: transparent; -fx-text-fill: #BDB69C");

        Label piquete = new Label(": Piquete");
        piquete.setFont(Font.font("Impact", 30));
        piquete.setStyle("-fx-border-width: 0px; -fx-border-color: transparent; -fx-background-color: transparent; -fx-text-fill: #BDB69C");

        Label sorpresaFavorable = new Label(": Sorpresa Favorable");
        sorpresaFavorable.setFont(Font.font("Impact", 30));
        sorpresaFavorable.setStyle("-fx-border-width: 0px; -fx-border-color: transparent; -fx-background-color: transparent; -fx-text-fill: #BDB69C");

        Label sorpresaDesfavorable = new Label(": Sorpresa Desfavorable");
        sorpresaDesfavorable.setFont(Font.font("Impact", 30));
        sorpresaDesfavorable.setStyle("-fx-border-width: 0px; -fx-border-color: transparent; -fx-background-color: transparent; -fx-text-fill: #BDB69C");


        VBox bordeDerecho = new VBox();
        bordeDerecho.getChildren().addAll(controlPolical, pozo, piquete, sorpresaFavorable, sorpresaDesfavorable);
        bordeDerecho.setSpacing(100);
        bordeDerecho.setPadding(new Insets(50, 80, 50, 00));
        this.setAlignment(bordeDerecho, Pos.CENTER_RIGHT);
        this.setRight(bordeDerecho);


        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        juegoVista = new Scene(this,screenSize.getWidth(), screenSize.getHeight(), Color.rgb(47, 52, 58));
        juegoVista.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent keyEvent) {
                EventHandler<KeyEvent> mov;
                switch(keyEvent.getCode()){
                    case W: mov = new MovArribaEventHandlerKey(jugadorVista);
                            mov.handle(keyEvent);
                            break;
                    case S: mov = new MovAbajoEventHandlerKey(jugadorVista);
                            mov.handle(keyEvent);
                            break;
                    case D: mov = new MovDerechaEventHandlerKey(jugadorVista);
                            mov.handle(keyEvent);
                            break;
                    case A: mov = new MovIzquierdaEventHandlerKey(jugadorVista);
                            mov.handle(keyEvent);
                            break;
                }
            }
        });


    }

    private void acercaDe(){
        Stage ventanaAcercaDe = new Stage();
        ventanaAcercaDe.setResizable(false);
        ventanaAcercaDe.setTitle("Acerca De");
        
        Button botonOK = new Button("OK");
        botonOK.setStyle(botonNormal);
        botonOK.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
        botonOK.setOnMouseEntered(e -> botonOK.setStyle(botonAntesDeSerPresionado));
        botonOK.setOnMouseExited(e -> botonOK.setStyle(botonNormal));
        
        VBox menuSalir = new VBox(20);
        
        Label instrucciones = new Label("aca deberia haber un texto q de info nuestra\n y el link al github, aparte no debe ser un label");
        instrucciones.setStyle(botonNormal);
        instrucciones.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
        
        menuSalir.getChildren().addAll(instrucciones , botonOK);
        menuSalir.setAlignment(Pos.CENTER);
        menuSalir.setStyle("-fx-border-color: #2F343A; -fx-background-color: #2F343A");
        
        botonOK.setOnAction(e-> {
            ventanaAcercaDe.close();
        });

        Scene  escenaSalir = new Scene(menuSalir , 600 , 400);
        Image logo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/logo-gps-challenge.png");
        ventanaAcercaDe.getIcons().add(logo);
        ventanaAcercaDe.setScene(escenaSalir);
        ventanaAcercaDe.showAndWait();
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
            ventanaComoSalir.close();
        });

        Scene  escenaSalir = new Scene(menuSalir , 600 , 400);
        Image logo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/logo-gps-challenge.png");
        ventanaComoSalir.getIcons().add(logo);
        ventanaComoSalir.setScene(escenaSalir);
        ventanaComoSalir.showAndWait();
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
        preguntaVolver.setStyle(botonNormal);
        
        Label advertenciaDatos = new Label("Todo tu progreso se perdera");
        advertenciaDatos.setFont(Font.font("Impact", 30));
        advertenciaDatos.setStyle(botonNormal);
        
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
