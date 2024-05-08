package edu.gorillas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Consultas {
    static Scanner sc = new Scanner(System.in);
    static ResultSet res = null;
    public static void consultarEmpleadosPorDepartamento(Statement sentencia) {
        System.out.println("Introduce el nombre del departamento");
        String Dnombre = sc.nextLine();
        try {
           res= sentencia.executeQuery("select * from empleados where Nu_Dept=(select Nu_Dept from departamentos where Dnombre='" + Dnombre + "');");
            while (res.next()) {
                System.out.println("Empleado: ");
                System.out.println("Dni: " + res.getString("dni"));
                System.out.println("Nombre: " + res.getString("nombre"));
                System.out.println("Estudios: " + res.getString("estudios"));
                System.out.println("Dir: " + res.getString("dir"));
                System.out.println("Fecha de alta: " + res.getDate("fecha_alt"));
                System.out.println("Salario: " + res.getInt("salario"));
                System.out.println("Comision: " + res.getInt("comision"));
                System.out.println("Nu_Dept: " + res.getInt("Nu_Dept"));
                System.out.println("-------------------------");
            }
        } catch (SQLException e) {
        }
    }
    public static void consultarDepartamentoPorDNI(Statement sentencia) {
        System.out.println("Introduce el DNI del empleado");
        String dni = sc.nextLine();
        try {
            res= sentencia.executeQuery("select * from departamentos where Nu_Dept=(select Nu_Dept from empleados where dni='" + dni + "');");
            if (res.next()) {
                System.out.println("El empleado con el DNI: " + dni + " pertenece al departamento: ");
                System.out.println("Nombre departamento: " + res.getString("Dnombre"));
                System.out.println("Localidad: " + res.getString("localidad"));
            }
        } catch (SQLException e) {
        }
    }
}