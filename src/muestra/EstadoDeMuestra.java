package muestra;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import opinion.Opinion;
import opinion.TipoDeOpinion;

public abstract class EstadoDeMuestra {

	public abstract TipoDeOpinion resultadoActual(Muestra muestra);

	protected abstract void verificarOActualizar(Muestra muestra, Opinion opinion);
	
	public TipoDeOpinion tipoConMasCoincidencia(Stream<Opinion> opiniones) {
		List<TipoDeOpinion> tipos = opiniones.map(opinion -> opinion.getTipoDeOpinion()).toList();
		return tipos.stream().collect(Collectors.groupingBy(tipo -> tipo, Collectors.counting()))
				.entrySet().stream().collect(Collectors.maxBy(Map.Entry.comparingByValue())).get().getKey();
	}

	public abstract boolean isExperto();

}
