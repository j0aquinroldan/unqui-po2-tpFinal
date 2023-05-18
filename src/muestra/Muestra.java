package muestra;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import opinion.Opinion;
import participantes.Participante;
import ubicacion.Ubicacion;

public class Muestra {
	private boolean verificada;
	private Ubicacion ubicacion;
	private Participante autor;
	private List<Opinion> opiniones;
	private LocalDate fecha;
	// lista de observers
	

	public  Muestra(Participante autor, LocalDate fecha) {
		this.verificada = false;
		this.opiniones = new ArrayList<Opinion>();	
		this.setAutor(autor);
		this.setUbicacion(autor.getUbicacion());
		this.fecha = fecha;
		// agregar funcinones del observer
	}
	
	public  Muestra(Participante autor) {
		this.verificada = false;
		this.opiniones = new ArrayList<Opinion>();	
		this.setAutor(autor);
		this.setUbicacion(autor.getUbicacion());
		this.fecha = LocalDate().now();
		// agregar funcinones del observer
	}
	
	private LocalDate LocalDate() {
		// TODO Auto-generated method stub
		return null;
	}

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

	public void agregarOpinion(Opinion o ) {
		this.opiniones.add(o);
		// agregar funcinones del observer
	}

	public List<Opinion> getOpiniones() {
		return this.opiniones;
	}
	
	
	
	
}
