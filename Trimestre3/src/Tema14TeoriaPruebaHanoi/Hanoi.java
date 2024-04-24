package Tema14TeoriaPruebaHanoi;

public class Hanoi 
{
	private Torre torreA, torreB, torreC;
	
	public Hanoi(int numDiscos)
	{
	torreA = new Torre();
	torreB = new Torre();
	torreC = new Torre();
	
		for (int i=numDiscos; i>0; i--)
		{
			torreA.agregarDisco(new Disco(i));
		}	
	}

	
	
	public void mover(char origen, char destino)
	{
		Torre TorreOrigen;
		Torre TorreDestino;
		
		if (origen=='A')
		{
			TorreOrigen=torreA;
		}
		else if (origen=='B')
		{
			TorreOrigen=torreB;
		}
		else
		{
			TorreOrigen=torreC;
		}
		
		if (destino=='A')
		{
			TorreDestino=torreA;
		}
		else if (destino=='B')
		{
			TorreDestino=torreB;
		}
		else
		{
			TorreDestino=torreC;
		}
	
		Disco Movimiento = TorreOrigen.cima();
		if (Movimiento != null && (TorreDestino.cima() == null || Movimiento.getTamano() <= TorreDestino.cima().getTamano()))
		{
			TorreDestino.agregarDisco(TorreOrigen.removerDisco());
			System.out.println("El disco de la Torre " + origen + " ha sido movido a la Torre " + destino);
		} else
		{
			System.out.println("Este movimiento no se puede realizar");
		}
	}
	
	public void Imprimir()
	{
		int MaximaAltura= Math.max(Math.max(torreA.getTorre().size(), torreB.getTorre().size()), torreC.getTorre().size());
		
		System.out.println(MaximaAltura);
		
		System.out.println("Torre A\t TorreB\t Torre C");
		
		for (int i = MaximaAltura-1; i>=0; i--)
		{
			String DiscoA = DiscoRepresentacion (torreA, i);
			String DiscoB = DiscoRepresentacion (torreB, i);
			String DiscoC = DiscoRepresentacion (torreC, i);
			System.out.println(" " + DiscoA +"\t"+ "  " + DiscoB+ "\t" + "  "+ DiscoC );
		}
	}
	
	public String DiscoRepresentacion (Torre x, int i)
	{
		if(x.getTorre().size()<i+1)
		{
			return "|";
		}
		else
		{
			return x.getTorre().get(i).toString();
		}
	}
	
	public boolean fin () 
    {
    	if(torreA.getTorre().isEmpty() && torreB.getTorre().isEmpty() )
    	{
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    }
}	
