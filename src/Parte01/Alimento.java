package Parte01;

public class Alimento {
    private int[] posicao = new int[2];

    public Alimento(int x, int y) {
        this.posicao[0] = x;
        this.posicao[1] = y;
    }

    public int[] getPosicao() {
        return this.posicao;
    }

    public void setPosicao(int[] posicao) {
        this.posicao = posicao;
    }

    public int getX() {
        return this.posicao[0];
    }

    public int getY() {
        return this.posicao[1];
    }
}