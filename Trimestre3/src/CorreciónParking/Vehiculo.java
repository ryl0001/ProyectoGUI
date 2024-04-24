package CorreciónParking;

public class Vehiculo {

	private String matricula;
	private String tipo;
	
	public Vehiculo (String m,String t)
	{
		this.matricula=m;
		this.tipo=t;
	}
	
	//getter
	public String getMatricula()
	{
		return this.matricula;
	}
	public String getTipo()
	{
		return this.tipo;
	}
	
	public String toString()
	{
		return "VEHICULO {"+
				"matricula= "+matricula+
				"...tipo="+tipo+"}";
	}
}
