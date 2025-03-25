package modelo;

public class Cuenta {
    private String idCuenta;
    private Usuario cliente;
    private double saldo;

    public Cuenta(String idCuenta, Usuario cliente) {
        this.idCuenta = idCuenta;
        this.cliente = cliente;
        this.saldo = 0.0;
    }

    // Getters y Setters
    public String getIdCuenta() { return idCuenta; }
    public Usuario getCliente() { return cliente; }
    public double getSaldo() { return saldo; }

    public void depositar(double monto) {
        saldo += monto;
    }

    public void retirar(double monto) {
        saldo -= monto;
    }
    
}