package CorreciónParking;

import java.util.ArrayList;
import java.util.List;

public class Parking {
	
	private ArrayList<Plaza> Aparcamiento;
	
	//constructores
	public Parking ()
	{
		this.Aparcamiento=new ArrayList<>();
	}
	public Parking (int NPlazas)
	{
		this.Aparcamiento=new ArrayList<>();
		for(int i=0;i<NPlazas;i++)
		{
			this.Aparcamiento.add(new Plaza(i));
		}
	}
	
	//metodos
	public void agregarPlazas(int NPlazas)
	{
		int inicio=Aparcamiento.size();
		
		for(int i=0;i<NPlazas;i++)
		{
			this.Aparcamiento.add(new Plaza(inicio+i));
		}
	}
	
	public boolean estacionarVehiculo(Vehiculo nuevoVehiculo)
	{
		for (Plaza P:Aparcamiento)
		{
			if(!P.getOcupado())//P.getocupada()==false
			{
				P.ocuparPlaza(nuevoVehiculo);
				return true;
			}
		}
		return false;//Lleno
	}
	public boolean retirarVehiculo(String matricula)
	{
		for (Plaza P:Aparcamiento)
		{
			if(P.getOcupado() && P.getVehiculo().getMatricula().equals(matricula))
			{
				P.liberarPlaza();
				return true;
			}
		}
		return false;//Lleno
	}
	
	public void imprimeEstado()
	{
		for (Plaza P:Aparcamiento)
		{
			System.out.println(P);
		}
	}

}
