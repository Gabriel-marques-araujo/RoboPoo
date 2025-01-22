package Exception;

public class MovimentoInvalidoException extends Exception {
    public MovimentoInvalidoException(String movimento) {
        super("Movimento invalido: " + movimento);
    }
}