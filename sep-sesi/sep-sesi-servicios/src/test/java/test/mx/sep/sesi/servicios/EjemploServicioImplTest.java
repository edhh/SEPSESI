package test.mx.sep.sesi.servicios;

import mx.sep.sesi.servicios.EjemploServicio;
import mx.sep.sesi.servicios.util.ErrorNegocio;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

public class EjemploServicioImplTest extends BaseServicioTest {
	
	@Autowired
	private EjemploServicio ejemploServicio;

	@Test
	public void ejemploServicioDependenciaTest(){
		Assert.notNull(ejemploServicio);
	}
	
	@Test(expected=ErrorNegocio.class)
	public void ejemploMensajeErrorNegocioTest(){
		ejemploServicio.ejemploCodigoMensajeErrorNegocio();
	}
}
