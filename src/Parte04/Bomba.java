package Parte04;

import Parte01.Robo;

public class Bomba extends Obstaculo{
    private Plano03 plano;

    public Bomba(int i, int j, Plano03 plano) {
        super.id = 1;
        super.setX(i);
        super.setY(j);
        this.plano = plano;
    }

    @Override
    public void bater(Robo robo) {
        System.out.printf("\nRobô´ %s encostou na Bomba\n", robo.getCor());
        plano.inserirNaPosicao("[   ]", robo.getXAntigo(), robo.getYAntigo());
    }
}