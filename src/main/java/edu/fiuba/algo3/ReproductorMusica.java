package edu.fiuba.algo3;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;


public class ReproductorMusica {
	static ReproductorMusica unReproductor = null;
	private HashMap<String, MediaPlayer> canciones;

	private ReproductorMusica() {
		this.canciones = new HashMap<String, MediaPlayer>();
	
		ArrayList<String> listaCanciones = new ArrayList<String>();
		listaCanciones.add("menu");
		listaCanciones.add("jugando");
		listaCanciones.add("obstaculo");
		listaCanciones.add("meta");
		listaCanciones.add("meta_alt");
	
		for (String cancion : listaCanciones) {
			String pathRelativoCancion = "src/main/java/edu/fiuba/algo3/sonidos/" + cancion + ".mp3";
			String pathAbsCancion = new File(pathRelativoCancion).toURI().toString();
			Media media = new Media(pathAbsCancion);
			canciones.put(cancion, new MediaPlayer(media));
		}
	}

	public static ReproductorMusica getReproductor() {
		if (unReproductor == null) {
			unReproductor = new ReproductorMusica();
		}

		return unReproductor;
	}

	
	public MediaPlayer getMusicaMenu() {
		return canciones.get("menu");
	}
	
	public MediaPlayer getMusicaObstaculo() {
		return canciones.get("obstaculo");
	}

	public MediaPlayer getMusicaJugando() {
		return canciones.get("jugando");
	}
	
	public MediaPlayer getMusicaMeta() {
		// Descomentar una linea para elegir entre los sonidos de meta.
		// return canciones.get("meta");
		return canciones.get("meta_alt");
	}
	
}