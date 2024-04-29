package BorradorProyecto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.TimeZone;

public class ConexionDB {

	private static String DatabaseURL = "";
	
	private static String usuario= "";
	
	private static String contraseña= "";
	
	public static Connection conectar() {
		try {
			return DriverManager.getConnection(DatabaseURL, usuario, contraseña);
		} catch (SQLException e) {
			System.out.println("Error conectando a la base de datos:" + e.getMessage());
		}
		return null;
	}
}
