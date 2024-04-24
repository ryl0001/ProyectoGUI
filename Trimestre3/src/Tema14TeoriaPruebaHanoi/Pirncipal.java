package Tema14TeoriaPruebaHanoi;

import java.util.Scanner;

public class Pirncipal {

	public static void main(String[] args) 
	{
		Hanoi hanoi = new Hanoi (2);
		Scanner scanner = new Scanner (System.in);
		boolean juega=true;
		System.out.println("Estado inicial");
		hanoi.Imprimir();
		
		while(juega)
		{
			System.out.println("Ingresa su movimiento (Origen Destino)");
			String movimiento = scanner.nextLine().toUpperCase();
			
			if (movimiento.length() !=2)
			{
				System.out.println("Movimiento inválido, intente de nuevo");
				continue;
			}
			
			char origen=movimiento.charAt(0);
			char destino=movimiento.charAt(1);
			
			if (origen !='A' && origen != 'B' && origen !='C' || destino != 'A' && destino != 'B' && destino != 'C')
			{
				System.out.println("Torres inválidas, intente de nuevo");
				continue;
			}
			
			hanoi.mover(origen, destino);
			hanoi.Imprimir();
			if(hanoi.fin())
			{
				System.out.println("Se terminó");
				juega=false;
			}
		}

	}

}
