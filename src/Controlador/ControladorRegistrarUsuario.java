package controlador;

import vista.VentanaRegistrarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.BancoDatos;

public class ControladorRegistrarUsuario implements ActionListener {
    private VentanaRegistrarUsuario ventanaRegistrarUsuario;

    public ControladorRegistrarUsuario() {
        ventanaRegistrarUsuario = new VentanaRegistrarUsuario();
        ventanaRegistrarUsuario.agregarListener(this);
        ventanaRegistrarUsuario.setVisible(true); // Mostrar la ventana emergente
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cui = ventanaRegistrarUsuario.getCui();
        String nombre = ventanaRegistrarUsuario.getNombre();
        String apellido = ventanaRegistrarUsuario.getApellido();

        // Validar que el CUI sea un número válido
        try {
            Long.parseLong(cui); // Intenta convertir el CUI a un número
        } catch (NumberFormatException ex) {
            ventanaRegistrarUsuario.mostrarMensaje("El CUI debe ser un número válido.");
            return;
        }

        // Validar que el nombre no exceda 50 caracteres
        if (nombre.length() > 50 || apellido.length() > 50) {
            ventanaRegistrarUsuario.mostrarMensaje("El nombre y apellido no deben exceder 50 caracteres.");
            return;
        }

        // Validar que el CUI no esté duplicado (simulación)
        if (BancoDatos.existeCliente(cui)) {
            ventanaRegistrarUsuario.mostrarMensaje("El CUI ya está registrado.");
            return;
        }

        // Registrar el cliente
        BancoDatos.registrarCliente(cui, nombre, apellido);
        ventanaRegistrarUsuario.mostrarMensaje("Usuario registrado exitosamente.");
        ventanaRegistrarUsuario.cerrar();
    }
}