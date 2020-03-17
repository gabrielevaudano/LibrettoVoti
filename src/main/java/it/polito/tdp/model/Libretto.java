package it.polito.tdp.model;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class Libretto {
	protected List<Voto> librettoVoti;
	protected boolean migliorato;

	public Libretto() {
		this.librettoVoti = new LinkedList<Voto>();
		this.migliorato = false;
	}
	
	public void add(Voto voto) {
		if (librettoVoti.contains(voto))
			throw new IllegalStateException("La valutazione è già stata inserita");
		
		for (Voto v : librettoVoti)
			if (v.getNomeCorso().compareTo(voto.getNomeCorso())==0)
				throw new IllegalStateException("La valutazione è in conflitto!");
	
		librettoVoti.add(voto);

		if (migliorato) 
			voto.miglioraLibretto();
	}

	public List<Voto> elencoPerVoto() {
		List<Voto> l_temp = new LinkedList<Voto>(this.librettoVoti);
		l_temp.sort(new Comparator<Voto>() {
			@Override
			public int compare(Voto o1, Voto o2) {
					return -(o1.getVoto()-o2.getVoto());
			}
		});;
		return l_temp;
	}
	
	public List<Voto> elencoPerNomeCorso() {
		List<Voto> l_temp = new LinkedList<Voto>(this.librettoVoti);
		l_temp.sort(new Comparator<Voto>() {
			@Override
			public int compare(Voto o1, Voto o2) {
				return o1.getNomeCorso().compareTo(o2.getNomeCorso());
			}	
		});;
		return l_temp;
	}
	
	public void eliminaValutazioni(int limiteSuperiore) {
		for (Voto v: librettoVoti)
			if (v.getVoto()<limiteSuperiore) 
				librettoVoti.remove(v);
	}
	
	public List<Voto> cercaVoto(int valutazione) {
		List<Voto> elencoValutazione = new LinkedList<Voto>();
		
		for (Voto v: librettoVoti)
			if(v.getVoto()==valutazione)
				elencoValutazione.add(v);
		
		return elencoValutazione;
	}
}
