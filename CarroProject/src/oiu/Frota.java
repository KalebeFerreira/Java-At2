package oiu;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Frota {
    private static final Scanner scanner = new Scanner(System.in); // Scanner como atributo da classe

    public static void main(String[] args) {
        List<Veiculo> veiculos = new ArrayList<>();

        // Adicionando veículos à lista
        veiculos.add(new Carro("Ford", "Fiesta", 15.0, 40.0));
        veiculos.add(new Carro("Fiat", "Uno", 19.0, 40.0));
        veiculos.add(new Moto("Honda", "CBR", 25.0, 15.0));
        veiculos.add(new Carro("Ford", "Fusion", 6.0, 50.0));
        veiculos.add(new Carro("Ferrari", "LaFerrari", 2.3, 50.0));
        // Exibindo a lista de veículos
        System.out.println("Selecione um veículo:");
        for (int i = 0; i < veiculos.size(); i++) {
            Veiculo v = veiculos.get(i);
            System.out.printf("%d: %s %s (Consumo: %.2f km/l, Combustível no tanque: %.2f L)%n",
                    i + 1, v.getMarca(), v.getModelo(), v.getConsumo(), 
                    (v instanceof Carro ? ((Carro) v).getCombustivelNoTanque() : ((Moto) v).getCombustivelNoTanque()));
        }

        // Permitir que o usuário escolha um veículo
        System.out.print("Digite o número do veículo desejado: ");
        int escolha = scanner.nextInt();
        
        // Validar a entrada do usuário
        if (escolha < 1 || escolha > veiculos.size()) {
            System.out.println("Escolha inválida.");
            return;
        }

        Veiculo veiculoEscolhido = veiculos.get(escolha - 1); // Ajuste para índice zero

        // Solicitar a distância a ser percorrida
        System.out.print("Insira a distância a ser percorrida: ");
        
        try {
            double distancia = scanner.nextDouble();
            if (distancia < 0) {
                System.out.println("A distância não pode ser negativa.");
                return;
            }
            
            // Tentar mover o veículo escolhido
            try {
                veiculoEscolhido.mover(distancia);
            } catch (CombustivelInsuficienteException e) {
                System.out.println(e.getMessage());
            }
        } catch (InputMismatchException e) {
            System.out.println("Por favor, insira um número válido para a distância.");
        }

        // Não feche o scanner aqui, pois ele está ligado ao System.in
    }
}