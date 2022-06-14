package edu.fiuba.algo3.Vehiculos;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.casillero.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.vehiculos.*;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class MotoTest {
    @Test
    public void testMotoPuedeMoverseSinObstaculos(){
        Vehiculo moto = new Moto(1, 1);
        Mapa mapa = new Mapa(3);
        
        Posicion posicionFinal = new Posicion(1,2);
        Casillero casillero = new Casillero();
        casillero.agregarElemento(new ObstaculoNulo());
        // interfaz antes de obstaculo q sea geneerica para items
        
        mapa.asignarCasillero(casillero, posicionFinal);

        moto.mover("Derecha", mapa);
        
        assertEquals(moto.getPosicion(), posicionFinal);
    }


    @Test
    public void testMotoAtraviezaPozoEsPenalizadoCon3Movimientos(){
        Vehiculo moto = new Moto(1, 1);
        Mapa mapa = new Mapa(3);
        
        Posicion posicionFinal = new Posicion(1,2);
        Casillero casillero = new Casillero();
        casillero.agregarElemento(new Pozo());

        mapa.asignarCasillero(casillero, posicionFinal);

        moto.mover("Derecha", mapa);

        assertEquals(moto.getCantidadMovimientos(), 4);
    }

    @Test
    public void testMotoAtraviezaPiqueteEsPenalizadoCon2Movimientos(){
        Vehiculo moto = new Moto(1, 1);
        Mapa mapa = new Mapa(3);
        
        Posicion posicionFinal = new Posicion(1,2);
        Casillero casillero = new Casillero();
        casillero.agregarElemento(new Piquete());

        mapa.asignarCasillero(casillero, posicionFinal);

        moto.mover("Derecha", mapa);

        assertEquals(moto.getCantidadMovimientos(), 3);
    }
}
