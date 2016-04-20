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
	@Test
	public void obtenerCodigoMayorA5(){
		Categoria categoria=new Categoria("categ1","123456");
		String Resultado = categoria.getCodigo();
		assertThat(Resultado,is("12345"));
	}
	
	@Test
	public void obtenerCodigoMenorA5(){
		Categoria categoria=new Categoria("categ1","123");
		String Resultado = categoria.getCodigo();
		assertThat(Resultado,is("123"));
	}
	
	@Test
	public void AsignarNombre(){
		Categoria categoria = new Categoria("","");
		categoria.setNombre("nombre");
		String Resultado = categoria.getNombre();
		assertThat(Resultado,is("nombre"));	
		
	}
	@Test
	public void AsignarCodigo(){
		Categoria categoria = new Categoria("","");
		categoria.setCodigo("codigo");
		String Resultado = categoria.getCodigo();
		assertThat(Resultado,is("codig"));	
		
	}
	
	
	
	

}
