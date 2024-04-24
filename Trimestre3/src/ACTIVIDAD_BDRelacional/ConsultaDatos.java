package ACTIVIDAD_BDRelacional;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultaDatos 
{
	
	public static void CD(ConexionMySQL ConsultaDatos) throws SQLException
	{
		String sentencia ="SELECT * FROM Estudiantes";
		ResultSet datos;
		datos=ConsultaDatos.ejecutarSelect(sentencia);
		
		while (datos.next())
		{
			String nombre=datos.getString("Nombre");
			int edad=datos.getInt("Edad");
			String Dni=datos.getString("Dni");
			
			System.out.println(nombre+" "+edad+" "+Dni);
		}
	}
}
