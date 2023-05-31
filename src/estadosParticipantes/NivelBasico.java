package estadosParticipantes;

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
	public String toString() {
		return "NivelBasico";
	}

	@Override
	protected void actualizarNivel(Participante participante) {
		//SI NO SE CUMPLE LA CONDICION PARA CONTINUAR, EL NIVEL CAMBIA
		if(!(this.puedeMantenerSuNivel(participante))) {
			participante.setNivel(new NivelExperto());
		}
	} 

	@Override
	public boolean puedeMantenerSuNivel(Participante participante) {
		return participante.revisionesDeLosUltimos30Dias().size() < 20 && participante.enviosDeLosUltimos30Dias().size() < 10;
		//EL PARTICIPANTE DEVUELVE LAS REVISIONES Y ENVIOS DE LOS ULTIMOS 30 DIAS CON UN MENSAJE
		
	}

	@Override
	protected boolean puedeOpinar(Participante p, Muestra m) {
		return m.getOpiniones().stream().allMatch(opinion -> opinion.isBasico());
	}
	

}
