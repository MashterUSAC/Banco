package controlador;

import vista.VentanaDepositar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorDepositar implements ActionListener {
    private VentanaDepositar ventanaDepositar;

    public ControladorDepositar() {
        ventanaDepositar = new VentanaDepositar();
        ventanaDepositar.agregarListener(this);
        ventanaDepositar.setVisible(true); // Mostrar la ventana emergente
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String idCuenta = ventanaDepositar.getIdCuenta();
        double monto = ventanaDepositar.getMonto();

        // Aquí puedes agregar la lógica para realizar el depósito
        System.out.println("Depósito de " + monto + " en la cuenta: " + idCuenta);

        ventanaDepositar.mostrarMensaje("Depósito realizado exitosamente.");
        ventanaDepositar.cerrar(); // Cierra la ventana después del depósito
    }
}