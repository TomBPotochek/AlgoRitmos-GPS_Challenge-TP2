package edu.fiuba.algo3.Vehiculos;

import edu.fiuba.algo3.modelo.casillero.*;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.casillero.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.vehiculos.*;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class CuatroPorCuatroTest {
    @Test
    public void test4x4PuedeMoverseSinObstaculos(){
        Vehiculo cuatrox4 = new CuatroPorCuatro(1, 1);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(1);
        Posicion posicionFinal = new Posicion(1,2);
        Casillero casilleroVacio = new Casillero();
        
        mapa.asignarCasillero(casilleroVacio, posicionFinal);

        cuatrox4.mover("Derecha");
        
        assertEquals(cuatrox4.getPosicion(), posicionFinal);
    }

    @Test
    public void test4x4AtraviezaPozo2VecesNoEsPenalizado(){
        Vehiculo cuatrox4 = new CuatroPorCuatro(1, 1);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(5);
        mapa.setAlto(1);

        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Casillero casillero = new Casillero();
        casillero.agregarElemento(new Pozo());

        mapa.asignarCasillero(casillero, posicion1);
        mapa.asignarCasillero(casillero, posicion2);

        cuatrox4.mover("Derecha");
        assertEquals(cuatrox4.getCantidadMovimientos(), 1);
        
        cuatrox4.mover("Derecha");
        assertEquals(cuatrox4.getCantidadMovimientos(), 2);
    }

    @Test
    public void test4x4AtraviezaPozo3VecesSePenalizaCon2Movimientos(){
        Vehiculo cuatrox4 = new CuatroPorCuatro(1, 1);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(5);
        mapa.setAlto(5);

        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(1,4);
        Casillero casillero = new Casillero();
        casillero.agregarElemento(new Pozo());

        mapa.asignarCasillero(casillero, posicion1);
        mapa.asignarCasillero(casillero, posicion2);
        mapa.asignarCasillero(casillero, posicion3);

        cuatrox4.mover("Derecha");
        cuatrox4.mover("Derecha");
        cuatrox4.mover("Derecha");
        assertEquals(cuatrox4.getCantidadMovimientos(), 5);
        //5 = 2 movs + 1 mov + 2 mov de penalizacion
    }

	@Test
    public void test4x4AvanzaParaAtravezarPiqueteYPegaLaVuelta(){
        Vehiculo una4x4 = new CuatroPorCuatro(1, 1);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);
        Posicion posicionPiquete = new Posicion(2,1);
        Casillero casillero = new Casillero();
        casillero.agregarElemento(new Piquete());
		
        mapa.asignarCasillero(casillero, posicionPiquete);
		
        una4x4.mover("Abajo");
        Posicion posicionFinal = new Posicion(1,1);
		
		System.out.println("Cantmov");
		System.out.println(una4x4.getCantidadMovimientos());
        assertEquals(una4x4.getCantidadMovimientos(), 1);
        assertEquals(una4x4.getPosicion(), posicionFinal);
    }
}
