package Parte04;

import Parte01.Robo;

public abstract class Obstaculo {
    protected int id;
    protected int[] posicao = new int[2];

    public abstract void bater(Robo robo);

    public int getX(){
        return this.posicao[0];
    }

    public int getY(){
        return this.posicao[1];
    }

    public void setX(int x){
        this.posicao[0] = x;
    }

    public void setY(int y){
        this.posicao[1] = y;
    }

    public int getId(){
        return this.id;
    }
}
