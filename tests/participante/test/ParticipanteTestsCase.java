package participante.test;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import estadosParticipantes.Nivel;
import estadosParticipantes.NivelBasico;
import estadosParticipantes.NivelExperto;
import muestra.Muestra;
import opinion.Opinion;
import opinion.TipoDeOpinion;
import participantes.Participante;
import ubicacion.Ubicacion;

public class ParticipanteTestsCase {

	Participante participante;
	Ubicacion ubicacion;
	NivelBasico nb;
	Opinion opinion;
	Muestra muestra;

	@BeforeEach
	public void setup() {
		ubicacion = mock(Ubicacion.class);
		nb = mock(NivelBasico.class);
		participante = new Participante(ubicacion);
		opinion = mock(Opinion.class);
		muestra = mock(Muestra.class);
	}

	/*
	 * al crearse se le asgina una instancia de NivelBasico
	 */
	@Test
	public void constructorTest() {
		assertEquals(ubicacion, participante.getUbicacion()); // misma ubicacion con la que se seteo
		assertTrue(participante.getNivel().isBasico());
	}

	@Test
	public void constructorVacioTest() {
		participante = new Participante();
		assertTrue(participante.getEnvios().isEmpty());
		assertTrue(participante.getRevisiones().isEmpty());
		assertTrue(participante.getNivel().isBasico());
	}

	/*
	 * cuando un se genera una opinion, esta considera el estado del
	 * participante(básico o experto) al momento del voto
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

//	@Test
//	public void getRevisionesTest() {
//
//		assertEquals(new ArrayList<>(), participante.getRevisiones());
//	}
//
//	@Test
//	public void getEnviosTest() {
//
//		assertEquals(new ArrayList<>(), participante.getEnvios());
//	}

	@Test
	public void agregarMuestraTest() {

		participante.agregarMuestra(muestra);
		assertEquals(Arrays.asList(muestra), participante.getEnvios());
	}

	@Test
	public void agregarOpinionTest() {

		participante.agregarOpinion(opinion);
		assertEquals(Arrays.asList(opinion), participante.getRevisiones());
	}

	@Test
	public void revisionesDeLosUltimos30DiasTest() {

		participante.agregarOpinion(opinion);

		when(opinion.getFecha()).thenReturn(LocalDate.of(2023, 6, 4)); // en este caso la opinion se hace en el mismo
																		// dia
		assertEquals(Arrays.asList(opinion), participante.revisionesDeLosUltimos30Dias(LocalDate.of(2023, 6, 4)));

		when(opinion.getFecha()).thenReturn(LocalDate.of(2022, 6, 4));// en este caso la opinion se un año antes
		assertEquals(Arrays.asList(), participante.revisionesDeLosUltimos30Dias(LocalDate.of(2023, 6, 4)));
	}

	@Test
	public void enviosDeLosUltimos30DiasTest() {

		participante.agregarMuestra(muestra);

		when(muestra.getFecha()).thenReturn(LocalDate.of(2023, 6, 4)); // en este caso la muestra se hace en el mismo
																		// dia
		assertEquals(Arrays.asList(muestra), participante.enviosDeLosUltimos30Dias(LocalDate.of(2023, 6, 4)));

		when(muestra.getFecha()).thenReturn(LocalDate.of(2022, 6, 4));// en este caso la muestra se un año antes
		assertEquals(Arrays.asList(), participante.enviosDeLosUltimos30Dias(LocalDate.of(2023, 6, 4)));
	}

	@Test
	public void cantEnviosDeLosUltimos30DiasTest() {

		participante.agregarMuestra(muestra);

		when(muestra.getFecha()).thenReturn(LocalDate.of(2023, 6, 4)); // en este caso la muestra se hace en el mismo
																		// dia
		assertEquals(1, participante.cantEnviosDeLosUltimos30Dias(LocalDate.of(2023, 6, 4)));

		when(muestra.getFecha()).thenReturn(LocalDate.of(2022, 6, 4));// en este caso la muestra se un año antes
		assertEquals(0, participante.cantEnviosDeLosUltimos30Dias(LocalDate.of(2023, 6, 4)));
	}

	@Test
	public void cantRevisionesDeLosUltimos30DiasTest() {

		participante.agregarOpinion(opinion);

		when(opinion.getFecha()).thenReturn(LocalDate.of(2023, 6, 4)); // en este caso la muestra se hace en el mismo
																		// dia
		assertEquals(1, participante.cantRevisionesDeLosUltimos30Dias(LocalDate.of(2023, 6, 4)));

		when(opinion.getFecha()).thenReturn(LocalDate.of(2022, 6, 4));// en este caso la muestra se un año antes
		assertEquals(0, participante.cantRevisionesDeLosUltimos30Dias(LocalDate.of(2023, 6, 4)));
	}

	@Test
	public void opinarTest() {
		Nivel nivelMock = mock(NivelBasico.class);
		participante.setNivel(nivelMock);

		participante.opinar(muestra, TipoDeOpinion.CHINCHE_FOLIADA, LocalDate.of(2023, 6, 4));

		verify(nivelMock).opinar(participante, muestra, TipoDeOpinion.CHINCHE_FOLIADA, LocalDate.of(2023, 6, 4));
	}

}
