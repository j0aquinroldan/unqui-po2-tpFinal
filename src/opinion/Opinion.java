package opinion;

import java.time.LocalDate;

import estadosParticipantes.Nivel;
import participantes.Participante;

public class Opinion {
	private TipoDeOpinion tipoDeOpinion;
	private Nivel nivel;
	private Participante autor;
	private LocalDate fechaDeCreacion;

	public Opinion(TipoDeOpinion tipoDeOpinion, Participante autor, LocalDate fechaDeCreacion) {
		this.tipoDeOpinion = tipoDeOpinion;
		this.autor = autor;
		this.nivel = autor.getNivel(); 
		this.fechaDeCreacion = fechaDeCreacion;
	}

	public Participante getAutor() {
		return autor;
	}

	public LocalDate getFecha() {
		return this.fechaDeCreacion;
	}

	public TipoDeOpinion getTipoDeOpinion() {
		return tipoDeOpinion;
	}

	public boolean isBasico() {
		return nivel.isBasico();
	}

	public boolean isExperto() {
		return nivel.isExperto();
	}

}
