package organizacion;

import muestra.Muestra;
import zonaCobertura.ZonaCobertura;

public class FuncionalidadDePrueba implements FuncionalidadExterna {

	@Override
	public void nuevoEvento(Organizacion org, ZonaCobertura zona, Muestra muestra) {
		// este metodo esta vacio ya que esta clase solo fue implementada con el fin de testear la clase Organizacion
	}

}
