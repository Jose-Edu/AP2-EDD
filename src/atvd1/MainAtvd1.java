package atvd1;

import java.util.Scanner;

public class MainAtvd1 {

    public static void main(String[] args) {

        Stack<Pedido> cancelados = new Stack<>();
        Queue<Pedido> pendentes = new Queue<>();
        Scanner scanner = new Scanner(System.in);

        boolean sysOn = true;

        while (sysOn) {

            System.out.println("Sistema de Pedidos:");
            System.out.println();
            System.out.println("0 - Sair");
            System.out.println("1 - Add. novo pedido");
            System.out.println("2 - Atender pedido");
            System.out.println("3 - Cancelar pedido");
            System.out.println("4 - Restaurar pedido");
            System.out.println("5 - Imprimir pedidos pendentes");
            System.out.println("6 - Imprimir pedidos cancelados");
            System.out.println();
            System.out.println("Selecione uma opção: ");

            int op = scanner.nextInt();
            Pedido handle;

            switch (op) {

                case 0: // Sair
                    System.out.println("Saindo do sistema...");
                    sysOn = false;

                case 1: // Add. novo pedido
                    System.out.println("Descreva o pedido: ");
                    pendentes.push(new Pedido(scanner.nextLine()));
                    break;

                case 2: // Atender pedido
                    handle = pendentes.pick();
                    pendentes.pop();
                    System.out.println(handle+" removido com sucesso!");
                    break;

                case 3: // Cancelar pedido
                    handle = pendentes.pick();
                    pendentes.pop();
                    cancelados.push(handle);
                    System.out.println(handle+" cancelado com sucesso!");
                    break;

                case 4: // Restaurar pedido
                    handle = cancelados.pick();
                    cancelados.pop();
                    pendentes.push(handle);
                    System.out.println(handle+" restaurado com sucesso!");
                    break;

                case 5: // Imprimir pedidos pendentes
                    pendentes.display();
                    break;

                case 6: // Imprimir pedidos cancelados
                    cancelados.display();
                    break;

                default:
                    System.out.println("Erro, comando inválido!");

            }

            System.out.println();

        }

    }

}
