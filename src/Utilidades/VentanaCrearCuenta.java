package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaCrearCuenta extends JDialog {
    private JTextField campoCuiCliente;
    private JButton botonCrear;

    public VentanaCrearCuenta() {
        setTitle("Crear Cuenta");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setModal(true); // Hace que la ventana sea modal

        JPanel panel = new JPanel(new GridLayout(2, 2, 5, 5));

        panel.add(new JLabel("CUI del Cliente:"));
        campoCuiCliente = new JTextField();
        panel.add(campoCuiCliente);

        botonCrear = new JButton("Crear Cuenta");
        panel.add(new JLabel()); // Espacio vacío
        panel.add(botonCrear);

        add(panel);
    }

    public String getCuiCliente() {
        return campoCuiCliente.getText();
    }

    public void agregarListener(ActionListener listener) {
        botonCrear.addActionListener(listener);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void cerrar() {
        dispose(); // Cierra la ventana
    }
}