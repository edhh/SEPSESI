package test.mx.sep.sesi.dao;

import mx.sep.sesi.dao.EjemploDao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

/**
 * Todas las clases test que se creen deben heredar de BaseDaoTest
 * para que tengan visibilidad de los beans de Spring.
 * 
 * @author Alejandro Pimentel
 *
 */
public class EjemploDaoTest extends BaseDaoTest {
	
	@Autowired
	private EjemploDao ejemploDao;
	
	@Test
	public void ejemploTest(){
		// Aqui simplemente probamos que el bean haya sido inyectado correctamente.
		Assert.notNull(ejemploDao);
	}
}
