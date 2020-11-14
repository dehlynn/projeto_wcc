package br.com.delaine.musica.controller.form;


import org.springframework.lang.NonNull;

import br.com.delaine.musica.modelo.Musica;
import br.com.delaine.musica.repository.MusicaRepository;


public class AtualizacaoMusicaForm {
	
	@NonNull
	private String song;
	
	@NonNull 
	private String artista;
	
	@NonNull 
	private String album;




	public Musica atualizar(Long id, MusicaRepository musicaRepository) {
		Musica musica = musicaRepository.getOne(id);
		
		musica.setSong(this.getSong());
		musica.setArtista(this.getArtista());
		musica.setAlbum(this.getAlbum());
		
		return musica;
	}




	public String getSong() {
		return song;
	}




	public void setSong(String song) {
		this.song = song;
	}




	public String getArtista() {
		return artista;
	}




	public void setArtista(String artista) {
		this.artista = artista;
	}




	public String getAlbum() {
		return album;
	}




	public void setAlbum(String album) {
		this.album = album;
	}
	
}
