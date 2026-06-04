package services;

import models.Administrador;
import models.Tester;
import models.Usuario;

public class UsuarioService {
    private Usuario[] usuarios;

    public UsuarioService() {

        usuarios = new Usuario[10];

        usuarios[0] = new Administrador(
                "Diego",
                "De la Barrera",
                "diegodlba@admin.com",
                "1234",
                "Uruguay",
                "superAdmin"
                );

        usuarios[1] = new Tester(
                "Rodrigo",
                "de la Barrera",
                "rodrigo@tester.com",
                "1234",
                "Uruguay",
                "testerManual"
        );

    }

    public void addUsuario(Usuario usuario) {

        for (int i = 0; i < usuarios.length; i++) {

            if (usuarios[i] == null) {

                usuarios[i] = usuario;
                return;
            }
        }

        System.out.println("No hay espacio para más usuarios");
    }

    public Usuario login(String email, String password) {

        for (Usuario usuario : usuarios) {

            if (usuario != null &&
                    usuario.getEmail().equals(email) &&
                    usuario.getPassword().equals(password)) {

                return usuario;
            }
        }

        return null;
    }

    public boolean validateExistingUser(String email) {

        for (Usuario usuario : usuarios) {

            if (usuario != null &&
                    usuario.getEmail().equals(email)) {

                return true;
            }
        }

        return false;
    }

}
