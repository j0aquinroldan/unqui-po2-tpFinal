package participante.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import estados.NivelBasico;
import participantes.Participante;
import ubicacion.Ubicacion;

public class ParticipanteTestsCase {
	
	Participante p;
	Ubicacion u;
	NivelBasico nb;
	
	@BeforeEach
	public void setup() {
		u = mock(Ubicacion.class);
		nb = mock(NivelBasico.class);
		p = new Participante(u);
	}
	
	
	/*
	 * al crearse se le asgina una instancia de NivelBasico
	 */
	@Test
	public void constructorTest() {
		assertEquals(u, p.getUbicacion());
		assertTrue(p.getNivel().isBasico());
	}

	
}
