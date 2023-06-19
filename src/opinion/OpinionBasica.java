package opinion;

import java.time.LocalDate;

import muestra.Muestra;
import participantes.Participante;

public class OpinionBasica extends Opinion {

	public OpinionBasica(TipoDeOpinion tipoDeOpinion, Participante autor, LocalDate fechaDeCreacion) {
		super(tipoDeOpinion, autor, fechaDeCreacion);
	}

	@Override
	public boolean isBasico() {
		return true;
	}

	@Override
	public boolean isExperto() {
		return false;
	}

	@Override
	public void actualizarMuestra(Muestra muestra) {
		
	}

}
