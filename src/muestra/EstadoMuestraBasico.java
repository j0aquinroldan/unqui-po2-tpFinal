package muestra;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import opinion.Opinion;
import opinion.TipoDeOpinion;

public class EstadoMuestraBasico extends EstadoDeMuestra {

	@Override
	public TipoDeOpinion resultadoActual(Muestra muestra) {
		
		Stream<Opinion> opiniones = muestra.getOpiniones().stream(); // toma todas las opiniones de la muestra (solo hay basicos)
		
		return tipoConMasCoincidencia(opiniones);
	}

	@Override
	protected void verificarOActualizar(Muestra muestra, Opinion opinion) {
		// actualiza el estado de la muestra si puede (opinion es de experto)
		if (opinion.isExperto()) {
			muestra.setEstado(new EstadoMuestraExperto());
		}
	}
	

}