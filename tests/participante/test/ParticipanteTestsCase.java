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
	
	Participante participante;
	Ubicacion ubicacion;
	NivelBasico nb;
	
	@BeforeEach
	public void setup() {
		ubicacion = mock(Ubicacion.class);
		nb = mock(NivelBasico.class);
		participante = new Participante(ubicacion);
	}
	
	
	/*
	 * al crearse se le asgina una instancia de NivelBasico
	 */
	@Test
	public void constructorTest() {
		assertEquals(ubicacion, participante.getUbicacion()); // misma ubicacion con la que se seteo
		assertTrue(participante.getNivel().isBasico());
	}
	
	/*
	 * cuando un se genera una opinion, esta considera el estado del participante(básico o experto) al
	 *	momento del voto
	 */
	@Test
	public void opinionMantieneElNivelConElQueFueCreada() {
//		participante.setNivel(new NivelBasico());
		Opinion op = new Opinion(TipoDeOpinion.CHINCHE_FOLIADA, participante, LocalDate.now());
		participante.setNivel(new NivelExperto());
		assertTrue(op.isBasico()); 
	}
	
	@Test
	public void setUbicacionTest() {
		participante.setUbicacion(ubicacion);
		assertEquals(ubicacion, participante.getUbicacion());
	}
	
	
	
}
