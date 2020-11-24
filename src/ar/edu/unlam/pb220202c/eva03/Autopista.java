package ar.edu.unlam.pb220202c.eva03;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;



public class Autopista {
	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los atributos o metodos que crean convenientes
	private HashMap <Integer,Vehiculo> telapase;
	private HashSet <Vehiculo> vehiculosEnCirculacion;
	
	public Autopista() {
		this.telapase=new HashMap<Integer, Vehiculo>();
		this.vehiculosEnCirculacion=new HashSet<Vehiculo>();
	}



	public Boolean registrarTelepase (Integer numeroTelpase, Vehiculo vehiculo) {
		this.telapase.put(numeroTelpase, vehiculo);
		Boolean existe= this.telapase.containsKey(numeroTelpase);

		return existe;		
	}
		
	public Boolean ingresarAutopista (Integer numeroTelepase) throws VehiculoNotFounException {
		//si el telepase no esta registrado lanza una Exceptios del tipo VehiculoNotFounException
	   // y no permite ingresar al autopista	
	
		if (this.telapase.containsKey(numeroTelepase)) {
			Vehiculo v=this.telapase.get(numeroTelepase);
			return this.vehiculosEnCirculacion.add(v);
		}else {
			throw new VehiculoNotFounException("No existe vehiculo registrado en TELEPASE");
		}
	}
	
	public void salirAutpista (Vehiculo vehiculo) throws VehiculoNotFounException {
		//lanza Una exception VehiculoNotFounException si no esta en circulacion
		if (this.vehiculosEnCirculacion.contains(vehiculo)) {
			this.vehiculosEnCirculacion.remove(vehiculo);
		}else {
			throw new VehiculoNotFounException("No existe este vehiculo en circulacion");
		}
		
	}
	
	public TreeSet<Vehiculo> obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente(){
		TreeSet<Vehiculo> listaOrdenada=new TreeSet<Vehiculo>();
		
		for (Vehiculo v : this.vehiculosEnCirculacion ) {
			 if (v instanceof Automovil) {
				 if (((Automovil) v).enInfraccion()) {
					listaOrdenada.add(v);
				}	
			}
			 if (v instanceof Camion) {
				 if (((Camion) v).enInfraccion()) {
					listaOrdenada.add(v);
				}	
			}			
		}
		
	   return listaOrdenada;
    }

	public Integer cantidadDeVehiculosENCirculacion() {
		return this.vehiculosEnCirculacion.size();
}
	}
