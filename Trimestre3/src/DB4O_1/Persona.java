package DB4O_1;

public class Persona 
{
	private String Nombre;
	private int Edad;
	
	public Persona (String Nombre, int Edad)
	{
		this.Nombre=Nombre;
		this.Edad=Edad;
		
	}
	
	public String toString()
	{
		return Nombre+" "+Edad;
	}
}
