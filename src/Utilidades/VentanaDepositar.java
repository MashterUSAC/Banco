package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import modelo.BancoDatos;
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

        // ComboBox para seleccionar cuenta con mejor estilo
        panel.add(new JLabel("Seleccionar Cuenta:"));
        comboCuentas = new JComboBox<>();
        comboCuentas.setBackground(Color.WHITE);
        cargarCuentasEnCombo();
        panel.add(comboCuentas);

        // Campo de monto con validación visual
        panel.add(new JLabel("Monto:"));
        campoMonto = new JTextField();
        campoMonto.setToolTipText("Ingrese solo números positivos");
        panel.add(campoMonto);

        // Botón con estilo mejorado
        botonDepositar = new JButton("Depositar");
        botonDepositar.setBackground(new Color(0, 102, 204)); // Azul
        botonDepositar.setForeground(Color.WHITE);
        botonDepositar.setFocusPainted(false);
        panel.add(new JLabel());
        panel.add(botonDepositar);

        add(panel);
    }

    private void cargarCuentasEnCombo() {
        comboCuentas.removeAllItems();
        BancoDatos.getCuentas().forEach(cuenta -> {
            String infoCuenta = String.format("%s - %s %s", 
                cuenta.getIdCuenta(), 
                cuenta.getCliente().getNombre(), 
                cuenta.getCliente().getApellido());
            comboCuentas.addItem(infoCuenta);
        });
        
        if(comboCuentas.getItemCount() == 0) {
            comboCuentas.addItem("No hay cuentas disponibles");
        }
    }

    // En VentanaDepositar.java
    public String getIdCuentaSeleccionada() {
        return comboCuentas.getSelectedItem() != null 
               ? comboCuentas.getSelectedItem().toString() 
               : null;
    }

    public double getMonto() throws NumberFormatException {
        String texto = campoMonto.getText().trim();
        if(texto.isEmpty()) {
            throw new NumberFormatException("El monto no puede estar vacío");
        }
        double monto = Double.parseDouble(texto);
        if(monto <= 0) {
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

    public void actualizarListaCuentas() {
        cargarCuentasEnCombo();
    }
    
    public void cargarCuentas(java.util.List<String> cuentasDisponibles) {
        comboCuentas.removeAllItems();  // Limpiar items existentes

        if(cuentasDisponibles != null) {  // Validar que la lista no sea nula
            for (String cuenta : cuentasDisponibles) {  // Usar el parámetro recibido
                comboCuentas.addItem(cuenta);
            }
        }
    }
       
}