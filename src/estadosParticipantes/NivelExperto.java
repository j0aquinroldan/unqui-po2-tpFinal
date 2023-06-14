package estadosParticipantes;

import java.time.LocalDate;

import muestra.Muestra;
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
		if (!(this.puedeMantenerSuNivel(participante))) {
			participante.setNivel(new NivelBasico());
		}
	}

	@Override
	public boolean puedeMantenerSuNivel(Participante participante) {
		return participante.cantRevisionesDeLosUltimos30Dias(LocalDate.now()) > 20
				&& participante.cantEnviosDeLosUltimos30Dias(LocalDate.now()) > 10;
	}

	@Override
	public boolean puedeOpinar(Muestra m) {
		return true;
	}

}
