package modelo;

import java.time.LocalDateTime;

public class Transaccion {
    private String idTransaccion;
    private LocalDateTime fechaHora;
    private String detalle;
    private double montoDebitado;
    private double montoAcreditado;

    public Transaccion(String idTransaccion, String detalle, double montoDebitado, double montoAcreditado) {
        this.idTransaccion = idTransaccion;
        this.fechaHora = LocalDateTime.now();
        this.detalle = detalle;
        this.montoDebitado = montoDebitado;
        this.montoAcreditado = montoAcreditado;
    }

    // Getters
    public String getIdTransaccion() { return idTransaccion; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public String getDetalle() { return detalle; }
    public double getMontoDebitado() { return montoDebitado; }
    public double getMontoAcreditado() { return montoAcreditado; }
}