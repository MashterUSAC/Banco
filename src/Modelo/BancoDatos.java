package modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class BancoDatos {
    private static List<Usuario> usuarios = new ArrayList<>();
    private static List<Cuenta> cuentas = new ArrayList<>();
    private static int contadorCuentas = 1; // Contador para generar IDs secuenciales

    public static boolean existeCliente(String cui) {
        return usuarios.stream().anyMatch(u -> u.getCui().equals(cui));
    }

    public static void registrarCliente(String cui, String nombre, String apellido) {
        usuarios.add(new Usuario(cui, nombre, apellido));
    }

    public static void crearCuenta(String cuiCliente, String idCuenta) {
        // Validar que el CUI del cliente exista
        Usuario cliente = usuarios.stream()
            .filter(u -> u.getCui().equals(cuiCliente))
            .findFirst()
            .orElse(null);

        if (cliente == null) {
            throw new RuntimeException("El cliente con CUI " + cuiCliente + " no está registrado.");
        }

        // Validar que el ID de la cuenta no esté duplicado
        boolean cuentaExistente = cuentas.stream()
            .anyMatch(c -> c.getIdCuenta().equals(idCuenta));

        if (cuentaExistente) {
            throw new RuntimeException("El ID de la cuenta " + idCuenta + " ya está en uso.");
        }

        // Crear la cuenta y asociarla al cliente
        cuentas.add(new Cuenta(idCuenta, cliente));
    }

        // En BancoDatos.java
    public static boolean realizarDeposito(String idCuenta, double monto) {
        try {
            Cuenta cuenta = cuentas.stream()
                .filter(c -> c.getIdCuenta().equals(idCuenta))
                .findFirst()
                .orElse(null);
            if(cuenta != null) {
                cuenta.depositar(monto);
                return true;
             }             return false;
        } catch(Exception e) {
            System.err.println("Error en depósito: " + e.getMessage());
            return false;
        }
    }

    public static void realizarRetiro(String idCuenta, double monto) {
        Cuenta cuenta = cuentas.stream()
            .filter(c -> c.getIdCuenta().equals(idCuenta))
            .findFirst()
            .orElse(null);

        if (cuenta != null) {
            if (cuenta.getSaldo() >= monto) {
                cuenta.retirar(monto);
            } else {
                throw new RuntimeException("Saldo insuficiente.");
            }
        } else {
            throw new RuntimeException("La cuenta no existe.");
        }
    }

    public static List<Usuario> getUsuarios() {
        return usuarios;
    }

    public static List<Cuenta> getCuentas() {
        return cuentas;
    }

    public static List<Cuenta> buscarCuentasPorCliente(String cuiCliente) {
        return cuentas.stream()
            .filter(c -> c.getCliente().getCui().equals(cuiCliente))
            .toList();
    }
    public static List<String> getCuentasDisponibles() {
        return cuentas.stream()
                     .map(cuenta -> cuenta.getIdCuenta() + " - " + cuenta.getCliente().getNombre())
                     .collect(Collectors.toList());
    }
      // Método auxiliar para obtener cuenta por ID
    public static Cuenta getCuentaPorId(String idCuenta) {
        return cuentas.stream()
                    .filter(c -> c.getIdCuenta().equals(idCuenta))
                    .findFirst()
                    .orElse(null);
    }
}