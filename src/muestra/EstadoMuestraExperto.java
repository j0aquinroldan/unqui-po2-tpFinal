package muestra;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import opinion.Opinion;
import opinion.TipoDeOpinion;

public class EstadoMuestraExperto extends EstadoDeMuestra {

	@Override
	public TipoDeOpinion resultadoActual(Muestra muestra) {
		
		Stream<Opinion> opiniones = muestra.getOpiniones().stream().filter(opinion -> opinion.isExperto());// filtra las opiniones de la muestra que sean expertos
		
		return tipoConMasCoincidencia(opiniones);
	}

	@Override
	public void verificarOActualizar(Muestra muestra, Opinion opinion) {
		// Verifica la muestra en caso de que se pueda.
		boolean anyMatch = muestra.getOpinionesExpertas().stream().anyMatch(opMuestra->opMuestra.getTipoDeOpinion().equals(opinion.getTipoDeOpinion()));
		if(anyMatch) {
			muestra.setVerificada();
		}
	}

	@Override
	public boolean isExperto() {
		// TODO Auto-generated method stub
		return true;
	} 

}
