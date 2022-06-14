package edu.fiuba.algo3.Vehiculos;

import edu.fiuba.algo3.modelo.casillero.*;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.casillero.Mapa;
import static org.junit.jupiter.api.Assertions.assertEquals;
import edu.fiuba.algo3.modelo.vehiculos.*;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class AutoTest {
    @Test
    public void testAutoPuedeMoverseSinObstaculos(){
        Vehiculo auto = new Auto(1, 1);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);
        Posicion posicionFinal = new Posicion(1,2);
        Casillero casilleroVacio = new Casillero();

        mapa.asignarCasillero(casilleroVacio, posicionFinal);

        auto.mover("Derecha");

        assertEquals(auto.getPosicion(), posicionFinal);
    }


    @Test
    public void testAutoAtraviezaPozoEsPenalizadoCon3Movimientos(){
        Vehiculo auto = new Auto(1, 1);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);
        Posicion posicionFinal = new Posicion(1,2);
        Casillero casillero = new Casillero();
        casillero.agregarElemento(new Pozo());

        mapa.asignarCasillero(casillero, posicionFinal);

        auto.mover("Derecha");

        assertEquals(auto.getCantidadMovimientos(), 4);
    }

    @Test
    public void testAutoQuiereAtravezarPiqueteYSeQuedaEnLaMismaPosicion(){
        Vehiculo auto = new Auto(1, 1);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);

        Posicion posicionPiquete = new Posicion(1,2);
        Casillero casillero = new Casillero();

        casillero.agregarElemento(new Piquete());

        mapa.asignarCasillero(casillero, posicionPiquete);

        auto.mover("Derecha");

        assertEquals(auto.getCantidadMovimientos(), 1);
        assertEquals(auto.getPosicion(), new Posicion(1, 1));
    }
}
