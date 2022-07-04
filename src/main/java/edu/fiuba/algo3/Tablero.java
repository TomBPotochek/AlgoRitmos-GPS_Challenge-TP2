package edu.fiuba.algo3;

import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;

public class Tablero extends GridPane {


    public Tablero(int alto, int ancho, JugadorVista jugadorVista){
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/unknown.png");
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                Rectangle casilla = new Rectangle(40,40, Color.BLUE);
                ImagePattern imagePattern = new ImagePattern(imagen);
                casilla.setFill(imagePattern);
                this.add(casilla,i,j);
            }
        }
        this.getChildren().add(jugadorVista.getDibujo());
        this.setGridLinesVisible(true);
    }
}
