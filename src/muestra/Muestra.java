package muestra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import opinion.Opinion;
import opinion.TipoDeOpinion;
import participantes.Participante;
import ubicacion.Ubicacion;

public class Muestra {
	private boolean verificada;
	private Ubicacion ubicacion;
	private Participante autor;
	private List<Opinion> opiniones;
	private LocalDate fecha;
	private EstadoDeMuestra estado;
	// lista de observers 
	
	//CONSTRUCTORES
	public  Muestra(Participante autor, LocalDate fecha) {
		this.verificada = false;
		this.opiniones = new ArrayList<Opinion>();	
		this.setAutor(autor);
		this.setUbicacion(autor.getUbicacion());
		this.fecha = fecha;
		this.estado = new EstadoMuestraBasico();
		// agregar funcinones del observer
	}
	
	public  Muestra(Participante autor) {
		this.verificada = false;
		this.opiniones = new ArrayList<Opinion>();	
		this.setAutor(autor);
		this.setUbicacion(autor.getUbicacion());
		this.fecha = LocalDate.now();
		this.estado = new EstadoMuestraBasico();
		// agregar funcinones del observer
	}
	
////GETS Y SETS
	
	private void setUbicacion(Ubicacion ubicacion) {
		this.ubicacion = ubicacion;
	}
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	private void setAutor(Participante autor) {
		this.autor = autor;
	}
	
	public Participante getAutor() {
		return autor;
	}
	
	public boolean isVerificada() {
		return verificada;
	}
	
	public List<Opinion> getOpiniones() {
		return this.opiniones;
	}
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setVerificada() {
		this.verificada = true;
	}

	public void setEstado(EstadoDeMuestra estado) {
		this.estado = estado;
	}
	
	public EstadoDeMuestra getEstado() {
		return estado;
	}
	
//// MENSAJES PRINCIPALES

	public TipoDeOpinion resultadoActual() {
		return this.estado.resultadoActual(this);
	}
	
	public void agregarOpinion(Opinion opinion ) {
		
			this.estado.verificarOActualizar(this, opinion);
			this.opiniones.add(opinion);
			// agregar funcinones del observer
	}

	public boolean fueOpinadaPor(Participante participante) {
		return this.getOpiniones().stream().anyMatch(o -> o.getAutor().equals(participante)); // testear t y f
	}

	public boolean soloOpinaronBasicos() {
		return this.getOpiniones().stream().allMatch(opinion -> opinion.isBasico()); // testear t y f
	}

	public List<Opinion> getOpinionesExpertas() {
		return this.opiniones.stream().filter(opinion -> opinion.isExperto()).toList();
	}
	
	public List<Muestra> muestrasQueEstenAUnaDistanciaMenorA(List<Muestra> listaDeMuestras, double kilometros){
		return listaDeMuestras.stream().filter(muestra -> muestra.laMuestraSeEncuentraAMenosDe(this, kilometros)).toList();
	}

	public boolean laMuestraSeEncuentraAMenosDe(Muestra muestra, double kilometros) {
		return this.ubicacion.laUbicacionSeEncuentraAMenosDe(muestra.getUbicacion(), kilometros);
	}
	
	
}
