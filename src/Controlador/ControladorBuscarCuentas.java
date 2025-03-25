package controlador;

import vista.VentanaBuscarCuentas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.BancoDatos;

public class ControladorBuscarCuentas implements ActionListener {
    private VentanaBuscarCuentas ventanaBuscarCuentas;

    public ControladorBuscarCuentas() {
        ventanaBuscarCuentas = new VentanaBuscarCuentas();
        ventanaBuscarCuentas.agregarListener(this);
        ventanaBuscarCuentas.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cuiCliente = ventanaBuscarCuentas.getCuiCliente();

        // Buscar cuentas asociadas al cliente
        StringBuilder resultados = new StringBuilder();
        BancoDatos.buscarCuentasPorCliente(cuiCliente).forEach(cuenta ->
            resultados.append("ID Cuenta: ").append(cuenta.getIdCuenta())
                     .append(", Saldo: ").append(cuenta.getSaldo()).append("\n")
        );

        if (resultados.length() == 0) {
            resultados.append("No se encontraron cuentas asociadas.");
        }

        ventanaBuscarCuentas.mostrarResultados(resultados.toString());
    }
}