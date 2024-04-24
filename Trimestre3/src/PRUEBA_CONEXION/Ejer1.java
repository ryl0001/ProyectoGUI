package PRUEBA_CONEXION;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Ejer1 {

	public static void main(String[] args) 
	{
		ConexionMySQL connect = new ConexionMySQL("root","test","prueba");
		Scanner teclado = new Scanner(System.in);
		try {
			connect.conectar();
			/*System.out.println("Introduzca un nombre:");
			String nuevoNombre=teclado.next();
			System.out.println("Introduzca una edad:");
			int nuevaEdad=teclado.nextInt();
			
			String sentencia="INSERT INTO Personas(Nombre,Edad)VALUES('"+nuevoNombre+"','"+nuevaEdad+"')";
			connect.ejecutarInsertDeleteUpdate(sentencia);*/
			String sentencia="SELECT * FROM Personas";
			ResultSet datos;
			datos=connect.ejecutarSelect(sentencia);
			
			while(datos.next())
			{
				String nombre=datos.getString("Nombre");
				int edad=datos.getInt("Edad");
				
				System.out.println(nombre+" "+edad);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				connect.desconectar();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
