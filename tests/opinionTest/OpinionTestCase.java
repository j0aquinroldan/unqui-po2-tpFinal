package opinionTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import nivelesParticipantes.NivelBasico;
import opinion.Opinion;
import opinion.TipoDeOpinion;
import participantes.Participante;

public class OpinionTestCase {
	private Opinion opinion;
	@Mock private Participante participante;
	
	@BeforeEach
	public void setUp() {
		this.participante = mock(Participante.class);
	}
	
	@Test
	public void testConstructor() {
		when(this.participante.getNivel()).thenReturn(new NivelBasico());
		this.opinion = new Opinion(TipoDeOpinion.VINCHUCA_INFESTANS, participante, LocalDate.of(2020, 3, 10));
		assertEquals(TipoDeOpinion.VINCHUCA_INFESTANS, this.opinion.getTipoDeOpinion());
		assertEquals(this.participante, this.opinion.getAutor());
		assertTrue(this.opinion.isBasico());
		assertEquals(LocalDate.of(2020, 3, 10), this.opinion.getFecha());
	}
	
	@Test
	public void testCuandoSuAutorEsExpertoLaOpinionTambienLoEs() {
		when(this.participante.getNivel()).thenReturn(new NivelBasico());
		this.opinion = new Opinion(TipoDeOpinion.VINCHUCA_INFESTANS, participante, LocalDate.of(2020, 3, 10));
		assertTrue(this.opinion.isBasico());
	}
}
