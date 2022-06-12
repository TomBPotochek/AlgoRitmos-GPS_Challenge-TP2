package edu.fiuba.algo3.Vehiculos;

import modelo.casillero.*;
import modelo.vehiculos.Auto;
import modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import vehiculos.*;
//import casillero.*;
import modelo.movimientos.Posicion;

public class AutoTest {
    @Test
    public void testAutoPuedeMoverseSinObstaculos(){
        Vehiculo auto = new Auto(1, 1);
        //Mapa mapa = new Mapa(3);
        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);
        Posicion posicionFinal = new Posicion(1,2);
        Casillero c = new SinObstaculo();
        // interfaz antes de obstaculo q sea geneerica para items

        mapa.asignarCasillero(c, posicionFinal);

        auto.mover("Derecha");

        assertEquals(auto.getPosicion(), posicionFinal);
    }


    @Test
    public void testAutoAtraviezaPozoEsPenalizadoCon3Movimientos(){
        Vehiculo auto = new Auto(1, 1);
        //Mapa mapa = new Mapa(3);
        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);
        Posicion posicionFinal = new Posicion(1,2);
        Casillero pozo = new Pozo();

        mapa.asignarCasillero(pozo, posicionFinal);

        auto.mover("Derecha");

        assertEquals(auto.getCantidadMovimientos(), 4);
    }

    @Test
    public void testAutoQuiereAtravezarPiqueteYSeQuedaEnLaMismaPosicion(){
        Vehiculo auto = new Auto(1, 1);
        //Mapa mapa = new Mapa(3);
        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);

        Posicion posicionPiquete = new Posicion(1,2);
        Casillero piquete = new Piquete();

        mapa.asignarCasillero(piquete, posicionPiquete);

        auto.mover("Derecha");

        assertEquals(auto.getCantidadMovimientos(), 1);
        assertEquals(auto.getPosicion(), new Posicion(1, 1));
    }
}
