package opinion;

import muestra.EstadoMuestraExperto;
import muestra.Muestra;

public class EstadoOpinionExperto extends EstadoOpinion {

	@Override
	public boolean isBasico() {
		return false;
	}

	@Override
	public boolean isExperto() {
		return true;
	}

	@Override
	public void actualizarMuestra(Muestra muestra) {
		muestra.setEstado(new EstadoMuestraExperto());
	}

}
