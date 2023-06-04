package nivelTest;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import estadosParticipantes.NivelBasico;
import estadosParticipantes.NivelExperto;
import participantes.Participante;

public class NivelBasicoTestCase {
	
	NivelBasico nivelBasico;
	Participante participante;
	
	@BeforeEach
	public void setup() {
		nivelBasico = new NivelBasico();
		participante = mock(Participante.class);
	}
	
	@Test
	public void puedeMantenerSuNivelTest() {
		
		when(participante.cantEnviosDeLosUltimos30Dias(LocalDate.now())).thenReturn(30);
		assertFalse(nivelBasico.puedeMantenerSuNivel(participante));
	}
	
	@Test
	public void puedeMantenerSuNivelTest2() {
		
		when(participante.cantRevisionesDeLosUltimos30Dias(LocalDate.now())).thenReturn(30);
		assertFalse(nivelBasico.puedeMantenerSuNivel(participante));
	}
	
	@Test
	public void actualizarNivelTest() {
		
		when(participante.cantEnviosDeLosUltimos30Dias(LocalDate.now())).thenReturn(30);
		when(participante.cantRevisionesDeLosUltimos30Dias(LocalDate.now())).thenReturn(30);
		nivelBasico.actualizarNivel(participante);
		assertFalse(nivelBasico.puedeMantenerSuNivel(participante));
	}
	
	@Test
	public void actualizarNivelTest2() {
		
		when(participante.cantEnviosDeLosUltimos30Dias(LocalDate.now())).thenReturn(1);
		when(participante.cantRevisionesDeLosUltimos30Dias(LocalDate.now())).thenReturn(1);
		nivelBasico.actualizarNivel(participante);
		assertTrue(nivelBasico.puedeMantenerSuNivel(participante));
	}
	
	

}
