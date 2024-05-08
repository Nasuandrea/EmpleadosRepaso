package edu.gorillas;

import java.sql.SQLException;
import java.sql.Statement;

public class CreacionBD {
public static void crearBD(Statement sentencia) {

    try {
        String bd = "empleados";
        //Sentencia para crear la base de datos si no existe y usarla
        sentencia.execute("CREATE DATABASE IF NOT EXISTS " + bd + ";");
        sentencia.execute("USE " + bd + ";");

        // Creación de la tabla Departamentos:
        sentencia.execute("CREATE TABLE IF NOT EXISTS Departamentos ("
                + "Nu_dept INT AUTO_INCREMENT PRIMARY KEY,"
                + "Dnombre VARCHAR(10) UNIQUE,"
                + "Localidad VARCHAR(10))");

        // Creación de la tabla Empleados:
        sentencia.execute("CREATE TABLE IF NOT EXISTS Empleados ("
                + "Dni VARCHAR(9) NOT NULL PRIMARY KEY ,"
                + "Nombre VARCHAR(10),"
                + "Estudios VARCHAR(10),"
                + "Dir VARCHAR(10),"
                + "Fecha_alt DATE,"
                + "Salario INT,"
                + "Comision INT,"
                + "Nu_dept INT,"
                + "FOREIGN KEY (Nu_dept) REFERENCES Departamentos(Nu_dept)"
                + " ON DELETE CASCADE"  // Para borrar la clave foranea
                + " ON UPDATE CASCADE)");

    } catch (Exception e)
    {
        System.out.println(e);
    }

}
}



