package estados;

import muestra.Muestra;
import opinion.Opinion;
import participantes.Participante;

public abstract class Nivel {
	
	public  void opinar(Participante p, Muestra m, String s) {
		//TEMPLATE METHOD
		
		if(!p.yaOpinoSobre(m)) {
			
			Opinion o = new Opinion(s,p);
			p.agregarOpinion(o);
			m.agregarOpinion(o);
			
			this.actualizarNivel(p);
		}
	}

	protected abstract void actualizarNivel(Participante p);

	public abstract void recolectar(Participante participante, Muestra m);
	
	public abstract boolean isBasico();
	public abstract boolean isExperto();
}
