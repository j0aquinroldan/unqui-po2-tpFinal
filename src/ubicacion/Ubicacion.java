package ubicacion;

import java.util.List;

public class Ubicacion {
	
	private double latitud;
	private double longitud;
	
	public Ubicacion(Double latitud, Double longitud) {
		super();
		this.latitud = latitud;
		this.longitud = longitud;
	}
	
	public double distanciaA(Ubicacion ubicacion) {
		double radioDeLaTierraEnKilometros = 6371;
		double deltaLatitud = this.convertirARadianes(this.latitud) - this.convertirARadianes(ubicacion.getLatitud());
		double deltaLongitud = this.convertirARadianes(this.longitud) - this.convertirARadianes(ubicacion.getLongitud());
		double a = Math.pow(Math.sin(deltaLatitud / 2), 2) + Math.cos(this.convertirARadianes(this.getLatitud())) * Math.cos(this.convertirARadianes(ubicacion.getLatitud())) * Math.pow(Math.sin(deltaLongitud / 2), 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = radioDeLaTierraEnKilometros * c;
        return distance;
	}
	
	public List<Ubicacion> ubicacionesQueSeEncuentranAMenosDe(List<Ubicacion> listaDeUbicaciones, double kilometros) {
		return listaDeUbicaciones.stream().filter(ubicacion -> this.laUbicacionSeEncuentraAMenosDe(ubicacion, kilometros)).toList();
	}

	public boolean laUbicacionSeEncuentraAMenosDe(Ubicacion ubicacion, double kilometros) {
		return this.distanciaA(ubicacion) < kilometros;
	}

	public double convertirARadianes(double numero) {
		return Math.toRadians(numero);
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
	
	
	

}
