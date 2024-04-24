package PARKING;

import java.util.ArrayList;

public class Parking 
{
	private static final int NPlazas = 0;
	private static final Plaza P= null;
	private ArrayList<Plaza> Aparcamientos;
	
	public Parking(int NPlazas)
	{
		this.Aparcamientos= new ArrayList<>();
		for (int i=0;i<NPlazas;i++)
		{
			Aparcamientos.add(new Plaza(i));
		}
	}
	
	public void agregarPlaza(int NPlazas)
	{
		int ultima=Aparcamientos.size()-1;
		for (int i=0;i<NPlazas;i++)
		{
			Aparcamientos.add(new Plaza(ultima+i));
		}
	}
	
	public boolean estacionarVehiculo(Vehiculo nuevoVehiculo)
	{
		
		for (Plaza P :Aparcamientos)
		{
			if (!P.isOcupada())
			{
				P.ocuparPlaza(nuevoVehiculo);
				return true;
			}
		}
		return false;
	}
	
	public boolean retirarVehiculo(String Matricula)
	{
		for (Plaza P: Aparcamientos)
		{
			if (P.isOcupada() && P.getvehiculo().getMatricula().equals(Matricula))
			{
				P.liberarPlaza();
				return true;
			}
		}
		return false;
	}
	
	public void imprimirEstado()
	{
		for (Plaza P:Aparcamientos)
		{
			System.out.println(P);
		}
	}
}
