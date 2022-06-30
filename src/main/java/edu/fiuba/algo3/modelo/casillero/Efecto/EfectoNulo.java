package edu.fiuba.algo3.modelo.casillero.Efecto;

import edu.fiuba.algo3.modelo.juego.Jugador;

public class EfectoNulo implements Efecto {
//efecto concreto base del decorador
	@Override
	public void aplicarseSobre(Jugador jugador) {
		return;
	}
	
}
