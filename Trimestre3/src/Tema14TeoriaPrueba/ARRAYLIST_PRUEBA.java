package Tema14TeoriaPrueba;

import java.util.ArrayList;

public class ARRAYLIST_PRUEBA {

	public static void main(String[] args) 
	{
		ArrayList<Character> LetrasAlfabeto = new ArrayList<> ();
		
		//CREAR LA LISTA CON LETRAS DEL ALFABETO
		char [] letras = {'A', 'B','C','D','E','F','G','H','I','J','K','L','M','N','Ñ','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		
		for (char letra: letras)
		{
			LetrasAlfabeto.add(letra);
		}
		
		//MOSTRAR LISTA
		System.out.println("ALFABETO ESPAÑOL:"+ LetrasAlfabeto);
		
		//BUSCAR Y MOSTRAR LA POSICIÓN E, H y O
		System.out.println("Posición de E: " + LetrasAlfabeto.indexOf('E'));
		System.out.println("Posición de H: " + LetrasAlfabeto.indexOf('H'));
		System.out.println("Posición de O: " + LetrasAlfabeto.indexOf('O'));
		
		//ELIMINAR EL ELEMENTO DE LA POSICIÓN 1 Y 'U'
		LetrasAlfabeto.remove(1);
		LetrasAlfabeto.remove((Character) 'U');
		
		//MOSTRAR LISTA
		System.out.println("NUEVO ALFABETO" + LetrasAlfabeto);
	}

}
