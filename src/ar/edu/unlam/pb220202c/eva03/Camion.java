package ar.edu.unlam.pb220202c.eva03;

public class Camion extends Vehiculo implements Imultable{

	//Si es necesario Utilice herencia o implemente de Interfaces
	//Se debe crear contructeres getters y Setters y los que crean conveniente
	private Integer cantidadDeEjes;
	private final Integer velMaxCamion=80;
	
	public Camion(String patente, Integer velocidadActual, Integer cantidadDeEjes) {
		super(patente, velocidadActual);
		this.cantidadDeEjes = cantidadDeEjes;
		setLimiteVelocidad(velMaxCamion);
	}
	
	@Override
	public Boolean enInfraccion() {
		if (getVelocidadActual()>this.velMaxCamion) {
			return true;
		}else {
			return false;
		}
	}

	//el Limite de velociadad para autos es de 80km
	//en caso que supere dicho limite el este sera multado

	
}
