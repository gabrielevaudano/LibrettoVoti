package it.polito.tdp.model;

public class TestLibretto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Libretto l = new LibrettoMigliorato();
		System.out.print("Ok");
		
		l.add(new Voto("Chimica", 24, 20192011));
		l.add(new Voto("Algebra", 30, 20192011));

		l.add(new Voto("Algebra 2", 25, 20192011));
				
		for(Voto v :  l.elencoPerNomeCorso())
			System.out.print(v);
		
		for(Voto v :  l.elencoPerVoto())
			System.out.print(v);
	}

}
