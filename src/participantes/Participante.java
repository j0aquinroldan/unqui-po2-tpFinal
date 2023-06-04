package participantes;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import estadosParticipantes.Nivel;
import estadosParticipantes.NivelBasico;
import muestra.Muestra;
import opinion.Opinion;
import opinion.TipoDeOpinion;
import ubicacion.Ubicacion;

public class Participante {

	private Nivel nivel;
	private Ubicacion ubicacion;
	private List<Muestra> envios;
	private List<Opinion> revisiones;

	public Participante() {
		nivel = new NivelBasico();
		envios = new ArrayList<>();
		revisiones = new ArrayList<>();
	}

	public Participante(Ubicacion ubicacion) {
		nivel = new NivelBasico();
		envios = new ArrayList<>();
		revisiones = new ArrayList<>();
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
	public void recolectar(TipoDeOpinion tipo, LocalDate fecha) {
		Muestra muestra = new Muestra(this, fecha);
		this.opinar(muestra, tipo, fecha);
		this.nivel.recolectar(this, muestra);
	}

	public void opinar(Muestra m, TipoDeOpinion tipo, LocalDate fechaDeCreacion) {
		this.nivel.opinar(this, m, tipo, fechaDeCreacion);
		// nivel tiene que agregar opinion a la list de revisiones
	}

	public Nivel getNivel() {
		return this.nivel;
	}

	public void agregarOpinion(Opinion o) {
		this.revisiones.add(o);
	}

	public List<Muestra> enviosDeLosUltimos30Dias(LocalDate fecha) {
		/*
		 * el parametro fecha debe ser LocalDate.now()
		 */
		return this.envios.stream().filter(muestra -> muestra.getFecha().isAfter(fecha.minusDays(30)))
				.toList();
	}

	public List<Opinion> revisionesDeLosUltimos30Dias(LocalDate fecha) {
		return this.revisiones.stream().filter(opinion -> opinion.getFecha().isAfter(fecha.minusDays(30)))
				.toList();
	}

	public void agregarMuestra(Muestra muestra) {
		this.envios.add(muestra);
	}

	public int cantRevisionesDeLosUltimos30Dias(LocalDate fecha) {
		return this.revisionesDeLosUltimos30Dias(fecha).size();
	}

	public int cantEnviosDeLosUltimos30Dias(LocalDate fecha) {
		return this.enviosDeLosUltimos30Dias(fecha).size();
	}
}
