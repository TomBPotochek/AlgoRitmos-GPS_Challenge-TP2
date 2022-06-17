package edu.fiuba.algo3.modelo.jugador;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.modelo.movimientos.MovDerecha;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.casillero.*;
import edu.fiuba.algo3.modelo.casillero.Mapa;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.movimientos.Posicion;
import edu.fiuba.algo3.modelo.vehiculos.*;

public class JugadorTest {
    @Test
    public void testMotoPuedeMoverseSinObstaculos(){
        Posicion posicionMoto = new Posicion(1,1);
        Vehiculo moto = new Moto(posicionMoto);
        Jugador conductor = new Jugador(moto);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);
      
        Posicion posicionFinal = new Posicion(1,2);
        Casillero casilleroVacio = new Casillero();
        
        mapa.asignarCasillero(casilleroVacio, posicionFinal);

        conductor.mover(new MovDerecha());
        assertTrue(moto.estaEnPosicion(posicionFinal));
    }


    @Test
    public void testMotoAtraviezaPozoEsPenalizadoCon3Movimientos(){
        Posicion posicionMoto = new Posicion(1,1);
        Vehiculo moto = new Moto(posicionMoto);
        Jugador conductor = new Jugador(moto);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);

        Posicion posicionFinal = new Posicion(1,2);
        Casillero casillero = new Casillero();
        casillero.agregarElemento(new Pozo());

        mapa.asignarCasillero(casillero, posicionFinal);

        conductor.mover(new MovDerecha());

        assertTrue(conductor.cantidadDeMovimientosEs(4));
    }

    @Test
    public void testMotoAtraviezaPiqueteEsPenalizadoCon2Movimientos(){
        Posicion posicionMoto = new Posicion(1,1);
        Vehiculo moto = new Moto(posicionMoto);
        Jugador conductor = new Jugador(moto);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);

        Posicion posicionFinal = new Posicion(1,2);
        Casillero casillero = new Casillero();
        casillero.agregarElemento(new Piquete());

        mapa.asignarCasillero(casillero, posicionFinal);

        conductor.mover(new MovDerecha());

        assertTrue(conductor.cantidadDeMovimientosEs(3));
    }

    @Test
    public void testMotoAtraviesaSorpresaFavorable(){
        Posicion posicionMoto = new Posicion(1,1);
        Vehiculo moto = new Moto(posicionMoto);
        Jugador conductor = new Jugador(moto);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);

        Posicion posicionFinal = new Posicion(1,2);
        Casillero casillero = new Casillero();
        casillero.agregarElemento(new SorpresaFavorable());

        mapa.asignarCasillero(casillero, posicionFinal);

        conductor.mover(new MovDerecha());

        assertTrue(conductor.cantidadDeMovimientosEs((int) Math.round(1*0.8)));
    }

    @Test
    public void testMotoAtraviesaSorpresaDesfavorable(){
        Posicion posicionMoto = new Posicion(1,1);
        Vehiculo moto = new Moto(posicionMoto);
        Jugador conductor = new Jugador(moto);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);

        Posicion posicionFinal = new Posicion(1,2);
        Casillero casillero = new Casillero();
        casillero.agregarElemento(new SorpresaDesfavorable());

        mapa.asignarCasillero(casillero, posicionFinal);

        conductor.mover(new MovDerecha());

        assertTrue(conductor.cantidadDeMovimientosEs((int) Math.round(1*1.25)));
    }

    @Test
    public void testMotoAtraviesaSorpresaCambiaVehiculo(){
        Posicion posicionMoto = new Posicion(1,1);
        Vehiculo moto = new Moto(posicionMoto);
        Jugador conductor = new Jugador(moto);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);

        Posicion posicionFinal = new Posicion(1,2);
        Casillero casillero = new Casillero();
        casillero.agregarElemento(new SorpresaCambioVehiculo());

        mapa.asignarCasillero(casillero, posicionFinal);

        conductor.mover(new MovDerecha());

       	assertTrue(conductor.vehiculoEsDeTipo(new Auto()));
    }
}
