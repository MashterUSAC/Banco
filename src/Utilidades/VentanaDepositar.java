package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaDepositar extends JDialog {
    private JTextField campoIdCuenta;
    private JTextField campoMonto;
    private JButton botonDepositar;

    public VentanaDepositar() {
        setTitle("Depositar");
        setSize(300, 150);
        setLocationRelativeTo(null);
        setModal(true); // Hace que la ventana sea modal

        JPanel panel = new JPanel(new GridLayout(3, 2, 5, 5));

        panel.add(new JLabel("ID de la Cuenta:"));
        campoIdCuenta = new JTextField();
        panel.add(campoIdCuenta);

        panel.add(new JLabel("Monto a Depositar:"));
        campoMonto = new JTextField();
        panel.add(campoMonto);

        botonDepositar = new JButton("Depositar");
        panel.add(new JLabel()); // Espacio vacío
        panel.add(botonDepositar);

        add(panel);
    }

    public String getIdCuenta() {
        return campoIdCuenta.getText();
    }

    public double getMonto() {
        return Double.parseDouble(campoMonto.getText());
    }

    public void agregarListener(ActionListener listener) {
        botonDepositar.addActionListener(listener);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void cerrar() {
        dispose(); // Cierra la ventana
    }
}