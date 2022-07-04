package edu.fiuba.algo3.modelo.juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import edu.fiuba.algo3.modelo.vehiculos.Direccion;
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
        mapa.generarGrillaVacia(4, 4);
        mapa.asignarPosicionMeta(new Posicion(2,3));
        
		CasilleroCalle casilleroConPozo = new CasilleroCalle();
        casilleroConPozo.agregarElemento(new Pozo());
        mapa.asignarCasillero(casilleroConPozo, new Posicion(2,1));

        ProveedorDatosAzar azarMock = mock(ProveedorDatosAzar.class);
        when(azarMock.enteroAzarEnRango(1, 3)).thenReturn(1);

        Juego juego = new Juego("juan", azarMock);
        
        //comenzamos a mover a los jugadores por el mapa
        //movemos la moto atravez del piquete y el auto no
        juego.mover(Direccion.abajo());  //moto +1
        juego.mover(Direccion.derecha());//moto +1. pozo +3.
        juego.mover(Direccion.derecha());//moto +1. llego a la meta.

        //assert juego se finalizo
        //assertTrue(juego.estaFinalizado());

        //assert del ganador
        assertEquals(6, juego.obtenerPuntaje());

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
        when(azarMock.enteroAzarEnRango(1, 3)).thenReturn(2, 3);
		
		// Bob tendra Auto y Alice CuatroPorCuatro; empiezan el la posicion (1, 1).
		Juego juegoBob = new Juego("Bob", azarMock);
		Juego juegoAlice = new Juego("Alice", azarMock);

		// Ambos atraviezan el mapa en linea recta y cruzan un Pozo.
        juegoBob.mover(Direccion.derecha());  	// Bob esta en: (1, 2) - suma 1 + 3 movimientos (Pozo).
        juegoBob.mover(Direccion.derecha());	// Bob esta en: (1, 3) - suma 1 movimiento.
        juegoBob.mover(Direccion.derecha());	// Bob esta en: (1, 4) - suma 1 movimiento; meta.
        
		juegoAlice.mover(Direccion.derecha());	// Alice esta en: (1, 2) - suma 1 movimientos (Pozo).
        juegoAlice.mover(Direccion.derecha());	// Alice esta en: (1, 3) - suma 1 movimiento.
        juegoAlice.mover(Direccion.derecha());	// Alice esta en: (1, 4) - suma 1 movimiento; meta.

		assertTrue(juegoBob.estaFinalizado());
		assertTrue(juegoAlice.estaFinalizado());
        
		//assert del ganador
        assertEquals("Alice", juegoAlice.obtenerNombre());
        assertEquals("Bob", juegoBob.obtenerNombre());
        assertTrue(juegoAlice.obtenerPuntaje() < juegoBob.obtenerPuntaje());

        //assert no se puede seguir jugando
        assertThrows(JuegoFinalizadoException.class,
		() -> {juegoBob.mover(Direccion.izquierda());} );
        
		assertThrows(JuegoFinalizadoException.class,
		() -> {juegoAlice.mover(Direccion.izquierda());}
		);
	}

    public void testJugadorTerminaElJuegoYQuedaRegistradoEnElRanking(){

    }
}