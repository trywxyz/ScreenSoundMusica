package br.com.alura.ScreenSoundMusic.model;

import jakarta.persistence.*;

@Entity
@Table(name = "musicas")
public class Musicas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    @ManyToOne
    private Artistas artista;

    public Musicas(){}

    public Musicas(String nomeMusica) {
        this.titulo = nomeMusica;
    }


    //Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Artistas getArtistas() {
        return artista;
    }

    public void setArtistas(Artistas artistas) {
        this.artista = artistas;
    }

    @Override
    public String toString() {
        return "Músicas" + titulo + '\'' +
                ", artistas=" + artista.getNome() +
                '}';
    }
}
