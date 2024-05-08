package edu.gorillas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Borrados {
    static Scanner sc = new Scanner(System.in);
    static ResultSet res = null;
    public static void borrarDep(Statement sentencia) {
        System.out.println("Introduce el nombre del departamento");
        String nombre = sc.nextLine();
        try {
            sentencia.executeUpdate("delete from departamentos where Dnombre='" + nombre + "';");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public static void borrarEmp(Statement sentencia) {
        System.out.println("Introduce el nombre del empleado");
        String nombre = sc.nextLine();

        try {
            sentencia.executeUpdate("delete from empleados where nombre='" + nombre + "';");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
}
