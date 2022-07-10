package edu.fiuba.algo3;

import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import java.lang.Runnable;

public class MenuPreguntas extends BorderPane{

    static Scene preguntaDatos;
    static String respuesta;
    Boolean confirmacionDatos;
    String botonAntesDeSerPresionado = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: #717D8C; -fx-text-fill: #BDB69C";
    String botonNormal = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";
    String formatoTexto = "-fx-border-width: 0px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";

	private Image logoFondo;
	private Image logoGpsChallenge;
	private Image iconoVolver;


    public MenuPreguntas(Stage stage, Scene pantallaDeInicio) {
        this.cargarImagenes();
		this.setMenuPreguntas(stage, pantallaDeInicio);
        stage.setMaximized(true);
	}

    public Scene getMenuPreguntas(){
        return preguntaDatos;
    }

	private void cargarImagenes() {
		String pathLogoFondo = this.getClass().getResource("/imagenes/fondo-gps-3.png").toString();
		this.logoFondo = new Image(pathLogoFondo); 
		
		String pathLogoGpsChallenge = this.getClass().getResource("/imagenes/fondo-gps-2.png").toString();
		this.logoGpsChallenge = new Image(pathLogoGpsChallenge); 
		
		String pathIconoVolver = this.getClass().getResource("/imagenes/icono-volver.png").toString();
		this.iconoVolver = new Image(pathIconoVolver); 
	}

