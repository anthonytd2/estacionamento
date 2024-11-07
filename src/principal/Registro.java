package principal;

import java.time.LocalDateTime;

public class Registro {
    private Veiculo veiculo;
    private LocalDateTime horaEntrada;
    private LocalDateTime horaSaida;
    private double valorPago;

    public Registro(Veiculo veiculo, LocalDateTime horaEntrada, LocalDateTime horaSaida, double valorPago) {
        this.veiculo = veiculo;
        this.horaEntrada = horaEntrada;
        this.horaSaida = horaSaida;
        this.valorPago = valorPago;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public LocalDateTime getHoraEntrada() {
        return horaEntrada;
    }

    public LocalDateTime getHoraSaida() {
        return horaSaida;
    }

    public double getValorPago() {
        return valorPago;
    }
}
