package br.com.alura.ScreenSoundMusic;

import br.com.alura.ScreenSoundMusic.principal.Principal;
import br.com.alura.ScreenSoundMusic.repository.ArtistasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenSoundMusicApplication implements CommandLineRunner {

	@Autowired
	private ArtistasRepository repository;


	public static void main(String[] args) {
		SpringApplication.run(ScreenSoundMusicApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Principal principal = new Principal(repository);

		principal.exibirMenu();
		System.out.println("Hello World!");


	}
}
