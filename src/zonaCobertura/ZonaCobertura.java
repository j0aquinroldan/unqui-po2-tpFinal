package zonaCobertura;

import java.util.ArrayList;
import java.util.List;

import muestra.Muestra;
import organizacion.Organizacion;
import sistemaVinchucas.SistemaVinchucas;
import ubicacion.Ubicacion;

public class ZonaCobertura {
	private String nombre; 
	private Ubicacion epicentro;
	private  int radio;
	private List<Muestra> muestrasReportadas;
	private List<Organizacion> organizaciones;

	public ZonaCobertura(String nombre, Ubicacion epicentro, int radio) {
		this.nombre = nombre;
		this.epicentro = epicentro;
		this.radio = radio;
		this.muestrasReportadas = new ArrayList<>();
		this.organizaciones= new ArrayList<>();
		SistemaVinchucas.instanciaUnica().agregarZonaAlSistema(this);
	}
	
	public Ubicacion getEpicentro() {
		return epicentro;
	}
	
	public int getRadio() {
		return radio;
	}
	
	public List<Organizacion> getOrganizaciones() {
		return organizaciones;
	}
	
	public void addOrganizacion(Organizacion org) {
		this.organizaciones.add(org);
	}
	
	public void removeOrganizacion(Organizacion org) {
		this.organizaciones.remove(org);
	}
	
	
	public boolean seSolapaCon(ZonaCobertura zonaB) {
		return this.epicentro.distanciaA(zonaB.getEpicentro()) < this.radio + zonaB.getRadio();
	}

	public void seCreoLaMuestra(Muestra muestra) {
		this.organizaciones.stream().forEach(organizacion -> organizacion.cargaRealizada(this, muestra));
	}

	public void seVerificoLaMuestra(Muestra muestra) {
		this.organizaciones.stream().forEach(organizacion -> organizacion.validacionRealizada(this, muestra));
	}

	public boolean leCorrespondeMuestra(Muestra muestra) {
		return this.getEpicentro().laUbicacionSeEncuentraAMenosDe(muestra.getUbicacion(), this.getRadio());
	}
	
	
}
