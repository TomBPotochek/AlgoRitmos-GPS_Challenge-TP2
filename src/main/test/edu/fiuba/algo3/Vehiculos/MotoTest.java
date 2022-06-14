package edu.fiuba.algo3.Vehiculos;

import edu.fiuba.algo3.modelo.casillero.*;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class MotoTest {
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

        conductor.moverDerecha();
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

        conductor.moverDerecha();

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

        conductor.moverDerecha();

        assertTrue(conductor.cantidadDeMovimientosEs(3));
    }
}
