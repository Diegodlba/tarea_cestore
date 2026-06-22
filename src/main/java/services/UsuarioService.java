package services;

import models.*;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    private List<Usuario> usuarios;

    public UsuarioService() {

        usuarios = new ArrayList<>();

        usuarios.add(
                new Administrador(
                        "Diego",
                        "De la Barrera",
                        "diegodlba@admin.com",
                        "1234",
                        "Uruguay",
                        "superAdmin"
                )
        );

        usuarios.add(
                new Tester(
                        "Rodrigo",
                        "De la Barrera",
                        "rodrigo@tester.com",
                        "1234",
                        "Uruguay",
                        "testerManual"
                )
        );
    }

    public void addUsuario(Usuario usuario) {
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

    public boolean validateExistingUser(String email) {

        for (Usuario usuario : usuarios) {

            if (usuario.getEmail().equals(email)) {
                return true;
            }
        }

        return false;
    }

    public void listarUsuarios() {

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios");
            return;
        }

        for (Usuario usuario : usuarios) {

            System.out.println("----------------");
            System.out.println(usuario);
        }
    }

    public Usuario buscarUsuario(String email) {

        for (Usuario usuario : usuarios) {

            if (usuario.getEmail().equals(email)) {
                return usuario;
            }
        }

        return null;
    }

}