package vista;

import javax.swing.*;
import java.awt.*;

public class VentanaDatosEstudiante extends JDialog {
    public VentanaDatosEstudiante() {
        setTitle("Datos del Estudiante");
        setSize(300, 200);
        setLocationRelativeTo(null);
        setModal(true);

        JPanel panel = new JPanel(new GridLayout(4, 1, 5, 5));

        panel.add(new JLabel("Nombre: Saul Orozco"));
        panel.add(new JLabel("Carnet: 202405397"));
        panel.add(new JLabel("Curso: Introducción a la Programación y Computación 1"));
        panel.add(new JLabel("Sección: F"));

        add(panel);
    }
}