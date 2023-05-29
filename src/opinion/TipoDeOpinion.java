package opinion;

public enum TipoDeOpinion {
	VINCHUCA_INFESTANS(true), VINCHUCA_SORDIDA(true), VINCHUCA_GUASAYANA(true), CHINCHE_FOLIADA(false), PHTIA_CHINCHE(false), NINGUNA(false), IMAGEN_POCO_CLARA(false);
	
	boolean validoEnvioMuestra;
	
	private TipoDeOpinion(boolean validoEnvioMuestra) {
		this.validoEnvioMuestra = validoEnvioMuestra;
	}
	
	public boolean getValidoEnvioMuestra() {
		return validoEnvioMuestra;
	}
}