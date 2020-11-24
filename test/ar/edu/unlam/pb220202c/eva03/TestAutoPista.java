package ar.edu.unlam.pb220202c.eva03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.TreeSet;

import org.junit.Test;

public class TestAutoPista {
	
	@Test
	public void queSePuedaRegistrarTelepase () {
		Autopista delSol=new Autopista();
		Vehiculo audi=new Automovil("AAA123", 100);
				
		assertTrue(delSol.registrarTelepase(123, audi));
	}

	@Test (expected = VehiculoNotFounException.class)
	public void queAlSalirDelAutopistaNoestaEncirculacionLanceUnaExcepcion() throws VehiculoNotFounException {
		Autopista delSol=new Autopista();
		Vehiculo audi=new Automovil("AAA123", 100);
		
		delSol.registrarTelepase(123, audi);
		delSol.ingresarAutopista(123);
		
		delSol.salirAutpista(audi);
		delSol.salirAutpista(audi);
		
	}
	
	@Test
	public void queVerifiqueQueSeObtengaUnaListaDeAutosInsfractoresOrdenadaPorPatente() throws VehiculoNotFounException{
		Autopista delSol=new Autopista();
		
		Vehiculo a=new Automovil("zz99", 200);//excede
		Vehiculo a1=new Automovil("a1", 100);
		Vehiculo c1=new Camion("a6", 100, 6);//excede
		Vehiculo a2=new Automovil("a3", 200);//excede
		Vehiculo c2=new Camion("a2", 50, 6);
		
		delSol.registrarTelepase(11, a);
		delSol.registrarTelepase(1, a1);
		delSol.registrarTelepase(2, c1);
		delSol.registrarTelepase(3, a2);
		delSol.registrarTelepase(4, c2);
		
		delSol.ingresarAutopista(11);
		delSol.ingresarAutopista(1);
		delSol.ingresarAutopista(2);
		delSol.ingresarAutopista(3);
		delSol.ingresarAutopista(4);
		
		TreeSet<Vehiculo> listaOrdenada=delSol.obtenerVehiculosConExcesosDeVelocidadOrdenadosPorPatente();
		
		assertEquals(a2,listaOrdenada.first());
		assertEquals(a,listaOrdenada.last());
		
	}

	@Test
	public void queSuperenVelocidad() {
		Automovil audi=new Automovil("AAA123", 100);
		assertFalse(audi.enInfraccion());
		audi.incrmentarVelocidad(100);
		assertTrue(audi.enInfraccion());
		
		Camion c=new Camion("aaa111", 100, 6);
		assertTrue(c.enInfraccion());
	}
	
	@Test
	public void agregarTantoCamionesComoAutos() {
		Autopista delSol=new Autopista();
		
		Vehiculo audi=new Automovil("AAA123", 100);
		Vehiculo c=new Camion("aaa111", 100, 6);
				
		assertTrue(delSol.registrarTelepase(123, audi));
		assertTrue(delSol.registrarTelepase(124, c));
	}
	
}
