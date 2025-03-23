package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class VistaPrincipal extends JFrame {
    private JButton botonRegistrarUsuario;
    private JButton botonCrearCuenta;
    private JButton botonDepositar;
    private JButton botonRetirar;
    private JButton botonSalir;
    private JTextArea areaMensajes;

    public VistaPrincipal() {
        setTitle("USAC International Bank");
        setSize(500, 300); // Tamaño un poco más grande para acomodar los botones
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar la ventana
        setResizable(false); // Evitar que el usuario cambie el tamaño

        // Panel principal con un diseño de cuadrícula
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1, 5, 5)); // 6 filas, 1 columna, con espacios entre componentes

        // Botones
        botonRegistrarUsuario = new JButton("Registrar Usuario");
        botonCrearCuenta = new JButton("Crear Cuenta");
        botonDepositar = new JButton("Depositar");
        botonRetirar = new JButton("Retirar");
        botonSalir = new JButton("Salir");

        // Área de mensajes
        areaMensajes = new JTextArea();
        areaMensajes.setEditable(false); // El usuario no puede editar el área de mensajes
        JScrollPane scrollPane = new JScrollPane(areaMensajes); // Agregar un scroll por si el texto es largo

        // Agregar componentes al panel
        panel.add(botonRegistrarUsuario);
        panel.add(botonCrearCuenta);
        panel.add(botonDepositar);
        panel.add(botonRetirar);
        panel.add(botonSalir);
        panel.add(scrollPane);

        add(panel);
    }

    // Métodos para agregar listeners a los botones
    public void agregarListenerRegistrarUsuario(ActionListener listener) {
        botonRegistrarUsuario.addActionListener(listener);
    }

    public void agregarListenerCrearCuenta(ActionListener listener) {
        botonCrearCuenta.addActionListener(listener);
    }

    public void agregarListenerDepositar(ActionListener listener) {
        botonDepositar.addActionListener(listener);
    }

    public void agregarListenerRetirar(ActionListener listener) {
        botonRetirar.addActionListener(listener);
    }

    public void agregarListenerSalir(ActionListener listener) {
        botonSalir.addActionListener(listener);
    }

    // Método para mostrar mensajes en el área de texto
    public void mostrarMensaje(String mensaje) {
        areaMensajes.append(mensaje + "\n"); // Agrega el mensaje al área de texto
    }
}