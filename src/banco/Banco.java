import vista.VistaLogin;
import vista.VistaPrincipal;
import controlador.ControladorLogin;
import controlador.ControladorPrincipal;

public class Banco {
    public static void main(String[] args) {
        // Crear las vistas
        VistaLogin vistaLogin = new VistaLogin();
        VistaPrincipal vistaPrincipal = new VistaPrincipal();

        // Crear los controladores
        ControladorLogin controladorLogin = new ControladorLogin(vistaLogin, vistaPrincipal);
        ControladorPrincipal controladorPrincipal = new ControladorPrincipal(vistaPrincipal);

        // Mostrar la ventana de inicio de sesión
        vistaLogin.setVisible(true);
    }
}