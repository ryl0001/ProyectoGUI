package ACTIVIDAD_BDRelacional;

import java.sql.SQLException;
import java.util.Scanner;



public class InsercionDatos 
{

	public static void Datos(ConexionMySQL PrimeraOp, Scanner EntradaDatos) throws SQLException
	{
		
		System.out.println("Escriba el nombre del estudiante");
		String nuevoNombre = EntradaDatos.next();
		System.out.println("Escriba la edad del estudiante");
		int nuevaEdad = EntradaDatos.nextInt();
		System.out.println("Escriba el Dni del estudiante");
		String nuevoDni = EntradaDatos.next();
		
		String sentencia = "INSERT INTO Estudiantes(Nombre,Edad,DNI)VALUES('"+nuevoNombre+"','"+nuevaEdad+"','"+nuevoDni+"')";
		PrimeraOp.ejecutarInsertDeleteUpdate(sentencia);
		
		
	}
}
