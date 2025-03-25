package controlador;

import vista.VentanaDepositar;
import modelo.BancoDatos;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import utilidades.Bitacora;

public class ControladorDepositar implements ActionListener {
    private VentanaDepositar ventana;

    public ControladorDepositar() {
        this.ventana = new VentanaDepositar();
        this.ventana.agregarListener(this);
        this.ventana.setVisible(true);
        
        // Cargar cuentas disponibles al iniciar
        this.ventana.cargarCuentas(BancoDatos.getCuentasDisponibles());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String idCuenta = ventana.getIdCuentaSeleccionada();
            if(idCuenta == null || idCuenta.isEmpty()) {
                ventana.mostrarError("Debe seleccionar una cuenta válida");
                return;
            }

            double monto = ventana.getMonto();
            
            if(monto <= 0) {
                ventana.mostrarError("El monto debe ser mayor a cero");
                return;
            }
            
            if(BancoDatos.realizarDeposito(idCuenta, monto)) {
                ventana.mostrarMensaje(String.format(
                    "Depósito exitoso de Q%.2f a la cuenta %s", 
                    monto, idCuenta));
                ventana.cerrar();
                
                Bitacora.registrar(
                    "Depósito", 
                    "Éxito", 
                    String.format("Cuenta: %s - Monto: Q%.2f", idCuenta, monto)
                );
            } else {
                ventana.mostrarError("No se encontró la cuenta especificada");
            }
        } catch (NumberFormatException ex) {
            ventana.mostrarError("Monto inválido: debe ser un número");
        } catch (Exception ex) {
            ventana.mostrarError("Error inesperado: " + ex.getMessage());
            }
    }
}