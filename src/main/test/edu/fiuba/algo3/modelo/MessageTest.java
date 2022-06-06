package edu.fiuba.algo3.modelo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
   /* @Test
    public void messageGreeting() {
        Message message = new Message("Hola Mundo!", "Hello world!");

        assertEquals("Hello world!", message.greet("us"));
    }

    @Test
    public void messageGreetingDefaultLanguage() {
        Message message = new Message("Hola Mundo!", "Hello world!");

        assertEquals("Hola Mundo!", message.greet());
    }*/

    @Test
    public void testMotoPuedeMoverseSinObstaculos(){
        Moto moto = new Moto(1, 1);
        Mapa mapa = new Mapa(3,3);
        
        Posicion posicionFinal = new Posicion(1,2);
        ObstaculoVacio obstaculoVacio = new ObstaculoVacio();
        // interfaz antes de obstaculo q sea geneerica para items
        
        mapa.agregarObstaculo(obstaculoVacio, 2, 1);
        mapa.agregarVehiculo(moto, 1, 1);

        moto.mover("Arriba");
        
        assertEquals(compararPosicion(moto.getPosicion(), posicionFinal), true);
    }


    @Test
    public void testMotoAtraviezaPozoEsPenalizadoCon3Movimientos(){
        Moto moto = new Moto(1, 1);
        Mapa mapa = new Mapa(3,3);
        
        ObstaculoPozo pozo = new ObstaculoPozo();

        mapa.agregarObstaculo(pozo, 1, 2);
        mapa.agregarVehiculo(moto, 1, 1);

        moto.mover("Arriba");

        assertEquals(moto.getCantidadMovimientos(), 4);
    }

}
