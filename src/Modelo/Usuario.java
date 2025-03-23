package modelo;

public class Usuario {
    private String cui;
    private String nombre;
    private String apellido;

    public Usuario(String cui, String nombre, String apellido) {
        this.cui = cui;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters y Setters
    public String getCui() { return cui; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }
}