package Parte04;

import Parte01.Robo;

import java.util.ArrayList;

public class Plano03 {
    private String[][] plano = new String[4][4];
    private ArrayList<Robo> robos = new ArrayList<>();
    private boolean robo01Morre = false;
    private boolean robo02Morre = false;

    public Plano03() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                this.plano[i][j] = "[   ]";
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

    public void adicionarRobo(Robo robo) {
        this.robos.add(robo);
    }

    public void inserirNaPosicao(String caractere, int i, int j) {
        this.plano[i][j] = caractere;
    }

    public void moverNaPosicao(int x, int y, Robo robo) {
        int index = 2;

        boolean nenhumRoboMorreu = !robo01Morre && !robo02Morre;

        for (int i = 0; i < this.robos.size(); i++) {
            if (this.robos.get(i).equals(robo)) {
                index = this.robos.indexOf(this.robos.get(i));
            }
        }

        switch (index){
            case 0:{
                if ((nenhumRoboMorreu) && this.robos.get(index).getXAntigo() == this.robos.get(1).getX() && this.robos.get(index).getYAntigo() == this.robos.get(1).getY()) {
                    this.plano[robo.getXAntigo()][robo.getYAntigo()] = "[ 2 ]";
                    break;
                }

            }
            case 1:{
                if ((nenhumRoboMorreu) && this.robos.get(index).getXAntigo() == this.robos.get(0).getX() && this.robos.get(index).getYAntigo() == this.robos.get(0).getY()) {
                    this.plano[robo.getXAntigo()][robo.getYAntigo()] = "[ 1 ]";
                    break;
                }
            }
            default:{
                this.plano[robo.getXAntigo()][robo.getYAntigo()] = "[   ]";
            }
        }



        if ((nenhumRoboMorreu) && this.robos.get(0).getX() == this.robos.get(1).getX() && this.robos.get(0).getY() == this.robos.get(1).getY()) {
            this.plano[x][y] = "[1,2]";
        } else if (index == 0) {
            this.plano[x][y] = "[ 1 ]";
        } else if (index == 1) {
            this.plano[x][y] = "[ 2 ]";
        }
    }

    public ArrayList<Robo> getRobos() {
        return robos;
    }

    public boolean isRobo01Morreu() {
        return robo01Morre;
    }

    public boolean isRobo02Morreu() {
        return robo02Morre;
    }

    public void setRobo01Morre(boolean robo01Morre) {
        this.robo01Morre = robo01Morre;
    }

    public void setRobo02Morre(boolean robo02Morre) {
        this.robo02Morre = robo02Morre;
    }
}

