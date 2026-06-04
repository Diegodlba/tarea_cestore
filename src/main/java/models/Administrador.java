package models;

public class Administrador extends Usuario{
    private String type;

    public Administrador(String type) {
        this.type = type;
    }

    public Administrador(String nombre, String apellido, String email, String password, String pais, String type) {
        super(nombre, apellido, email, password, pais);
        this.type = type;
    }
}
