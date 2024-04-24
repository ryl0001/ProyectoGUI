package Tema14TeoriaPruebaHanoi;

public class Disco 
{
	private int tamano;
	
	public Disco (int Valor)
	{
		this.tamano=Valor;
	}
	
	public int getTamano()
	{
		return this.tamano;
	}
	
	public String toString()
	{
		return String.valueOf(tamano);
	}
}
