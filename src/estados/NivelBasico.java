package estados;

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
	public void recolectar(Participante participante, Muestra m) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void actualizarNivel(Participante p) {
		if(p.getRevisiones().size() >20 && p.getEnvios().size()>10) {
			// FALTA VALIDAR LAS FECHAS DE REVISIONES Y ENVIOS
			p.setNivel(new NivelExperto());
		}
	}
	
	

}
