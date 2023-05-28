package muestraTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import muestra.Muestra;
import participantes.Participante;
import ubicacion.Ubicacion;

public class MuestraTestCase {
	
	Muestra muestra;
	 Participante p;
	 Ubicacion u;
	
	@BeforeEach
	public void setup() {
		p = new Participante(); // es un DOC, por tanto podria ser un mock pero no funciona
		u = mock(Ubicacion.class);
		p.setUbicacion(u);
		muestra = new Muestra(p);
	}
	
	@Test
	public void getAutor() {
		assertEquals(p, muestra.getAutor());
	}
	 
	/*
	 * cuando se crea una muestra se asigna un autor y su ubicacion, no esta verificada y la lista de opiniones vacia
	 */
	@Test
	public void testConstructor() {
		
		//when(p.getUbicacion()).thenReturn(u);
		
		assertEquals(p, muestra.getAutor());
		assertEquals(u, muestra.getUbicacion());
		assertFalse(muestra.isVerificada());
		assertTrue(muestra.getOpiniones().isEmpty());
	}

/*
 *  LO BASICO DE MUESTRA CODSEADO Y TESTEADO FALTA RESULTADO ACTUAL ETC
 */

}
