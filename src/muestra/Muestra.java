package muestra;

import java.time.LocalDate;
import java.util.ArrayList;
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
	
//// MENSAJES PRINCIPALES

	public TipoDeOpinion resultadoActual() {
		return this.estado.resultadoActual(this);
	}
	
	public void agregarOpinion(Opinion opinion ) {
		
			this.estado.verificarOActualizar(this, opinion);
			this.opiniones.add(opinion);
			// agregar funcinones del observer
	}
	
}
