package edu.fiuba.algo3.Vehiculos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import vehiculos.*;
import casillero.*;
import movimientos.Posicion;

public class AutoTest {
    @Test
    public void testAutoPuedeMoverseSinObstaculos(){
        Auto auto = new Auto(1, 1);
        Mapa mapa = new Mapa(3);
        
        Posicion posicionFinal = new Posicion(1,2);
        Casillero c = new SinObstaculo();
        // interfaz antes de obstaculo q sea geneerica para items
        
        mapa.asignarCasillero(c, posicionFinal);

        auto.mover("Derecha", mapa);
        
        assertEquals(auto.getPosicion(), posicionFinal);
    }


    @Test
    public void testAutoAtraviezaPozoEsPenalizadoCon3Movimientos(){
        Auto auto = new Auto(1, 1);
        Mapa mapa = new Mapa(3);
        
        Posicion posicionFinal = new Posicion(1,2);
        Casillero pozo = new Pozo();

        mapa.asignarCasillero(pozo, posicionFinal);

        auto.mover("Derecha", mapa);

        assertEquals(auto.getCantidadMovimientos(), 4);
    }
}
