package controlador;

import vista.VentanaCrearCuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.BancoDatos;

public class ControladorCrearCuenta implements ActionListener {
    private VentanaCrearCuenta ventanaCrearCuenta;

    public ControladorCrearCuenta() {
        // Obtener la lista de usuarios registrados
        ventanaCrearCuenta = new VentanaCrearCuenta(BancoDatos.getUsuarios());
        ventanaCrearCuenta.agregarListener(this);
        ventanaCrearCuenta.setVisible(true); // Mostrar la ventana emergente
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Generar ID")) {
            // Generar un ID de cuenta único
            String idCuenta = generarIdCuenta();
            ventanaCrearCuenta.setIdCuenta(idCuenta);
        } else if (e.getActionCommand().equals("Crear Cuenta")) {
            String cuiCliente = ventanaCrearCuenta.getCuiUsuarioSeleccionado();
            String idCuenta = ventanaCrearCuenta.getIdCuenta();

            // Validar ID de cuenta
            if (idCuenta.isEmpty()) {
                ventanaCrearCuenta.mostrarMensaje("Primero genera un ID para la cuenta.");
                return;
            }

            // Crear la cuenta
            BancoDatos.crearCuenta(cuiCliente, idCuenta);
            ventanaCrearCuenta.mostrarMensaje("Cuenta creada exitosamente.");
            ventanaCrearCuenta.cerrar(); // Cierra la ventana después de crear la cuenta
        }
    }

    private String generarIdCuenta() {
        // ID de cuenta único
        return "C" + System.currentTimeMillis(); // 
    }
}