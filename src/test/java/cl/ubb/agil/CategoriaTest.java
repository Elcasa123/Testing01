package cl.ubb.agil;

import static org.junit.Assert.assertThat; 
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;


public class CategoriaTest {
	
	@Test
	public void obtenerNombre(){
		Categoria categoria=new Categoria("categ1","123");
		String Resultado = categoria.getNombre();
		assertThat(Resultado,is("categ1"));
		
	}
	
	
	

}
