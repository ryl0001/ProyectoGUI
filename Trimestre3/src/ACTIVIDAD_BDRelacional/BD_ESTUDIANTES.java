package ACTIVIDAD_BDRelacional;

import java.sql.SQLException;
import java.util.Scanner;



public class BD_ESTUDIANTES {

	public static void main(String[] args) 
	{
		ConexionMySQL connect = new ConexionMySQL("root","test","Escuela");
		Scanner teclado = new Scanner (System.in);
		int opcion;
		
		try {
			connect.conectar();
			do
			{
				System.out.println("Selecciona la opción del menu que quieras acceder: " + "\n" + "1. Inserción de datos" + "\n" +
									"2. Consulta de datos" + "\n" + "3. Actualización de datos" + "\n" + "4. Borrado de datos" + "\n" + "5. Cerrar programa");
				opcion = teclado.nextInt();
				
				switch (opcion)
				{
				
				case 1:
					InsercionDatos.Datos(connect,teclado);
					break;
				
				case 2: 
					ConsultaDatos.CD(connect);
					break;
					
				case 3:
					ActualizacionDatos.AD(connect,teclado);
					break;
					
				case 4:
					BorradoDatos.BD();
					break;
				
				case 5:
					System.out.println("Cerrando programa");
					break;
				
				default:
					System.out.println("Ha introducido una opción incorrecta");
				}
			} while (opcion !=5);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

	}

}
