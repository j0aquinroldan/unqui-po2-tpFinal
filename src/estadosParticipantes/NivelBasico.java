package estadosParticipantes;

import java.time.LocalDate;

import muestra.Muestra;
import participantes.Participante;

public class NivelBasico extends Nivel {
	@Override
	public boolean isBasico() {
		return true;
	}

	@Override
	public boolean isExperto() {
		return false;
	}

	@Override
	public void actualizarNivel(Participante participante) {
		//SI NO SE CUMPLE LA CONDICION PARA CONTINUAR, EL NIVEL CAMBIA
		if(this.debeCambiarSuNivel(participante)) {
			participante.setNivel(new NivelExperto());
		}
	} 

	@Override
	public boolean debeCambiarSuNivel(Participante participante) {
		return (participante.cantRevisionesDeLosUltimos30Dias(LocalDate.now())) < 20 && (participante.cantEnviosDeLosUltimos30Dias(LocalDate.now()) < 10);
	}

	@Override
	protected boolean puedeOpinar(Muestra m) {
		return m.soloOpinaronBasicos();
	}

	public boolean cumpleEnviosSuficientesParaCambiar(Participante participante) {
		return participante.cantEnviosDeLosUltimos30Dias(LocalDate.now()) > 10;
	}

	public boolean cumpleRevisionesSuficientesParaCambiar(Participante participante) {
		return participante.cantRevisionesDeLosUltimos30Dias(LocalDate.now()) > 20;
	}
	

}
