package edu.fiuba.algo3.Movimientos;

import edu.fiuba.algo3.modelo.casillero.Mapa;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.casillero.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.vehiculos.*;
import edu.fiuba.algo3.modelo.movimientos.Posicion;


public class MovimientosTest {
    @Test
    public void testMotoIntentaMoverseFueraDelMapaYVuelveALaMismaPosicion(){
        Vehiculo moto = new Moto(1, 1);
        //Mapa mapa = new Mapa(3);
        Mapa mapa = Mapa.getMapa();
        Posicion posicionFinal = new Posicion(1,1);
        moto.mover("Arriba");

        assertEquals(moto.getPosicion(), posicionFinal);
    }
}
