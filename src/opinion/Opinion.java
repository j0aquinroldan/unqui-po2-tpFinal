package opinion;

import java.time.LocalDate;

import nivelesParticipantes.Nivel;
import participantes.Participante;

public class Opinion {
	private TipoDeOpinion tipoDeOpinion;
	private EstadoOpinion estado;
	private Participante autor;
	private LocalDate fechaDeCreacion;

	public Opinion(TipoDeOpinion tipoDeOpinion, Participante autor, LocalDate fechaDeCreacion) {
		this.tipoDeOpinion = tipoDeOpinion;
		this.autor = autor;
		this.estado = autor.getNivel().estadoDeOpinion(); 
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
		return getEstado().isBasico();
	}

	public boolean isExperto() {
		return getEstado().isExperto();
	}

	public EstadoOpinion getEstado() {
		return estado;
	}

}
