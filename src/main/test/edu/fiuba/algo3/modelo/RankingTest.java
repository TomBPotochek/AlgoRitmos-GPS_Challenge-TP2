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
        ranking.registrarJugador("Ricardo", 100);
        ranking.registrarJugador("Roberto", 90);
        ranking.registrarJugador("Raul", 80);
        ranking.registrarJugador("Raul", 70);
        ranking.registrarJugador("Ricardo", 500);
        List<Map.Entry<String,Integer>> lista = ranking.obtenerRanking();
        Iterator<Map.Entry<String,Integer>> it = lista.iterator();

        assertEquals(500,it.next().getValue());
        assertEquals("Roberto", it.next().getKey());
        assertEquals("Raul",it.next().getKey());
        assertEquals(3, lista.size());
    }
}
