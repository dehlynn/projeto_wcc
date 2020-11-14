package br.com.delaine.musica.controller.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import br.com.delaine.musica.modelo.Musica;


public class MusicaDto {

	private Long id;
	private String song;
	private String album;
	private String artista;
	private LocalDateTime dataCriacao;
	
	public MusicaDto(Musica musica) {
		this.setId(musica.getId());
		this.setSong(musica.getSong());
		this.setAlbum(musica.getAlbum());
		this.setArtista(musica.getArtista());

	}



	public static List<MusicaDto> converter(List<Musica> musicas) {
		return musicas.stream().map(MusicaDto::new).collect(Collectors.toList());
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getSong() {
		return song;
	}



	public void setSong(String song) {
		this.song = song;
	}



	public String getAlbum() {
		return album;
	}



	public void setAlbum(String album) {
		this.album = album;
	}



	public String getArtista() {
		return artista;
	}



	public void setArtista(String artista) {
		this.artista = artista;
	}



	public LocalDateTime getDataCriacao() {
		return dataCriacao;
	}



	public void setDataCriacao(LocalDateTime dataCriacao) {
		this.dataCriacao = dataCriacao;
	}

}
