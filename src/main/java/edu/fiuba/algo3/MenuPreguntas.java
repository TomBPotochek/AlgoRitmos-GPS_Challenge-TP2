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
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuPreguntas extends Group{

    static Scene preguntaDatos;
    static String respuesta;
    Boolean confirmacionDatos;

    public MenuPreguntas(Stage stage, Scene pantallaDeInicio){
        this.setMenuPreguntas(stage, pantallaDeInicio);
    }

    public Scene getMenuPreguntas(){
        return preguntaDatos;
    }

    private void setMenuPreguntas(Stage stage, Scene pantallaDeInicio) {
        //ESCENA PREGUNTAR DATOS DEL JUGADOR Y LA PARTIDA
        HBox parteSuperior = new HBox();

        parteSuperior.setStyle("-fx-background-color: #26798E");
        preguntaDatos = new Scene(this,640, 580, Color.rgb(38, 121, 142));
    
        //BOTON DE VOLVER A LA PANTALLA DE INICIO
        Button volverPantallaInicial = new Button("Volver al Menu");
        volverPantallaInicial.setFont(Font.font("Visage Bold", 10));
        volverPantallaInicial.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-background-color: #26798E; -fx-font-size: 2em; -fx-text-fill: #FFC172");
     
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
        preguntaNombre.setFont(Font.font("Visage Bold", 20));
        preguntaNombre.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 40px; -fx-text-fill: #FFC172");
    
        //INPUT NOMBRE DEL JUGADOR
        TextField nombreDelJugador = new TextField();
        nombreDelJugador.setAlignment(Pos.CENTER);
        nombreDelJugador.setPromptText("Inserte un nombre");
        nombreDelJugador.setStyle("-fx-border-width: 1px; -fx-border-color: #FFC172; -fx-background-color: #26798E; -fx-font-size: 3em; -fx-text-fill: #FFC172");
        
        //PREGUNTA ANCHO DEL MAPA
        // Label preguntaAnchoDelMapa = new Label("Ancho del Mapa");
        // preguntaAnchoDelMapa.setFont(Font.font("Visage Bold", 20));
        // preguntaAnchoDelMapa.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 25px; -fx-text-fill: #FFC172");
    
        // ////PREGUNTA ALTO DEL MAPA
        // Label preguntaAltoDelMapa = new Label("Altura del Mapa");
        // preguntaAltoDelMapa.setFont(Font.font("Visage Bold", 20));
        // preguntaAltoDelMapa.setStyle("-fx-border-width: 0px; -fx-border-color: #26798E; -fx-background-color: #26798E; -fx-font-size: 25px; -fx-text-fill: #FFC172");
    
        //INPUT ANCHO DEL MAPA
        // TextField anchoDelMapa = new TextField();
        // anchoDelMapa.setAlignment(Pos.CENTER);
        // anchoDelMapa.setPromptText("Ancho");
        // anchoDelMapa.setStyle("-fx-border-width: 1px; -fx-border-color: #FFC172; -fx-background-color: #26798E; -fx-font-size: 2em; -fx-text-fill: #FFC172");
        
        //INPUT ALTO DEL MAPA
        // TextField altoDelMapa = new TextField();
        // altoDelMapa.setAlignment(Pos.CENTER);
        // altoDelMapa.setPromptText("Alto");
        // altoDelMapa.setStyle("-fx-border-width: 1px; -fx-border-color: #FFC172; -fx-background-color: #26798E; -fx-font-size: 2em; -fx-text-fill: #FFC172");
    
    
        //BOTON SIGUIENTE
        Button siguiente = new Button("Siguiente");
        siguiente.setFont(Font.font("Visage Bold", 20));
        siguiente.setStyle("-fx-border-width: 2px; -fx-border-color: #FFC172; -fx-background-color: #26798E; -fx-font-size: 3em; -fx-text-fill: #FFC172");
        
        //Group grupoMapa = new Group();
        //mapaDelJuego = new Scene(grupoMapa,640, 580, Color.rgb(38, 121, 142));
        
        siguiente.setOnAction(e-> {
            //if(this.verificarDatos(11, 7, nombreDelJugador.getText())){
                //anchoDelMapa.getText()
                //Integer.parseInt(altoDelMapa.getText())
            //}
            JuegoVista juegoVista = new JuegoVista(stage, pantallaDeInicio,11, 7, nombreDelJugador.getText());
            stage.setScene(juegoVista.getJuegoVista());
        });
    
        //MAPA DEL JUEGO
        
        parteSuperior.getChildren().add(volverPantallaInicial);
        
        preguntas.getChildren().add(preguntaNombre);
        preguntas.getChildren().add(nombreDelJugador);
        // preguntas.getChildren().add(preguntaAnchoDelMapa);
        // preguntas.getChildren().add(anchoDelMapa);
        // preguntas.getChildren().add(preguntaAltoDelMapa);
        // preguntas.getChildren().add(altoDelMapa);
        preguntas.getChildren().add(siguiente);

        preguntas.setSpacing(30);
        
        this.getChildren().add(preguntas);
        this.getChildren().add(parteSuperior);

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

    private boolean verificarDatos(String ancho, String alto, String nombre){
        try{ // ancho 11 alto 7
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
}
