package oiu;

public class Carro extends Veiculo {
	private double combustivelNoTanque;

    public Carro(String marca, String modelo, double consumo, double combustivelNoTanque) {
        super(marca, modelo, consumo);
        this.combustivelNoTanque = combustivelNoTanque;
    }

    public double getCombustivelNoTanque() {
        return combustivelNoTanque;
    }

    public void setCombustivelNoTanque(double combustivelNoTanque) {
        this.combustivelNoTanque = combustivelNoTanque;
    }

    @Override
    public void mover(double distancia) throws CombustivelInsuficienteException {
        double combustivelNecessario = distancia / getConsumo(); // Use o getter
        if (combustivelNoTanque < combustivelNecessario) {
            throw new CombustivelInsuficienteException("Combustível insuficiente para percorrer a distância.");
        } else {
            combustivelNoTanque -= combustivelNecessario;
            System.out.println("Carro movida " + distancia + " km. Combustível restante: " + combustivelNoTanque + " litros.");
        }
    }
}