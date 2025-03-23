package controlador;

import vista.VentanaCrearCuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorCrearCuenta implements ActionListener {
    private VentanaCrearCuenta ventanaCrearCuenta;

    public ControladorCrearCuenta() {
        ventanaCrearCuenta = new VentanaCrearCuenta();
        ventanaCrearCuenta.agregarListener(this);
        ventanaCrearCuenta.setVisible(true); // Mostrar la ventana emergente
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cuiCliente = ventanaCrearCuenta.getCuiCliente();

        // Aquí puedes agregar la lógica para crear la cuenta
        System.out.println("Cuenta creada para el cliente con CUI: " + cuiCliente);

        ventanaCrearCuenta.mostrarMensaje("Cuenta creada exitosamente.");
        ventanaCrearCuenta.cerrar(); // Cierra la ventana después de crear la cuenta
    }
}