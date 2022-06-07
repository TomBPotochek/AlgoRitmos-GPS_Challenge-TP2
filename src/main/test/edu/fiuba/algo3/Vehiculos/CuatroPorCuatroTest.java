package edu.fiuba.algo3.Vehiculos;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import vehiculos.*;
import casillero.*;
import movimientos.Posicion;

public class CuatroPorCuatroTest {
    @Test
    public void test4x4PuedeMoverseSinObstaculos(){
        CuatroPorCuatro cuatrox4 = new CuatroPorCuatro(1, 1);
        Mapa mapa = new Mapa(3);
        
        Posicion posicionFinal = new Posicion(1,2);
        Casillero c = new SinObstaculo();
        // interfaz antes de obstaculo q sea geneerica para items
        
        mapa.asignarCasillero(c, posicionFinal);

        cuatrox4.mover("Derecha", mapa);
        
        assertEquals(cuatrox4.getPosicion(), posicionFinal);
    }

    @Test
    public void test4x4AtraviezaPozo2VecesNoEsPenalizado(){
        CuatroPorCuatro cuatrox4 = new CuatroPorCuatro(1, 1);
        Mapa mapa = new Mapa(5);
        
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Casillero pozo = new Pozo();

        mapa.asignarCasillero(pozo, posicion1);
        mapa.asignarCasillero(pozo, posicion2);

        cuatrox4.mover("Derecha", mapa);
        assertEquals(cuatrox4.getCantidadMovimientos(), 1);
        
        cuatrox4.mover("Derecha", mapa);
        assertEquals(cuatrox4.getCantidadMovimientos(), 2);
    }

    @Test
    public void test4x4AtraviezaPozo3VecesSePenalizaCon2Movimientos(){
        CuatroPorCuatro cuatrox4 = new CuatroPorCuatro(1, 1);
        Mapa mapa = new Mapa(5);
        
        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(1,4);
        Casillero pozo = new Pozo();

        mapa.asignarCasillero(pozo, posicion1);
        mapa.asignarCasillero(pozo, posicion2);
        mapa.asignarCasillero(pozo, posicion3);

        cuatrox4.mover("Derecha", mapa);
        cuatrox4.mover("Derecha", mapa);
        cuatrox4.mover("Derecha", mapa);
        assertEquals(cuatrox4.getCantidadMovimientos(), 5);
        //5 = 2 movs + 1 mov + 2 mov de penalizacion
    }
}