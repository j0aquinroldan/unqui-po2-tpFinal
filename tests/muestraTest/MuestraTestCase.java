package muestraTest;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import muestra.EstadoDeMuestra;
import muestra.EstadoMuestraBasico;
import muestra.Muestra;
import opinion.Opinion;
import opinion.TipoDeOpinion;
import participantes.Participante;
import ubicacion.Ubicacion;

public class MuestraTestCase {
	
	 Muestra muestra;
	 Participante p;
	 Ubicacion u;
	 EstadoDeMuestra estadoBasico;
	
	@BeforeEach
	public void setup() {
		p = new Participante(); // es un DOC, por tanto podria ser un mock pero no funciona
		u = mock(Ubicacion.class);
		p.setUbicacion(u);
		muestra = new Muestra(p);
		this.estadoBasico = mock(EstadoMuestraBasico.class);
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

	@Test
	public void testAlPedirElResultadoActualDeLaMuestraSeDelegaASuEstado() {
		this.muestra.setEstado(this.estadoBasico); // Este estado se setea como un mock solo para poder verificar que recibe el mensaje
		this.muestra.resultadoActual();
		verify(this.muestra.getEstado(), times(1)).resultadoActual(this.muestra);
	}
	
	
	@Test
	public void testLaMuestraFueOpinadaPorUnParticipanteEnEspecifico() {
		this.p.opinar(muestra, TipoDeOpinion.CHINCHE_FOLIADA, LocalDate.now());
		assertTrue(this.muestra.fueOpinadaPor(p));
	}
	
	@Test
	public void testLaMuestraNoFueOpinadaPorUnParticipanteEnEspecifico() {
		assertFalse(this.muestra.fueOpinadaPor(p));
	}
	
	@Test
	public void testSoloOpinaronBasicosVerdadero() {
		Opinion opinion1 = mock(Opinion.class);
		Opinion opinion2 = mock(Opinion.class);
		when(opinion1.isBasico()).thenReturn(true);
		when(opinion2.isBasico()).thenReturn(true);
		this.muestra.agregarOpinion(opinion1);
		this.muestra.agregarOpinion(opinion2);
		assertTrue(this.muestra.soloOpinaronBasicos());
	}
	
	@Test
	public void testSoloOpinaronBasicosFalso() {
		Opinion opinion1 = mock(Opinion.class);
		Opinion opinion2 = mock(Opinion.class);
		when(opinion1.isBasico()).thenReturn(false);
		when(opinion2.isBasico()).thenReturn(true);
		this.muestra.agregarOpinion(opinion1);
		this.muestra.agregarOpinion(opinion2);
		assertFalse(this.muestra.soloOpinaronBasicos());
	}
	
	@Test
	public void testGetOpinionesExpertas() {
		Opinion opinion1 = mock(Opinion.class);
		Opinion opinion2 = mock(Opinion.class);
		when(opinion1.isExperto()).thenReturn(false);
		when(opinion2.isExperto()).thenReturn(true);
		this.muestra.agregarOpinion(opinion1);
		this.muestra.agregarOpinion(opinion2);
		
		assertEquals(opinion2, this.muestra.getOpinionesExpertas().get(0));
	}
}
