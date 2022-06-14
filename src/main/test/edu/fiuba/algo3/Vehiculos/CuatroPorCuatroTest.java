package edu.fiuba.algo3.Vehiculos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import vehiculos.*;
import casillero.*;
import movimientos.Posicion;

public class CuatroPorCuatroTest {
    @Test
    public void test4x4PuedeMoverseSinObstaculos(){
        Vehiculo cuatrox4 = new CuatroPorCuatro(1, 1);
        Mapa mapa = new Mapa(3);
        
        Posicion posicionFinal = new Posicion(1,2);
        Casillero casillero = new Casillero();
        casillero.agregarElemento(new ObstaculoNulo());
        // interfaz antes de obstaculo q sea geneerica para items
        
        mapa.asignarCasillero(casillero, posicionFinal);

        cuatrox4.mover("Derecha", mapa);
        
        assertEquals(cuatrox4.getPosicion(), posicionFinal);
    }

    @Test
    public void test4x4AtraviezaPozo2VecesNoEsPenalizado(){
        Vehiculo cuatrox4 = new CuatroPorCuatro(1, 1);
        Mapa mapa = new Mapa(5);
        
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Casillero casillero = new Casillero();
        casillero.agregarElemento(new Pozo());

        mapa.asignarCasillero(casillero, posicion1);
        mapa.asignarCasillero(casillero, posicion2);

        cuatrox4.mover("Derecha", mapa);
        assertEquals(cuatrox4.getCantidadMovimientos(), 1);
        
        cuatrox4.mover("Derecha", mapa);
        assertEquals(cuatrox4.getCantidadMovimientos(), 2);
    }

    @Test
    public void test4x4AtraviezaPozo3VecesSePenalizaCon2Movimientos(){
        Vehiculo cuatrox4 = new CuatroPorCuatro(1, 1);
        Mapa mapa = new Mapa(5);
        
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(1,4);
        Casillero casillero = new Casillero();
        casillero.agregarElemento(new Pozo());

        mapa.asignarCasillero(casillero, posicion1);
        mapa.asignarCasillero(casillero, posicion2);
        mapa.asignarCasillero(casillero, posicion3);

        cuatrox4.mover("Derecha", mapa);
        cuatrox4.mover("Derecha", mapa);
        cuatrox4.mover("Derecha", mapa);
        assertEquals(cuatrox4.getCantidadMovimientos(), 5);
        //5 = 2 movs + 1 mov + 2 mov de penalizacion
    }

	@Test
    public void test4x4AvanzaParaAtravezarPiqueteYPegaLaVuelta(){
        Vehiculo una4x4 = new CuatroPorCuatro(1, 1);
        Mapa mapa = new Mapa(3);
        
        Posicion posicionPiquete = new Posicion(2,1);
        Casillero casillero = new Casillero();
        casillero.agregarElemento(new Piquete());
		
        mapa.asignarCasillero(casillero, posicionPiquete);
		
        una4x4.mover("Abajo", mapa);
        Posicion posicionFinal = new Posicion(1,1);
		
        assertEquals(una4x4.getCantidadMovimientos(), 1);
        assertEquals(una4x4.getPosicion(), posicionFinal);
    }
}
