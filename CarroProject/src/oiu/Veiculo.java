package oiu;

public abstract class Veiculo {
    // Atributos privados
    private String marca;
    private String modelo;
    private double consumo;

    // Construtor que recebe marca, modelo e consumo
    public Veiculo(String marca, String modelo, double consumo) {
        this.marca = marca;
        this.modelo = modelo;
        setConsumo(consumo); // Usar o setter para validar o consumo
    }

    // Getters e setters para todos os atributos
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getConsumo() {
        return consumo;
    }

    public void setConsumo(double consumo) {
        if (consumo <= 0) {
            throw new IllegalArgumentException("O consumo deve ser maior que zero.");
        }
        this.consumo = consumo;
    }

    // Método abstrato
    public abstract void mover(double distancia) throws CombustivelInsuficienteException;
}