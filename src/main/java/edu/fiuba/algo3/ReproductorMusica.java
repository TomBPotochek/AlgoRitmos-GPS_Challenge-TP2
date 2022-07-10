package edu.fiuba.algo3;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.ArrayList;

public class ReproductorMusica {
	static ReproductorMusica unReproductor = null;
	private ArrayList<MediaPlayer> canciones;
	private final Integer indiceMenu = 0;
	private final Integer indiceJugando = 1;
	private final Integer indiceObstaculo = 2;

	private final Integer indiceMeta = 3;
	private final Integer indiceMetaAlternativa = 4;

	private ReproductorMusica() {

		this.canciones = new ArrayList<MediaPlayer>();
		ArrayList<String> listaCanciones = new ArrayList<String>();
		// Inserto las canciones en orden segun sus indices.
		listaCanciones.add("/sonidos/menu.mp3");
		listaCanciones.add("/sonidos/jugando.mp3");
		listaCanciones.add("/sonidos/obstaculo.mp3");
		listaCanciones.add("/sonidos/meta.mp3");
		listaCanciones.add("/sonidos/meta_alt.mp3");
		
		// Creo un reproductor por cada cancion de la lista.
		for (String cancion : listaCanciones) {
			String pathCancion = this.getClass().getResource(cancion).toString();
			Media media = new Media(pathCancion);
			canciones.add(new MediaPlayer(media));
		}
	}

	public static ReproductorMusica getReproductor() {
		if (unReproductor == null) {
			unReproductor = new ReproductorMusica();
		}

		return unReproductor;
	}

	public MediaPlayer getMusicaMenu() {
		return canciones.get(this.indiceMenu);
	}
	
	public MediaPlayer getMusicaObstaculo() {
		return canciones.get(this.indiceObstaculo);
	}

	public MediaPlayer getMusicaJugando() {
		return canciones.get(this.indiceJugando);
	}
	
	public MediaPlayer getMusicaMeta() {
		return canciones.get(this.indiceMetaAlternativa);
	}
	
}