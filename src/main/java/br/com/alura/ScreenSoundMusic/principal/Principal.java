package br.com.alura.ScreenSoundMusic.principal;

import br.com.alura.ScreenSoundMusic.model.Artistas;
import br.com.alura.ScreenSoundMusic.model.Musicas;
import br.com.alura.ScreenSoundMusic.model.TipoArtista;
import br.com.alura.ScreenSoundMusic.repository.ArtistasRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {
    private final ArtistasRepository repository;
    Scanner leitura = new Scanner(System.in);

    public Principal(ArtistasRepository repository) {
        this.repository = repository;
    }

    public void exibirMenu() {
        var opcao = -1;

        while (opcao != 0) {
            var menu = """
                     ==============================
                     Bem vindo a aplicação 
                     **Screen Sound Music**
                    
                     Escolha uma das opções:
                    
                    1- Cadastras artistas
                    2- Cadastras músicas
                    3- Listas músicas
                    4- Buscas músicas por artistas
                    5- Pesquisar dados sobre um artista
                    
                    0- Sair da aplicação
                    ==============================
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao){
                case 1:
                    cadastrarArtistas();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    listarMusicas();
                    break;
                case 4:
                    buscarMusicasPorArtistas();
                    break;
                case 5:
                    pesquisarDadosDoArtista();
                    break;
                case 9:
                    System.out.printf("Saindo...");
                    System.out.println("Encerrando a aplicação!");
                    break;

                default:
                    System.out.println("Opção inválida!");

            }

        }


    }


    private void cadastrarArtistas() {
        var cadastrarNovo = "s";

        while(cadastrarNovo.equalsIgnoreCase("s") ){
            System.out.println("Digite o nome do artista:");
            var nome = leitura.nextLine();

            System.out.println("Tipo do artista: (solo,dupla ou banda)");
            var tipo = leitura.nextLine();

            TipoArtista tipoArtista = TipoArtista.valueOf(tipo.toLowerCase());
            Artistas artistas = new Artistas(nome,tipoArtista);
            repository.save(artistas);
            System.out.println("Cadastrar novo artista? (S/N)");
            cadastrarNovo = leitura.nextLine();
        }

    }

    private void cadastrarMusica() {
        System.out.println("Cadastrar músicas de qual artista: ");
        var nome = leitura.nextLine();
        Optional<Artistas> artistas = repository.findByNomeContainingIgnoreCase(nome);
        if(artistas.isPresent()){
            System.out.println("Informe o titulo da música: ");
            var nomeMusica = leitura.nextLine();
            Musicas musica = new Musicas(nomeMusica);
            musica.setArtistas(artistas.get());
            artistas.get().getMusicas().add(musica);
            repository.save(artistas.get());

        }
    }

    private void listarMusicas() {
        List<Artistas> artistasList = repository.findAll();
        artistasList.forEach(a -> a.getMusicas().forEach(System.out::println));

    }

    private void buscarMusicasPorArtistas() {
        System.out.println("Buscas músicas de que artista?");
        var nome = leitura.nextLine();
        List<Musicas> musicas = repository.buscaMusicaPorArtista(nome);
        musicas.forEach(System.out::println);
    }

    private void pesquisarDadosDoArtista() {
        //CONSULTA VIA CHAT GPT
    }



}
