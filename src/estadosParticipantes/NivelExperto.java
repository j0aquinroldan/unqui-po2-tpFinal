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
	public String toString() {
		return "NivelExperto";
	}

	@Override
	protected void actualizarNivel(Participante participante) {
		// SI NO SE CUMPLE LA CONDICION PARA CONTINUAR, EL NIVEL CAMBIA
		if (!(this.puedeMantenerSuNivel(participante))) {
			participante.setNivel(new NivelBasico());
		}
	}

	@Override
	public boolean puedeMantenerSuNivel(Participante participante) {
		return participante.cantRevisionesDeLosUltimos30Dias(LocalDate.now()) > 20 && participante.cantEnviosDeLosUltimos30Dias(LocalDate.now()) > 10;
		// EL PARTICIPANTE DEVUELVE LAS REVISIONES Y ENVIOS DE LOS ULTIMOS 30 DIAS CON
		// UN MENSAJE

	}

	@Override
	protected boolean puedeOpinar(Muestra m) {
		return true;
	}

}
