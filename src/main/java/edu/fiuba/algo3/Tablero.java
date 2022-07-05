package edu.fiuba.algo3;

import java.util.ArrayList;

import edu.fiuba.algo3.modelo.Logging.Logger;
import edu.fiuba.algo3.modelo.casillero.*;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.movimientos.Posicion;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Tablero {

    private int posJugadorX = 0;
    private int posJugadorY = 0;
    private int tamanioCelda = 40;
    private int altoTablero;
    private Group contenedor;
    private GridPane grilla;
    private Rectangle mapaOculto;
    private Circle visionJugador;
    private Circle visionMeta;
    
    public Tablero(int alto, int ancho, Juego juego){
        this.altoTablero = alto;
        Image imagen = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/unknown.png");
        this.grilla = new GridPane();
        for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                Group grupoCasilla = new Group();
                Rectangle casilla = new Rectangle(tamanioCelda, tamanioCelda, Color.BLUE);
                ImagePattern imagePattern = new ImagePattern(imagen);
                casilla.setFill(imagePattern);
                StackPane stack = new StackPane();
                stack.setMinSize(tamanioCelda, tamanioCelda);
                
                HBox vistaElementosMapa = new HBox();
                vistaElementosMapa.setAlignment(Pos.CENTER);
                // Logger.log(String.format("intentando colocar en posicion (f,c) = (%d,%d)", j+1, i+1));
                ArrayList<ElementoMapa> elementosMapa = juego.obtenerElementos(new Posicion(j+1, i+1));
                for (ElementoMapa elemento: elementosMapa) {
                    Rectangle vistaElem = generarElementoMapa(elemento);
                    vistaElem.maxWidth(tamanioCelda/4.);
                    vistaElem.widthProperty().bind(Bindings.divide(vistaElementosMapa.widthProperty(),elementosMapa.size()+0.5));
                    vistaElem.heightProperty().bind(vistaElem.widthProperty());
                    vistaElementosMapa.getChildren().add(vistaElem);
                }
    
                stack.getChildren().add(vistaElementosMapa);
    
                grupoCasilla.getChildren().addAll(casilla, stack);
                this.grilla.add(grupoCasilla,i,j);
            }
        }
       
        //jugador posicion inicial en tablero
        StackPane sp = obtenerPaneCelda(0, 0);
        sp.getChildren().add(new Rectangle(10, 10, Color.GREEN));
        
        //Meta
        Posicion meta = juego.obtenerPosicionMeta();
        // Logger.log(String.format("obteniendo meta en posicion x,y = %d,%d", meta.getFila()-1, meta.getColumna()-1));
        sp = obtenerPaneCelda(meta.getFila()-1, meta.getColumna()-1);
        HBox elementos = (HBox) sp.getChildren().get(0);
        Rectangle metaForma = new Rectangle(20, 20, Color.BLUEVIOLET);
        Image fotoMeta = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-salida.png");
        metaForma.setFill(new ImagePattern(fotoMeta));
        elementos.getChildren().add(metaForma);

        this.mapaOculto = new Rectangle(800, 560, Color.BLACK);
        this.visionJugador = new Circle(this.tamanioCelda*2);
        this.visionJugador.relocate(this.tamanioCelda*(-1.5), this.tamanioCelda*(-1.5));
        this.visionJugador.setStyle("-fx-background-color: transparent");
        Shape resultadoVision = Rectangle.subtract(mapaOculto, visionJugador);

        //vision meta
        this.visionMeta = new Circle(tamanioCelda*2);
        this.visionMeta.relocate(
                                tamanioCelda*((meta.getColumna()-1)+0.5-2), 
                                tamanioCelda*((meta.getFila()-1)+0.5-2));
        visionMeta.setStyle("-fx-background-color: transparent");
        resultadoVision = Rectangle.subtract(resultadoVision, visionMeta);
        
        // this.setGridLinesVisible(true);
        this.contenedor = new Group(this.grilla, resultadoVision);
    }

    public Group getContenedor(){
        return this.contenedor;
    }

    private void moverVision(int x, int y){
        this.contenedor.getChildren().remove(1);
        this.visionJugador.relocate(tamanioCelda*(y+0.5-2), tamanioCelda*(x+0.5-2));

        Shape resultadoVision = Rectangle.subtract(mapaOculto, visionJugador);
        resultadoVision = Rectangle.subtract(resultadoVision, this.visionMeta);
        contenedor.getChildren().add(resultadoVision);

    }

    private Rectangle generarElementoMapa(ElementoMapa elemento){
        //ImagePattern
        Rectangle vistaElemento;
        int tamanio = 20;
        switch (elemento.getClass().getSimpleName()) {
            case "Pozo":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.BROWN);
                Image fondoPozo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-pozo.png");
                vistaElemento.setFill(new ImagePattern(fondoPozo));
                break;
            case "Piquete":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.RED);
                Image fondoPiquete = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-piquete.png");
                vistaElemento.setFill(new ImagePattern(fondoPiquete));
                break;
            case "ControlPolicial":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.BLUE);
                Image fondoControlPolicial = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-control-policial.png");
                vistaElemento.setFill(new ImagePattern(fondoControlPolicial));
                break;
            case "SorpresaFavorable":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.YELLOW);
                Image fondoSorpresaFavorable = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-sorpresa.png");
                vistaElemento.setFill(new ImagePattern(fondoSorpresaFavorable));
                break;
            case "SorpresaDesfavorable":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.YELLOW);
                Image fondoSorpresaDesfavorable = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-sorpresa.png");
                vistaElemento.setFill(new ImagePattern(fondoSorpresaDesfavorable));
                break;
            case "SorpresaCambioVehiculo":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.YELLOW);
                Image fondoCambioVehiculo = new Image("file:src/main/java/edu/fiuba/algo3/imagenes/icono-sorpresa.png");
                vistaElemento.setFill(new ImagePattern(fondoCambioVehiculo));
                break;
            default:
                vistaElemento = new Rectangle(tamanio, tamanio, Color.ANTIQUEWHITE);
        }
        return vistaElemento;    

    }

    private Group obtenerCelda(int x, int y){
        Group celda = (Group) this.grilla.getChildren().get(x+altoTablero*y);
        return celda;
    }

    private StackPane obtenerPaneCelda(int x, int y){
        Group celda = obtenerCelda(x, y);
        StackPane sp = (StackPane) celda.getChildren().get(1);
        return sp;
    }



    public void moverJugadorA(int x, int y, Rectangle dibujoJugador){

        StackPane sp = obtenerPaneCelda(posJugadorX, posJugadorY);
        sp.getChildren().remove(1);
        
        this.posJugadorX = x;
        this.posJugadorY = y;
        
        sp = obtenerPaneCelda(posJugadorX, posJugadorY);
        sp.getChildren().add(dibujoJugador);

        this.moverVision(posJugadorX, posJugadorY);

    }

}
