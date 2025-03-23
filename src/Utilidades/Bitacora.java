package utilidades;

import java.time.LocalDateTime;

public class Bitacora {
    public static void registrarEvento(String usuario, String accion, String resultado, String detalles) {
        String evento = String.format("[%s] Usuario: %s - Acción: %s - Resultado: %s - Detalles: %s",
                LocalDateTime.now(), usuario, accion, resultado, detalles);
        System.out.println(evento);
    }
}