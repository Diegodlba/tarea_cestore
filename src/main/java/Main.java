import exceptions.DatosInvalidosException;
import exceptions.EmailDuplicadoException;
import exceptions.UsuarioNoEncontradoException;

import models.Administrador;
import models.Tester;
import models.Usuario;

import services.UsuarioService;

import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {


    static Scanner scanner = new Scanner(System.in);

    static UsuarioService usuarioService =
            UsuarioService.getInstance();


    static Usuario usuarioLogueado = null;


    public static void main(String[] args) {

        boolean salir = false;

        while (!salir) {

            try {

                System.out.println("\nSeleccione una acción:");

                if (usuarioLogueado == null) {

                    System.out.println("1 - Login");
                    System.out.println("2 - Registrar Administrador");
                    System.out.println("0 - Salir");

                } else if (usuarioLogueado.puedeGestionarUsuarios()) {

                    System.out.println("3 - Registrar Tester");
                    System.out.println("4 - Listar usuarios");
                    System.out.println("5 - Buscar usuario");
                    System.out.println("6 - Editar perfil");
                    System.out.println("7 - Cerrar sesión");
                    System.out.println("0 - Salir");

                } else {

                    System.out.println("6 - Editar perfil");
                    System.out.println("7 - Cerrar sesión");
                    System.out.println("0 - Salir");
                }

                System.out.print("Digita el número de la opción: ");

                int opcion = scanner.nextInt();
                scanner.nextLine();


                //Sin usuario logueado
                if (usuarioLogueado == null) {

                    if (opcion == 1) {

                        login();

                    } else if (opcion == 2) {

                        registrarAdministrador();

                    } else if (opcion == 0) {

                        salir = true;

                        System.out.println("Saliste con éxito.");

                    } else {

                        System.out.println(
                                "Debe iniciar sesión para acceder a esa opción."
                        );
                    }

                    //Cuando está logueado un administrador.
                } else if (usuarioLogueado.puedeGestionarUsuarios()) {

                    if (opcion == 3) {

                        registrarTester();

                    } else if (opcion == 4) {

                        usuarioService.listarUsuarios();

                    } else if (opcion == 5) {

                        buscarUsuario();

                    } else if (opcion == 6) {

                        editarPerfil();

                    } else if (opcion == 7) {

                        cerrarSesion();

                    } else if (opcion == 0) {

                        salir = true;

                        System.out.println("Saliste con éxito.");

                    } else {

                        System.out.println(
                                "Seleccione una opción válida."
                        );
                    }


                    //Cuando está logueado un tester
                } else {

                    if (opcion == 6) {

                        editarPerfil();

                    } else if (opcion == 7) {

                        cerrarSesion();

                    } else if (opcion == 0) {

                        salir = true;

                        System.out.println("Saliste con éxito.");

                    } else {

                        System.out.println(
                                "No tiene permisos para realizar esa acción."
                        );
                    }

                }

            } catch (InputMismatchException e) {

                System.out.println("Debe ingresar un número.");

                scanner.nextLine();

            } catch (EmailDuplicadoException |
                     UsuarioNoEncontradoException |
                     DatosInvalidosException e) {

                System.out.println("Error: " + e.getMessage());

            } catch (Exception e) {

                System.out.println(
                        "Error inesperado: " + e.getMessage()
                );
            }
        }
    }


    public static void registrarAdministrador()
            throws EmailDuplicadoException {


        System.out.println(
                "\n=== REGISTRAR ADMINISTRADOR ==="
        );


        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();


        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();


        String email;

        do {

            System.out.print("Email: ");

            email = scanner.nextLine();


            if (usuarioService.existeEmail(email)) {

                System.out.println(
                        "Ya existe un usuario con ese email. Ingrese otro."
                );
            }


        } while (usuarioService.existeEmail(email));


        System.out.print("Password: ");
        String password = scanner.nextLine();


        System.out.print("País: ");
        String pais = scanner.nextLine();


        System.out.print("Nivel administrador: ");
        String nivel = scanner.nextLine();


        Administrador administrador =
                new Administrador(
                        nombre,
                        apellido,
                        email,
                        password,
                        pais,
                        nivel
                );


        usuarioService.addUsuario(administrador);


        System.out.println(
                "Administrador registrado correctamente."
        );
    }


    public static void registrarTester()
            throws EmailDuplicadoException {


        if (!puedeGestionarUsuarios()) {

            return;
        }


        System.out.println(
                "\n=== REGISTRAR TESTER ==="
        );


        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();


        System.out.print("Apellido: ");
        String apellido = scanner.nextLine();


        String email;


        do {

            System.out.print("Email: ");

            email = scanner.nextLine();


            if (usuarioService.existeEmail(email)) {


                System.out.println(
                        "Ya existe un usuario con ese email. Ingrese otro."
                );
            }


        } while (usuarioService.existeEmail(email));


        System.out.print("Password: ");
        String password = scanner.nextLine();


        System.out.print("País: ");
        String pais = scanner.nextLine();


        System.out.print("Rol tester: ");
        String rol = scanner.nextLine();


        Tester tester =
                new Tester(
                        nombre,
                        apellido,
                        email,
                        password,
                        pais,
                        rol
                );


        usuarioService.addUsuario(tester);


        System.out.println(
                "Tester registrado correctamente."
        );

    }


    public static void login() {


        System.out.println("\n=== LOGIN ===");


        System.out.print("Email: ");
        String email = scanner.nextLine();


        System.out.print("Password: ");
        String password = scanner.nextLine();


        Usuario usuario =
                usuarioService.login(email, password);


        if (usuario != null) {


            usuarioLogueado = usuario;


            System.out.println(
                    "\nBienvenido "
                            + usuario.getNombre()
            );


            System.out.println(
                    "Tipo: "
                            + usuario.mostrarTipo()
            );


        } else {


            System.out.println(
                    "Email o contraseña incorrectos."
            );
        }

    }


    public static void buscarUsuario()
            throws UsuarioNoEncontradoException {


        System.out.println(
                "\n=== BUSCAR USUARIO ==="
        );


        System.out.print(
                "Ingrese email: "
        );


        String email = scanner.nextLine();


        Usuario usuario =
                usuarioService.buscarUsuario(email);


        System.out.println(
                "\nUsuario encontrado:"
        );


        System.out.println(usuario);

    }


    public static void cerrarSesion() {


        if (usuarioLogueado == null) {


            System.out.println(
                    "No hay sesión iniciada."
            );


            return;
        }


        usuarioLogueado = null;


        System.out.println(
                "Sesión cerrada correctamente."
        );

    }


    public static boolean puedeGestionarUsuarios() {


        if (usuarioLogueado == null) {


            System.out.println(
                    "Debe iniciar sesión."
            );


            return false;
        }


        if (!usuarioLogueado.puedeGestionarUsuarios()) {


            System.out.println(
                    "No tiene permisos para realizar esta acción."
            );


            return false;
        }


        return true;
    }

    public static void editarPerfil() {

        System.out.println("\n=== EDITAR PERFIL ===");

        System.out.print("Nuevo nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Nuevo apellido: ");
        String apellido = scanner.nextLine();

        System.out.print("Nuevo país: ");
        String pais = scanner.nextLine();

        System.out.print("Nueva contraseña: ");
        String password = scanner.nextLine();

        usuarioService.editarPerfil(
                usuarioLogueado,
                nombre,
                apellido,
                pais,
                password
        );

        System.out.println("Perfil actualizado correctamente.");
    }

}