package opinion;

import java.time.LocalDate;

import estados.Nivel;
import participantes.Participante;

public class Opinion {
	private TipoDeOpinion tipoDeOpinion;
	private Nivel nivel;
	private Participante autor;
	private LocalDate fechaDeCreacion;
	
	public Opinion(TipoDeOpinion tipodeopinion, Participante autor, LocalDate fechaDeCreacion) {
		this.tipoDeOpinion = tipoDeOpinion;
		this.autor= autor; 
		this.nivel = autor.getNivel(); // REVISAR
	}

	public Participante getAutor() {
		return autor;
	}

	public LocalDate getFecha() {
		// TODO Auto-generated method stub
		return this.fechaDeCreacion;
	}
	
	public TipoDeOpinion getTipoDeOpinion() {
		return tipoDeOpinion;
	}
	
	public Nivel getNivel() {
		return nivel;
	}

}
