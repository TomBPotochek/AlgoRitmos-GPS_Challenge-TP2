package edu.fiuba.algo3.Vehiculos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import vehiculos.*;
import casillero.*;
import movimientos.Posicion;

public class MotoTest {
    @Test
    public void testMotoPuedeMoverseSinObstaculos(){
        Moto moto = new Moto(1, 1);
        Mapa mapa = new Mapa(3);
        
        Posicion posicionFinal = new Posicion(1,2);
        Casillero c = new SinObstaculo();
        // interfaz antes de obstaculo q sea geneerica para items
        
        mapa.asignarCasillero(c, posicionFinal);

        moto.mover("Derecha", mapa);
        
        assertEquals(moto.getPosicion(), posicionFinal);
    }


    @Test
    public void testMotoAtraviezaPozoEsPenalizadoCon3Movimientos(){
        Moto moto = new Moto(1, 1);
        Mapa mapa = new Mapa(3);
        
        Posicion posicionFinal = new Posicion(1,2);
        Casillero pozo = new Pozo();

        mapa.asignarCasillero(pozo, posicionFinal);

        moto.mover("Derecha", mapa);

        assertEquals(moto.getCantidadMovimientos(), 4);
    }

    @Test
    public void testMotoAtraviezaPiqueteEsPenalizadoCon2Movimientos(){
        Moto moto = new Moto(1, 1);
        Mapa mapa = new Mapa(3);
        
        Posicion posicionFinal = new Posicion(1,2);
        Casillero piquete = new Piquete();

        mapa.asignarCasillero(piquete, posicionFinal);

        moto.mover("Derecha", mapa);

        assertEquals(moto.getCantidadMovimientos(), 3);
    }
}
