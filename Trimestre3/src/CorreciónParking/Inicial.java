package CorreciónParking;

public class Inicial {

	public static void main(String[] args) {
		//Creo vehiculos
		Vehiculo V1 =new Vehiculo("4335A","Motocicleta");
		Vehiculo V2 =new Vehiculo("6666C","Patinete");
		Vehiculo V3 =new Vehiculo("6666T","Coche");
		
		//Creo el Parkig
		Parking Encarnacion =new Parking();
		//Parking Encarnacion =new Parking(10); Así lo crearía con 10 plazas
		
		//Añado 5 Plazas cada vez
		Encarnacion.agregarPlazas(5);
		Encarnacion.agregarPlazas(5);
		
		//Imprimo el parking vacio
		Encarnacion.imprimeEstado();
		
		//Añado Vehiculos
		Encarnacion.estacionarVehiculo(V3);
		
		//Imprimo el parking
		System.out.println();
		Encarnacion.imprimeEstado();

		//Añado Vehiculos
		Encarnacion.estacionarVehiculo(V1);
		Encarnacion.estacionarVehiculo(V2);
		
		//Imprimo el parking
		System.out.println();
		Encarnacion.imprimeEstado();
		
		//Retiro el patinete segun la matricula
		Encarnacion.retirarVehiculo("6666C");
		//Imprimo el parking
		System.out.println();
		Encarnacion.imprimeEstado();
		
		//Si queremos saber si se ha podido retirar, como el método le dijimos que devolviera un boolean.
		//En este caso le diré una matricula que no existe y devolvera falso.
		if (Encarnacion.retirarVehiculo("44"))
		{
			System.out.println("Vehículo retirado correctamente");
		}
		else
		{
			System.out.println();
			System.out.println("Vehículo no encontrado");
		}
		
		
		
		
	}

}
