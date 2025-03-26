package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Cuenta;

public class VentanaDepositar extends JDialog {
    private JComboBox<String> comboCuentas;
    private JTextField campoMonto;
    private JButton botonDepositar;

    public VentanaDepositar() {
        setTitle("Depositar");
        setSize(350, 150);
        setLocationRelativeTo(null);
        setModal(true);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // ComboBox para seleccionar cuenta
        panel.add(new JLabel("Seleccionar Cuenta:"));
        comboCuentas = new JComboBox<>();
        comboCuentas.setBackground(Color.WHITE);
        panel.add(comboCuentas);

        // Campo de monto
        panel.add(new JLabel("Monto:"));
        campoMonto = new JTextField();
        campoMonto.setToolTipText("Ingrese solo números positivos");
        panel.add(campoMonto);

        // Botón
        botonDepositar = new JButton("Depositar");
        botonDepositar.setBackground(new Color(0, 102, 204));
        botonDepositar.setForeground(Color.WHITE);
        botonDepositar.setFocusPainted(false);
        panel.add(new JLabel());
        panel.add(botonDepositar);

        add(panel);
    }

    public void cargarCuentas(List<Cuenta> cuentas) {
        comboCuentas.removeAllItems();
        if (cuentas.isEmpty()) {
            comboCuentas.addItem("No hay cuentas disponibles");
            comboCuentas.setEnabled(false);
            botonDepositar.setEnabled(false);
        } else {
            for (Cuenta cuenta : cuentas) {
                String infoCuenta = String.format("%s - %s %s", 
                    cuenta.getIdCuenta(), 
                    cuenta.getCliente().getNombre(), 
                    cuenta.getCliente().getApellido());
                comboCuentas.addItem(infoCuenta);
            }
            comboCuentas.setEnabled(true);
            botonDepositar.setEnabled(true);
        }
    }

    public String getIdCuentaSeleccionada() {
        if (comboCuentas.getSelectedItem() == null || 
            comboCuentas.getSelectedItem().equals("No hay cuentas disponibles")) {
            return null;
        }
        
        // Extrae solo el ID de la cuenta del texto del combo (asumiendo formato "ID - Nombre Apellido")
        String seleccion = comboCuentas.getSelectedItem().toString();
        return seleccion.split(" - ")[0];
    }

    public double getMonto() throws NumberFormatException {
        String texto = campoMonto.getText().trim();
        if (texto.isEmpty()) {
            throw new NumberFormatException("El monto no puede estar vacío");
        }
        double monto = Double.parseDouble(texto);
        if (monto <= 0) {
            throw new NumberFormatException("El monto debe ser positivo");
        }
        return monto;
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Información", 
            JOptionPane.INFORMATION_MESSAGE);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error", 
            JOptionPane.ERROR_MESSAGE);
    }

    public void cerrar() {
        dispose();
    }

    public void agregarListener(ActionListener listener) {
        botonDepositar.addActionListener(listener);
    }
}