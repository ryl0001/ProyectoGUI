package PARKING;

public class Plaza 
{
	private int Numero;
	private boolean Ocupado;
	private Vehiculo vehiculo;
	
	public Plaza (int Numero)
	{
		this.Numero=Numero;
		this.Ocupado=false;
		this.vehiculo=null;
	}
	
	public int getNumero()
	{
		return this.Numero;
	}
	
	public boolean getOcupado()
	{
		return this.Ocupado;
	}
	
	public Vehiculo getvehiculo()
	{
		return this.vehiculo;
	}
	
	public boolean ocuparPlaza(Vehiculo vehiculo)
	{
		if(!Ocupado)
		{
			this.Ocupado=true;
			this.vehiculo=vehiculo;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Vehiculo liberarPlaza()
	{
		if (Ocupado)
		{
			Vehiculo tem=this.vehiculo;
			this.Ocupado=false;
			this.vehiculo=null;
			return tem;
		}
		else
		{
			return null;
		}
	}
	
	public boolean isOcupada()
	{
		return Ocupado;
	}
	
	public String toString()
	{
		return "Plaza{" + "numero=" + Numero + " ocupada=" + Ocupado + " Vehiculo=" + vehiculo + "}";
	}
	
}
