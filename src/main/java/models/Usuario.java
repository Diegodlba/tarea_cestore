package models;

public abstract class Usuario {

    private String nombre;
    private String apellido;
    private String email;
    private String password;
    private String pais;


    public Usuario(String nombre,
                   String apellido,
                   String email,
                   String password,
                   String pais) {

        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.password = password;
        this.pais = pais;
    }


    public abstract String mostrarTipo();


    public boolean puedeGestionarUsuarios() {

        return false;
    }


    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public String getEmail() {
        return email;
    }


    public String getPassword() {
        return password;
    }


    public String getPais() {
        return pais;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Override
    public String toString() {

        return "Nombre: " + nombre +
                " " + apellido +
                "\nEmail: " + email +
                "\nPaís: " + pais +
                "\nTipo: " + mostrarTipo();
    }
}