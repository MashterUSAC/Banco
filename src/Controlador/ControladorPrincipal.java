package controlador;

import vista.VistaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrincipal {
    private VistaPrincipal vistaPrincipal;

    public ControladorPrincipal(VistaPrincipal vistaPrincipal) {
        this.vistaPrincipal = vistaPrincipal;

        // Asignar listeners a los botones
        this.vistaPrincipal.agregarListenerRegistrarUsuario(e -> abrirVentanaRegistrarUsuario());
        this.vistaPrincipal.agregarListenerCrearCuenta(e -> abrirVentanaCrearCuenta());
        this.vistaPrincipal.agregarListenerDepositar(e -> abrirVentanaDepositar());
        this.vistaPrincipal.agregarListenerRetirar(e -> abrirVentanaRetirar());
        this.vistaPrincipal.agregarListenerBuscarCuentas(e -> abrirVentanaBuscarCuentas());
        this.vistaPrincipal.agregarListenerHistorialTransacciones(e -> abrirVentanaHistorialTransacciones());
        this.vistaPrincipal.agregarListenerDatosEstudiante(e -> mostrarDatosEstudiante());
        this.vistaPrincipal.agregarListenerSalir(e -> System.exit(0));
    }

    private void abrirVentanaRegistrarUsuario() {
        new ControladorRegistrarUsuario(); // Abre la ventana de registrar usuario
    }

    private void abrirVentanaCrearCuenta() {
        new ControladorCrearCuenta(); // Abre la ventana de crear cuenta
    }

    private void abrirVentanaDepositar() {
        new ControladorDepositar(); // Abre la ventana de depositar
    }

    private void abrirVentanaRetirar() {
        new ControladorRetirar(); // Abre la ventana de retirar
    }

    private void abrirVentanaBuscarCuentas() {
        new ControladorBuscarCuentas(); // Abre la ventana de buscar cuentas
    }

    private void abrirVentanaHistorialTransacciones() {
        new ControladorHistorialTransacciones(); // Abre la ventana de historial de transacciones
    }

    private void mostrarDatosEstudiante() {
        String datos = "Nombre: Tu Nombre\nCarnet: 202300000\nCurso: IPC1\nSección: A";
        vistaPrincipal.mostrarMensaje(datos); // Muestra los datos del estudiante en el área de mensajes
    }
}