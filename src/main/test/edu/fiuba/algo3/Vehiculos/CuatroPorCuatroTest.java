package edu.fiuba.algo3.Vehiculos;

import edu.fiuba.algo3.modelo.casillero.*;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.movimientos.MovAbajo;
import edu.fiuba.algo3.modelo.movimientos.MovDerecha;
import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Direccion;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class CuatroPorCuatroTest {
    @Test
    public void test4x4PuedeMoverseSinObstaculos(){
        Posicion posicion4x4 = new Posicion(1,1);
        Vehiculo cuatrox4 = new CuatroPorCuatro(posicion4x4);
        Jugador conductor = new Jugador("LaMona", cuatrox4);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(1);
        Posicion posicionFinal = new Posicion(1,2);
        CasilleroCalle casilleroVacio = new CasilleroCalle();
        
        mapa.asignarCasillero(casilleroVacio, posicionFinal);

        conductor.mover(Direccion.derecha());

        assertTrue(cuatrox4.estaEnPosicion(posicionFinal));
    }

    @Test
    public void test4x4AtraviezaPozo2VecesNoEsPenalizado(){
        Posicion posicion4x4 = new Posicion(1,1);
        Vehiculo cuatrox4 = new CuatroPorCuatro(posicion4x4);
        Jugador conductor = new Jugador("Milazzo", cuatrox4);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(5);
        mapa.setAlto(1);

        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        CasilleroCalle casillero = new CasilleroCalle();
        casillero.agregarElemento(new Pozo());

        mapa.asignarCasillero(casillero, posicion1);
        mapa.asignarCasillero(casillero, posicion2);

        conductor.mover(Direccion.derecha());
        assertTrue(conductor.cantidadDeMovimientosEs(1));
        
        conductor.mover(Direccion.derecha());
        assertTrue(conductor.cantidadDeMovimientosEs(2));
    }

    @Test
    public void test4x4AtraviezaPozo3VecesSePenalizaCon2Movimientos(){
        Posicion posicion4x4 = new Posicion(1,1);
        Vehiculo cuatrox4 = new CuatroPorCuatro(posicion4x4);
        Jugador conductor = new Jugador("Avestruz", cuatrox4);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(5);
        mapa.setAlto(5);

        Posicion posicion1 = new Posicion(1,2);
        Posicion posicion2 = new Posicion(1,3);
        Posicion posicion3 = new Posicion(1,4);
        CasilleroCalle casillero = new CasilleroCalle();
        casillero.agregarElemento(new Pozo());

        mapa.asignarCasillero(casillero, posicion1);
        mapa.asignarCasillero(casillero, posicion2);
        mapa.asignarCasillero(casillero, posicion3);

        conductor.mover(Direccion.derecha());
        conductor.mover(Direccion.derecha());
        conductor.mover(Direccion.derecha());
        assertTrue(conductor.cantidadDeMovimientosEs(5));
        //5 = 2 movs + 1 mov + 2 mov de penalizacion
    }

	@Test
    public void test4x4AvanzaParaAtravezarPiqueteYPegaLaVuelta(){
        Posicion posicion4x4 = new Posicion(1,1);
        Vehiculo cuatrox4 = new CuatroPorCuatro(posicion4x4);
        Jugador conductor = new Jugador("Yubarta", cuatrox4);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);
        Posicion posicionPiquete = new Posicion(2,1);
        CasilleroCalle casillero = new CasilleroCalle();
        casillero.agregarElemento(new Piquete());
		
        mapa.asignarCasillero(casillero, posicionPiquete);
		
		conductor.mover(Direccion.abajo());
		Posicion posicionFinal = new Posicion(1,1);
		
        assertTrue(conductor.cantidadDeMovimientosEs(1));
        assertTrue(cuatrox4.estaEnPosicion(posicionFinal));
    }
}
