package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.juego.Ranking;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.ArrayList;
import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RankingTest {

    @Test
    public void puedoRegistrarJugadores(){


        Ranking ranking = new Ranking();
        ranking.registrarJugador("Roberto", 100);
        ranking.registrarJugador("Ricardo", 90);
        ranking.registrarJugador("Raul", 80);
        ranking.registrarJugador("Roberto", 70);

        Collection<ArrayList<String>> lista = ranking.obtenerRanking();
        Iterator<ArrayList<String>> iter = lista.iterator();

		assertEquals("Roberto", iter.next().get(0));
        assertEquals("Raul",iter.next().get(0));
        assertEquals("Ricardo",iter.next().get(0));

		assertEquals(70, ranking.obtenerPuntajeJugador("Roberto"));
		assertEquals(80, ranking.obtenerPuntajeJugador("Raul"));
		assertEquals(90, ranking.obtenerPuntajeJugador("Ricardo"));
    }
}
