package edu.fiuba.algo3.modelo.juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import edu.fiuba.algo3.modelo.casillero.CasilleroCalle;
import edu.fiuba.algo3.modelo.casillero.Mapa;
import edu.fiuba.algo3.modelo.casillero.Pozo;
import edu.fiuba.algo3.modelo.casillero.Piquete;
import edu.fiuba.algo3.modelo.casillero.azar.ProveedorDatosAzar;
import edu.fiuba.algo3.modelo.excepciones.JuegoFinalizadoException;
import edu.fiuba.algo3.modelo.movimientos.*;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class JuegoTest {
    @Test
    public void testJugadorFinalizaLaPartidaPasandoPorUnPozoConMoto(){
        //armamos el mapa de 4x4 con un pozo en (2,1) y meta en (2,3)
        Mapa mapa = Mapa.getMapa();
		mapa.limpiar();
        mapa.asignarPosicionMeta(new Posicion(2,3));
        mapa.generarGrillaVacia(4, 4);
        CasilleroCalle casilleroConPozo = new CasilleroCalle();
        casilleroConPozo.agregarElemento(new Pozo());
        mapa.asignarCasillero(casilleroConPozo, new Posicion(2,1));

        ProveedorDatosAzar azarMock = mock(ProveedorDatosAzar.class);
        when(azarMock.enteroAzarEnRango(0, 2)).thenReturn(0);

        Juego juego = new Juego(new ArrayList<String>(Arrays.asList("Juan")), azarMock);
        
        //comenzamos a mover a los jugadores por el mapa
        //movemos la moto atravez del piquete y el auto no
        juego.mover(new MovAbajo());  //moto +1
        juego.mover(new MovDerecha());//moto +1. pozo +3.
        juego.mover(new MovDerecha());//moto +1. llego a la meta.

        //assert juego se finalizo
        //assertTrue(juego.estaFinalizado());

        //assert del ganador
        assertEquals(6, juego.obtenerPuntajeGanador());

        //assert no se puede seguir jugando
        //assertThrows(JuegoFinalizadoException.class,
          //           () -> {juego.mover(new MovArriba());}
            //         );
    }

	@Test
	public void testJugadoresConDiferenteVehiculoFinalizanPartidaYSeObtienePuntajeDelGanador() {
	
		Mapa mapa = Mapa.getMapa();
		mapa.limpiar();
        mapa.generarGrillaVacia(4, 4);
        mapa.asignarPosicionMeta(new Posicion(1,4));
        
		// Posicionamiento de obstaculos
		CasilleroCalle casilleroConPozo = new CasilleroCalle();
        casilleroConPozo.agregarElemento(new Pozo());
        mapa.asignarCasillero(casilleroConPozo, new Posicion(1,2));

		ProveedorDatosAzar azarMock = mock(ProveedorDatosAzar.class);
        when(azarMock.enteroAzarEnRango(0, 2)).thenReturn(1, 2);
		
		// Bob tendra auto y Alice CuatroPorCuatro; empiezan el la posicion (1, 1).
		ArrayList<String> jugadores;
		jugadores = new ArrayList<String>(Arrays.asList("Bob", "Alice"));
		Juego juego = new Juego(jugadores, azarMock);

		// Ambos atraviezan el mapa en linea recta y cruzan un Pozo.
        juego.mover(new MovDerecha());  // Bob esta en: (1, 2) - suma 1 + 3 movimientos (Pozo).
        juego.mover(new MovDerecha());	// Alice esta en: (1, 2) - suma 1 movimientos (Pozo). 
        juego.mover(new MovDerecha());	// Bob esta en: (1, 3) - suma 1 movimiento. 
        juego.mover(new MovDerecha());	// Alice esta en: (1, 3) - suma 1 movimiento.
        juego.mover(new MovDerecha());	// Bob esta en: (1, 4) - suma 1 movimiento; meta. 
        juego.mover(new MovDerecha());	// Alice esta en: (1, 4) - suma 1 movimiento; meta.

		assertTrue(juego.estaFinalizado());
        
		//assert del ganador
        assertEquals(3, juego.obtenerPuntajeGanador());
        assertEquals("Alice", juego.obtenerNombreGanador());

        //assert no se puede seguir jugando
        assertThrows(JuegoFinalizadoException.class,
                     () -> {juego.mover(new MovIzquierda());}
                     );


	}

    public void testJugadorTerminaElJuegoYQuedaRegistradoEnElRanking(){

    }
}