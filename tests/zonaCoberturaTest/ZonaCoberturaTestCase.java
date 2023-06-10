package zonaCoberturaTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import organizacion.Organizacion;
import ubicacion.Ubicacion;
import zonaCobertura.ZonaCobertura;

public class ZonaCoberturaTestCase {
	
	private ZonaCobertura zona;
	private ZonaCobertura zona2;
	private Ubicacion centro;
	private Ubicacion centro2;
	private Organizacion org;
	
	@BeforeEach
	void setup() {
		centro = mock(Ubicacion.class);
		zona = new ZonaCobertura("zona1", centro, 20);
		zona2 = new ZonaCobertura("zona2", centro2, 10);
		org = mock(Organizacion.class);
	}
	
	@Test
	public void getEpicentroTest() {
		assertEquals(centro, zona.getEpicentro());
	}
	
	@Test
	public void getRadioTest() {
		assertEquals(20, zona.getRadio());
	}
	
	@Test
	public void addOrgTest() {
		assertEquals(0, zona.getOrganizaciones().size());
		zona.addOrganizacion(org);
		assertEquals(1, zona.getOrganizaciones().size());
	}
	
	@Test
	public void removeOrgTest() {
		zona.addOrganizacion(org);
		assertEquals(1, zona.getOrganizaciones().size());
		zona.removeOrganizacion(org);
		assertEquals(0, zona.getOrganizaciones().size());
	}
	
	@Test
	/*
	 * en este caso las zonas SI se solapan
	 */
	public void seSolapaTest() {
		
		when(centro.distanciaA(centro2)).thenReturn(5d);
		assertTrue(zona.seSolapaCon(zona2));
	}
	
	@Test
	/*
	 * en este caso las zonas NO se solapan
	 */
	public void seSolapaTest2() {
		
		when(centro.distanciaA(centro2)).thenReturn(50d);
		assertFalse(zona.seSolapaCon(zona2));
	}

}
