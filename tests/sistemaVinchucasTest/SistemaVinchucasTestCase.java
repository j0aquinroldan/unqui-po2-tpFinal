package sistemaVinchucasTest;
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

import muestra.Muestra;
import sistemaVinchucas.SistemaVinchucas;
import zonaCobertura.ZonaCobertura;

public class SistemaVinchucasTestCase {
	private SistemaVinchucas sistema;
	private ZonaCobertura zona1;
	private ZonaCobertura zona2;
	private Muestra muestra;
	
	@BeforeEach
	public void setUp() {
		this.sistema = new SistemaVinchucas();
		this.zona1 = mock(ZonaCobertura.class);
		this.zona2 = mock(ZonaCobertura.class);
		this.muestra = mock(Muestra.class);
	}
	
	@Test
	public void testSeAgregaUnaZonaAlSistema() {
		this.sistema.agregarZonaAlSistema(zona1);
		assertEquals(1, this.sistema.getListaDeZonasExistentes().size());
	}
	
	@Test
	public void testRemoverZonaDelSistema() {
		this.sistema.agregarZonaAlSistema(zona1);
		this.sistema.removerZonaDelSistema(zona1);
		assertEquals(0, this.sistema.getListaDeZonasExistentes().size());
	}
	
	@Test
	public void testNotificarASusZonasDeCreacionDeMuestra() {
		this.sistema.agregarZonaAlSistema(zona1);
		this.sistema.agregarZonaAlSistema(zona2);
		when(this.zona1.leCorrespondeMuestra(muestra)).thenReturn(true);
		when(this.zona2.leCorrespondeMuestra(muestra)).thenReturn(false);
		this.sistema.muestraCreada(this.muestra);
		verify(this.zona1, times(1)).leCorrespondeMuestra(muestra);
		verify(this.zona2, times(1)).leCorrespondeMuestra(muestra);
		verify(this.zona1, times(1)).seCreoLaMuestra(muestra);
		verify(this.zona2, times(0)).seCreoLaMuestra(muestra);
	}
	
	@Test
	public void testNotificarASusZonasDeVerificacionDeMuestra() {
		this.sistema.agregarZonaAlSistema(zona1);
		this.sistema.agregarZonaAlSistema(zona2);
		when(this.zona1.leCorrespondeMuestra(muestra)).thenReturn(true);
		when(this.zona2.leCorrespondeMuestra(muestra)).thenReturn(false);
		this.sistema.muestraVerificada(this.muestra);
		verify(this.zona1, times(1)).leCorrespondeMuestra(muestra);
		verify(this.zona2, times(1)).leCorrespondeMuestra(muestra);
		verify(this.zona1, times(1)).seVerificoLaMuestra(muestra);
		verify(this.zona2, times(0)).seVerificoLaMuestra(muestra);
	}
}
