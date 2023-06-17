package participantes;

import nivelesParticipantes.Nivel;
import nivelesParticipantes.NivelExperto;
import ubicacion.Ubicacion;

public class Especialista extends Participante {
	
	public Especialista(Ubicacion u) {
		super(u);
		super.setNivel(new NivelExperto());
	}
	
	@Override
	public void setNivel(Nivel nivel) { 
	}

}
