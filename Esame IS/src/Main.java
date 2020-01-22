import Gestione.entity.*;

import java.time.LocalDate;
import java.time.Month;

import Gestione.control.*;




public class Main {

	public static void main(String[] args) {

		
		Cliente c1 = new Cliente("Giuseppe","pass","123","000111");
		Cliente c2 = new Cliente("Andrea","pass", "456", "222333");
		
		Gestione gestione = new Gestione ();
		
		c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
		c1.aggiungiAlCarrello(gestione.getCatalogo().get(1), 1);
		c2.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
		c1.aggiungiAlCarrello(gestione.getCatalogo().get(0), 1);
		
		gestione.effettuaPagamento(c1, 1, LocalDate.of(2019, Month.DECEMBER, 28) , StatoSpesa.ORDINATA);
		gestione.effettuaPagamento(c2,2, LocalDate.of(2019, Month.DECEMBER, 25), StatoSpesa.ORDINATA);
		
		
		gestione.effettuaPagamento(c1, 2, LocalDate.of(2019, Month.DECEMBER, 20), StatoSpesa.ORDINATA);
		gestione.generaReport();
		System.out.println ("CIAO");
	}

}
