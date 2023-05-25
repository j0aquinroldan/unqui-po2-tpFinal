package estados;

import muestra.Muestra;
import participantes.Participante;

public class NivelExperto extends Nivel {

	

	@Override
	public void recolectar(Participante participante, Muestra m) {
		// TODO Auto-generated method stub
		
	}

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
	protected void actualizarNivel(Participante p) {
		// TODO Auto-generated method stub
		
	}
	
	

}
