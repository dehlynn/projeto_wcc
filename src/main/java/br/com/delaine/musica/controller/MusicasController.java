package br.com.delaine.musica.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.delaine.musica.controller.dto.MusicaDto;
import br.com.delaine.musica.controller.form.AtualizacaoMusicaForm;
import br.com.delaine.musica.controller.form.MusicaForm;
import br.com.delaine.musica.modelo.Musica;
import br.com.delaine.musica.repository.MusicaRepository;

@RestController
@RequestMapping("/musicas")
public class MusicasController {
	

	
	@Autowired
	private MusicaRepository musicaRepository;
	

	
	
	@GetMapping
	public List<MusicaDto> lista(String nomeCurso) {
			//nessa linha eu vou acessar os registro do bd, o repository é um padrão de acesso a dados
			List<Musica> musicas = musicaRepository.findAll();
			
			//aqui eu vou utilizar o retorno do bd para devolver 
			return MusicaDto.converter(musicas);
	}
	
	
	@PostMapping
	@Transactional
	public ResponseEntity<MusicaDto> cadastrar(@RequestBody @Validated MusicaForm form, UriComponentsBuilder uriBuilder) {
		Musica musica = form.converter(musicaRepository);
		musicaRepository.save(musica);
		
		URI uri = uriBuilder.path("/musicas/{id}").buildAndExpand(musica.getId()).toUri();
		return ResponseEntity.created(uri).body(new MusicaDto(musica));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<MusicaDto> detalhar(@PathVariable Long id) {
		Optional<Musica> musica = musicaRepository.findById(id);
		if (musica.isPresent()) {
			return ResponseEntity.ok(new MusicaDto(musica.get()));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<MusicaDto> atualizar(@PathVariable Long id, @RequestBody @Validated AtualizacaoMusicaForm form) {
		Optional<Musica> optional = musicaRepository.findById(id);
		if (optional.isPresent()) {
			Musica musica = form.atualizar(id, musicaRepository);
			return ResponseEntity.ok(new MusicaDto(musica));
		}
		
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Musica> optional = musicaRepository.findById(id);
		if (optional.isPresent()) {
			musicaRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.notFound().build();
	}

}







