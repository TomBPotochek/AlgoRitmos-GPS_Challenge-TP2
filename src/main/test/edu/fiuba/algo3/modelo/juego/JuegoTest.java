package edu.fiuba.algo3.modelo.juego;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import edu.fiuba.algo3.modelo.vehiculos.CuatroPorCuatro;
import edu.fiuba.algo3.modelo.vehiculos.Moto;
import edu.fiuba.algo3.modelo.vehiculos.Auto;
import edu.fiuba.algo3.modelo.vehiculos.Direccion;
import org.junit.jupiter.api.Test;

import java.util.*;

import edu.fiuba.algo3.modelo.Logging.Logger;
import edu.fiuba.algo3.modelo.casillero.CasilleroCalle;
import edu.fiuba.algo3.modelo.casillero.Mapa;
import edu.fiuba.algo3.modelo.casillero.ElementosMapa.Pozo;
import edu.fiuba.algo3.modelo.casillero.ElementosMapa.SorpresaFavorable;
import edu.fiuba.algo3.modelo.casillero.ElementosMapa.Piquete;
import edu.fiuba.algo3.modelo.movimientos.Posicion;

public class JuegoTest {
    @Test
    public void testUnJugadorFinalizaLaPartidaPasandoPorUnPozoConMoto(){
		Logger.enableLogging(true);
        //armamos el mapa de 4x4 con un pozo en (2,1) y meta en (2,3)
        Mapa mapa = Mapa.getMapa();
		mapa.limpiar();
        mapa.generarGrillaVacia(4, 4);
        mapa.asignarPosicionMeta(new Posicion(2,3));
        
		CasilleroCalle casilleroConPozo = new CasilleroCalle();
        casilleroConPozo.agregarElemento(new Pozo());
        mapa.asignarCasillero(casilleroConPozo, new Posicion(2,1));

        Juego juego = new Juego("juan", new Moto());
        
        //comenzamos a mover a los jugadores por el mapa
        //movemos la moto atravez del piquete y el auto no
        juego.mover(Direccion.abajo());  //moto +1
        juego.mover(Direccion.derecha());//moto +1. pozo +3.
        juego.mover(Direccion.derecha());//moto +1. llego a la meta.

        //assert juego se finalizo
        //assertTrue(juego.estaFinalizado());

        //assert del ganador
        assertEquals(6, juego.obtenerPuntaje());
        Ranking ranking = Ranking.getRanking();
        ranking.limpiarRanking();
        ranking.registrarJugador(juego.obtenerNombre(), juego.obtenerPuntaje());
        assertTrue(ranking.estaEnElRanking(juego.obtenerNombre()));
        assertEquals(juego.obtenerPuntaje(), 6);
        //assert no se puede seguir jugando
        //assertThrows(JuegoFinalizadoException.class,
          //           () -> {juego.mover(new MovArriba());}
            //         );
		Logger.enableLogging(false);
    
	}

