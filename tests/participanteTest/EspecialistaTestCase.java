package participanteTest;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.jupiter.api.Test;

import nivelesParticipantes.NivelBasico;
import participantes.Especialista;
import ubicacion.Ubicacion;

public class EspecialistaTestCase {
	
	@Test
	public void setNivelTest() {
		
		Especialista e = new Especialista(mock(Ubicacion.class));
		
		assertTrue(e.getNivel().isExperto());
		
		e.setNivel(new NivelBasico());
		
		assertTrue(e.getNivel().isExperto());
		
	}
}
