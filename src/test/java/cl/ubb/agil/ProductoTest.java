package cl.ubb.agil;

import static org.junit.Assert.assertThat; 
import static org.hamcrest.CoreMatchers.is;
import org.junit.Test;

public class ProductoTest {
	
	@Test
	public void obtenerStockEs0(){
		Producto producto= new Producto("Tallarines",1,2);
		int resultado=producto.getStock();
		assertThat(resultado, is(0));
	}
	
	@Test
	public void EstaElStockBajoCorrecto(){
		Producto producto= new Producto("Tallarines",1,2);
		boolean resultado=producto.isBajoStock();
		assertThat(resultado, is(true));
	}
	 @Test
	public void EstaElStockBajoFalso(){
		Existencia existencia= new Existencia("2");
		Producto producto= new Producto("Tallarines",1,2);
		producto.addExistencia(existencia);
		boolean resultado=producto.isBajoStock();
		assertThat(resultado, is(false));
	}
	 
	 @Test
		public void obtenerstockfaltanteEs10(){
		 Categoria categoria= new Categoria("pastas","123");
		 Producto producto= new Producto("Tallarines",1,10,categoria);
		 int resultado = producto.getStockFaltante();
		 assertThat(resultado, is(10));
	 }
	 @Test (expected=ExcepcionDeProducto.class)
	 public void obtenerProximaExistenciaLanzaExcepcion() throws ExcepcionDeProducto{
		 Producto producto= new Producto("Tallarines",1,5);
		 producto.getProximaExistencia();		 
	 }
	 
	 @Test
	 public void ObitnerProximaExistenciaDevuelveUnaExistencia() throws ExcepcionDeProducto{
		 Existencia existencia = new Existencia("2");
		 Producto producto= new Producto("Tallarines",1,5);
		 producto.addExistencia(existencia);
		 Existencia resultado = producto.getProximaExistencia();
		 assertThat(resultado, is(existencia));
		 
	 }
	 
	 @Test
	 public void agregarExistenciaEsTrue(){
		 Existencia existencia = new Existencia("1");
		 Producto producto= new Producto("tallarines",2,20);
		 boolean resultado= producto.addExistencia(existencia);
		 assertThat(resultado, is(true));
	}
	 
	 /*este test revela que hay un error en el codigo ya que permite 
	  * agregar una unidad mas que el stock maximo
	 */
	 @Test
	 public void agregarExistenciaEsFalseExcedeElMaximo(){
		 Existencia existencia = new Existencia("1");
		 Existencia existencia1 = new Existencia("1");
		 Existencia existencia2 = new Existencia("1");
		 Producto producto= new Producto("tallarines",2,3);
		 producto.addExistencia(existencia);
		 producto.addExistencia(existencia1);
		 producto.addExistencia(existencia2);
		 boolean resultado= producto.addExistencia(existencia);
		 assertThat(resultado, is(false));
	}
	 
	 /*esta purbe fuerza el stock a ser mayor al stock maximo, para forzar el return false*/
	 @Test
	 public void agregarExistenciaEsFalso(){
		 Existencia existencia = new Existencia("1");
		 Producto producto= new Producto("tallarines",2,4);
		 producto.stock=21;
		 boolean resultado= producto.addExistencia(existencia);
		 assertThat(resultado, is(false));
	}
	 
	 @Test
	 public void obtenercategoria(){
		 Categoria categoria= new Categoria("pastas","123");
		 Producto producto= new Producto("Tallarines",1,2,categoria);
		 Categoria resultado=producto.getCategoria();
		 assertThat(resultado, is(categoria));
	}
	 
	 @Test
	 public void ObtenerNombreIgualATallarines(){
		 
		 Producto producto= new Producto("Tallarines",1,2);
		 String resultado=producto.getNombre();
		 assertThat(resultado, is("Tallarines"));
	 }
	 @Test
	 public void AsignarNombreArrozCorrectamente(){
		 
		 Producto producto= new Producto("Tallarines",1,2);
		 producto.setNombre("arroz");
		 String resultado=producto.getNombre();
		 assertThat(resultado, is("arroz"));
	 }
	 @Test
	 public void AsignarCategoria(){
		 Categoria categoria= new Categoria("pastas","123");
		 Producto producto= new Producto("Tallarines",1,2);
		 producto.setCategoria(categoria);
		 Categoria resultado=producto.getCategoria();
		 assertThat(resultado, is(categoria));
	 }
	 @Test
	 public void ObtenerCodigoDeExistenciaRetornaXXXXX() throws ExcepcionDeProducto{
		 Existencia existencia = new Existencia("1");
		 Producto producto= new Producto("tallarines",2,20);
		 producto.addExistencia(existencia);
		 String resultado= producto.getCodigoProximaExistencia();
		 assertThat(resultado, is("XXXXX-1"));
	 }
	 
	 @Test
	 public void ObtenerCodigoDeExistenciaRetornaCodigoCategorimasNumeroExistencia() throws ExcepcionDeProducto{
		 Existencia existencia = new Existencia("1");
		 Categoria categoria= new Categoria("pastas","123");
		 Producto producto= new Producto("tallarines",2,20,categoria);
		 producto.addExistencia(existencia);
		 String resultado= producto.getCodigoProximaExistencia();
		 assertThat(resultado, is("123-1"));
	 }
	 
	 @Test (expected=ExcepcionDeProducto.class)
	 public void ObtenerCodigoDeExistenciaLanzaExcepcion() throws ExcepcionDeProducto{
		 Producto producto= new Producto("tallarines",2,20);
		 String resultado= producto.getCodigoProximaExistencia();
	 }
	 

}
