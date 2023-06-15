package estadosParticipantes;

import java.time.LocalDate;

import muestra.Muestra;
import opinion.Opinion;
import opinion.TipoDeOpinion;
import participantes.Participante;

public abstract class Nivel {
	
	public void opinar(Participante p, Muestra m, TipoDeOpinion tipoDeOpinion, LocalDate fechaDeCreacion) {
		
		if(!m.fueOpinadaPor(p) && this.puedeOpinar(m) && !m.isVerificada()) {
			
			Opinion o = new Opinion(tipoDeOpinion,p, fechaDeCreacion);
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

	protected abstract boolean puedeOpinar(Muestra m) ;
}

