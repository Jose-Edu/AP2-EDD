package atvd2;

import java.util.Scanner;

public class MainAtvd2 {
    public static void main(String[] args) {

        boolean sysOn = true;
        ListaDuplamenteLigada<Song> playlist = new ListaDuplamenteLigada<>();
        Scanner scanner = new Scanner(System.in);
        int op;

        while (sysOn) {

            System.out.println("Sistema gerenciador de músicas:");
            System.out.println();
            System.out.println("1 - Próxima música");
            System.out.println("2 - Música anterior");
            System.out.println("3 - Ordernar música");
            System.out.println("4 - Tocar música");
            System.out.println("5 - Adicionar música");
            System.out.println("6 - Remover música");
            System.out.println("7 - Listar músicas");
            System.out.println("8 - Sair");

            op = scanner.nextInt();
            System.out.println();

            switch (op) {

                case 1: //avançar
                    playlist.nextNode();
                    break;

                case 2: //voltar
                    playlist.previousNode();
                    break;

                case 3: //ordenar por título ou por artista
                    break;

                case 4: //tocar música
                    System.out.println(playlist.getAcNode().data);
                    break;

                case 5: //add música no inicio, fim ou posição selecionada
                    break;

                case 6: //rmv música por nome ou por index
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
