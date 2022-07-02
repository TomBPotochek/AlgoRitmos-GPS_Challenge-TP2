package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.juego.Ranking;
import org.junit.jupiter.api.Test;

import java.util.Collection;
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

        Collection<String> lista = ranking.obtenerRanking();
        Iterator<String> it = lista.iterator();

        assertEquals("Roberto", it.next());
        assertEquals("Ricardo",it.next());
        assertEquals("Raul",it.next());
        assertEquals("Roberto", it.next());
    }
}
