package participante.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import estadosParticipantes.NivelBasico;
import estadosParticipantes.NivelExperto;
import opinion.TipoDeOpinion;
import opinion.Opinion;
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
	
	@Test
	public void sd() {
		p.setNivel(new NivelBasico());
		Opinion op = new Opinion(TipoDeOpinion.CHINCHE_FOLIADA, p, LocalDate.now());
		p.setNivel(new NivelExperto());
		assertTrue(op.isBasico()); 
	}
	
	
}
