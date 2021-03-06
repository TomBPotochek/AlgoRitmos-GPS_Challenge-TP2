package edu.fiuba.algo3;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
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
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;
import edu.fiuba.algo3.ReproductorMusica;
import java.net.URL;

public class MenuPrincipal extends FlowPane{
    static Scene pantallaDeInicio;
    static String respuesta;
    String botonAntesDeSerPresionado = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: #717D8C; -fx-text-fill: #BDB69C";
    String botonNormal = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";
    String formatoTexto = "-fx-border-width: 0px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";

	private Image logoGpsChallenge;
	private Image logoTitulo;
	private Image logoJugar;
	private Image logoSalir;
	private Image logoTabla;
	private Image logoFondo;


    public MenuPrincipal (Stage stage) {
		this.cargarImagenes();
        this.setMenu(stage);
        stage.setMaximized(true);
        this.setOrientation(Orientation.VERTICAL);
        this.setStyle(" -fx-padding: 70 100 20 70");
        
        BackgroundImage imagenDeFondo = new BackgroundImage(this.logoFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
		ReproductorMusica.getReproductor().getMusicaMenu().play();
	}


	private void cargarImagenes() {
		String pathFondoLogo = this.getClass().getResource("/imagenes/fondo-gps-2.png").toString();
		this.logoFondo = new Image(pathFondoLogo); 
		
		String pathTituloFoto = this.getClass().getResource("/imagenes/titulo-gps.png").toString();
		this.logoTitulo = new Image(pathTituloFoto); 
		
		String pathIconoJugar = this.getClass().getResource("/imagenes/icono-jugar.png").toString();
		this.logoJugar = new Image(pathIconoJugar); 
		
		String pathIconoSalir = this.getClass().getResource("/imagenes/icono-salir.png").toString();
		this.logoSalir = new Image(pathIconoSalir); 
		
		String pathIconoTabla = this.getClass().getResource("/imagenes/icono-tabla.png").toString();
		this.logoTabla = new Image(pathIconoTabla);

		String pathLogoGpsChallenge = this.getClass().getResource("/imagenes/logo-gps-challenge.png").toString();
		this.logoGpsChallenge = new Image(pathLogoGpsChallenge); 
	}


    private void setMenu(Stage stage){
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
		
        ImageView nombreDelJuego = new ImageView(this.logoTitulo);
        nombreDelJuego.setFitHeight(210);
        nombreDelJuego.setFitWidth(400);

        //BOTON DE JUGAR
        Button jugar = new Button(" Jugar");
		
        jugar.setGraphic(new ImageView(this.logoJugar));
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
        salir.setGraphic(new ImageView(this.logoSalir));

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
        tablaPosiciones.setGraphic(new ImageView(this.logoTabla));
        tablaPosiciones.setOnMouseEntered(e -> tablaPosiciones.setStyle(botonAntesDeSerPresionado));
        tablaPosiciones.setOnMouseExited(e -> tablaPosiciones.setStyle(botonNormal));


        //PARTE INFERIOR
        HBox parteInferior = new HBox();
        
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
        acercaDe.setOnAction(e -> acercaDe());

        parteInferior.getChildren().add(comoJugar);
        parteInferior.getChildren().add(acercaDe);
        parteInferior.setPadding(new Insets(70, 0, 0, 0));
        parteInferior.setSpacing(10);

        VBox botonesPrincipales = new VBox();
        botonesPrincipales.getChildren().add(nombreDelJuego);
        botonesPrincipales.getChildren().add(jugar);
        botonesPrincipales.getChildren().add(tablaPosiciones);
        botonesPrincipales.getChildren().add(salir);
        botonesPrincipales.getChildren().add(parteInferior);
        botonesPrincipales.setSpacing(10);

        this.getChildren().add(botonesPrincipales);

        
        pantallaDeInicio = new Scene(this, screenSize.getWidth(), screenSize.getHeight(), Color.rgb(47, 52, 58));
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
        + "Este es nuestro proyecto para el Trabajo Pr??ctico N??2\n"+ "\n"
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
		
        ventanaAcercaDe.getIcons().add(this.logoGpsChallenge);
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
        + "Parece f??cil... Pero hay un peque??o detalle: se deber??n atravesar numerosos obst??culos\n"
        + "que pueden favorecer o perjudicar el puntaje. Se puede elegir entre Moto, Auto o 4x4, \n"
        + "y para mover se puede usar las cl??sicas W-A-S-D, o los botones en pantalla.\n"
        + "Obst??culos:\n" + "\n"
        + "* Pozo                                 --> Suma 3 movimientos a Motos y Autos\n"
        + "* Piquete                          --> Los Autos y 4x4 no lo pueden atravesar,\n"
        + "                                                    pero le suma 2 movimientos a las Motos.\n"+ "\n"
        + "* Control Policial                  --> Suma 3 movimientos con frecuencia: \n"
        + "                                                                 - el 30% de las veces para las 4x4\n"
        + "                                                                 - el 50% de las veces para los Autos\n"
        + "                                                                 - el 80% de las veces para las Motos\n"+ "\n"
        + " * Sorpresa Favorable                  --> Descuenta un 20% a los movimientos acumulados.\n"+ "\n"
        + "* Sorpresa Desfavorable             --> Aumenta un 25% a los movimientos acumulados.\n"+ "\n"
        + " * Sorpresa Cambio de Veh??culo   --> Cambia el veh??culo a:\n"
        + "                                             - Moto --> Auto\n"
        + "                                             - Auto --> 4x4\n"
        + "                                             - 4x4  --> Moto\n");

        Label instrucciones = new Label(parrafoComoJugar);
        instrucciones.setStyle(formatoTexto);
        instrucciones.setFont(Font.font("Impact", FontWeight.LIGHT, 20));
        
        menuSalir.getChildren().addAll(instrucciones , botonOK);
        menuSalir.setAlignment(Pos.CENTER);
        menuSalir.setStyle("-fx-border-color: #2F343A; -fx-background-color: #2F343A");
        
        botonOK.setOnAction(e-> {
            ventanaComoSalir.close();
        });

        Scene  escenaSalir = new Scene(menuSalir , 800 , 700);
        ventanaComoSalir.getIcons().add(this.logoGpsChallenge);
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

        Scene  escenaSalir = new Scene(menuSalir , 370 , 200);
        ventanaSalir.getIcons().add(this.logoGpsChallenge);
        ventanaSalir.setScene(escenaSalir);
        ventanaSalir.showAndWait();
        return(respuesta);
    }
}
