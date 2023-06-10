package muestraTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import muestra.EstadoMuestraBasico;
import muestra.EstadoMuestraExperto;
import muestra.Muestra;
import opinion.Opinion;
import opinion.TipoDeOpinion;
import participantes.Participante;

public class EstadoMuestraBasicoTestCase {
	private EstadoMuestraBasico estadoBasico;
	@Mock private Muestra muestra;
	@Mock private Opinion op1;
	@Mock private Opinion op2;
	@Mock private Opinion op3;
	@Mock private Opinion op4;
	@Mock private Opinion op5;
	
	@BeforeEach
	public void setUp() {
		this.estadoBasico = new EstadoMuestraBasico();
		this.muestra = mock(Muestra.class);
		this.op1 = mock(Opinion.class);
		this.op2 = mock(Opinion.class);
		this.op3 = mock(Opinion.class);
		this.op4 = mock(Opinion.class);
		this.op5 = mock(Opinion.class);
	}
	
	@Test
	public void testElEstadoSeActualizaDeBasicoAExperto() {
		Muestra muestraParaTestear = new Muestra(mock(Participante.class)); //Se creo una instancia particular de Muestra para poder testear el cambio de estado de forma dinamica
		when(this.op3.isExperto()).thenReturn(true);
		this.estadoBasico.verificarOActualizar(muestraParaTestear, op3);
		assertTrue(muestraParaTestear.getEstado().isExperto());
	}
	@Test
	public void testElEstadoNoSeActualizaDeBasicoAExperto() {
		Muestra muestraParaTestear = new Muestra(mock(Participante.class)); //Se creo una instancia particular de Muestra para poder testear el cambio de estado de forma dinamica
		when(this.op3.isExperto()).thenReturn(false);
		this.estadoBasico.verificarOActualizar(muestraParaTestear, op3);
		assertFalse(muestraParaTestear.getEstado().isExperto());
	}
	
	@Test 
	public void testEsExpertoFalso(){
		assertFalse(this.estadoBasico.isExperto());
	}
	
	@Test
	public void testTipoDeOpinionConMasCoincidencias() {
		when(this.op1.getTipoDeOpinion()).thenReturn(TipoDeOpinion.VINCHUCA_GUASAYANA);
		when(this.op2.getTipoDeOpinion()).thenReturn(TipoDeOpinion.VINCHUCA_GUASAYANA);
		when(this.op3.getTipoDeOpinion()).thenReturn(TipoDeOpinion.IMAGEN_POCO_CLARA);
		when(this.op4.getTipoDeOpinion()).thenReturn(TipoDeOpinion.VINCHUCA_GUASAYANA);
		when(this.op5.getTipoDeOpinion()).thenReturn(TipoDeOpinion.IMAGEN_POCO_CLARA);
		Stream <Opinion> streamDeOpiniones = Arrays.asList(op1,op2,op3,op4,op5).stream();
		assertEquals(TipoDeOpinion.VINCHUCA_GUASAYANA, this.estadoBasico.tipoConMasCoincidencia(streamDeOpiniones)); //En caso de empate, devuelve el primer par que se repita
	}
}