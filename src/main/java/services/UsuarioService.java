package services;

import exceptions.DatosInvalidosException;
import exceptions.EmailDuplicadoException;
import exceptions.UsuarioNoEncontradoException;

import models.Administrador;
import models.Tester;
import models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    // Singleton (Aquí se guarda la única instancia de la clase.)
    private static UsuarioService instancia;

    private List<Usuario> usuarios;

    private UsuarioService() {

        usuarios = new ArrayList<>();

        usuarios.add(
                new Administrador(
                        "Diego",
                        "De la Barrera",
                        "diegodlba@admin.com",
                        "123456",
                        "Uruguay",
                        "SuperAdmin"
                )
        );

        usuarios.add(
                new Tester(
                        "Rodrigo",
                        "De la Barrera",
                        "rodrigo@tester.com",
                        "123456",
                        "Uruguay",
                        "testerManual"
                )
        );
    }


    public static UsuarioService getInstance() {

        if (instancia == null) {

            instancia = new UsuarioService();
        }

        return instancia;
    }


    public void addUsuario(Usuario usuario)
            throws EmailDuplicadoException {


        validarUsuario(usuario);


        if (existeEmail(usuario.getEmail())) {

            throw new EmailDuplicadoException(
                    "Ya existe un usuario con ese email."
            );
        }


        usuarios.add(usuario);
    }


    public Usuario login(String email, String password) {


        for (Usuario usuario : usuarios) {


            if (usuario.getEmail().equals(email)
                    && usuario.getPassword().equals(password)) {

                return usuario;
            }
        }


        return null;
    }


    public void listarUsuarios() {


        if (usuarios.isEmpty()) {

            System.out.println("No existen usuarios registrados.");

            return;
        }


        System.out.println("\n===== LISTADO DE USUARIOS =====");


        for (Usuario usuario : usuarios) {

            System.out.println("-------------------------");
            System.out.println(usuario);
        }
    }


    public Usuario buscarUsuario(String email)
            throws UsuarioNoEncontradoException {


        for (Usuario usuario : usuarios) {


            if (usuario.getEmail().equals(email)) {

                return usuario;
            }
        }


        throw new UsuarioNoEncontradoException(
                "No existe un usuario con ese email."
        );
    }


    public boolean existeEmail(String email) {


        for (Usuario usuario : usuarios) {


            if (usuario.getEmail().equals(email)) {

                return true;
            }
        }


        return false;
    }


    private void validarUsuario(Usuario usuario) {


        if (usuario.getNombre() == null ||
                usuario.getNombre().trim().isEmpty()) {

            throw new DatosInvalidosException(
                    "El nombre es obligatorio."
            );
        }


        if (usuario.getApellido() == null ||
                usuario.getApellido().trim().isEmpty()) {

            throw new DatosInvalidosException(
                    "El apellido es obligatorio."
            );
        }


        if (usuario.getPais() == null ||
                usuario.getPais().trim().isEmpty()) {

            throw new DatosInvalidosException(
                    "El país es obligatorio."
            );
        }


        if (usuario.getEmail() == null ||
                usuario.getEmail().trim().isEmpty()) {

            throw new DatosInvalidosException(
                    "El email es obligatorio."
            );
        }


        String regex =
                "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";


        if (!usuario.getEmail().matches(regex)) {

            throw new DatosInvalidosException(
                    "El formato del email es inválido."
            );
        }


        if (usuario.getPassword() == null ||
                usuario.getPassword().length() < 6) {

            throw new DatosInvalidosException(
                    "La contraseña debe tener mínimo 6 caracteres."
            );
        }

    }

    public void editarPerfil(Usuario usuario,
                             String nombre,
                             String apellido,
                             String pais,
                             String password) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new DatosInvalidosException("El nombre es obligatorio.");
        }

        if (apellido == null || apellido.trim().isEmpty()) {
            throw new DatosInvalidosException("El apellido es obligatorio.");
        }

        if (pais == null || pais.trim().isEmpty()) {
            throw new DatosInvalidosException("El país es obligatorio.");
        }

        if (password == null || password.length() < 6) {
            throw new DatosInvalidosException(
                    "La contraseña debe tener mínimo 6 caracteres."
            );
        }

        usuario.setNombre(nombre);
        usuario.setApellido(apellido);
        usuario.setPais(pais);
        usuario.setPassword(password);
    }

}