package opinion;
import muestra.Muestra;

public abstract class EstadoOpinion {
	
	public abstract void actualizarMuestra(Muestra muestra);
	
	public abstract boolean isBasico();
	
	public abstract boolean isExperto();

}
