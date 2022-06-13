package edu.fiuba.algo3.Vehiculos;

import edu.fiuba.algo3.modelo.casillero.*;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Vehiculo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import vehiculos.*;
//import casillero.*;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class MotoTest {
    @Test
    public void testMotoPuedeMoverseSinObstaculos(){

        Vehiculo moto = new Moto(1, 1);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);
      
        Posicion posicionFinal = new Posicion(1,2);
        Casillero casilleroVacio = new SinObstaculo();
        // interfaz antes de obstaculo q sea geneerica para items
        
        mapa.asignarCasillero(casilleroVacio, posicionFinal);

        moto.mover("Derecha");
        
        assertEquals(moto.getPosicion(), posicionFinal);
    }


    @Test
    public void testMotoAtraviezaPozoEsPenalizadoCon3Movimientos(){

        Vehiculo moto = new Moto(1, 1);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);

        Posicion posicionFinal = new Posicion(1,2);
        Casillero pozo = new Pozo();

        mapa.asignarCasillero(pozo, posicionFinal);

        moto.mover("Derecha");

        assertEquals(moto.getCantidadMovimientos(), 4);
    }

    @Test
    public void testMotoAtraviezaPiqueteEsPenalizadoCon2Movimientos(){

        Vehiculo moto = new Moto(1, 1);

        Mapa mapa = Mapa.getMapa();
        mapa.setAncho(3);
        mapa.setAlto(3);

        Posicion posicionFinal = new Posicion(1,2);
        Casillero piquete = new Piquete();

        mapa.asignarCasillero(piquete, posicionFinal);

        moto.mover("Derecha");

        assertEquals(moto.getCantidadMovimientos(), 3);
    }
}
