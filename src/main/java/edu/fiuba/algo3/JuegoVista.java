package edu.fiuba.algo3;

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
import javafx.scene.control.ToolBar;
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
import edu.fiuba.algo3.modelo.casillero.azar.Azar;
import edu.fiuba.algo3.modelo.juego.Juego;

public class JuegoVista extends BorderPane {
    static String respuesta;
    static Scene juegoVista;
    static ToolBar barra;
    static Juego juego;
    static Group contenedorCentral;

    String botonAntesDeSerPresionado = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: #717D8C; -fx-text-fill: #BDB69C";
    String botonNormal = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";

    String formatoTexto = "-fx-border-width: 0px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";


    public JuegoVista(Stage stage, Scene pantallaDeInicio, int ancho, int alto, String nombreJugador, String eleccionVehiculo){
        this.setJuego(stage, pantallaDeInicio, ancho, alto, nombreJugador, eleccionVehiculo);
        stage.setMaximized(true);
        Image fondoLogo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/fondo-gps-3.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(fondoLogo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    }

    public Scene getJuegoVista(){
        return juegoVista;
    }

    private void setJuego(Stage stage, Scene pantallaDeInicio, int ancho, int alto, String nombreJugador, String eleccionVehiculo){

        //NOMBRE DEL JUGADOR
        Label nombreDelJugador = new Label("Jugador: \n" + nombreJugador);
        nombreDelJugador.setFont(Font.font("Impact", 40));
        nombreDelJugador.setStyle(formatoTexto);

        juego = new Juego(nombreJugador, new Azar());
        juego.setVehiculo(eleccionVehiculo);
        juego.setDimensionesMapa(ancho, alto);

        //Puntuacion
        Label puntajeActual = new Label("Puntaje");
        puntajeActual.setFont(Font.font("Impact", 40));
        puntajeActual.setStyle(formatoTexto);


        Tablero grilla = new Tablero(alto,ancho, juego);
        
        this.setCenter(grilla.getContenedor());

        Canvas canvasCentral = new Canvas(900, 650);
        JugadorVista jugadorVista = new JugadorVista(juego, canvasCentral, grilla, stage,pantallaDeInicio,puntajeActual);


		// Menu bar
        MenuBar barraSuperior = new MenuBar();
        barraSuperior.setStyle("-fx-border-width: 0px; -fx-border-color: #2F343A; -fx-background-color: #717D8C; -fx-text-fill: #BDB69C; -fx-font-family: Impact; -fx-font-size: 20");
        
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
				jugadorVista.salirDelJuego();
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

        //Boton DERECHA
        Button moverseDerecha = new Button("");
        moverseDerecha.setFont(Font.font("Impact", 35));
        moverseDerecha.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-boton-derecha.png")));
        moverseDerecha.setStyle(formatoTexto);
        moverseDerecha.setOnMouseEntered(e -> moverseDerecha.setStyle("-fx-background-color: #717D8C; -fx-text-fill: #BDB69C"));
        moverseDerecha.setOnMouseExited(e -> moverseDerecha.setStyle(formatoTexto));
        
        Button moverseAbajo = new Button("");
        moverseAbajo.setFont(Font.font("Impact", 35));
        moverseAbajo.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-boton-abajo.png")));
        moverseAbajo.setStyle(formatoTexto);
        moverseAbajo.setOnMouseEntered(e -> moverseAbajo.setStyle("-fx-background-color: #717D8C; -fx-text-fill: #BDB69C"));
        moverseAbajo.setOnMouseExited(e -> moverseAbajo.setStyle(formatoTexto));
        
        Button moverseIzquierda = new Button("");
        moverseIzquierda.setFont(Font.font("Impact", 35));
        moverseIzquierda.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-boton-izqueirda.png")));
        moverseIzquierda.setStyle(formatoTexto);
        moverseIzquierda.setOnMouseEntered(e -> moverseIzquierda.setStyle("-fx-background-color: #717D8C; -fx-text-fill: #BDB69C"));
        moverseIzquierda.setOnMouseExited(e -> moverseIzquierda.setStyle(formatoTexto));
        
        Button moverseArriba = new Button("");
        moverseArriba.setFont(Font.font("Impact", 35));
        moverseArriba.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-boton-arriba.png")));
        moverseArriba.setStyle(formatoTexto);
        moverseArriba.setOnMouseEntered(e -> moverseArriba.setStyle("-fx-background-color: #717D8C; -fx-text-fill: #BDB69C"));
        moverseArriba.setOnMouseExited(e -> moverseArriba.setStyle(formatoTexto));
        
        VBox botonesMovimiento = new VBox();

        HBox sonidos = new HBox();
        BotonMusica apagarMusica = new BotonMusica("Silenciar",jugadorVista);
        apagarMusica.setOnAction(((BotonMusica) apagarMusica).silenciar());
        apagarMusica.setStyle(botonNormal);
        apagarMusica.setFont(Font.font("Impact", 35));
        apagarMusica.setOnMouseEntered(e -> apagarMusica.setStyle(botonAntesDeSerPresionado));
        apagarMusica.setOnMouseExited(e -> apagarMusica.setStyle(botonNormal));
        sonidos.getChildren().add(apagarMusica);
        sonidos.setAlignment(Pos.TOP_CENTER);

        BotonMusica encenderMusica = new BotonMusica("Encender",jugadorVista);
        encenderMusica.setOnAction(encenderMusica.reproducir());
        encenderMusica.setStyle(botonNormal);
        encenderMusica.setFont(Font.font("Impact", 35));
        encenderMusica.setOnMouseEntered(e -> encenderMusica.setStyle(botonAntesDeSerPresionado));
        encenderMusica.setOnMouseExited(e -> encenderMusica.setStyle(botonNormal));
        sonidos.getChildren().add(encenderMusica);
        //this.setTop(sonidos);

        MoverseALaDerechaEventHandler moverseDerechaHandler = new MoverseALaDerechaEventHandler(jugadorVista);
        moverseDerecha.setOnAction(moverseDerechaHandler);
        
        MoverseALaIzquierdaEventHandler moverseIzquierdaHandler = new MoverseALaIzquierdaEventHandler(jugadorVista);
        moverseIzquierda.setOnAction(moverseIzquierdaHandler);
        
        MoverseAbajoEventHandler moverseAbajoHandler = new MoverseAbajoEventHandler(jugadorVista);
        moverseAbajo.setOnAction(moverseAbajoHandler);
        
        MoverseArribaEventHandler moverseArribaHandler = new MoverseArribaEventHandler(jugadorVista);
        moverseArriba.setOnAction(moverseArribaHandler);
        
        
        HBox botonesID = new HBox();
        botonesID.getChildren().add(moverseIzquierda);
        botonesID.getChildren().add(moverseDerecha);
        botonesID.setAlignment(Pos.CENTER);
        botonesID.setSpacing(5);
        
        moverseArriba.setAlignment(Pos.CENTER);
        botonesMovimiento.getChildren().add(moverseArriba);
        botonesMovimiento.getChildren().add(botonesID);
        moverseAbajo.setAlignment(Pos.CENTER);
        botonesMovimiento.getChildren().add(moverseAbajo);
        botonesMovimiento.setAlignment(Pos.CENTER);

        //BORDE IZQUIERDO
        VBox bordeIzquierdo = new VBox();
        bordeIzquierdo.getChildren().addAll(nombreDelJugador, puntajeActual,botonesMovimiento);
        bordeIzquierdo.setSpacing(100);
        bordeIzquierdo.setPadding(new Insets(50, 0, 50, 80));
        this.setAlignment(bordeIzquierdo, Pos.CENTER_LEFT);
        this.setLeft(bordeIzquierdo);


        Label controlPolical = new Label(": Control Policial");
        controlPolical.setFont(Font.font("Impact", 30));
        controlPolical.setStyle("-fx-border-width: 0px; -fx-border-color: transparent; -fx-background-color: transparent; -fx-text-fill: #BDB69C");
        controlPolical.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-control-policial.png")));

        Label pozo = new Label(": Pozo");
        pozo.setFont(Font.font("Impact", 30));
        pozo.setStyle("-fx-border-width: 0px; -fx-border-color: transparent; -fx-background-color: transparent; -fx-text-fill: #BDB69C");
        pozo.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-pozo.png")));

        Label piquete = new Label(": Piquete");
        piquete.setFont(Font.font("Impact", 30));
        piquete.setStyle("-fx-border-width: 0px; -fx-border-color: transparent; -fx-background-color: transparent; -fx-text-fill: #BDB69C");
        piquete.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-piquete.png")));

        Label sorpresaFavorable = new Label(": Sorpresa");
        sorpresaFavorable.setFont(Font.font("Impact", 30));
        sorpresaFavorable.setStyle("-fx-border-width: 0px; -fx-border-color: transparent; -fx-background-color: transparent; -fx-text-fill: #BDB69C");
        sorpresaFavorable.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-sorpresa.png")));

        VBox bordeDerecho = new VBox();
        bordeDerecho.getChildren().addAll(controlPolical, pozo, piquete, sorpresaFavorable);
        bordeDerecho.setSpacing(100);
        bordeDerecho.setPadding(new Insets(10, 0, 0, 30));
        this.setAlignment(bordeDerecho, Pos.CENTER_RIGHT);
        this.setRight(bordeDerecho);


        //CONSOLA INFERIOR
        VBox contenedorConsola = new VBox();
        contenedorConsola.setSpacing(10);
        contenedorConsola.setPadding(new Insets(15));
        //contenedorConsola.setStyle("-fx-background-color: black;");
        contenedorConsola.getChildren().add(sonidos);

        this.setAlignment(contenedorConsola, Pos.TOP_LEFT);
        this.setBottom(contenedorConsola);

        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        juegoVista = new Scene(this,screenSize.getWidth(), screenSize.getHeight(), Color.rgb(47, 52, 58));
        juegoVista.setOnKeyPressed(new Controles(stage,jugadorVista));
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
        
        String parrafoAcercaDe = new String("Somos el grupo 19 de la materia ALGORITMOS Y PROGRAMACION III FIUBA.\n"
        + "Este es nuestro proyecto para el Trabajo Práctico Nº2\n"+ "\n"
        + "Si queres ver el codigo de este proyecto podes ir a:\n"+ "\n"
        + "https://github.com/TomBPotochek/AlgoRitmos-GPS_Challenge-TP2\n");

        Label instrucciones = new Label(parrafoAcercaDe);
        instrucciones.setStyle(formatoTexto);
        instrucciones.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 25));
        
