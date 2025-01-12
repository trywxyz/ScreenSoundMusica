package br.com.alura.ScreenSoundMusic.repository;

import br.com.alura.ScreenSoundMusic.model.Artistas;
import br.com.alura.ScreenSoundMusic.model.Musicas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ArtistasRepository extends JpaRepository <Artistas, Long> {


    Optional<Artistas> findByNomeContainingIgnoreCase(String nome);

    @Query("SELECT m FROM Artista a JOIN a.musicas m WHERE a.nome ILIKE %:nome%")
    List<Musicas> buscaMusicaPorArtista(String nome);
}
