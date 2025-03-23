package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaLogin extends JFrame {
    private JTextField campoUsuario;
    private JPasswordField campoContrasena;
    private JButton botonLogin;

    public VistaLogin() {
        setTitle("Inicio de Sesión");
        setSize(300, 150); // Tamaño más pequeño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        setResizable(false); // Evitar que el usuario cambie el tamaño

        // Panel principal con un diseño más minimalista
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2, 5, 5)); // 3 filas, 2 columnas, con espacios entre componentes

        // Campo de usuario
        panel.add(new JLabel("Usuario:"));
        campoUsuario = new JTextField();
        panel.add(campoUsuario);

        // Campo de contraseña
        panel.add(new JLabel("Contraseña:"));
        campoContrasena = new JPasswordField();
        panel.add(campoContrasena);

        // Botón de inicio de sesión
        botonLogin = new JButton("Ingresar");
        panel.add(new JLabel()); // Espacio vacío para alinear el botón
        panel.add(botonLogin);

        add(panel);
    }

    public String getUsuario() {
        return campoUsuario.getText();
    }

    public String getContrasena() {
        return new String(campoContrasena.getPassword());
    }

    public void agregarListenerLogin(ActionListener listener) {
        botonLogin.addActionListener(listener);
    }

    public void mostrarMensaje(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
}