package Parte03;

import Parte01.Robo;
import Exception.*;
import java.util.Random;

public class RoboInteligente extends Robo {

    private String direcaoInvalida = "vazio";

    public RoboInteligente(String cor) {
        super(cor);
        this.posicao = new int[2];
    }

    public void mover() throws MovimentoInvalidoException {
        this.xAntigo = this.posicao[0];
        this.yAntigo = this.posicao[1];

        Random gerador = new Random();

        if (!(this.direcaoInvalida.equals("vazio"))) {
            if (this.xAntigo == 0 && this.yAntigo == 0 || this.xAntigo == 0 && this.yAntigo == 3) {
                this.direcaoInvalida = "vazio";
                int movimento = gerador.nextInt(1, 3);
                if (movimento == 1){
                    super.mover("2");
                } else if (movimento == 2){
                    super.mover("4");
                }
            }

            if (this.xAntigo == 3 && this.yAntigo == 0 || this.xAntigo == 3 && this.yAntigo == 3) {
                this.direcaoInvalida = "vazio";
                int movimento = gerador.nextInt(1, 3);
                if (movimento == 1){
                    super.mover("1");
                } else if (movimento == 2) {
                    super.mover("3");
                }
            }

            if (this.direcaoInvalida.equals("cima")) {
                this.direcaoInvalida = "vazio";
                int movimento = gerador.nextInt(1, 4);
                switch (movimento) {
                    case 1: {
                        super.mover("2");
                        break;
                    }
                    case 2: {
                        super.mover("3");
                        break;
                    }
                    case 3: {
                        super.mover("4");
                        break;
                    }
                }
            }

            if (this.direcaoInvalida.equals("baixo")) {
                this.direcaoInvalida = "vazio";
                int movimento = gerador.nextInt(1, 4);
                switch (movimento) {
                    case 1: {
                        super.mover("1");
                        break;
                    }
                    case 2: {
                        super.mover("3");
                        break;
                    }
                    case 3: {
                        super.mover("4");
                        break;
                    }
                }
            }

            if (this.direcaoInvalida.equals("esquerda")) {
                this.direcaoInvalida = "vazio";
                int movimento = gerador.nextInt(1, 4);
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
                        super.mover("4");
                        break;
                    }
                }
            }

            if (this.direcaoInvalida.equals("direita")) {
                this.direcaoInvalida = "vazio";
                int movimento = gerador.nextInt(1, 4);
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
                }
            }

        } else {

            Random gerador2 = new Random();

            int movimento = gerador2.nextInt(1, 5);

            switch (movimento) {
                case 1: {
                    if (this.posicao[0] > 0) {
                        this.posicao[0]--;
                        this.direcao = "cima";
                        this.qtdMovimentosValidos++;
                    } else {
                        String msg = "up";
                        this.direcaoInvalida = "cima";
                        this.qtdMovimentosInvalidos++;
                        throw new MovimentoInvalidoException(msg);
                    }
                    break;
                }
                case 2: {
                    if (this.posicao[0] < 3) {
                        this.posicao[0]++;
                        this.direcao = "baixo";
                        this.qtdMovimentosValidos++;
                    } else {
                        String msg = "down";
                        this.direcaoInvalida = "baixo";
                        this.qtdMovimentosInvalidos++;
                        throw new MovimentoInvalidoException(msg);
                    }
                    break;
                }
                case 3: {
                    if (this.posicao[1] > 0) {
                        this.posicao[1]--;
                        this.direcao = "esquerda";
                        this.qtdMovimentosValidos++;
                    } else {
                        String msg = "left";
                        this.direcaoInvalida = "esquerda";
                        this.qtdMovimentosInvalidos++;
                        throw new MovimentoInvalidoException(msg);
                    }
                    break;
                }
                case 4: {
                    if (this.posicao[1] < 3) {
                        this.posicao[1]++;
                        this.direcao = "direita";
                        this.qtdMovimentosValidos++;
                    } else {
                        String msg = "right";
                        this.direcaoInvalida = "direita";
                        this.qtdMovimentosInvalidos++;
                        throw new MovimentoInvalidoException(msg);
                    }
                    break;
                }
            }

            System.out.printf("Robô %s posição atual: (%d, %d)\n", this.cor, this.posicao[0], this.posicao[1]);
        }
    }

    public String getDirecaoInvalida(){
        return this.direcaoInvalida;
    }

    public void setDirecaoInvalida(String direcaoInvalida){
        this.direcaoInvalida = direcaoInvalida;
    }
}