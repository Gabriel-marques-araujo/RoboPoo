package Parte01;

public class Plano {
    private String[][] plano = new String[4][4];

    public Plano() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.plano[i][j] = "[ ]";
            }
        }
    }

    public void exibirPlano() {
        for (int i = 0; i < this.plano.length; i++) {
            for (int j = 0; j < this.plano[i].length; j++) {
                System.out.print(this.plano[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void inserirNaPosicao(String caractere, int i, int j) {
        this.plano[i][j] = caractere;
    }

    public void moverNaPosicao(int x, int y, Robo robo) {

        if (robo.getDirecao().equals("cima")){
            this.plano[robo.getXAntigo()][robo.getYAntigo()] = "[ ]";

        }

        if (robo.getDirecao().equals("baixo")){
            this.plano[robo.getXAntigo()][robo.getYAntigo()] = "[ ]";
        }

        if (robo.getDirecao().equals("esquerda")){
            this.plano[robo.getXAntigo()][robo.getYAntigo()] = "[ ]";
        }

        if (robo.getDirecao().equals("direita")){
            this.plano[robo.getXAntigo()][robo.getYAntigo()] = "[ ]";
        }

        this.plano[x][y] = "[R]";
    }
}
