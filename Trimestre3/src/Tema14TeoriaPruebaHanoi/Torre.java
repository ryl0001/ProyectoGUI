package Tema14TeoriaPruebaHanoi;

import java.util.ArrayList;

public class Torre 
{
	ArrayList<Disco> Palo;
	
	public Torre()
	{
		Palo=new ArrayList<Disco>();
	}
	
	public Disco cima ()
	{
		if (Palo.isEmpty()) 
			return null;
		else
		
			return Palo.get(Palo.size()-1);
		
		
	}
	
	public void agregarDisco(Disco NuevoDisco)
	{
		if(Palo.isEmpty() ||  NuevoDisco.getTamano()<Palo.get(Palo.size()-1).getTamano())
		{
			Palo.add(NuevoDisco);
		}
		else
		{
			System.out.println("No se puede introducir el disco porque el tamaño es menor ");
		}
		
		
	}
	
	public Disco removerDisco()
	{
		
		if (!Palo.isEmpty())
		{
			return Palo.remove(Palo.size()-1);
		}
		else
		{
			return null;
		}
	}
	
	public ArrayList<Disco> getTorre()
	{
		return Palo;
	}
}
