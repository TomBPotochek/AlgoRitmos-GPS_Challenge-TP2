package edu.fiuba.algo3;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class ReproductorMusica {
	static ReproductorMusica reproductorMusica = null;
	
	private MediaPlayer musicaMenu;
	private MediaPlayer musicaJugando;
	private MediaPlayer musicaObstaculo;
	private MediaPlayer musicaMeta;
	private MediaPlayer musicaMetaAlternativa;
	
	private ReproductorMusica() {
		final String pathCancionMenu = this.getClass().getResource("/sonidos/menu.mp3").toString();
		this.musicaMenu = new MediaPlayer(new Media(pathCancionMenu));
		
		final String pathCancionJugando = this.getClass().getResource("/sonidos/jugando.mp3").toString();
		this.musicaJugando = new MediaPlayer(new Media(pathCancionJugando));
		
		final String pathCancionObstaculo = this.getClass().getResource("/sonidos/obstaculo.mp3").toString();
		this.musicaObstaculo = new MediaPlayer(new Media(pathCancionObstaculo));
		
		final String pathCancionMeta = this.getClass().getResource("/sonidos/meta.mp3").toString();
		this.musicaMeta = new MediaPlayer(new Media(pathCancionMeta));
		
		final String pathCancionMetaAlt = this.getClass().getResource("/sonidos/meta_alt.mp3").toString();
		this.musicaMetaAlternativa = new MediaPlayer(new Media(pathCancionMetaAlt));	
	}

	public static ReproductorMusica getReproductor() {
		if (reproductorMusica == null) {
			reproductorMusica = new ReproductorMusica();
		}

		return reproductorMusica;
	}

	public MediaPlayer getMusicaMenu() {
		return this.musicaMenu;
	}
	
	public MediaPlayer getMusicaObstaculo() {
		return this.musicaObstaculo;
	}

	public MediaPlayer getMusicaJugando() {
		return this.musicaJugando;
	}
	
	public MediaPlayer getMusicaMeta() {
		return this.musicaMetaAlternativa;
	}
	
}