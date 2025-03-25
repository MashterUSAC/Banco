package controlador;

import vista.VentanaRetirar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelo.BancoDatos;
import modelo.Cuenta;

public class ControladorRetirar implements ActionListener {
    private VentanaRetirar ventanaRetirar;

    public ControladorRetirar() {
        ventanaRetirar = new VentanaRetirar();
        ventanaRetirar.agregarListener(this);
        ventanaRetirar.setVisible(true); // Mostrar la ventana emergente
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String idCuenta = ventanaRetirar.getIdCuenta();
            double monto = ventanaRetirar.getMonto();

            // Validar que el monto sea positivo
            if (monto <= 0) {
                ventanaRetirar.mostrarMensaje("El monto debe ser mayor a 0.");
                return;
            }

            // Validar que la cuenta tenga saldo suficiente
            Cuenta cuenta = BancoDatos.getCuentas().stream()
                .filter(c -> c.getIdCuenta().equals(idCuenta))
                .findFirst()
                .orElse(null);

            if (cuenta != null) {
                if (cuenta.getSaldo() < monto) {
                    ventanaRetirar.mostrarMensaje("Saldo insuficiente.");
                    return;
                }
            } else {
                ventanaRetirar.mostrarMensaje("La cuenta no existe.");
                return;
            }

            // Realizar el retiro
            BancoDatos.realizarRetiro(idCuenta, monto);
            ventanaRetirar.mostrarMensaje("Retiro realizado exitosamente.");
            ventanaRetirar.cerrar();
        } catch (NumberFormatException ex) {
            ventanaRetirar.mostrarMensaje("El monto debe ser un número válido.");
        } catch (Exception ex) {
            ventanaRetirar.mostrarMensaje("Ocurrió un error: " + ex.getMessage());
        }
    }
}