package estados;

import java.time.LocalDate;

import muestra.Muestra;
import opinion.Opinion;
import opinion.TipoDeOpinion;
import participantes.Participante;

public abstract class Nivel {
	
	public void opinar(Participante p, Muestra m, TipoDeOpinion tipoDeOpinion, LocalDate fechaDeCreacion) {
		//TEMPLATE METHOD
		
		if(!p.yaOpinoSobre(m)) {
			
			Opinion o = new Opinion(tipoDeOpinion,p, fechaDeCreacion);
			//STATE DE MUESTRA SE ENCARGA DE AGREGAR LA OPINION, 3 ESTADOS DIFERENTES DE LA MUESTRA
			p.agregarOpinion(o);
			m.agregarOpinion(o);
			
			this.actualizarNivel(p); 
		}
	}

	protected abstract void actualizarNivel(Participante p);

	public void recolectar(Participante participante, Muestra muestra) {
		participante.agregarMuestra(muestra);
		this.actualizarNivel(participante);
	}
	
	public abstract boolean puedeMantenerSuNivel(Participante participante);
	
	public abstract boolean isBasico();
	public abstract boolean isExperto();
}

