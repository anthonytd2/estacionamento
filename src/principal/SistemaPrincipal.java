package principal;

import java.util.Scanner;

public class SistemaPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estacionamento estacionamento = new Estacionamento();

      
        estacionamento.adicionarVaga(new Vaga(1, "pequeno"));
        estacionamento.adicionarVaga(new Vaga(2, "médio"));
        estacionamento.adicionarVaga(new Vaga(3, "grande"));

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Registrar entrada de veículo");
            System.out.println("2. Registrar saída de veículo");
            System.out.println("3. Mostrar vagas ocupadas");
            System.out.println("4. Mostrar histórico");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1 -> {
                    System.out.print("Placa do veículo: ");
                    String placa = scanner.nextLine();
                    System.out.print("Modelo do veículo: ");
                    String modelo = scanner.nextLine();
                    System.out.print("Tamanho (pequeno, médio, grande): ");
                    String tamanho = scanner.nextLine();
                    Veiculo veiculo = new Veiculo(placa, modelo, tamanho);
                    estacionamento.registrarEntrada(veiculo);
                }
                case 2 -> {
                    System.out.print("Placa do veículo para saída: ");
                    String placa = scanner.nextLine();
                    estacionamento.registrarSaida(placa);
                }
                case 3 -> estacionamento.gerarRelatorioVagasOcupadas();
                case 4 -> estacionamento.mostrarHistorico();
                case 5 -> {
                    System.out.println("Saindo do sistema.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Opção inválida.");
            }
        }
    }
}
