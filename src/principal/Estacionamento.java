package principal;

import java.util.ArrayList;
import java.util.List;
import java.time.Duration;
import java.time.LocalDateTime;

public class Estacionamento {
    private List<Vaga> vagas;
    private List<Registro> historico;

    public Estacionamento() {
        this.vagas = new ArrayList<>();
        this.historico = new ArrayList<>();
    }

    public void adicionarVaga(Vaga vaga) {
        vagas.add(vaga);
    }

    public void registrarEntrada(Veiculo veiculo) {
        for (Vaga vaga : vagas) {
            if (vaga.isDisponivel() && vaga.getTamanho().equals(veiculo.getTamanho())) {
                vaga.ocupar(veiculo);
                System.out.println("Veículo estacionado na vaga " + vaga.getNumero());
                return;
            }
        }
        System.out.println("Nenhuma vaga disponível para o tamanho do veículo.");
    }

    public void registrarSaida(String placa) {
        for (Vaga vaga : vagas) {
            Veiculo veiculo = vaga.getVeiculo();
            if (veiculo != null && veiculo.getPlaca().equals(placa)) {
                veiculo.setHoraSaida();
                double valor = calcularValor(veiculo.getHoraEntrada(), veiculo.getHoraSaida());
                historico.add(new Registro(veiculo, veiculo.getHoraEntrada(), veiculo.getHoraSaida(), valor));
                vaga.liberar();
                System.out.println("Veículo saiu. Valor a pagar: R$" + valor);
                return;
            }
        }
        System.out.println("Veículo não encontrado.");
    }

    private double calcularValor(LocalDateTime entrada, LocalDateTime saida) {
        long horas = Duration.between(entrada, saida).toHours();
        if (horas <= 1) return 5.0;
        else if (horas <= 3) return 10.0;
        else return 15.0;
    }

    public void gerarRelatorioVagasOcupadas() {
        System.out.println("Relatório de Vagas Ocupadas:");
        for (Vaga vaga : vagas) {
            if (!vaga.isDisponivel()) {
                System.out.println("Vaga " + vaga.getNumero() + " - Tamanho: " + vaga.getTamanho() + 
                                   " - Placa: " + vaga.getVeiculo().getPlaca());
            }
        }
    }

    public void mostrarHistorico() {
        System.out.println("Histórico de permanência:");
        for (Registro registro : historico) {
            System.out.println("Placa: " + registro.getVeiculo().getPlaca() + 
                               ", Entrada: " + registro.getHoraEntrada() +
                               ", Saída: " + registro.getHoraSaida() +
                               ", Valor Pago: R$" + registro.getValorPago());
        }
    }
}
