package edu.gorillas;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Statement sentencia = null;
        Connection conexion = null;

        //Variable opción (op) inicializada a 0

        try {
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String url = "jdbc:mariadb://localhost:3306/?user=root&password=";
        try {
            conexion = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println("No hay ningún driver que reconozca la URL especificada");
        } catch (Exception e) {
            System.out.println("Se ha producido algún otro error");
        }

        try {
            sentencia = conexion.createStatement();
        } catch (SQLException e) {
            System.out.println("Error");
        }

        CreacionBD.crearBD(sentencia);

        int  op = 0;
        int op2 = 0;
        do {
            System.out.println("MENU PRINCIPAL");
            System.out.println("1. Insertar datos");
            System.out.println("2. Borrar datos");
            System.out.println("3. Consultar datos");
            System.out.println("4. Modificar datos");
            System.out.println("5. Salir");

            op = sc.nextInt();
            sc.nextLine();
            switch (op) {
                case 1:
                    do {
                        System.out.println("MENU INSERCIONES");
                        System.out.println("1. Insercion de nuevo departamento");
                        System.out.println("2. Insercion de nuevo empleado");
                        op2 = sc.nextInt();
                        sc.nextLine();
                        switch (op2) {
                            case 1:Inserciones.insertarDep(sentencia);
                                break;
                            case 2:Inserciones.insertarEmp(sentencia);
                                break;
                            default:
                                break;
                        }

                    } while (op2 != 2);
                    break;

                case 2:
                    do {
                        System.out.println("MENU BORRADO");
                        System.out.println("1. Borrar departamento ");
                        System.out.println("2. Borrar empleado");
                        op2 = sc.nextInt();
                        sc.nextLine();
                        switch (op2) {
                            case 1:Borrados.borrarDep(sentencia);
                                break;
                            case 2:Borrados.borrarEmp(sentencia);
                                break;
                            default:
                                break;
                        }

                    } while (op2 != 2);
                    break;
                case 3:
                    do {
                        System.out.println("MENU CONSULTAS");
                        System.out.println("1.Mostrar empleados por departamento ");
                        System.out.println("2.Mostrar departamento por dni empleado");
                        op2 = sc.nextInt();
                        sc.nextLine();
                        switch (op2) {
                            case 1:Consultas.consultarEmpleadosPorDepartamento(sentencia);
                                break;
                            case 2:Consultas.consultarDepartamentoPorDNI(sentencia);
                                break;
                            default:
                                break;
                        }

                    } while (op2 != 2);
                    break;
                case 4:do {
                    System.out.println("MENU MODIFICACIONES");
                    System.out.println("1.Modificar salario o comisión por dni");
                    System.out.println("2.Modificar localidad por departamento");
                    op2 = sc.nextInt();
                    sc.nextLine();
                    switch (op2) {
                        case 1:Modificaciones.modificarSalarioComisionPorDNI(sentencia);
                            break;
                        case 2:Modificaciones.modificarLocalidadPorDepartamento(sentencia);
                            break;
                        default:
                            break;
                    }

                } while (op2 != 2);
                    break;
                case 5:
                    System.out.println("Adios");
                    break;
            }
        } while (op != 5);
    }
}