    private void setMenuPreguntas(Stage stage, Scene pantallaDeInicio) {
        //ESCENA PREGUNTAR DATOS DEL JUGADOR Y LA PARTIDA
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        preguntaDatos = new Scene(this,screenSize.getWidth(), screenSize.getHeight(), Color.rgb(47, 52, 58));
        BackgroundImage imagenDeFondo = new BackgroundImage(this.logoFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    
        //BOTON DE VOLVER A LA PANTALLA DE INICIO
        Button volverPantallaInicial = new Button("Volver al Menu");
        volverPantallaInicial.setGraphic(new ImageView(this.iconoVolver));
        volverPantallaInicial.setFont(Font.font("Impact", 40));
        volverPantallaInicial.setStyle(botonNormal);
        volverPantallaInicial.setOnMouseEntered(e -> volverPantallaInicial.setStyle(botonAntesDeSerPresionado));
        volverPantallaInicial.setOnMouseExited(e -> volverPantallaInicial.setStyle(botonNormal));

        volverPantallaInicial.setOnAction(e-> {
			stage.setScene(pantallaDeInicio);
            // String a = this.volverAlMenu(stage);
            // if(a =="Volver"){
            // }
        });
    
        //JUGADOR INSERTA NOMBRE
        VBox preguntas = new VBox();
        preguntas.setAlignment(Pos.CENTER);
        preguntas.setSpacing(30);
        preguntas.setStyle("-fx-padding: 100;");
        
        //PREGUNTA DEL NOMBRE
        Label preguntaNombre = new Label("Nombre del Jugador");
        preguntaNombre.setFont(Font.font("Impact", 50));
        preguntaNombre.setStyle(formatoTexto);
    
        //INPUT NOMBRE DEL JUGADOR
        TextField nombreDelJugador = new TextField();
        nombreDelJugador.setAlignment(Pos.CENTER);
        nombreDelJugador.setPromptText("Inserte un nombre");
        nombreDelJugador.setFont(Font.font("Impact", 50));
        nombreDelJugador.setStyle(botonNormal);
        nombreDelJugador.setOnMouseEntered(e -> nombreDelJugador.setStyle(botonAntesDeSerPresionado));
        nombreDelJugador.setOnMouseExited(e -> nombreDelJugador.setStyle(botonNormal));

        //PREGUNTA DEL NOMBRE
        Label seleccioneUnVehiculo = new Label("Seleccione Un Vehiculo");
        seleccioneUnVehiculo.setFont(Font.font("Impact", 50));
        seleccioneUnVehiculo.setStyle(formatoTexto);
    
        //INPUT NOMBRE DEL JUGADOR
        ChoiceBox<String> seleccionVehiculo = new ChoiceBox();
        seleccionVehiculo.getItems().addAll("Moto", "Auto", "4 X 4");
        seleccionVehiculo.setMinWidth(200);
        seleccionVehiculo.setMinHeight(100);
        seleccionVehiculo.setStyle("-fx-border-width: 0px; -fx-border-color: #2F343A; -fx-background-color: #717D8C; -fx-text-fill: #BDB69C; -fx-font-family: Impact; -fx-font-size: 40; -fx-color: #BDB69C");
        seleccionVehiculo.setOnMouseEntered(e -> seleccionVehiculo.setStyle("-fx-border-width: 0px; -fx-border-color: #2F343A; -fx-background-color: #717D8C; -fx-text-fill: #BDB69C; -fx-font-family: Impact; -fx-font-size: 40; -fx-color: #BDB69C"));
        seleccionVehiculo.setOnMouseExited(e -> seleccionVehiculo.setStyle("-fx-border-width: 0px; -fx-border-color: #2F343A; -fx-background-color: #717D8C; -fx-text-fill: #BDB69C; -fx-font-family: Impact; -fx-font-size: 40; -fx-color: #BDB69C"));

        //BOTON SIGUIENTE
        Button siguiente = new Button("Aceptar");
        siguiente.setFont(Font.font("Impact", 50));
        siguiente.setStyle(botonNormal);
        siguiente.setOnMouseEntered(e -> siguiente.setStyle(botonAntesDeSerPresionado));
        siguiente.setOnMouseExited(e -> siguiente.setStyle(botonNormal));
        
        siguiente.setOnAction(e-> {
            if(preguntarDatosCorrectos(nombreDelJugador.getText(), seleccionVehiculo.getValue())){
                if(seleccionVehiculo.getValue() != null && !(nombreDelJugador.getText().isBlank())){
                    JuegoVista juegoVista = new JuegoVista(stage, pantallaDeInicio,20, 14, nombreDelJugador.getText(), seleccionVehiculo.getValue());
                    stage.setScene(juegoVista.getJuegoVista());
				} else{
                    datosIncorrectos();
                }
            }
        });
		
        //MAPA DEL JUEGO
        
        preguntas.getChildren().add(preguntaNombre);
        preguntas.getChildren().add(nombreDelJugador);
        preguntas.getChildren().add(seleccioneUnVehiculo);
        preguntas.getChildren().add(seleccionVehiculo);
        preguntas.getChildren().add(siguiente);

        this.setTop(volverPantallaInicial);
        this.setCenter(preguntas);
    }

    private void datosIncorrectos(){
        Stage ventanaDatosIncorrectos = new Stage();
        ventanaDatosIncorrectos.setResizable(false);
        ventanaDatosIncorrectos.setTitle("Datos Incorrectos");
        
        Button botonVolverAIngresarDatos = new Button("Volver a Ingresar Datos");
        botonVolverAIngresarDatos.setFont(Font.font("Impact", 30));
        botonVolverAIngresarDatos.setStyle(botonNormal);
        botonVolverAIngresarDatos.setOnMouseEntered(e -> botonVolverAIngresarDatos.setStyle(botonAntesDeSerPresionado));
        botonVolverAIngresarDatos.setOnMouseExited(e -> botonVolverAIngresarDatos.setStyle(botonNormal));
        
        VBox menuDatosIngresados = new VBox(20);
        
        Label avisoDatos = new Label("Los datos ingresados no son validos, asegurate de:\n");
        avisoDatos.setFont(Font.font("Impact", 30));
        avisoDatos.setStyle(formatoTexto);
        
        Label avisoVehiculo = new Label("      -Si o si tenés que seleccionar un Vehículo\n");
        avisoVehiculo.setFont(Font.font("Impact", 25));
        avisoVehiculo.setStyle(formatoTexto);
        
        Label avisoNombre = new Label("      -Tu nombre tiene que tener por lo menos un caracter");
        avisoNombre.setFont(Font.font("Impact", 25));
        avisoNombre.setStyle(formatoTexto);
        
        ventanaDatosIncorrectos.setMinWidth(280);
        ventanaDatosIncorrectos.initModality(Modality.APPLICATION_MODAL);
        
        menuDatosIngresados.getChildren().addAll(avisoDatos, avisoVehiculo, avisoNombre, botonVolverAIngresarDatos);
        menuDatosIngresados.setAlignment(Pos.CENTER);
        menuDatosIngresados.setStyle("-fx-border-color: #2F343A; -fx-background-color: #2F343A");
        
        
        botonVolverAIngresarDatos.setOnAction(e->{
            confirmacionDatos = false;
            ventanaDatosIncorrectos.close();
        });

        Scene  escenaDatosIngresados = new Scene(menuDatosIngresados , 650 , 400, Color.rgb(47, 52, 58));
        ventanaDatosIncorrectos.getIcons().add(this.logoGpsChallenge);
        ventanaDatosIncorrectos.setScene(escenaDatosIngresados);
        ventanaDatosIncorrectos.showAndWait();
    }


    private boolean preguntarDatosCorrectos(String nombre, String vehiculoElejido){
        Stage ventanaPreguntaDatos = new Stage();
        ventanaPreguntaDatos.setResizable(false);
        ventanaPreguntaDatos.setTitle("Datos Ingresados");
        
        Button botonConfirmar = new Button("Confirmar");
        botonConfirmar.setFont(Font.font("Impact", 30));
        botonConfirmar.setStyle(botonNormal);
        botonConfirmar.setOnMouseEntered(e -> botonConfirmar.setStyle(botonAntesDeSerPresionado));
        botonConfirmar.setOnMouseExited(e -> botonConfirmar.setStyle(botonNormal));
        
        Button botonVolverAIngresarDatos = new Button("Volver a Ingresar Datos");
        botonVolverAIngresarDatos.setFont(Font.font("Impact", 30));
        botonVolverAIngresarDatos.setStyle(botonNormal);
        botonVolverAIngresarDatos.setOnMouseEntered(e -> botonVolverAIngresarDatos.setStyle(botonAntesDeSerPresionado));
        botonVolverAIngresarDatos.setOnMouseExited(e -> botonVolverAIngresarDatos.setStyle(botonNormal));
        
        VBox menuDatosIngresados = new VBox(20);
        
        Label preguntaDatosCorrectos = new Label("¿Mantener Estos Datos?");
        preguntaDatosCorrectos.setFont(Font.font("Impact", 40));
        preguntaDatosCorrectos.setStyle(formatoTexto);
        
        Label nombreDado = new Label("Nombre: " + nombre);
        nombreDado.setFont(Font.font("Impact", 30));
        nombreDado.setStyle("-fx-border-width: 0px; -fx-border-color: transparent; -fx-background-color: transparent; -fx-text-fill: #BDB69C");

        Label vehiculoSeleccionado = new Label("Vehiculo Elejido: " + vehiculoElejido);
        vehiculoSeleccionado.setFont(Font.font("Impact", 30));
        vehiculoSeleccionado.setStyle("-fx-border-width: 0px; -fx-border-color: transparent; -fx-background-color: transparent; -fx-text-fill: #BDB69C");

        ventanaPreguntaDatos.setMinWidth(280);
        ventanaPreguntaDatos.initModality(Modality.APPLICATION_MODAL);
        
        menuDatosIngresados.getChildren().addAll(preguntaDatosCorrectos, nombreDado, vehiculoSeleccionado, botonConfirmar, botonVolverAIngresarDatos);
        menuDatosIngresados.setAlignment(Pos.CENTER);
        menuDatosIngresados.setStyle("-fx-border-color: #2F343A; -fx-background-color: #2F343A");
        
        botonConfirmar.setOnAction(e-> {
            confirmacionDatos = true;
            ventanaPreguntaDatos.close();
        });
        
        botonVolverAIngresarDatos.setOnAction(e->{
            confirmacionDatos = false;
            ventanaPreguntaDatos.close();
        });

        Scene  escenaDatosIngresados = new Scene(menuDatosIngresados , 480 , 400, Color.rgb(47, 52, 58));
        ventanaPreguntaDatos.getIcons().add(this.logoGpsChallenge);
        ventanaPreguntaDatos.setScene(escenaDatosIngresados);
        ventanaPreguntaDatos.showAndWait();
        return(confirmacionDatos);
    }
}
