package controlador;

import vista.VentanaDepositar;
import modelo.BancoDatos;
import modelo.Cuenta;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import utilidades.Bitacora;

public class ControladorDepositar implements ActionListener {
    private VentanaDepositar ventana;

    public ControladorDepositar() {
        this.ventana = new VentanaDepositar();
        this.ventana.agregarListener(this);
        
        // Cargar cuentas disponibles al iniciar
        List<Cuenta> cuentas = BancoDatos.getCuentas();
        this.ventana.cargarCuentas(cuentas);
        
        this.ventana.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String seleccionCompleta = ventana.getIdCuentaSeleccionada();
            
            if(seleccionCompleta == null || seleccionCompleta.equals("No hay cuentas disponibles")) {
                ventana.mostrarError("No hay cuentas disponibles para depositar");
                return;
            }
            
            // Extraer ID de la cuenta
            String idCuenta = seleccionCompleta.split(" - ")[0].trim();
            double monto = ventana.getMonto();
            
            if(monto <= 0) {
                ventana.mostrarError("El monto debe ser mayor a cero");
                return;
            }
            
            if(BancoDatos.realizarDeposito(idCuenta, monto)) {
                ventana.mostrarMensaje(String.format(
                    "Depósito exitoso de Q%.2f a la cuenta %s", 
                    monto, idCuenta));
                
                // Actualizar lista de cuentas del depósito
                ventana.cargarCuentas(BancoDatos.getCuentas());
                
                Bitacora.registrar(
                    "Depósito", 
                    "Éxito", 
                    String.format("Cuenta: %s - Monto: Q%.2f", idCuenta, monto)
                );
            } else {
                ventana.mostrarError("No se pudo completar el depósito");
            }
        } catch (NumberFormatException ex) {
            ventana.mostrarError("Monto inválido: " + ex.getMessage());
        } catch (ArrayIndexOutOfBoundsException ex) {
            ventana.mostrarError("Formato de cuenta inválido");
        } catch (Exception ex) {
            ventana.mostrarError("Error inesperado: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
}