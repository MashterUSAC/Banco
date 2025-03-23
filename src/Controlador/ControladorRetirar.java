package controlador;

import vista.VentanaRetirar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorRetirar implements ActionListener {
    private VentanaRetirar ventanaRetirar;

    public ControladorRetirar() {
        ventanaRetirar = new VentanaRetirar();
        ventanaRetirar.agregarListener(this);
        ventanaRetirar.setVisible(true); // Mostrar la ventana emergente
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String idCuenta = ventanaRetirar.getIdCuenta();
        double monto = ventanaRetirar.getMonto();

        // Aquí puedes agregar la lógica para realizar el retiro
        System.out.println("Retiro de " + monto + " de la cuenta: " + idCuenta);

        ventanaRetirar.mostrarMensaje("Retiro realizado exitosamente.");
        ventanaRetirar.cerrar(); // Cierra la ventana después del retiro
    }
}