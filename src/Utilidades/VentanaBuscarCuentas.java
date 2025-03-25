package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VentanaBuscarCuentas extends JDialog {
    private JTextField campoCuiCliente;
    private JButton botonBuscar;
    private JTextArea areaResultados;

    public VentanaBuscarCuentas() {
        setTitle("Buscar Cuentas Asociadas");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setModal(true);

        JPanel panel = new JPanel(new BorderLayout());

        JPanel panelSuperior = new JPanel(new GridLayout(2, 2, 5, 5));
        panelSuperior.add(new JLabel("CUI del Cliente:"));
        campoCuiCliente = new JTextField();
        panelSuperior.add(campoCuiCliente);

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

    public String getCuiCliente() {
        return campoCuiCliente.getText();
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