	@Test
	public void testDosJugadoresConDiferenteVehiculoFinalizanPartidaYSeObtienePuntajeDelGanador() {
		Logger.enableLogging(true);
		Mapa mapa = Mapa.getMapa();
		mapa.limpiar();
        mapa.generarGrillaVacia(4, 4);
        mapa.asignarPosicionMeta(new Posicion(1,4));
        
		// Posicionamiento de obstaculos
		CasilleroCalle casilleroConPozo = new CasilleroCalle();
        casilleroConPozo.agregarElemento(new Pozo());
        mapa.asignarCasillero(casilleroConPozo, new Posicion(1,2));
		
		// Bob tendra Auto y Alice CuatroPorCuatro; empiezan el la posicion (1, 1).
		Juego juegoBob = new Juego("Bob", new Auto());
		Juego juegoAlice = new Juego("Alice", new CuatroPorCuatro());
        Ranking ranking = Ranking.getRanking();
        ranking.limpiarRanking();

		// Ambos atraviezan el mapa en linea recta y cruzan un Pozo.
        juegoBob.mover(Direccion.derecha());  	// Bob esta en: (1, 2) - suma 1 + 3 movimientos (Pozo).
        juegoBob.mover(Direccion.derecha());	// Bob esta en: (1, 3) - suma 1 movimiento.
        juegoBob.mover(Direccion.derecha());	// Bob esta en: (1, 4) - suma 1 movimiento; meta.
        ranking.registrarJugador(juegoBob.obtenerNombre(), juegoBob.obtenerPuntaje());

		juegoAlice.mover(Direccion.derecha());	// Alice esta en: (1, 2) - suma 1 movimientos (Pozo).
        juegoAlice.mover(Direccion.derecha());	// Alice esta en: (1, 3) - suma 1 movimiento.
        juegoAlice.mover(Direccion.derecha());	// Alice esta en: (1, 4) - suma 1 movimiento; meta.
        ranking.registrarJugador(juegoAlice.obtenerNombre(), juegoAlice.obtenerPuntaje());

		assertTrue(juegoBob.estaFinalizado());
		assertTrue(juegoAlice.estaFinalizado());
        
		//assert del ganador
        assertEquals("Alice", juegoAlice.obtenerNombre());
        assertEquals("Bob", juegoBob.obtenerNombre());
        assertTrue(juegoAlice.obtenerPuntaje() < juegoBob.obtenerPuntaje());

        //assert ranking

        assertTrue(ranking.estaEnElRanking("Alice"));
        assertTrue(ranking.estaEnElRanking("Bob"));

        List<Map.Entry<String,Integer>> lista = ranking.obtenerRanking();
        Iterator<Map.Entry<String,Integer>> it = lista.iterator();

        assertEquals("Alice", it.next().getKey());
        assertEquals("Bob", it.next().getKey());

		Logger.enableLogging(false);
	}

	@Test
    public void testJugadorAtraviezaElMapaYAlLlegarALaMetaQuedaRegistradoEnElRanking(){
		Logger.enableLogging(true);
		Mapa mapa = Mapa.getMapa();
		mapa.limpiar();
        mapa.generarGrillaVacia(4, 4);
        mapa.asignarPosicionMeta(new Posicion(4,1));

		CasilleroCalle casilleroConEfectos = new CasilleroCalle();
        casilleroConEfectos.agregarElemento(new Pozo());
        casilleroConEfectos.agregarElemento(new Piquete());
        casilleroConEfectos.agregarElemento(new SorpresaFavorable());
		mapa.asignarCasillero(casilleroConEfectos, new Posicion(2,1));
		mapa.asignarCasillero(casilleroConEfectos, new Posicion(3,1));
		
		Juego juego = new Juego("Jeronimo", new Moto());
        Ranking ranking = Ranking.getRanking();
        ranking.limpiarRanking();

		assertEquals(0, juego.getCantMovimientosJugadorActual());
		juego.mover(Direccion.abajo()); // += 1
		assertTrue(juego.obtenerPosicionVehiculo().equals(new Posicion(2, 1)));
		
		assertEquals(5, juego.getCantMovimientosJugadorActual());
		juego.mover(Direccion.abajo()); // -> round (total + 1 + (3 + 2)) * (1 - 20/100) = 5
		assertTrue(juego.obtenerPosicionVehiculo().equals(new Posicion(3, 1)));
		
		assertEquals(9, juego.getCantMovimientosJugadorActual());
		juego.mover(Direccion.abajo());	// -> round (total + 1 + (3 + 2)) * (1 - 20/100)) = 9
		assertTrue(juego.obtenerPosicionVehiculo().equals(new Posicion(4, 1)));
		
		assertEquals(10, juego.getCantMovimientosJugadorActual());
		juego.mover(Direccion.abajo()); // -> total + 1 ==> 10 movimientos
		assertTrue(juego.obtenerPosicionVehiculo().equals(new Posicion(4, 1)));
		
		// Muevo una vez mas y el jugador no se mueve ni se incrementa el puntaje. 
		assertEquals(10, juego.getCantMovimientosJugadorActual());
		ranking.registrarJugador(juego.obtenerNombre(), juego.getCantMovimientosJugadorActual());
		
		assertTrue(juego.estaFinalizado());
		assertEquals(10, ranking.obtenerPuntajeJugador(juego.obtenerNombre()));
		
		Logger.enableLogging(false);
    }
}