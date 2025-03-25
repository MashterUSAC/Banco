package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaHistorialTransacciones extends JDialog {
    private JTextField campoIdCuenta;
    private JButton botonBuscar;
    private JTextArea areaResultados;

    public VentanaHistorialTransacciones() {
        setTitle("Historial de Transacciones");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setModal(true);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel panelSuperior = new JPanel(new GridLayout(2, 2, 5, 5));
        panelSuperior.add(new JLabel("ID de la Cuenta:"));
        campoIdCuenta = new JTextField();
        panelSuperior.add(campoIdCuenta);

        botonBuscar = new JButton("Buscar");
        panelSuperior.add(new JLabel()); // Espacio vacío
        panelSuperior.add(botonBuscar);

        panel.add(panelSuperior, BorderLayout.NORTH);

        areaResultados = new JTextArea();
        areaResultados.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaResultados);
        panel.add(scrollPane, BorderLayout.CENTER);

        add(panel);
    }

    public String getIdCuenta() {
        return campoIdCuenta.getText();
    }

    public void agregarListener(ActionListener listener) {
        botonBuscar.addActionListener(listener);
    }

    public void mostrarResultados(String resultados) {
        areaResultados.setText(resultados);
    }

    public void cerrar() {
        dispose();
    }
}