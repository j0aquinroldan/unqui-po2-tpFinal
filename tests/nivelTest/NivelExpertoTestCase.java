package nivelTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import estadosParticipantes.NivelExperto;
import participantes.Participante;

public class NivelExpertoTestCase {
	
	NivelExperto nivelExperto;
	Participante participante;
	
	@BeforeEach
	public void setup() {
		nivelExperto = new NivelExperto();
		participante = mock(Participante.class);
	}
	
	@Test
	public void puedeMantenerSuNivelTest() {
		
		when(participante.cantEnviosDeLosUltimos30Dias(LocalDate.now())).thenReturn(0);
		assertFalse(nivelExperto.debeCambiarSuNivel(participante));
	}
	
	@Test
	public void puedeMantenerSuNivelTest2() {
		
		when(participante.cantRevisionesDeLosUltimos30Dias(LocalDate.now())).thenReturn(0);
		assertFalse(nivelExperto.debeCambiarSuNivel(participante));
	}
	
	@Test
	public void actualizarNivelTest() {
		
		when(participante.cantEnviosDeLosUltimos30Dias(LocalDate.now())).thenReturn(30);
		when(participante.cantRevisionesDeLosUltimos30Dias(LocalDate.now())).thenReturn(30);
		nivelExperto.actualizarNivel(participante);
		assertTrue(nivelExperto.debeCambiarSuNivel(participante));
	}
	
	@Test
	public void actualizarNivelTest2() {
		
		when(participante.cantEnviosDeLosUltimos30Dias(LocalDate.now())).thenReturn(1);
		when(participante.cantRevisionesDeLosUltimos30Dias(LocalDate.now())).thenReturn(1);
		nivelExperto.actualizarNivel(participante);
		assertFalse(nivelExperto.debeCambiarSuNivel(participante));
	}
	
	@Test
	public void isBasicoTest() {
		assertFalse(nivelExperto.isBasico());
	}
	
	@Test
	public void isExpertoTest() {
		assertTrue(nivelExperto.isExperto());
	}
	
	@Test
	public void puedeOpinarTest() {
		assertTrue(nivelExperto.puedeOpinar(null));
	}
	

}