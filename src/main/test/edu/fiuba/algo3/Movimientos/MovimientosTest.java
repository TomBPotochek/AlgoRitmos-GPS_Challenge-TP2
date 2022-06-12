package edu.fiuba.algo3.Movimientos;

import modelo.casillero.Mapa;
import modelo.vehiculos.Moto;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

//import vehiculos.*;
//import casillero.*;
import modelo.movimientos.Posicion;

public class MovimientosTest {
    @Test
    public void testMotoIntentaMoverseFueraDelMapaYVuelveALaMismaPosicion(){
        Moto moto = new Moto(1, 1);
        //Mapa mapa = new Mapa(3);
        Mapa mapa = Mapa.getMapa();
        Posicion posicionFinal = new Posicion(1,1);
        moto.mover("Arriba");

        assertEquals(moto.getPosicion(), posicionFinal);
    }
}
