package edu.fiuba.algo3.modelo.juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;

import edu.fiuba.algo3.modelo.casillero.CasilleroCalle;
import edu.fiuba.algo3.modelo.casillero.Mapa;
import edu.fiuba.algo3.modelo.casillero.Pozo;
import edu.fiuba.algo3.modelo.casillero.azar.ProveedorDatosAzar;
import edu.fiuba.algo3.modelo.excepciones.JuegoFinalizadoException;
import edu.fiuba.algo3.modelo.movimientos.*;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class JuegoTest {
    @Test
    public void testJugadorFinalizaLaPartidaPasandoPorUnPozoConMoto(){
        //armamos el mapa de 4x4 con un pozo en (2,1) y meta en (2,3)
        Mapa mapa = Mapa.getMapa();
        mapa.asignarPosicionMeta(new Posicion(2,3));
        mapa.generarGrillaVacia(4, 4);
        CasilleroCalle casilleroConPozo = new CasilleroCalle();
        casilleroConPozo.agregarElemento(new Pozo());
        mapa.asignarCasillero(casilleroConPozo, new Posicion(2,1));

        ProveedorDatosAzar azarMock = mock(ProveedorDatosAzar.class);
        when(azarMock.enteroAzarEnRango(1, 3)).thenReturn(1);

        Juego juego = new Juego("Juan", azarMock);
        
        //comenzamos a mover a los jugadores por el mapa
        //movemos la moto atravez del piquete y el auto no
        juego.mover(new MovAbajo());  //moto +1
        juego.mover(new MovDerecha());//moto +1. pozo +3.
        juego.mover(new MovDerecha());//moto +1. llego a la meta.

        //assert juego se finalizo
        //assertTrue(juego.estaFinalizado());

        //assert del ganador
        assertEquals(6, juego.obtenerPuntaje());

        //assert no se puede seguir jugando
        //assertThrows(JuegoFinalizadoException.class,
          //           () -> {juego.mover(new MovArriba());}
            //         );
    }

}
