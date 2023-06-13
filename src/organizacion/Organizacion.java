package organizacion;

import muestra.Muestra;
import ubicacion.Ubicacion;
import zonaCobertura.ZonaCobertura;

public class Organizacion {

	private Ubicacion ubicacion;
	private TipoUbicacion tipo;
	private int cantidadEmpleados;
	private FuncionalidadExterna funcCarga;
	private FuncionalidadExterna funcValidacion;

	public Organizacion(Ubicacion ubicacion, TipoUbicacion tipo, int cantidadEmpleados, FuncionalidadExterna funcCarga,
			FuncionalidadExterna funcValidacion) {
		this.ubicacion = ubicacion;
		this.tipo = tipo;
		this.cantidadEmpleados = cantidadEmpleados;
		this.funcCarga = funcCarga;
		this.funcValidacion = funcValidacion;
	}
	
	public Ubicacion getUbicacion() {
		return ubicacion;
	}

	public TipoUbicacion getTipo() {
		return tipo;
	}

	public int getCantidadEmpleados() {
		return cantidadEmpleados;
	}

	public void setFuncCarga(FuncionalidadExterna funcCarga) {
		this.funcCarga = funcCarga;
	}

	public void setFuncValidacion(FuncionalidadExterna funcValidacion) {
		this.funcValidacion = funcValidacion;
	}
	
	public void cargaRealizada(ZonaCobertura zona, Muestra muestra) {
		this.funcCarga.nuevoEvento(this, zona, muestra);
	}
	
	public void validacionRealizada(ZonaCobertura zona, Muestra muestra) {
		this.funcValidacion.nuevoEvento(this, zona, muestra);
	}

}
