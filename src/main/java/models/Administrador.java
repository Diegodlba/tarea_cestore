package models;

public class Administrador extends Usuario {

    private String nivel;


    public Administrador(String nombre,
                         String apellido,
                         String email,
                         String password,
                         String pais,
                         String nivel) {

        super(nombre, apellido, email, password, pais);

        this.nivel = nivel;
    }


    @Override
    public String mostrarTipo() {

        return "Administrador - " + nivel;
    }

    @Override
    public boolean puedeGestionarUsuarios() {

        return true;
    }

    public String getNivel() {

        return nivel;
    }
}