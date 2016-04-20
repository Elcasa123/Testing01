package cl.ubb.agil;

import static org.junit.Assert.assertThat; 
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class ExistenciaTest {
	
	
	
	@Test
	public void obtenerNumero(){
		Existencia existencia = new Existencia("4");
		String Resultado=existencia.getNumero();
		assertThat(Resultado,is("4"));
	}
	

}
