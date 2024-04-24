package CorreciónParking;

public class Plaza {
	private int numero;
	private boolean ocupada;
	private Vehiculo veh;
	
	public Plaza(int numero)
	{
		this.numero=numero;
		this.ocupada=false;
		this.veh=null;
	}
	
	//getter
	public int getNumero()
	{
		return this.numero;
	}
	public Vehiculo getVehiculo()
	{
		return this.veh;
	}
	public boolean getOcupado()
	{
		return this.ocupada;
	}

	
	//metodos
	public boolean ocuparPlaza(Vehiculo nuevoVehiculo)
	{
		if (!ocupada)//ocupada==falso// !getOcupada()//getocupada()==false
		{
			this.ocupada=true;
			this.veh=nuevoVehiculo;
			return true;
		}
		else
		{
			return false;
		}
	}
	
	public Vehiculo liberarPlaza()
	{
		if(ocupada)//ocupada==true//getOcupada()//getOcupada()==true
		{
			Vehiculo temp=getVehiculo();//this.veh
			this.ocupada=false;
			this.veh=null;
			return temp;
		}
		else
		{
			return null;
		}
	}
	
	public String toString()
	{
		return "PLAZA{"+
				"numero= "+ numero+
				"...ocupada= "+ ocupada +
				"...vehiculo= "+veh+"}";
	}
}
