package edu.fiuba.algo3;

import java.util.ArrayList;
import edu.fiuba.algo3.modelo.casillero.*;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.movimientos.Posicion;
import javafx.beans.binding.Bindings;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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
    
	private Image casillaEsquina;
	private Image iconoMeta;
	private Image iconoPozo;
	private Image iconoPiquete;
	private Image iconoControlPolicial;
	private Image iconoSorpresa;


    public Tablero(int alto, int ancho, Juego juego){
        this.altoTablero = alto;
        this.cargarImagenes();
        this.grilla = new GridPane();
        
		for (int i = 0; i < ancho; i++) {
            for (int j = 0; j < alto; j++) {
                Group grupoCasilla = new Group();
                Rectangle casilla = new Rectangle(tamanioCelda, tamanioCelda, Color.BLUE);
                ImagePattern imagePattern = new ImagePattern(this.casillaEsquina);
                casilla.setFill(imagePattern);
                StackPane stack = new StackPane();
                stack.setMinSize(tamanioCelda, tamanioCelda);
                
                HBox vistaElementosMapa = new HBox();
                vistaElementosMapa.setAlignment(Pos.CENTER);
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
        sp = obtenerPaneCelda(meta.getFila()-1, meta.getColumna()-1);
        HBox elementos = (HBox) sp.getChildren().get(0);
        Rectangle metaForma = new Rectangle(20, 20, Color.BLUEVIOLET);
        metaForma.setFill(new ImagePattern(this.iconoMeta));
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
        
        this.contenedor = new Group(this.grilla, resultadoVision);
    }

    public Group getContenedor(){
        return this.contenedor;
    }

	private void cargarImagenes() {
		String pathCasillaEsquina = this.getClass().getResource("/imagenes/casilla-esquina.png").toString();
		this.casillaEsquina = new Image(pathCasillaEsquina);
		
		String pathIconoMeta = this.getClass().getResource("/imagenes/icono-meta.png").toString();
		this.iconoMeta = new Image(pathIconoMeta);
		
		String pathIconoPozo = this.getClass().getResource("/imagenes/icono-pozo.png").toString();
		this.iconoPozo = new Image(pathIconoPozo);
		
		String pathIconoPiquete = this.getClass().getResource("/imagenes/icono-piquete.png").toString();
		this.iconoPiquete = new Image(pathIconoPiquete);
		
		String pathIconoControl = this.getClass().getResource("/imagenes/icono-control-policial.png").toString();
		this.iconoControlPolicial = new Image(pathIconoControl);
		
		String pathIconoSorpresa = this.getClass().getResource("/imagenes/icono-sorpresa.png").toString();
		this.iconoSorpresa = new Image(pathIconoSorpresa);

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
                vistaElemento.setFill(new ImagePattern(this.iconoPozo));
                break;
            case "Piquete":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.RED);
                vistaElemento.setFill(new ImagePattern(this.iconoPiquete));
                break;
            case "ControlPolicial":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.BLUE);
                vistaElemento.setFill(new ImagePattern(this.iconoControlPolicial));
                break;
            case "SorpresaFavorable":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.YELLOW);
                vistaElemento.setFill(new ImagePattern(this.iconoSorpresa));
                break;
            case "SorpresaDesfavorable":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.YELLOW);
                vistaElemento.setFill(new ImagePattern(this.iconoSorpresa));
                break;
            case "SorpresaCambioVehiculo":
                vistaElemento = new Rectangle(tamanio, tamanio, Color.RED);
                //vistaElemento.setFill(new ImagePattern(this.iconoSorpresa));
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
