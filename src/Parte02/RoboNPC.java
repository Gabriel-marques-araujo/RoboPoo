package Parte02;

import Parte01.Robo;
import Exception.*;
import java.util.Random;

public class RoboNPC extends Robo {

    public RoboNPC(String cor) {
        super(cor);
        this.posicao = new int[2];
    }

    public void mover() throws MovimentoInvalidoException{
        Random gerador = new Random();

        int movimento = gerador.nextInt(1, 5);

        switch (movimento) {
            case 1: {
                super.mover("1");
                break;
            }
            case 2: {
                super.mover("2");
                break;
            }
            case 3: {
                super.mover("3");
                break;
            }
            case 4: {
                super.mover("4");
                break;
            }
        }
    }
}
