package organizacion;

import muestra.Muestra;
import zonaCobertura.ZonaCobertura;

public class FuncionalidadDePrueba implements FuncionalidadExterna {

	@Override
	public void nuevoEvento(Organizacion org, ZonaCobertura zona, Muestra muestra) {
		// este metodo es vacio ya que toda la clase su utiliza solamente para testear Organizacion

	}

}
