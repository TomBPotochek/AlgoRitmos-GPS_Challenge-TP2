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
        String jugador = "Raul";
        int puntajeRaul = 10;
        String otroJugador = "Roberto";
        int puntajeRoberto = 35;
        String ricardo = "Ricardo";
        int puntajeRicardo = 100;

        Ranking ranking = new Ranking();
        ranking.registrarJugador(jugador, puntajeRaul);
        ranking.registrarJugador(otroJugador, puntajeRoberto);
        ranking.registrarJugador(ricardo, puntajeRicardo);

        Collection<String> lista = ranking.obtenerRanking();
        Iterator<String> it = lista.iterator();

        assertEquals("Ricardo",it.next());
        assertEquals("Roberto", it.next());
        assertEquals("Raul",it.next());

    }
}
