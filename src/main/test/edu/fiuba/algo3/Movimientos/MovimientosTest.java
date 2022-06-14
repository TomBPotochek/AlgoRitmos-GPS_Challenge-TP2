package edu.fiuba.algo3.Movimientos;

import edu.fiuba.algo3.modelo.casillero.Mapa;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import edu.fiuba.algo3.modelo.vehiculos.*;
import edu.fiuba.algo3.modelo.movimientos.Posicion;


public class MovimientosTest {
    @Test
    public void testMotoIntentaMoverseFueraDelMapaYVuelveALaMismaPosicion(){
        Posicion posicionMoto = new Posicion(1,1);
        Vehiculo moto = new Moto(posicionMoto);
        Jugador conductor = new Jugador(moto);

        Mapa mapa = Mapa.getMapa();
        Posicion posicionFinal = new Posicion(1,1);
        conductor.moverArriba();

		System.out.println(moto.estaEnPosicion(posicionMoto));
        assertTrue(moto.estaEnPosicion(posicionMoto));
    }
}
