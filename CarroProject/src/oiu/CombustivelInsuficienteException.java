package oiu;

public class CombustivelInsuficienteException extends Exception {
    private static final long serialVersionUID = 1L; // Declaração do serialVersionUID

    public CombustivelInsuficienteException(String mensagem) {
        super(mensagem);
    }
}