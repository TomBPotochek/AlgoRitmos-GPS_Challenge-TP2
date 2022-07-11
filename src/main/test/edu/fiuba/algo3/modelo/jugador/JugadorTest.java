package edu.fiuba.algo3.modelo.jugador;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import edu.fiuba.algo3.modelo.casillero.ElementosMapa.*;
import edu.fiuba.algo3.modelo.movimientos.*;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.casillero.*;
import edu.fiuba.algo3.modelo.casillero.Mapa;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Posicion;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class JugadorTest {
    @Test
    public void testMotoPuedeMoverseSinObstaculos(){
        Posicion posicionMoto = new Posicion(1,1);
        Vehiculo moto = new Moto(posicionMoto);
        Jugador conductor = new Jugador("Enrique", moto);


        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);
      
        Posicion posicionFinal = new Posicion(1,2);
        CasilleroCalle casilleroVacio = new CasilleroCalle();
        
        mapa.asignarCasillero(casilleroVacio, posicionFinal);
        conductor.mover(new MovDerecha());
        
		assertTrue(moto.estaEnPosicion(posicionFinal));
    }


    @Test
    public void testMotoAtraviezaPozoEsPenalizadoCon3Movimientos(){
        Posicion posicionMoto = new Posicion(1,1);
        Vehiculo moto = new Moto(posicionMoto);
        Jugador conductor = new Jugador("mequedesinnombres", moto);


        Mapa mapa = Mapa.getMapa();
		mapa.limpiar();
        mapa.setAncho(3);
        mapa.setAlto(3);

        Posicion posicionFinal = new Posicion(1,2);
        CasilleroCalle casillero = new CasilleroCalle();
        casillero.agregarElemento(new Pozo());

        mapa.asignarCasillero(casillero, posicionFinal);

        conductor.mover(new MovDerecha());

        assertTrue(conductor.cantidadDeMovimientosEs(4));
    }

    @Test
    public void testMotoAtraviezaPiqueteEsPenalizadoCon2Movimientos(){
        Posicion posicionMoto = new Posicion(1,1);
        Vehiculo moto = new Moto(posicionMoto);
        Jugador conductor = new Jugador("Juliana", moto);

        Mapa mapa = Mapa.getMapa();
        mapa.limpiar();
		mapa.setAncho(3);
        mapa.setAlto(3);

        Posicion posicionFinal = new Posicion(1,2);
        CasilleroCalle casillero = new CasilleroCalle();
        casillero.agregarElemento(new Piquete());

        mapa.asignarCasillero(casillero, posicionFinal);

        conductor.mover(new MovDerecha());

        assertTrue(conductor.cantidadDeMovimientosEs(3));
    }

    @Test
    public void testMotoAtraviesaSorpresaFavorable(){
        Posicion posicionMoto = new Posicion(1,1);
        Vehiculo moto = new Moto(posicionMoto);
        Jugador conductor = new Jugador("Montgomery", moto);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);

        Posicion posicionFinal = new Posicion(1,2);
        CasilleroCalle casillero = new CasilleroCalle();
        casillero.agregarElemento(new SorpresaFavorable());

        mapa.asignarCasillero(casillero, posicionFinal);

        conductor.mover(new MovDerecha());

        assertTrue(conductor.cantidadDeMovimientosEs((int) Math.round(1*0.8)));
    }

    @Test
    public void testMotoAtraviesaSorpresaDesfavorable(){
        Posicion posicionMoto = new Posicion(1,1);
        Vehiculo moto = new Moto(posicionMoto);
        Jugador conductor = new Jugador("Carmen", moto);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);

        Posicion posicionFinal = new Posicion(1,2);
        CasilleroCalle casillero = new CasilleroCalle();
        casillero.agregarElemento(new SorpresaDesfavorable());

        mapa.asignarCasillero(casillero, posicionFinal);

        conductor.mover(new MovDerecha());

        assertTrue(conductor.cantidadDeMovimientosEs((int) Math.round(1*1.25)));
    }

    @Test
    public void testMotoAtraviesaSorpresaCambiaVehiculo(){
        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);
		mapa.limpiar();
		
		Posicion posicionMoto = new Posicion(1,1);
        Vehiculo moto = new Moto(posicionMoto);
        Jugador conductor = new Jugador("Repartidor", moto);
		
        Posicion posicionFinal = new Posicion(1,2);
        CasilleroCalle casillero = new CasilleroCalle();
        casillero.agregarElemento(new SorpresaCambioVehiculo());

        mapa.asignarCasillero(casillero, posicionFinal);
        conductor.mover(new MovDerecha());

		assertTrue(conductor.estaEnPosicion(posicionFinal));
		assertTrue(conductor.cantidadDeMovimientosEs(1));
		
		// Testeo el comportamiento para comprobar que sea un Auto.
        
		// 1. Sin obstaculos se puede mover
        posicionFinal = new Posicion(1,3);
		casillero = new CasilleroCalle();
		mapa.asignarCasillero(casillero, posicionFinal);
		
		conductor.mover(new MovDerecha());
		
		assertTrue(conductor.estaEnPosicion(posicionFinal));
		assertTrue(conductor.cantidadDeMovimientosEs(2));
		
		// 2. Atravieza un pozo y es penalizado con 3 mov + 1 por el movimiento.
        posicionFinal = new Posicion(2,3);
		casillero = new CasilleroCalle();
		casillero.agregarElemento(new Pozo());
        mapa.asignarCasillero(casillero, posicionFinal);
		conductor.mover(new MovAbajo());
		
        assertTrue(conductor.cantidadDeMovimientosEs(6));
		assertTrue(conductor.estaEnPosicion(posicionFinal));
		
		// 3. No puede atravezar piquete.
		Posicion posicionPiquete = new Posicion(3,3);
		casillero = new CasilleroCalle();
		casillero.agregarElemento(new Piquete());
		mapa.asignarCasillero(casillero, posicionPiquete);
		conductor.mover(new MovAbajo());
		
		assertTrue(conductor.cantidadDeMovimientosEs(7));
        assertTrue(conductor.estaEnPosicion(new Posicion(2, 3)));
	}
}
