package estadosParticipantes;

import java.time.LocalDate;

import muestra.Muestra;
import opinion.Opinion;
import opinion.TipoDeOpinion;
import participantes.Participante;

public abstract class Nivel {
	
	public void opinar(Participante p, Muestra m, TipoDeOpinion tipoDeOpinion, LocalDate fechaDeCreacion) {
		//TEMPLATE METHOD
		
		if(!m.fueOpinadaPor(p) && this.puedeOpinar(m) && !m.isVerificada()) {
			
			Opinion o = new Opinion(tipoDeOpinion,p, fechaDeCreacion);
			//STATE DE MUESTRA SE ENCARGA DE AGREGAR LA OPINION, 3 ESTADOS DIFERENTES DE LA MUESTRA
			p.agregarOpinion(o); // test size opiniones
			m.agregarOpinion(o); // verify mensaje enviado
			
			this.actualizarNivel(p); // asset niuvel esperado
		}
	}


	protected abstract void actualizarNivel(Participante p);

	public void recolectar(Participante participante, Muestra muestra) {
		participante.agregarMuestra(muestra); // test size muestras
		this.actualizarNivel(participante); // asset niuvel esperado
	}
	
	public abstract boolean puedeMantenerSuNivel(Participante participante);
	
	public abstract boolean isBasico();
	public abstract boolean isExperto();

	protected abstract boolean puedeOpinar(Muestra m) ;
}

