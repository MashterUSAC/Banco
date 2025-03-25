package controlador;

import vista.VentanaHistorialTransacciones;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorHistorialTransacciones implements ActionListener {
    private VentanaHistorialTransacciones ventanaHistorialTransacciones;

    public ControladorHistorialTransacciones() {
        ventanaHistorialTransacciones = new VentanaHistorialTransacciones();
        ventanaHistorialTransacciones.agregarListener(this);
        ventanaHistorialTransacciones.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String idCuenta = ventanaHistorialTransacciones.getIdCuenta();

        // Aquí puedes agregar la lógica para obtener el historial de transacciones
        String resultados = "Historial de transacciones para la cuenta " + idCuenta + ":\n";
        resultados += "Transacción 1: Depósito de Q. 100\n";
        resultados += "Transacción 2: Retiro de Q. 50\n";

        ventanaHistorialTransacciones.mostrarResultados(resultados);
    }
}