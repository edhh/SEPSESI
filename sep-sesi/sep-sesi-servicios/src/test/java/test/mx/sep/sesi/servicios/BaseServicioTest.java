package test.mx.sep.sesi.servicios;

import org.junit.runner.RunWith;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Esta clase establece por medio de anotaciones la configuraci�n para ejecutar los tests.
 * 
 * - Primero se indica que JUnit ser� el encargado de ejecutar las mismas y evaluar los resultados.
 * - Despu�s el archivo que contiene la configuraci�n de spring para iniciar el contendor y sus beans.
 * - Se activa el profile con el que se debe iniciar el contenedor.
 * - Se indica el nombre del bean que se encargar� de manejar la transacci�n. Adem�s para el caso de los tests, por definici�n
 *   siempre debemos regresar al estado de los datos en que iniciamos, as� que al terminar cada test se har� rollback.
 * - Por �ltimo indicamos con @Transactional que todas los test, a menos que indiquemos lo contrario, iniciar�n una transacci�n.
 * 
 * @author Alejandro Pimentel
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/mx/sep/peeare/servicios/config/application-context-test.xml")
@ActiveProfiles("testing")
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=true)
@Transactional
public abstract class BaseServicioTest {

}
