package Parte01;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Plano plano = new Plano();
        String cor;
        int x = -1, y =-1;
        System.out.println("Bem vindo!\n");

        plano.exibirPlano();

        System.out.println("Crie um novo Robô");

        boolean entradaValida;
        do {
            entradaValida = true;
            System.out.println("Escolha uma cor: ");
            cor = teclado.nextLine();

            if (cor.isEmpty()) {
                System.out.println("Não Pode Entrada Vazia");
                entradaValida = false;
                continue;
            }

            for (char c : cor.toCharArray()) {
                if (!Character.isLetter(c)) {
                    System.out.println("Entrada Invalida");
                    entradaValida = false;
                    break;
                }
            }

        } while (!entradaValida);

        Robo robo = new Robo(cor);
        plano.inserirNaPosicao("[R]",0,0);

        System.out.println("Escolha um local para colocar o alimento: ");
        while (x < 0 || x > 3) {
            System.out.print("Insira a coordenada x : ");
            if (teclado.hasNextInt()) {
                x = teclado.nextInt();
                if (x < 0 || x > 3) {
                    System.out.println("Coordenada x fora dos limites . Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida para coordenada x! Por favor, insira um número.");
                teclado.next();

            }
        }

        while (y < 0 || y > 3) {
            System.out.print("Insira a coordenada y : ");
            if (teclado.hasNextInt()) {
                y = teclado.nextInt();
                if (y < 0 || y > 3) {
                    System.out.println("Coordenada y fora dos limites . Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida para coordenada y! Por favor, insira um número.");
                teclado.next();

            }
        }

        Alimento alimento = new Alimento(x,y);
        plano.inserirNaPosicao("[A]",alimento.getX(),alimento.getY());
        teclado.nextLine();

        int opcao =0;
        do {
            System.out.println("\n");

            plano.exibirPlano();

            if(robo.verificarEncontradoAlimento(alimento)) {
                System.out.printf("O Robô %s encontrou o alimento!\n", robo.getCor());
                break;
            }

            System.out.print("Escolha uma opção: \n");
            System.out.println("1 - Mover Robô");
            System.out.println("2 - Sair");
            do {
                entradaValida = true;
                if (teclado.hasNextInt()) {
                    opcao = teclado.nextInt();
                    teclado.nextLine();
                }else{
                    System.out.println("Entrada Invalida,Digite Novamente: ");
                    entradaValida = false;
                    teclado.next();
                }

            }while (!entradaValida);

            if (opcao == 1) {
                try {

                    System.out.println("Digite o movimento: ");
                    String movimento = teclado.nextLine();

                    switch (movimento) {
                        case "up", "down", "left", "right", "1", "2", "3", "4": {
                            robo.mover(movimento);
                            plano.moverNaPosicao(robo.getX(), robo.getY(), robo);
                            break;
                        }

                        default: {
                            System.out.println("Entrada Inválida");
                        }
                    }
                }catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

        } while (opcao != 2);

        System.out.println("Jogo Encerrado!\n");

        System.out.println("PLACAR:");
        System.out.printf("Robô %s\n", robo.getCor());
        System.out.printf("Quantidade de Movimentos Válidos: %d\n", robo.getQtdMovimentosValidos());
        System.out.printf("Quantidade de Movimentos Inválidos: %d\n", robo.getQtdMovimentosInvalidos());
    }
}
