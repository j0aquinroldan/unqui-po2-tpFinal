package muestra;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import zonaCobertura.ZonaCobertura;

public class SistemaVinchucas {
	private static SistemaVinchucas instanciaUnicaDeSistema;
	private List<ZonaCobertura> listaDeZonasExistentes;
	
	private SistemaVinchucas() {
		this.listaDeZonasExistentes = new ArrayList<ZonaCobertura>();
	}
	
	 public static SistemaVinchucas instanciaUnica() {
	        if (instanciaUnicaDeSistema == null) {
	            instanciaUnicaDeSistema = new SistemaVinchucas();
	        }
	        return instanciaUnicaDeSistema;
	    } //Testear cuando ya hay una instancia o no

	public void muestraCreada(Muestra muestra) {
		this.notificarNuevaMuestraAZonasSiCorresponde(muestra);
	}

	private void notificarNuevaMuestraAZonasSiCorresponde(Muestra muestra) {
		Stream<ZonaCobertura> streamConZonas = this.listaDeZonasExistentes.stream().filter(zona -> zona.ALaZonaLeInteresaLaMuestra(muestra)); // Primero se obtienen las zonas a las que les interesa la nueva muestra.
		streamConZonas.forEach(zonaInteresada -> zonaInteresada.seCreoLaMuestra(muestra));															// A las que les interesa se les notifica.
	}

	public void muestraVerificada(Muestra muestra) {
		this.notificarMuestraVerificadaAZonasSiCorresponde(muestra);
	}

	private void notificarMuestraVerificadaAZonasSiCorresponde(Muestra muestra) {
		Stream<ZonaCobertura> streamConZonas = this.listaDeZonasExistentes.stream().filter(zona -> zona.ALaZonaLeInteresaLaMuestra(muestra)); // Primero se obtienen las zonas a las que les interesa la nueva muestra.
		streamConZonas.forEach(zonaInteresada -> zonaInteresada.seVerificoLaMuestra(muestra));															// A las que les interesa se les notifica.
	}
	
	public void agregarZonaAlSistema(ZonaCobertura zona) {
		this.listaDeZonasExistentes.add(zona);
	}
	
	public void removerZonaDelSistema(ZonaCobertura zona) {
		this.listaDeZonasExistentes.remove(zona);
	}
}
