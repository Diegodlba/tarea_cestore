import models.Administrador;
import models.Tester;
import models.Usuario;
import services.UsuarioService;

import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static UsuarioService usuarioService = new UsuarioService();

    public static void main(String[] args) {

        boolean salir = false;

        while (!salir) {

            System.out.println("\nSeleccione una acción:");
            System.out.println("1 - Registro");
            System.out.println("2 - Login");
            System.out.println("3 - Listar usuarios");
            System.out.println("4 - Buscar usuario");
            System.out.println("0 - Salir");
            System.out.print("Digita el número de la opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {

                registrarUsuario();

            } else if (opcion == 2) {

                login();

            } else if (opcion == 3) {

                usuarioService.listarUsuarios();

            } else if (opcion == 4) {

                buscarUsuario();

            } else if (opcion == 0) {

                salir = true;
                System.out.println("Saliste con éxito");

            } else {

                System.out.println("Selecciona una opción válida");
            }
        }
    }

    public static void registrarUsuario() {

        System.out.println("\n=== REGISTRO ===");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        if (usuarioService.validateExistingUser(email)) {

            System.out.println("Ya existe un usuario con ese email");
            return;
        }

        System.out.print("Password: ");
        String password = scanner.nextLine();

        System.out.print("País: ");
        String pais = scanner.nextLine();

        System.out.println("\nTipo de usuario:");
        System.out.println("1 - Administrador");
        System.out.println("2 - Tester");
        System.out.print("Seleccione una opción: ");

        int tipoUsuario = scanner.nextInt();
        scanner.nextLine();

        Usuario usuario;

        if (tipoUsuario == 1) {

            System.out.print("Nivel de administrador: ");
            String nivelAdmin = scanner.nextLine();

            usuario = new Administrador(
                    nombre,
                    apellido,
                    email,
                    password,
                    pais,
                    nivelAdmin
            );

        } else if (tipoUsuario == 2) {

            System.out.print("Tipo de tester: ");
            String tipoTester = scanner.nextLine();

            usuario = new Tester(
                    nombre,
                    apellido,
                    email,
                    password,
                    pais,
                    tipoTester
            );

        } else {

            System.out.println("Tipo de usuario inválido");
            return;
        }

        usuarioService.addUsuario(usuario);

        System.out.println("Usuario registrado correctamente");
    }

    public static void login() {

        System.out.println("\n=== LOGIN ===");

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        Usuario usuario = usuarioService.login(email, password);

        if (usuario != null) {

            System.out.println("\nBienvenido " + usuario.getNombre());

            System.out.println("Tipo: " + usuario.mostrarTipo());

        } else {

            System.out.println("Email o contraseña incorrectos");
        }
    }

    public static void buscarUsuario() {

        System.out.println("\n=== BUSCAR USUARIO ===");

        System.out.print("Ingrese email: ");
        String email = scanner.nextLine();

        Usuario usuario = usuarioService.buscarUsuario(email);

        if (usuario != null) {

            System.out.println("\nUsuario encontrado:");
            System.out.println(usuario);

        } else {

            System.out.println("Usuario no encontrado");
        }
    }
}