package nivelesParticipantes;

import java.time.LocalDate;

import muestra.Muestra;
import opinion.EstadoOpinion;
import opinion.EstadoOpinionExperto;
import participantes.Participante;

public class NivelExperto extends Nivel {

	@Override
	public boolean isBasico() {
		return false;
	}

	@Override
	public boolean isExperto() {
		return true;
	}

	@Override
	public void actualizarNivel(Participante participante) {
		if (this.debeCambiarSuNivel(participante)) {
			participante.setNivel(new NivelBasico());
		}
	}

	public boolean cumpleEnviosSuficientesParaCambiar(Participante participante) {
		return participante.cantEnviosDeLosUltimos30Dias(LocalDate.now()) < 10;
	}

	public boolean cumpleRevisionesSuficientesParaCambiar(Participante participante) {
		return participante.cantRevisionesDeLosUltimos30Dias(LocalDate.now()) < 20;
	}

	@Override
	public boolean puedeOpinar(Muestra m) {
		return true;
	}

	@Override
	public EstadoOpinion estadoDeOpinion() {
		return new EstadoOpinionExperto();
	}

}
