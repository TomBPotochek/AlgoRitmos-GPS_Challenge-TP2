package edu.fiuba.algo3.Movimientos;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.casillero.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import edu.fiuba.algo3.modelo.vehiculos.*;
import edu.fiuba.algo3.modelo.movimientos.Posicion;


public class MovimientosTest {
    @Test
    public void testMotoIntentaMoverseFueraDelMapaYVuelveALaMismaPosicion(){
        Moto moto = new Moto(1, 1);
        Mapa mapa = new Mapa(3);
        
        Posicion posicionFinal = new Posicion(1,1);
        moto.mover("Arriba", mapa);

        assertEquals(moto.getPosicion(), posicionFinal);
    }
}
