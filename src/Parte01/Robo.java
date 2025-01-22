package Parte01;

import  Exception.*;

public class Robo {
    protected int[] posicao;
    protected String cor;
    protected String direcao = "vazio";
    protected int xAntigo;
    protected int yAntigo;
    protected int qtdMovimentosValidos = 0;
    protected int qtdMovimentosInvalidos = 0;

    public Robo(String cor) {
        this.cor = cor;
        this.posicao = new int[2];
    }

    public void mover(String movimento) throws MovimentoInvalidoException {
        this.xAntigo = this.posicao[0];
        this.yAntigo = this.posicao[1];

        if (movimento.equals("up") || movimento.equals("1")){
            if (this.posicao[0] > 0){
                this.posicao[0]--;
                this.direcao = "cima";
                this.qtdMovimentosValidos++;
            } else {
                movimento = "up";
                this.qtdMovimentosInvalidos++;
                throw new MovimentoInvalidoException(movimento);
            }
        }

        if (movimento.equals("down") || movimento.equals("2")){
            if (this.posicao[0] < 3){
                this.posicao[0]++;
                this.direcao = "baixo";
                this.qtdMovimentosValidos++;
            } else {
                movimento = "down";
                this.qtdMovimentosInvalidos++;
                throw new MovimentoInvalidoException(movimento);
            }
        }

        if (movimento.equals("left") || movimento.equals("3")){
            if (this.posicao[1] > 0){
                this.posicao[1]--;
                this.direcao = "esquerda";
                this.qtdMovimentosValidos++;
            } else {
                movimento = "left";
                this.qtdMovimentosInvalidos++;
                throw new MovimentoInvalidoException(movimento);
            }
        }

        if (movimento.equals("right") || movimento.equals("4")){
            if (this.posicao[1] < 3){
                this.posicao[1]++;
                this.direcao = "direita";
                this.qtdMovimentosValidos++;
            } else {
                movimento =  "right";
                this.qtdMovimentosInvalidos++;
                throw new MovimentoInvalidoException(movimento);
            }
        }

        System.out.printf("Robô %s posição atual: (%d, %d)\n", this.cor, this.posicao[0], this.posicao[1]);
    }


    public boolean verificarEncontradoAlimento(Alimento alimento){
        return this.posicao[0] == alimento.getX() && this.posicao[1] == alimento.getY();
    }

    public int[] getPosicao() {
        return this.posicao;
    }

    public String getCor() {
        return this.cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setPosicao(int[] posicao) {
        this.posicao = posicao;
    }

    public String getDirecao() {
        return this.direcao;
    }

    public int getXAntigo() {
        return this.xAntigo;
    }

    public int getYAntigo() {
        return this.yAntigo;
    }

    public int getX(){
        return this.posicao[0];
    }

    public int getY(){
        return this.posicao[1];
    }

    public void setX(int x) {
        this.posicao[0] = x;
    }

    public void setY(int y) {
        this.posicao[1] = y;
    }

    public int getQtdMovimentosValidos() {
        return this.qtdMovimentosValidos;
    }

    public int getQtdMovimentosInvalidos() {
        return this.qtdMovimentosInvalidos;
    }
}
