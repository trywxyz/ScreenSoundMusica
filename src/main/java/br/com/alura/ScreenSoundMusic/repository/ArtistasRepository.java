package br.com.alura.ScreenSoundMusic.repository;

import br.com.alura.ScreenSoundMusic.model.Artistas;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArtistasRepository extends JpaRepository <Artistas, Long> {


    Optional<Artistas> findByNomeContainingIgnoreCase(String nome);
}
