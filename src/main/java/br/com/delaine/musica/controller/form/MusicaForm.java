package br.com.delaine.musica.controller.form;


import org.springframework.lang.NonNull;

import br.com.delaine.musica.modelo.Musica;
import br.com.delaine.musica.repository.MusicaRepository;

public class MusicaForm {

	@NonNull 
	private String album;
	
	@NonNull 
	private String artista;
	
	@NonNull 
	private String song;

	public String getAlbum() {
		return this.album;
	}

	public void setAlbum(String titulo) {
		this.album = titulo;
	}

	public String getArtista() {
		return this.artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}

	public String getSong() {
		return this.song;
	}

	public void setSong(String song) {
		this.song = song;
	}

	public Musica converter(MusicaRepository musicaRepository) {
		Musica musica = musicaRepository.findBySong(song);
		return new Musica(this.song, this.album, this.artista);
	}

}
