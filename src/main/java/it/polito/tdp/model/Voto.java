package it.polito.tdp.model;

public class Voto {
	private String nomeCorso;
	protected int voto;
	private int dataEsame;
	
	public Voto(String nomeCorso, int voto, int dataEsame) {
		super();
		this.nomeCorso = nomeCorso;
		this.voto = voto;
		this.dataEsame = dataEsame;
	}

	public String getNomeCorso() {
		return nomeCorso;
	}

	public int getVoto() {
		return voto;
	}

	public int getDataEsame() {
		return dataEsame;
	}

	@Override
	public boolean equals(Object obj) {
		Voto other = (Voto) obj;
		if (nomeCorso == null) {
			if (other.nomeCorso != null)
				return false;
		} else if (!nomeCorso.equals(other.nomeCorso))
			return false;
		if (voto != other.voto)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Nome del Corso: " + nomeCorso + ", voto: " + voto + ", data d'Esame: " + dataEsame + "\n";
	}

	public void miglioraLibretto() {
		if (this.voto>=18)
			this.voto +=1;
		else if (this.voto>=24)
			this.voto += 2;
		if (this.voto >=30)
			this.voto = 30;
	}
	
	
}
