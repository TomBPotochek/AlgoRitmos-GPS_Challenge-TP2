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

        //ESCENA DEL MENU
        Group grupo = new Group();
        pantallaDeInicio = new Scene(grupo, 640, 480, Color.rgb(38, 121, 142));

        VBox menu = new VBox();
        menu.setAlignment(Pos.CENTER);
        menu.setSpacing(30);

        //TITULO DEL JUEGO
        Text nombreDelJuego = new Text();
        nombreDelJuego.setText("GPS CHALLENGE");
        nombreDelJuego.setFont(Font.font("Impact", 80));
        nombreDelJuego.setFill(Color.rgb(255, 193, 114));

        //BOTON DE JUGAR
        Button jugar = new Button("Jugar");
        jugar.setFont(Font.font("Visage Bold", 20));
        jugar.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 3em; -fx-text-fill: #FFC172");
        jugar.setOnAction(e -> stage.setScene(preguntaDatos));
        
        //BOTON DE TABLA DE POSICIONES
        Button tablaPosiciones = new Button("Tabla de Posiciones");
        tablaPosiciones.setFont(Font.font("Visage Bold", 20));
        tablaPosiciones.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 3em; -fx-text-fill: #FFC172");
        

        Group grupoTablas = new Group();
        tablaDePosicionesHistorial = new Scene(grupoTablas,640, 580, Color.rgb(38, 121, 142));
        
        tablaPosiciones.setOnAction(e-> {
            mostrarTablaDePosiciones(stage, grupoTablas);
        });

        //BOTON DE SALIR
        Button salir = new Button("Salir");
        salir.setFont(Font.font("Visage Bold", 20));
        salir.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 3em; -fx-text-fill: #FFC172");
     
        salir.setOnAction(e-> {
            a = cerrarJuego(stage);
            if(a =="Salir"){
                stage.close();
            }
        });


        menu.setPadding(new Insets(80, 150, 80, 70));
        menu.getChildren().add(nombreDelJuego);
        menu.getChildren().add(jugar);
        menu.getChildren().add(tablaPosiciones);
        menu.getChildren().add(salir);
        grupo.getChildren().add(menu);
        
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


        //ESCENA PREGUNTAR DATOS DEL JUGADOR Y LA PARTIDA
        HBox parteSuperior = new HBox();
        Group grupoPreguntas = new Group();
        parteSuperior.setStyle("-fx-background-color: #26798E");
        preguntaDatos = new Scene(grupoPreguntas,640, 580, Color.rgb(38, 121, 142));

        //BOTON DE VOLVER A LA PANTALLA DE INICIO
        Button volverPantallaInicial = new Button("Volver al Menu");
        volverPantallaInicial.setFont(Font.font("Visage Bold", 10));
        volverPantallaInicial.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-background-color: #26798E; -fx-font-size: 2em; -fx-text-fill: #FFC172");
     
        volverPantallaInicial.setOnAction(e-> {
            a = volverAlMenu(stage);
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
        preguntaNombre.setFont(Font.font("Visage Bold", 20));
        preguntaNombre.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 40px; -fx-text-fill: #FFC172");

        //INPUT NOMBRE DEL JUGADOR
        TextField nombreDelJugador = new TextField();
        nombreDelJugador.setAlignment(Pos.CENTER);
        nombreDelJugador.setPromptText("Inserte un nombre");
        nombreDelJugador.setStyle("-fx-border-width: 1px; -fx-border-color: #FFC172; -fx-background-color: #26798E; -fx-font-size: 3em; -fx-text-fill: #FFC172");
        
        //PREGUNTA ANCHO DEL MAPA
        Label preguntaAnchoDelMapa = new Label("Ancho del Mapa");
        preguntaAnchoDelMapa.setFont(Font.font("Visage Bold", 20));
        preguntaAnchoDelMapa.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 25px; -fx-text-fill: #FFC172");

        ////PREGUNTA ALTO DEL MAPA
        Label preguntaAltoDelMapa = new Label("Altura del Mapa");
        preguntaAltoDelMapa.setFont(Font.font("Visage Bold", 20));
        preguntaAltoDelMapa.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 25px; -fx-text-fill: #FFC172");

        //INPUT ANCHO DEL MAPA
        TextField anchoDelMapa = new TextField();
        anchoDelMapa.setAlignment(Pos.CENTER);
        anchoDelMapa.setPromptText("Ancho");
        anchoDelMapa.setStyle("-fx-border-width: 1px; -fx-border-color: #FFC172; -fx-background-color: #26798E; -fx-font-size: 2em; -fx-text-fill: #FFC172");
        
        //INPUT ALTO DEL MAPA
        TextField altoDelMapa = new TextField();
        altoDelMapa.setAlignment(Pos.CENTER);
        altoDelMapa.setPromptText("Alto");
        altoDelMapa.setStyle("-fx-border-width: 1px; -fx-border-color: #FFC172; -fx-background-color: #26798E; -fx-font-size: 2em; -fx-text-fill: #FFC172");


        //BOTON SIGUIENTE
        Button siguiente = new Button("Siguiente");
        siguiente.setFont(Font.font("Visage Bold", 20));
        siguiente.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-background-color: #26798E; -fx-font-size: 3em; -fx-text-fill: #FFC172");
        
        Group grupoMapa = new Group();
        mapaDelJuego = new Scene(grupoMapa,640, 580, Color.rgb(38, 121, 142));
        
        siguiente.setOnAction(e-> {
            if(verificarDatos(anchoDelMapa.getText(), altoDelMapa.getText(), nombreDelJugador.getText())){
                //stage.setScene(mapaDelJuego);
                jugar(stage, grupoMapa,Integer.parseInt(anchoDelMapa.getText()), Integer.parseInt(altoDelMapa.getText()), nombreDelJugador.getText());
            }
        });


        //MAPA DEL JUEGO


        
        parteSuperior.getChildren().add(volverPantallaInicial);
        
        preguntas.getChildren().add(preguntaNombre);
        preguntas.getChildren().add(nombreDelJugador);
        preguntas.getChildren().add(preguntaAnchoDelMapa);
        preguntas.getChildren().add(anchoDelMapa);
        preguntas.getChildren().add(preguntaAltoDelMapa);
        preguntas.getChildren().add(altoDelMapa);
        preguntas.getChildren().add(siguiente);
        
        grupoPreguntas.getChildren().add(preguntas);
        grupoPreguntas.getChildren().add(parteSuperior);

        stage.setScene(pantallaDeInicio);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private void jugar(Stage stage, Group grupoMapa, int ancho, int alto, String nombreJugador){
        stage.setScene(mapaDelJuego);
        
        HBox encabezado = new HBox();
        encabezado.setAlignment(Pos.CENTER_LEFT);
        encabezado.setSpacing(150);

        //BOTON SIGUIENTE
        Button salir = new Button("Salir");
        salir.setFont(Font.font("Visage Bold", 20));
        salir.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-background-color: #26798E; -fx-font-size: 2em; -fx-text-fill: #FFC172");
     
        salir.setOnAction(e-> {
            a = cerrarJuego(stage);
            if(a =="Salir"){
                stage.close();
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
        
        grupoMapa.getChildren().add(encabezado);
        insertarCuadras(ancho, alto, grupoMapa);
    }

    private void mostrarTablaDePosiciones(Stage stage, Group grupoTabla){
        stage.setScene(tablaDePosicionesHistorial);
        
        HBox encabezado = new HBox();
        encabezado.setAlignment(Pos.CENTER_LEFT);
        encabezado.setSpacing(150);

        //BOTON SIGUIENTE
        Button volverMenuPrincipal = new Button("Volver al Menu principal");
        volverMenuPrincipal.setFont(Font.font("Visage Bold", 20));
        volverMenuPrincipal.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-background-color: #26798E; -fx-font-size: 2em; -fx-text-fill: #FFC172");
     
        volverMenuPrincipal.setOnAction(e-> {
            a = volverAlMenu(stage);
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
        
        grupoTabla.getChildren().add(mejoresPuntajes);
        grupoTabla.getChildren().add(encabezado);
    }

    private void insertarCuadras(int ancho, int alto, Group grupoMapa){
        int posicionActualAncho = 50;
        int posicionActualAlto = 50;
        for(int i = 0; i<alto; i++){
            for(int j = 0; j<ancho; j++){
                Rectangle cuadra = new Rectangle(40, 40, Color.rgb(255, 227, 179));
                cuadra.setX(posicionActualAncho);
                cuadra.setY(posicionActualAlto);
                grupoMapa.getChildren().add(cuadra);
                posicionActualAncho = posicionActualAncho + 50;
            }
            posicionActualAncho = 50;
            posicionActualAlto = posicionActualAlto + 50;
        }
    }

    private boolean preguntarDatosCorrectos(String ancho, String alto, String nombre){
        Stage ventanaPreguntaDatos = new Stage();
        ventanaPreguntaDatos.setResizable(false);
        ventanaPreguntaDatos.setTitle("Datos Ingresados");
        
        Button botonConfirmar = new Button("Confirmar");
        botonConfirmar.setFont(Font.font("Visage Bold", 15));
        botonConfirmar.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-font-size: 20px; -fx-background-color: #26798E; -fx-text-fill: #FFC172");
        
        Button botonVolverAIngresarDatos = new Button("Volver a Ingresar Datos");
        botonVolverAIngresarDatos.setFont(Font.font("Visage Bold", 15));
        botonVolverAIngresarDatos.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-font-size: 20px; -fx-background-color: #26798E; -fx-text-fill: #FFC172");
        
        VBox menuDatosIngresados = new VBox(20);
        
        Label preguntaDatosCorrectos = new Label("¿Mantener Estos Datos?");
        preguntaDatosCorrectos.setFont(Font.font("Visage Bold", 20));
        preguntaDatosCorrectos.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 20px; -fx-text-fill: #FFC172");
        
        Label nombreDado = new Label("Nombre: " + nombre);
        nombreDado.setFont(Font.font("Visage Bold", 20));
        nombreDado.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 20px; -fx-text-fill: #FFC172");

        Label anchoDado = new Label("Ancho: " + ancho);
        anchoDado.setFont(Font.font("Visage Bold", 20));
        anchoDado.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 20px; -fx-text-fill: #FFC172");

        Label altoDado = new Label("Alto: " + alto);
        altoDado.setFont(Font.font("Visage Bold", 20));
        altoDado.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 20px; -fx-text-fill: #FFC172");

        ventanaPreguntaDatos.setMinWidth(280);
        ventanaPreguntaDatos.initModality(Modality.APPLICATION_MODAL);
        
        menuDatosIngresados.getChildren().addAll(preguntaDatosCorrectos, nombreDado, anchoDado, altoDado, botonConfirmar, botonVolverAIngresarDatos);
        menuDatosIngresados.setAlignment(Pos.CENTER);
        menuDatosIngresados.setStyle("-fx-border-color: #26798E; -fx-background-color: #26798E");
        
        botonConfirmar.setOnAction(e-> {
            confirmacionDatos = true;
            ventanaPreguntaDatos.close();
        });
        
        botonVolverAIngresarDatos.setOnAction(e->{
            confirmacionDatos = false;
            ventanaPreguntaDatos.close();
        });

        Scene  escenaDatosIngresados = new Scene(menuDatosIngresados , 480 , 400);
        ventanaPreguntaDatos.setScene(escenaDatosIngresados);
        ventanaPreguntaDatos.showAndWait();
        return(confirmacionDatos);
    }

    private boolean verificarDatos(String ancho, String alto, String nombre){
        try{
            Integer.parseInt(ancho);
            Integer.parseInt(alto);
            if(preguntarDatosCorrectos(ancho, alto, nombre)){
                return true;
            }
            return false;
        }catch(NumberFormatException e){
            avisarErrorDeInput();
            return false;
        }
    }

    private void avisarErrorDeInput(){
        Stage ventanaNotificarError = new Stage();
        ventanaNotificarError.setResizable(false);
        ventanaNotificarError.setTitle("Error Input");
        
        Button botonAceptar = new Button("Aceptar");
        botonAceptar.setFont(Font.font("Visage Bold", 15));
        botonAceptar.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-font-size: 20px; -fx-background-color: #26798E; -fx-text-fill: #FFC172");
        
        VBox menuErrorInput = new VBox(20);
        
        Label notificacionError = new Label("Ancho y Alto solo pueden ser numeros");
        notificacionError.setFont(Font.font("Visage Bold", 20));
        notificacionError.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 25px; -fx-text-fill: #FFC172");
        
        
        ventanaNotificarError.setMinWidth(280);
        ventanaNotificarError.initModality(Modality.APPLICATION_MODAL);
        
        menuErrorInput.getChildren().addAll(notificacionError , botonAceptar);
        menuErrorInput.setAlignment(Pos.CENTER);
        menuErrorInput.setStyle("-fx-border-color: #26798E; -fx-background-color: #26798E");
        
        botonAceptar.setOnAction(e-> {
            ventanaNotificarError.close();
        });

        Scene  escenaError = new Scene(menuErrorInput , 450 , 150);
        ventanaNotificarError.setScene(escenaError);
        ventanaNotificarError.showAndWait();
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