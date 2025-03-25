package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import modelo.Usuario;

public class VentanaCrearCuenta extends JDialog {
    private JComboBox<String> comboUsuarios;
    private JTextField campoIdCuenta;
    private JButton botonGenerarId;
    private JButton botonCrear;

    public VentanaCrearCuenta(List<Usuario> usuarios) {
        setTitle("Crear Cuenta");
        setSize(400, 200);
        setLocationRelativeTo(null);
        setModal(true); // Hace que la ventana sea modal

        JPanel panel = new JPanel(new GridLayout(4, 2, 5, 5));

        // Combo box para seleccionar el usuario
        panel.add(new JLabel("Seleccionar Usuario:"));
        comboUsuarios = new JComboBox<>();
        for (Usuario usuario : usuarios) {
            comboUsuarios.addItem(usuario.getCui() + " - " + usuario.getNombre() + " " + usuario.getApellido());
        }
        panel.add(comboUsuarios);

        // Campo para el ID de la cuenta
        panel.add(new JLabel("ID de la Cuenta:"));
        campoIdCuenta = new JTextField();
        campoIdCuenta.setEditable(false); // El usuario no puede editarlo manualmente
        panel.add(campoIdCuenta);

        // Botón para generar un ID de cuenta
        botonGenerarId = new JButton("Generar ID");
        panel.add(botonGenerarId);

        // Botón para crear la cuenta
        botonCrear = new JButton("Crear Cuenta");
        panel.add(botonCrear);

        add(panel);
    }

    public String getCuiUsuarioSeleccionado() {
        String seleccion = (String) comboUsuarios.getSelectedItem();
        return seleccion.split(" - ")[0]; // Extraer el CUI del ítem seleccionado
    }

    public String getIdCuenta() {
        return campoIdCuenta.getText();
    }

    public void setIdCuenta(String idCuenta) {
        campoIdCuenta.setText(idCuenta);
    }

    public void agregarListener(ActionListener listener) {
        botonGenerarId.addActionListener(listener);
        botonCrear.addActionListener(listener);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }

    public void cerrar() {
        dispose(); // Cierra la ventana
    }
}