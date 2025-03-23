package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaRegistrarUsuario extends JDialog {
    private JTextField campoCui;
    private JTextField campoNombre;
    private JTextField campoApellido;
    private JButton botonRegistrar;

    public VentanaRegistrarUsuario() {
        setTitle("Registrar Usuario");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setModal(true); // Hace que la ventana sea modal

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        panel.add(new JLabel("CUI:"));
        campoCui = new JTextField();
        panel.add(campoCui);

        panel.add(new JLabel("Nombre:"));
        campoNombre = new JTextField();
        panel.add(campoNombre);

        panel.add(new JLabel("Apellido:"));
        campoApellido = new JTextField();
        panel.add(campoApellido);

        botonRegistrar = new JButton("Registrar");
        panel.add(new JLabel()); // Espacio vacío
        panel.add(botonRegistrar);

        add(panel);
    }

    public String getCui() {
        return campoCui.getText();
    }

    public String getNombre() {
        return campoNombre.getText();
    }

    public String getApellido() {
        return campoApellido.getText();
    }

    public void agregarListener(ActionListener listener) {
        botonRegistrar.addActionListener(listener);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void cerrar() {
        dispose(); // Cierra la ventana
    }
}