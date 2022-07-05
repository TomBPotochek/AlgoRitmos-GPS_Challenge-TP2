package edu.fiuba.algo3;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.casillero.*;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.movimientos.Posicion;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Tablero extends GridPane {

    private int posJugadorX = 0;
    private int posJugadorY = 0;
    private int altoTablero;

    private Rectangle generarElementoMapa(ElementoMapa elemento){
        //ImagePattern
        Rectangle vistaElemento;
        int tamanio = 8;
        switch (elemento.getClass().getSimpleName()) {
            case "Pozo":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.BROWN);
                break;
            case "Piquete":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.RED);
                break;
            case "ControlPolicial":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.BLUE);
                break;
            case "SorpresaFavorable":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.YELLOW);
                break;
            case "SorpresaDesfavorable":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.YELLOW);
                break;
            case "SorpresaCambioVehiculo":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.YELLOW);
                break;
            default:
                vistaElemento = new Rectangle(tamanio, tamanio, Color.ANTIQUEWHITE);
        }
        return vistaElemento;    

    }


    public Tablero(int alto, int ancho, Juego juego){
        this.altoTablero = alto;
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/unknown.png");
        int tamanioCelda = 40;
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                Group grupoCasilla = new Group();
                Rectangle casilla = new Rectangle(tamanioCelda, tamanioCelda, Color.BLUE);
                ImagePattern imagePattern = new ImagePattern(imagen);
                casilla.setFill(imagePattern);
                StackPane stack = new StackPane();
                stack.setMinSize(tamanioCelda, tamanioCelda);
                
                HBox VistaElementosMapa = new HBox();
                VistaElementosMapa.setAlignment(Pos.CENTER);
                // Logger.log(String.format("intentando colocar en posicion (f,c) = (%d,%d)", j+1, i+1));
                ArrayList<ElementoMapa> elementosMapa = juego.obtenerElementos(new Posicion(j+1, i+1));
                for (ElementoMapa elemento: elementosMapa) {
                    VistaElementosMapa.getChildren().add(generarElementoMapa(elemento));
                }



                stack.getChildren().add(VistaElementosMapa);


                grupoCasilla.getChildren().addAll(casilla, stack);
                this.add(grupoCasilla,i,j);
            }
        }
        Group g = (Group)(this.getChildren().get(0));
        StackPane sp = (StackPane)(g.getChildren().get(1));
        sp.getChildren().add(new Rectangle(10, 10, Color.GREEN));
        this.setGridLinesVisible(true);
    }

    public void moverJugadorA(int x, int y, Rectangle dibujoJugador){
        Group g = (Group)(this.getChildren().get(posJugadorX+altoTablero*posJugadorY));
        StackPane sp = (StackPane)(g.getChildren().get(1));
        sp.getChildren().remove(1);
        
        this.posJugadorX = x;
        this.posJugadorY = y;
        
        g = (Group)(this.getChildren().get(x+altoTablero*y));
        sp = (StackPane)(g.getChildren().get(1));
        sp.getChildren().add(dibujoJugador);

    }

}