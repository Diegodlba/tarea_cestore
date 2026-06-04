package models;

public class Tester extends Usuario{
    private String rol;

    public Tester(String rol) {
        this.rol = rol;
    }

    public Tester(String nombre, String apellido, String email, String password, String pais, String rol) {
        super(nombre, apellido, email, password, pais);
        this.rol = rol;
    }
}
