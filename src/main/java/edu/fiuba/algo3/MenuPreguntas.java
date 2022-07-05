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

public class MenuPreguntas extends BorderPane{

    static Scene preguntaDatos;
    static String respuesta;
    Boolean confirmacionDatos;

    String botonAntesDeSerPresionado = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: #717D8C; -fx-text-fill: #BDB69C";
    String botonNormal = "-fx-border-width: 2px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";

    String formatoTexto = "-fx-border-width: 0px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #80CEB9";

    public MenuPreguntas(Stage stage, Scene pantallaDeInicio){
        this.setMenuPreguntas(stage, pantallaDeInicio);
        stage.setMaximized(true);
    }

    public Scene getMenuPreguntas(){
        return preguntaDatos;
    }

    private void setMenuPreguntas(Stage stage, Scene pantallaDeInicio) {
        //ESCENA PREGUNTAR DATOS DEL JUGADOR Y LA PARTIDA
        Rectangle2D screenSize = Screen.getPrimary().getVisualBounds();
        preguntaDatos = new Scene(this,screenSize.getWidth(), screenSize.getHeight(), Color.rgb(47, 52, 58));
        Image fondoLogo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/fondo-gps-3.png");
        BackgroundImage imagenDeFondo = new BackgroundImage(fondoLogo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));
    
        //BOTON DE VOLVER A LA PANTALLA DE INICIO
        Button volverPantallaInicial = new Button("Volver al Menu");
        volverPantallaInicial.setGraphic(new ImageView(new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-volver.png")));
        volverPantallaInicial.setFont(Font.font("Impact", 40));
        volverPantallaInicial.setStyle(botonNormal);
        volverPantallaInicial.setOnMouseEntered(e -> volverPantallaInicial.setStyle(botonAntesDeSerPresionado));
        volverPantallaInicial.setOnMouseExited(e -> volverPantallaInicial.setStyle(botonNormal));

        volverPantallaInicial.setOnAction(e-> {
            String a = this.volverAlMenu(stage);
            if(a =="Volver"){
                stage.setScene(pantallaDeInicio);
            }
        });
    
        //JUGADOR INSERTA NOMBRE
        VBox preguntas = new VBox();
        preguntas.setAlignment(Pos.CENTER);
        preguntas.setSpacing(15);
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
                }else{
                    datosIncorrectos();
                }
            }
        });
    
        //MAPA DEL JUEGO
        
        preguntas.getChildren().add(preguntaNombre);
        preguntas.getChildren().add(nombreDelJugador);
        preguntas.getChildren().add(seleccioneUnVehiculo);
        preguntas.getChildren().add(seleccionVehiculo);

        this.setTop(volverPantallaInicial);
        this.setCenter(preguntas);
        this.setAlignment(siguiente, Pos.TOP_CENTER);
        this.setBottom(siguiente);

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
        Image logo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/logo-gps-challenge.png");
        ventanaDatosIncorrectos.getIcons().add(logo);
        ventanaDatosIncorrectos.setScene(escenaDatosIngresados);
        ventanaDatosIncorrectos.showAndWait();
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
        Image logo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/logo-gps-challenge.png");
        ventanaPreguntaDatos.getIcons().add(logo);
        ventanaPreguntaDatos.setScene(escenaDatosIngresados);
        ventanaPreguntaDatos.showAndWait();
        return(confirmacionDatos);
    }
}
