package participantes;

import estadosParticipantes.Nivel;
import estadosParticipantes.NivelExperto;
import ubicacion.Ubicacion;

public class Especialista extends Participante {
	
	public Especialista(Ubicacion u) {
		super(u);
		super.setNivel(new NivelExperto());
	}
	
	@Override
	public void setNivel(Nivel nivel) { // no hace nada porque no puede cambiar su nivel 
	}

}
