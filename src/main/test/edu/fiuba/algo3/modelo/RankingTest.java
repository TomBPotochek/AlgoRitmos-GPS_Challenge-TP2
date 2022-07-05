package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.juego.Ranking;
import org.junit.jupiter.api.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RankingTest {

    @Test
    public void puedoRegistrarJugadores(){


        Ranking ranking = new Ranking();
        ranking.registrarJugador("Ricardo", 10);
        ranking.registrarJugador("Roberto", 20);
        ranking.registrarJugador("Raul", 30);
        ranking.registrarJugador("Raul", 1000);
        ranking.registrarJugador("Raul", 2500);

        List<Map.Entry<String,Integer>> lista = ranking.obtenerRanking();
        Iterator<Map.Entry<String,Integer>> it = lista.iterator();

        assertEquals("Ricardo", it.next().getKey());
        assertEquals("Roberto", it.next().getKey());
        assertEquals("Raul",it.next().getKey());
        assertEquals(3, lista.size());
    }
}