        menuSalir.getChildren().addAll(instrucciones , botonOK);
        menuSalir.setAlignment(Pos.CENTER);
        menuSalir.setStyle("-fx-border-color: #2F343A; -fx-background-color: #2F343A");
        
        botonOK.setOnAction(e-> {
            ventanaAcercaDe.close();
        });

        Scene  escenaSalir = new Scene(menuSalir , 800 , 400);
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
        
        String parrafoComoJugar = new String("El objetivo del juego es llegar a la meta en la  menor cantidad de movimientos posibles.\n"
        + "Parece fácil... Pero hay un pequeño detalle: se deberán atravesar numerosos obstáculos\n"
        + "que pueden favorecer o perjudicar el puntaje. Se puede elegir entre Moto, Auto o 4x4, \n"
        + "y para mover se puede usar las clásicas W-A-S-D, o los botones en pantalla.\n"
        + "Obstáculos:\n" + "\n"
        + "* Pozo                                 --> Suma 3 movimientos a Motos y Autos\n"
        + "* Piquete                          --> Los Autos y 4x4 no lo pueden atravesar,\n"
        + "                                                    pero le suma 2 movimientos a las Motos.\n"+ "\n"
        + "* Control Policial                  --> Suma 3 movimientos con frecuencia: \n"
        + "                                                                 - el 30% de las veces para las 4x4\n"
        + "                                                                 - el 50% de las veces para los Autos\n"
        + "                                                                 - el 80% de las veces para las Motos\n"+ "\n"
        + " * Sorpresa Favorable                  --> Descuenta un 20% a los movimientos acumulados.\n"+ "\n"
        + "* Sorpresa Desfavorable             --> Aumenta un 25% a los movimientos acumulados.\n"+ "\n"
        + " * Sorpresa Cambio de Vehículo   --> Cambia el vehículo a:\n"
        + "                                             - Moto --> Auto\n"
        + "                                             - Auto --> 4x4\n"
        + "                                             - 4x4  --> Moto\n");

        Label instrucciones = new Label(parrafoComoJugar);
        instrucciones.setStyle(formatoTexto);
        instrucciones.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 20));
        
        menuSalir.getChildren().addAll(instrucciones , botonOK);
        menuSalir.setAlignment(Pos.CENTER);
        menuSalir.setStyle("-fx-border-color: #2F343A; -fx-background-color: #2F343A");
        
        botonOK.setOnAction(e-> {
            ventanaComoSalir.close();
        });

        Scene  escenaSalir = new Scene(menuSalir , 800 , 700);
        Image logo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/logo-gps-challenge.png");
        ventanaComoSalir.getIcons().add(logo);
        ventanaComoSalir.setScene(escenaSalir);
        ventanaComoSalir.showAndWait();
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
