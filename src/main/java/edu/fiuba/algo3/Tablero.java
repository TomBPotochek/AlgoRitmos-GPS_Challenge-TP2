package edu.fiuba.algo3;

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


    public Tablero(int alto, int ancho){
        this.altoTablero = alto;
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/unknown.png");
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                Group grupoCasilla = new Group();
                Rectangle casilla = new Rectangle(40,40, Color.BLUE);
                ImagePattern imagePattern = new ImagePattern(imagen);
                casilla.setFill(imagePattern);
                StackPane stack = new StackPane();
                
                HBox elementosMapa = new HBox();
                stack.getChildren().add(elementosMapa);


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
