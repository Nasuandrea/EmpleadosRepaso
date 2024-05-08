package edu.gorillas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Inserciones {
static Scanner sc = new Scanner(System.in);
static ResultSet res = null;
    public static void insertarDep(Statement sentencia) {
        System.out.println("Introduce el nombre del departamento");
        String nombre = sc.nextLine();
        System.out.println("Introduce la localidad del departamento");
        String localidad = sc.nextLine();
        try {
            sentencia.executeUpdate("insert into departamentos (Dnombre,localidad) "
                    + "values('" + nombre + "','" + localidad + "');");
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }

    public static void insertarEmp(Statement sentencia) {
        System.out.println("Introduce el dni del empleado");
        String dni = sc.nextLine();
        System.out.println("Introduce el nombre del empleado");
        String nombre = sc.nextLine();
        System.out.println("Introduce los estudios del empleado");
        String estudios = sc.nextLine();
        System.out.println("Introduce la dirección del empleado");
        String dir = sc.nextLine();
        System.out.println("Introduce la fecha de alta del empleado (yyyy-mm-dd)");
        String fecha = sc.nextLine();
        System.out.println("Introduce el salario del empleado");
        int salario = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce la comisión del empleado");
        int comision = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce el nombre del departamento del empleado");
        String Dnombre = sc.nextLine();
        try {
            res = sentencia.executeQuery("select * from departamentos where Dnombre='" + Dnombre + "';");
            if(res.next()){
                int Nu_dept = res.getInt("Nu_dept");
            sentencia.executeUpdate("insert into empleados (dni,nombre,estudios,dir,fecha_alt,salario,comision,Nu_Dept) "
                    + "values('" + dni + "','" + nombre + "','" + estudios + "','" + dir + "','" + fecha + "'," + salario + "," + comision + "," + Nu_dept + ");");
            }else{
                System.out.println("No existe el departamento");
                insertarEmp(sentencia);
            }
        } catch (SQLException e) {
            System.out.println("Error: " + e);
        }
    }
}
