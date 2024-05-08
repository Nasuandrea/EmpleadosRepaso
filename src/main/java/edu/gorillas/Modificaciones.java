package edu.gorillas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.jar.JarOutputStream;

public class Modificaciones {
    static Scanner sc = new Scanner(System.in);
    static ResultSet res = null;
    public static void modificarSalarioComisionPorDNI(Statement sentencia) {
        try{
            System.out.println("Introduce el DNI del empleado");
            String dni = sc.nextLine();
            System.out.println("¿Deseas modificar el salario (1) o la comisión (2)?");
            String respuesta= sc.nextLine();
            if(respuesta.equals("1")) {
                System.out.println("Introduce el nuevo salario");
                int nuevoSalario = sc.nextInt();
                sentencia.executeUpdate("update empleados set salario=" + nuevoSalario + " where dni='" + dni + "';");
            }else if(respuesta.equals("2")){
                System.out.println("Introduce la nueva comisión");
                int nuevaComision = sc.nextInt();
                sentencia.executeUpdate("update empleados set comision=" + nuevaComision + " where dni='" + dni + "';");
            }else{
                System.out.println("Opcion incorrecta");
                modificarSalarioComisionPorDNI(sentencia);
            }

        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
    }

    }
    public static void modificarLocalidadPorDepartamento(Statement sentencia) {
        try{
            System.out.println("Introduce el nombre del departamento");
            String Dnombre = sc.nextLine();
            res= sentencia.executeQuery("select * from departamentos where Dnombre='" + Dnombre + "';");
            if(!res.next()){
                System.out.println("No existe el departamento");
                modificarLocalidadPorDepartamento(sentencia);
            }
            System.out.println("Introduce la nueva localidad");
            String nuevaLocalidad = sc.nextLine();
            sentencia.executeUpdate("update departamentos set localidad='" + nuevaLocalidad + "' where Dnombre='" + Dnombre + "';");
        }
        catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }
}
