package opinion;

import participantes.Participante;

public class Opinion {
	private String especie;
	private String nivel;
	private Participante autor;
	
	public Opinion(String especie, Participante autor) {
		this.especie = especie;
		this.autor= autor;
		this.nivel = autor.getNivel().toString(); // REVISAR
	}

	public Participante getAutor() {
		return autor;
	}

	
	

}
