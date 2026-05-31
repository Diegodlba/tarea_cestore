import models.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static String nombre;
    public static String apellido;
    public static String email;
    public static String password;
    public static String pais;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean salir = false;

        while (!salir) {
            System.out.println("Seleccione una acción: ");
            System.out.println("1 - Registro");
            System.out.println("2 - Login");
            System.out.println("0 - Salir");
            System.out.println("Digita el número de la opción:\n");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                registrarUsuario();
            } else if (opcion == 2) {
                login();
                salir = true;
            } else if (opcion == 0) {
                salir = true;
                System.out.println("Saliste con éxito");
            } else System.out.println("Selecciona una opción valida\n");
        }
    }

    // REGISTRO DE USUARIO
    public static void registrarUsuario() {
        System.out.println("\n=== REGISTRO ===\n");
        System.out.print("Nombre: ");
        nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        apellido = scanner.nextLine();

        if (nombre.matches(".*\\d.*") || apellido.matches(".*\\d.*")) {
            System.out.println("el nombre y o el apellido no pueden contener números, ingreselos nuevamente");
            System.out.print("Nombre: ");
            nombre = scanner.nextLine();

            System.out.print("Apellido: ");
            apellido = scanner.nextLine();
        }

        System.out.print("Email: ");
        email = scanner.nextLine();
        while (!email.contains("@")) {
            System.out.println("Email inválido. Debe contener @");
            System.out.print("Email: ");
            email = scanner.nextLine();
        }

        System.out.print("Contraseña: ");
        password = scanner.nextLine();

        System.out.print("País:");
        pais = scanner.nextLine();

        System.out.println("Usuario registrado correctamente\n");
    }

    //LOGIN
    public static void login() {
        System.out.print("Email: ");
        String emailLoguin = scanner.nextLine();

        System.out.print("Password: ");
        String passwordLoguin = scanner.nextLine();

        if ((emailLoguin.equals(email) && passwordLoguin.equals(password))
                || (emailLoguin.equals("diegodlba@ces.com") && passwordLoguin.equals("1234"))) {
            System.out.println("Bienvenido, ingresaste al sistema con éxito\n");
        } else System.out.println("Email o contraseña incorrecta");

    }

}


   /* static ArrayList<Usuario> usuarios = new ArrayList<>();

    public static void main(String[] args) {

        boolean salir = false;

        while (!salir) {

            System.out.println("Seleccione una acción: ");
            System.out.println("1 - Registro");
            System.out.println("2 - Login");
            System.out.println("3 - Ver usuarios");
            System.out.println("0 - Salir");
            System.out.println("Digita el número de la opción:");


            int opcion = scanner.nextInt();
            scanner.nextLine();

//            switch (opcion) {
//
//                case 1:
//                    registrarUsuario();
//                    break;
//
//                case 2:
//                    login();
//                    break;
//
//                case 3:
//                    mostrarUsuarios();
//                    break;
//
//                case 0:
//                    salir = true;
//                    System.out.println("Saliste con éxito");
//                    break;
//
//                default:
//                    System.out.println("Selecciona una opción valida");
//            }

            if (opcion == 1) {
                registrarUsuario();
                //salir = true;
            } else if (opcion == 2) {
                login();
                salir = true;
            } else if (opcion == 3) {
                mostrarUsuarios();
                salir = true;
            } else if (opcion == 0) {
                salir = true;
                System.out.println("Saliste con éxito");
            } else System.out.println("Selecciona una opción valida");
        }
    }

    // REGISTRO DE USUARIO
    public static void registrarUsuario() {

        System.out.println("\n=== REGISTRO ===");

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Email: ");
        String email = scanner.nextLine();

        // VALIDAR USUARIO EXISTENTE
        if (usuarioExiste(email)) {
            System.out.println("Ya existe un usuario con ese email");
            return;
        }

        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        System.out.print("País: ");
        String pais = scanner.nextLine();

        Usuario nuevoUsuario = new Usuario(
                nombre,
                apellido,
                email,
                password,
                pais
        );

        usuarios.add(nuevoUsuario);

        System.out.println("Usuario registrado correctamente");
    }

    // LOGIN
    public static void login() {

        System.out.println("\n=== LOGIN ===");

        System.out.print("Email: ");
        String email = scanner.nextLine();

        System.out.print("Contraseña: ");
        String password = scanner.nextLine();

        boolean loginCorrecto = false;

        for (int i = 0; i < usuarios.size(); i++) {

            // VALIDAR CREDENCIALES
            if (usuarios.get(i).getEmail().equals(email)
                    && usuarios.get(i).getPassword().equals(password)) {

                loginCorrecto = true;

                System.out.println("Bienvenido " + usuarios.get(i).getNombre());
            }
        }

        to) {
            System.out.println("Credenciales incorrectas");
        }
    }

    // VALIDAR USUARIO EXISTENTE
    public static boolean usuarioExiste(String email) {

        for (int i = 0; i < usuarios.size(); i++) {

            if (usuarios.get(i).getEmail().equals(email)) {

                return true;
            }
        }
        return false;
    }

    // MOSTRAR TODOS LOS USUARIOS
    public static void mostrarUsuarios() {

        System.out.println("\n=== LISTA DE USUARIOS ===");

        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios registrados");
            return;
        }

        for (int i = 0; i < usuarios.size(); i++) {

            System.out.println("-------------------");
            System.out.println("Nombre: " + usuarios.get(i).getNombre());
            System.out.println("Apellido: " + usuarios.get(i).getApellido());
            System.out.println("Email: " + usuarios.get(i).getEmail());
            System.out.println("País: " + usuarios.get(i).getPais());
        }
    } */

