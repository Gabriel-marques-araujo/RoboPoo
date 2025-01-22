package Parte04;

import Parte01.Alimento;
import Parte01.Robo;
import Parte02.RoboNPC;
import Parte03.RoboInteligente;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Plano03 plano = new Plano03();
        ArrayList<Robo> robos = plano.getRobos();
        String cor1, cor2;
        boolean entradaValida;
        int x =-1, y=-1;
        ArrayList<Obstaculo> obstaculos = new ArrayList<>();

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

            for (char j: cor1.toCharArray()) {
                if (!Character.isLetter(j)) {
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
                System.out.println("Entrada Invalida");
                entradaValida = false;
                continue;
            }

            for (char j: cor2.toCharArray()) {
                if (!Character.isLetter(j)) {
                    System.out.println("Entrada Invalida");
                    entradaValida = false;
                    break;
                }
            }
        } while(cor1.equals(cor2) || !entradaValida);

        RoboInteligente robo02 = new RoboInteligente(cor2);
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

        int escolha;

        do {
            System.out.println("Escolha o tipo de Obstáculo:");
            System.out.println("1 - Bomba");
            System.out.println("2 - Rocha");
            System.out.println("3 - Iniciar Jogo");
            escolha = teclado.nextInt();
            switch (escolha){
                case 1:{
                    System.out.println("Escolha um local para colocar a Bomba: ");
                    System.out.println("Coordenada x: ");
                    int z = teclado.nextInt();

                    while (z < 0 || z > 3) {
                        System.out.print("Insira a coordenada x : ");
                        if (teclado.hasNextInt()) {
                            z = teclado.nextInt();
                            if (z < 0 || z > 3) {
                                System.out.println("Coordenada x fora dos limites . Tente novamente.");
                            }
                        } else {
                            System.out.println("Entrada inválida para coordenada x! Por favor, insira um número.");
                            teclado.next();

                        }
                    }

                    System.out.println("Coordenada y: ");
                    int w = teclado.nextInt();

                    while (w < 0 || w > 3) {
                        System.out.print("Insira a coordenada y : ");
                        if (teclado.hasNextInt()) {
                            w = teclado.nextInt();
                            if (w < 0 || w > 3) {
                                System.out.println("Coordenada y fora dos limites . Tente novamente.");
                            }
                        } else {
                            System.out.println("Entrada inválida para coordenada y! Por favor, insira um número.");
                            teclado.next();

                        }
                    }

                    if(!(z == 0 && w == 0 || z == alimento.getX() && w == alimento.getY())) {
                        Obstaculo bomba = new Bomba(z, w, plano);
                        obstaculos.add(bomba);
                        plano.inserirNaPosicao("[ B ]", bomba.getX(), bomba.getY());
                        entradaValida = true;
                        System.out.print("A Bomba foi criada com Sucesso!\n");
                    } else {
                        System.out.println("Entrada inválida para as coordenadas! Por favor, insira um número.");
                        entradaValida = false;
                        teclado.nextLine();
                    }
                    break;
                }
                case 2:{
                    System.out.println("Escolha um local para colocar a Rocha: ");
                    System.out.println("Coordenada x: ");
                    int k = teclado.nextInt();

                    while (k < 0 || k > 3) {
                        System.out.print("Insira a coordenada x : ");
                        if (teclado.hasNextInt()) {
                            k = teclado.nextInt();
                            if (k < 0 || k > 3) {
                                System.out.println("Coordenada x fora dos limites . Tente novamente.");
                            }
                        } else {
                            System.out.println("Entrada inválida para coordenada x! Por favor, insira um número.");
                            teclado.next();

                        }
                    }

                    System.out.println("Coordenada y: ");
                    int l = teclado.nextInt();

                    while (l < 0 || l > 3) {
                        System.out.print("Insira a coordenada y : ");
                        if (teclado.hasNextInt()) {
                            l = teclado.nextInt();
                            if (l < 0 || l > 3) {
                                System.out.println("Coordenada y fora dos limites . Tente novamente.");
                            }
                        } else {
                            System.out.println("Entrada inválida para coordenada y! Por favor, insira um número.");
                            teclado.next();

                        }
                    }

                    if (!(k == 0 && l == 0 || k == alimento.getX() && l == alimento.getY())) {
                        Obstaculo rocha = new Rocha(k, l, plano);
                        obstaculos.add(rocha);
                        plano.inserirNaPosicao("[ R ]", rocha.getX(), rocha.getY());
                        entradaValida = true;
                        System.out.print("A Rocha foi criada com Sucesso!\n");
                    } else {
                        System.out.println("Entrada inválida para as coordenadas! Por favor, insira um número.");
                        entradaValida = false;
                        teclado.nextLine();
                    }
                    break;
                }
            }
        } while (escolha != 3 || !entradaValida);

        teclado.nextLine();

        int opcao;

        do {
            System.out.println();

            plano.exibirPlano();

            System.out.printf("Movimento Robô %s NORMAL\n", robo01.getCor());

            if (!plano.isRobo01Morreu()) {
                System.out.print("Escolha uma opção: \n");
                System.out.println("1 - Mover Robô 01 NORMAL");
                System.out.println("2 - Sair");
                opcao = teclado.nextInt();
                teclado.nextLine();

                if (opcao == 1) {
                    try {
                        robo01.mover();

                        for (int i = 0; i < obstaculos.size(); i++) {
                            if (obstaculos.get(i).getX() == robo01.getX() && obstaculos.get(i).getY() == robo01.getY()) {
                                obstaculos.get(i).bater(robo01);
                                if (obstaculos.get(i).getId() == 1) {
                                    plano.inserirNaPosicao("[   ]", obstaculos.get(i).getX(), obstaculos.get(i).getY());
                                    obstaculos.remove(obstaculos.get(i));
                                    plano.setRobo01Morre(true);
                                }
                            } else {
                                plano.moverNaPosicao(robo01.getX(), robo01.getY(), robo01);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (opcao == 2) {
                    System.out.println("Jogo Encerrado!");
                    System.exit(0);
                }
            } else {
                System.out.printf("Robô %s NORMAL morreu!\n", robo01.getCor());
            }

            System.out.println();

            plano.exibirPlano();

            if(robo01.verificarEncontradoAlimento(alimento)) {
                System.out.printf("O Robô %s NORMAL encontrou o alimento!\n", robo01.getCor());
                break;
            }

            System.out.printf("Movimento Robô %s INTELIGENTE\n", robo02.getCor());

            if (!plano.isRobo02Morreu()) {
                System.out.print("Escolha uma opção: \n");
                System.out.println("1 - Mover Robô 02 INTELIGENTE");
                System.out.println("2 - Sair");
                opcao = teclado.nextInt();
                teclado.nextLine();

                if (opcao == 1) {
                    try {
                        robo02.mover();

                        for (int i = 0; i < obstaculos.size(); i++) {
                            if (obstaculos.get(i).getX() == robo02.getX() && obstaculos.get(i).getY() == robo02.getY()) {
                                obstaculos.get(i).bater(robo02);
                                if (obstaculos.get(i).getId() == 1) {
                                    plano.inserirNaPosicao("[   ]", obstaculos.get(i).getX(), obstaculos.get(i).getY());
                                    obstaculos.remove(obstaculos.get(i));
                                    plano.setRobo02Morre(true);
                                } else if (obstaculos.get(i).getId() == 2) {
                                    plano.moverNaPosicao(robo02.getX(), robo02.getY(), robo02);
                                }
                            } else {
                                plano.moverNaPosicao(robo02.getX(), robo02.getY(), robo02);
                            }
                        }
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                } else if (opcao == 2) {
                    System.out.println("Jogo Encerrado!");
                    System.exit(0);
                }
            } else {
                System.out.printf("Robô %s INTELIGENTE morreu!\n", robo02.getCor());
            }

            if(robo02.verificarEncontradoAlimento(alimento)) {
                System.out.printf("O Robô %s INTELIGENTE encontrou o alimento!\n", robo02.getCor());
                break;
            }

            if (plano.isRobo01Morreu() && plano.isRobo02Morreu()) {
                System.out.println("Ambos os Robôs morreram!");
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