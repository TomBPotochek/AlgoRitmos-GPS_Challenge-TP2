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

		
		String pathLogoFondo = this.getClass().getResource("/imagenes/fondo-gps-3.png").toString();
		Image logoFondo = new Image(pathLogoFondo);
		BackgroundImage imagenDeFondo = new BackgroundImage(logoFondo, BackgroundRepeat.REPEAT, BackgroundRepeat.REPEAT, BackgroundPosition.CENTER, BackgroundSize.DEFAULT);
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
            jugadorNuevo.setStyle("-fx-border-width: 0px; -fx-border-color: #80CEB9; -fx-background-color: transparent; -fx-text-fill: #BDB69C");
            jugadorNuevo.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 35));
            tabla.getChildren().add(jugadorNuevo);
        }

        tabla.setAlignment(Pos.TOP_CENTER);
        this.setCenter(tabla);
    }

    private void setTablaDePosiciones(Stage stage, Scene pantallaDeInicio){
        HBox encabezado = new HBox();
        //encabezado.setAlignment(Pos.CENTER_LEFT);
        encabezado.setSpacing(280);
    
        //BOTON SIGUIENTE
        Button volverMenuPrincipal = new Button("Volver al Menu");
        volverMenuPrincipal.setStyle(botonNormal);
        volverMenuPrincipal.setFont(Font.font("Impact", FontWeight.SEMI_BOLD, 35));

		String pathIconoVolver = this.getClass().getResource("/imagenes/icono-volver.png").toString();
		Image iconoVolver = new Image(pathIconoVolver);
        volverMenuPrincipal.setGraphic(new ImageView(iconoVolver));
        volverMenuPrincipal.setOnMouseEntered(e -> volverMenuPrincipal.setStyle(botonAntesDeSerPresionado));
        volverMenuPrincipal.setOnMouseExited(e -> volverMenuPrincipal.setStyle(botonNormal));

        volverMenuPrincipal.setOnAction(e-> {
			stage.setScene(pantallaDeInicio);
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
}