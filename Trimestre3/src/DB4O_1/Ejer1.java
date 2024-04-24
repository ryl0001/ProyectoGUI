package DB4O_1;

public class Ejer1 {

	public static void main(String[] args) 
	{
		ConexionDB4O connect=new ConexionDB4O("baseObjeto.db4o");
		Persona P1 = new Persona("Juan",40);
		Persona P2 = new Persona("Manuel",4);
		Persona P3 = new Persona("Paco",3);
		Persona P_Plantilla = new Persona(null,0);
		
		try {
			connect.conectar();
			/*connect.insertar(P1);
			connect.insertar(P2);
			connect.insertar(P3);*/
			
			connect.consulta(P_Plantilla);
		} catch (DB4OException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				connect.desconectar();
			} catch (DB4OException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		}
}
