package opinion;

import muestra.Muestra;

public class EstadoOpinionBasico extends EstadoOpinion {

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
