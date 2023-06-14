package organizacion;

import muestra.Muestra;
import zonaCobertura.ZonaCobertura;

public class Organizacion {

	private FuncionalidadExterna funcCarga;
	private FuncionalidadExterna funcValidacion;

	public Organizacion(FuncionalidadExterna funcCarg, FuncionalidadExterna funcValidacion) {
		this.funcCarga = funcCarg;
		this.funcValidacion = funcValidacion;
	}

	public void setFuncCarga(FuncionalidadExterna funcCarga) {
		this.funcCarga = funcCarga;
	}

	public void setFuncValidacion(FuncionalidadExterna funcValidacion) {
		this.funcValidacion = funcValidacion;
	}
	
	public void cargaRealizada(ZonaCobertura zona, Muestra muestra) {
		this.funcCarga.nuevoEvento(this, zona, muestra);
	}
	
	public void validacionRealizada(ZonaCobertura zona, Muestra muestra) {
		this.funcValidacion.nuevoEvento(this, zona, muestra);
	}
	
	public void suscribirseAZona(ZonaCobertura zona) {
		zona.addOrganizacion(this);
	}
	
	public void desuscribirseDeZona(ZonaCobertura zona) {
		zona.removeOrganizacion(this);
	}

}
