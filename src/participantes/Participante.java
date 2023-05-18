package participantes;

import java.util.ArrayList;
import java.util.List;

import estados.Nivel;
import estados.NivelBasico;
import muestra.Muestra;
import opinion.Opinion;
import ubicacion.Ubicacion;

public class Participante {
	
	private Nivel nivel;
	private Ubicacion ubicacion;
	private List<Muestra> envios;
	private List<Opinion> revisiones;
	
	public  Participante(){
		nivel = new NivelBasico();
		envios = new ArrayList<>();
		revisiones = new ArrayList<>();
	}
	
	public  Participante(Ubicacion ubicacion){
		nivel = new NivelBasico();
		this.ubicacion = ubicacion;
	}
	
	
	// GETS Y SETS
	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	public List<Opinion> getRevisiones() {
		return revisiones;
	}
	
	public List<Muestra> getEnvios() {
		return envios;
	}
	
	
	// OTROS MENSAJES
	public void recolectar(Muestra m) {
		this.nivel.recolectar(this, m);
		this.envios.add(m);
	}

	public void opinar(Muestra m, String s) {
		this.nivel.opinar(this, m, s);
		// nivel tiene que agregar opinion a la list de revisipones
	}

	public Nivel getNivel() {
		return this.nivel;
	}
	
	public void agregarOpinion(Opinion o) {
		this.revisiones.add(o);
	}

	public boolean yaOpinoSobre(Muestra m) {
		return m.getOpiniones().stream().anyMatch(o -> o.getAutor().equals(this));
	}
}
