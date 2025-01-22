package Parte02;

import Parte01.Alimento;
import Parte01.Robo;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Plano02 plano = new Plano02();
        String cor1 , cor2 ;
        boolean entradaValida;
        int x=-1, y=-1;

        ArrayList<Robo> robos = plano.getRobos();

        System.out.println("Bem vindo!\n");

        plano.exibirPlano();

        System.out.println("Crie um novo Robô 01");
        do {
            entradaValida = true;
            System.out.println("Escolha uma cor: ");
            cor1 = teclado.nextLine();

            if (cor1.isEmpty()){
                System.out.println("Não Pode Entrada Vazia");
                entradaValida = false;
                continue;
            }
            for (char c:cor1.toCharArray()) {
                if (!Character.isLetter(c)){
                    System.out.println("Entrada Invalida");
                    entradaValida = false;
                    break;
                }
            }
        } while (!entradaValida);

        RoboNPC robo01 = new RoboNPC(cor1);
        plano.adicionarRobo(robo01);

        System.out.println("Crie um novo Robô 02");
        do {
            entradaValida = true;
            System.out.println("Escolha uma cor diferente: ");
            cor2 = teclado.nextLine();

            if (cor2.isEmpty()){
                System.out.println("Não Pode Entrada Vazia");
                entradaValida = false;
                continue;
            }

            for (char c:cor2.toCharArray()) {
                if (!Character.isLetter(c)){
                    System.out.println("Entrada Invalida");
                    entradaValida = false;
                    break;
                }
            }
        } while(cor1.equals(cor2)|| !entradaValida);

        RoboNPC robo02 = new RoboNPC(cor2);
        plano.adicionarRobo(robo02);

        plano.inserirNaPosicao("[1,2]",0,0);

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
        plano.inserirNaPosicao("[ A ]",alimento.getX(),alimento.getY());
        teclado.nextLine();

        int opcao;

        do {
            System.out.println();

            plano.exibirPlano();

            System.out.printf("Movimento Robô %s NORMAL\n", robo01.getCor());

            System.out.print("Escolha uma opção: \n");
            System.out.println("1 - Mover Robô 01 NORMAL");
            System.out.println("2 - Sair");
            opcao = teclado.nextInt();
            teclado.nextLine();

            if (opcao == 1) {
                try {
                    robo01.mover();
                    plano.moverNaPosicao(robo01.getX(), robo01.getY(), robo01);
                } catch (Exception e) {
                    plano.moverNaPosicao(robo01.getX(), robo01.getY(), robo01);
                    System.out.println(e.getMessage());
                }
            } else if (opcao == 2) {
                System.out.println("Jogo Encerrado!");
                System.exit(0);
            }
            System.out.println();

            plano.exibirPlano();

            if(robo01.verificarEncontradoAlimento(alimento)) {
                System.out.printf("O Robô %s encontrou o alimento! NORMAL\n", robo01.getCor());
                break;
            }

            System.out.printf("Movimento Robô %s NORMAL\n", robo02.getCor());

            System.out.print("Escolha uma opção: \n");
            System.out.println("1 - Mover Robô 02 NORMAL");
            System.out.println("2 - Sair");
            opcao = teclado.nextInt();
            teclado.nextLine();

            if (opcao == 1) {
                try {
                    robo02.mover();
                    plano.moverNaPosicao(robo02.getX(), robo02.getY(), robo02);
                } catch (Exception e) {
                    plano.moverNaPosicao(robo02.getX(), robo02.getY(), robo02);
                    System.out.println(e.getMessage());
                }
            } else if (opcao == 2) {
                System.out.println("Jogo Encerrado!");
                System.exit(0);
            }

            if(robo02.verificarEncontradoAlimento(alimento)) {
                System.out.printf("O Robô %s NORMAL encontrou o alimento!\n", robo02.getCor());
                break;
            }

        } while (true);

        plano.exibirPlano();

        System.out.println("Jogo Encerrado!\n");

        System.out.println("PLACAR:");
        for (int i = 0; i < robos.size(); i++) {
            System.out.printf("Robô %s \n", robos.get(i).getCor());
            System.out.printf("Quantidade de Movimentos Válidos %d\n", robos.get(i).getQtdMovimentosValidos());
            System.out.printf("Quantidade de Movimentos Inválidos %d\n", robos.get(i).getQtdMovimentosInvalidos());
        }
    }
}

