package Parte04;

import Parte01.Robo;

public class Rocha extends Obstaculo{
    private Plano03 plano;

    public Rocha(int i, int j, Plano03 plano) {
        super.id = 2;
        super.posicao = new int[2];
        super.posicao[0] = i;
        super.posicao[1] = j;
        this.plano = plano;
    }

    @Override
    public void bater(Robo robo) {
        System.out.printf("\nRobô %s encostou na Rocha\n", robo.getCor());
        plano.inserirNaPosicao("[ R ]", robo.getX(), robo.getY());
        robo.setX(robo.getXAntigo());
        robo.setY(robo.getYAntigo());
        System.out.printf("Robô %s posição atual: (%d, %d)", robo.getCor(),robo.getX(), robo.getY());
    }
}