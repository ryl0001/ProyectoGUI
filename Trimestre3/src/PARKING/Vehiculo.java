package PARKING;

public class Vehiculo 
{
	private String Matricula;
	private String tipo;
	
	public Vehiculo (String Matricula, String tipo)
	{
		this.Matricula=Matricula;
		this.tipo=tipo;
	}
	
	public String getMatricula()
	{
		return this.Matricula;
	}
	
	public String getTipo()
	{
		return this.tipo;
	}
	
	public String toString()
	{
		return "Vehiculo{"+"matricula="+Matricula+"...tipo="+tipo+"}";
	}
	
}
