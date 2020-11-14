package br.com.delaine.musica.repository;

import java.util.List;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;

import br.com.delaine.musica.modelo.Musica;


public interface MusicaRepository extends JpaRepository<Musica, Long> {

	Musica findBySong(@NonNull String song);

	//List<Musica> findByMusicaSong(String musicaSong);

}
