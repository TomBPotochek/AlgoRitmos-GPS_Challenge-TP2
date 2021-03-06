package edu.fiuba.algo3.Vehiculos;

import edu.fiuba.algo3.modelo.casillero.*;
import edu.fiuba.algo3.modelo.casillero.ElementosMapa.Piquete;
import edu.fiuba.algo3.modelo.casillero.ElementosMapa.Pozo;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.movimientos.Direccion;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.casillero.Mapa;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import edu.fiuba.algo3.modelo.vehiculos.Posicion;
import edu.fiuba.algo3.modelo.juego.Jugador;


public class AutoTest {
    @Test
    public void testAutoPuedeMoverseSinObstaculos(){
        Posicion posicionAuto = new Posicion(1,1);
		Vehiculo auto = new Auto(posicionAuto);
        Jugador conductor = new Jugador("Pepe", auto);


        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);
        Posicion posicionFinal = new Posicion(1,2);
        CasilleroCalle casilleroVacio = new CasilleroCalle();

        mapa.asignarCasillero(casilleroVacio, posicionFinal);

        conductor.mover(Direccion.derecha());

        assertTrue(auto.estaEnPosicion(posicionFinal));
    }


    @Test
    public void testAutoAtraviezaPozoEsPenalizadoCon3Movimientos(){
        Posicion posicionAuto = new Posicion(1,1);
        Vehiculo auto = new Auto(posicionAuto);
        Jugador conductor = new Jugador("LaCinthia", auto);


        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);
        Posicion posicionFinal = new Posicion(1,2);
        CasilleroCalle casillero = new CasilleroCalle();
        casillero.agregarElemento(new Pozo());

        mapa.asignarCasillero(casillero, posicionFinal);
        conductor.mover(Direccion.derecha());

        assertTrue(conductor.cantidadDeMovimientosEs(4));
    }

    @Test
    public void testAutoQuiereAtravezarPiqueteYSeQuedaEnLaMismaPosicion(){
        Posicion posicionAuto = new Posicion(1,1);
        Vehiculo auto = new Auto(posicionAuto);
        Jugador conductor = new Jugador("Migens", auto);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);

        Posicion posicionPiquete = new Posicion(1,2);
        CasilleroCalle casillero = new CasilleroCalle();

        casillero.agregarElemento(new Piquete());
        mapa.asignarCasillero(casillero, posicionPiquete);
        conductor.mover(Direccion.derecha());
        assertTrue(conductor.cantidadDeMovimientosEs(1));
        assertTrue(auto.estaEnPosicion(new Posicion(1, 1)));
    }
}
