package controlador;

import vista.VentanaRegistrarUsuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

        // Aquí puedes agregar la lógica para registrar el usuario
        System.out.println("Usuario registrado: " + nombre + " " + apellido + " (CUI: " + cui + ")");

        ventanaRegistrarUsuario.mostrarMensaje("Usuario registrado exitosamente.");
        ventanaRegistrarUsuario.cerrar(); // Cierra la ventana después de registrar
    }
}