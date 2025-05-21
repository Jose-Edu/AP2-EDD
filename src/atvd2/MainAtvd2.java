package atvd2;

import java.util.Scanner;

public class MainAtvd2 {
    public static void main(String[] args) {

        boolean sysOn = true;
        ListaDuplamenteLigada<Song> playlist = new ListaDuplamenteLigada<>();
        Scanner scanner = new Scanner(System.in);
        int op;

        String titulo;
        String artista;
        String album;
        int segundos;
        Song songHandle;

        while (sysOn) {

            System.out.println("Sistema gerenciador de músicas:");
            System.out.println();
            System.out.println("1 - Próxima música");
            System.out.println("2 - Música anterior");
            System.out.println("3 - Ordernar músicas");
            System.out.println("4 - Tocar música");
            System.out.println("5 - Adicionar música");
            System.out.println("6 - Remover música");
            System.out.println("7 - Listar músicas");
            System.out.println("8 - Sair");

            op = scanner.nextInt();
            System.out.println();

            switch (op) {

                case 1: //avançar
                    if (playlist.getAcNode() == null) {
                        System.out.println("Lista vazia...");
                        break;
                    }

                    playlist.nextNode();
                    break;

                case 2: //voltar
                    if (playlist.getAcNode() == null) {
                        System.out.println("Lista vazia...");
                        break;
                    }

                    playlist.previousNode();
                    break;

                case 3: //ordenar por título ou por artista

                    if (playlist.getAcNode() == null) {
                        System.out.println("Lista vazia...");
                        break;
                    }

                    System.out.println();
                    System.out.println("1 - Ordenar por título");
                    System.out.println("2 - Ordenar por artista");
                    System.out.println("0 - Voltar");
                    System.out.println("Escolha uma opção de ordenação:");
                    op = scanner.nextInt();
                    switch (op) {

                        case 1: // ordenar por título
                            Song.orderByTitle(playlist);
                            break;
                        case 2: // ordenar por artista
                            Song.orderByArtist(playlist);
                            break;
                        default:
                            System.out.println("Voltando...");

                    }
                    break;

                case 4: //tocar música
                    playlist.imprimirAtual();
                    break;

                case 5: //add música no inicio, fim ou posição selecionada

                    System.out.println("Digite o título da música:");
                    titulo = scanner.next();

                    System.out.println("Digite o artista da música:");
                    artista = scanner.next();

                    System.out.println("Digite o album da música:");
                    album = scanner.next();

                    System.out.println("Digite o tempo (em segundos) da música");
                    segundos = scanner.nextInt();

                    songHandle = new Song(titulo, artista, album, segundos);

                    System.out.println();
                    System.out.println("Onde deseja salvar a música?");
                    System.out.println("1 - início da playlist");
                    System.out.println("2 - fim da playlist");
                    System.out.println("3 - posição customizada");

                    op = scanner.nextInt();

                    switch (op) {

                        case 1: // Inicio
                            playlist.inserirNoInicio(songHandle);
                            break;
                        case 2: // Fim
                            playlist.inserirNoFim(songHandle);
                            break;
                        case 3: // Por index
                            System.out.println("Digite a posição para inserir:");
                            op = scanner.nextInt();
                            playlist.inserirPorIndex(songHandle, op);
                            break;

                    }
                    break;

                case 6: //rmv música por nome ou por index

                    if (playlist.getAcNode() == null) {
                        System.out.println("Lista vazia...");
                        break;
                    }

                    System.out.println("Deseja remover ou nome ou por endereço?");
                    System.out.println("1 - Por nome");
                    System.out.println("2 - Por endereço");
                    System.out.println("3 - Voltar");

                    op = scanner.nextInt();

                    switch (op) {

                        case 1: // Por nome
                            System.out.println("Digite o nome da música:");
                            titulo = scanner.next();
                            playlist.removerPorValor(new Song(titulo));
                            break;

                        case 2: // Por index
                            System.out.println("Digite o endereço:");
                            op = scanner.nextInt();
                            playlist.removerPorIndex(op);
                            break;

                        default:
                            System.out.println("Voltando...");

                    }
                    break;

                case 7: //listar músicas
                    playlist.imprimir();
                    break;

                case 8: //sair
                    sysOn = false;
                    System.out.println("Deixando o sistema...");
                    break;

                default: // erro
                    System.out.println("Opção inválida!");

            }

            System.out.println();

        }

    }
}
