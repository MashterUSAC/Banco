package controlador;

import vista.VistaLogin;
import vista.VistaPrincipal;

import java.awt.event.ActionListener;

public class ControladorLogin {
    private VistaLogin vistaLogin;
    private VistaPrincipal vistaPrincipal;

    public ControladorLogin(VistaLogin vistaLogin, VistaPrincipal vistaPrincipal) {
        this.vistaLogin = vistaLogin;
        this.vistaPrincipal = vistaPrincipal;

        // Agregar el listener al botón de inicio de sesión
        this.vistaLogin.agregarListenerLogin(e -> validarCredenciales());
    }

    private void validarCredenciales() {
        String usuario = vistaLogin.getUsuario();
        String contrasena = vistaLogin.getContrasena();

        // Validar credenciales (usuario y contraseña son "a")
        if (usuario.equals("a") && contrasena.equals("a")) {
            vistaLogin.mostrarMensaje("Bienvenido");
            vistaLogin.setVisible(false); // Ocultar la ventana de login
            vistaPrincipal.setVisible(true); // Mostrar la ventana principal
        } else {
            vistaLogin.mostrarMensaje("Usuario o contraseña incorrectos");
        }
    }
}