package Gestione.test;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import Gestione.control.Gestione;
import Gestione.entity.Cliente;
import Gestione.entity.StatoSpesa;

public class GestioneTest {
	
	
	Gestione g;
	Cliente c1, c2;
	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {            
		 g = new Gestione();
		 c1 = new Cliente("Giuseppe", "pass", "123", "000111");      
		 c2 = new Cliente("Andrea", "pass", "456","222333");
	}

	@After
	public void tearDown() throws Exception {        /* Termino l'operazione */
		g = null;
		c1 = null;
		c2 = null;
	}

	
/*............TEST1.............*/	
	@Test
	public void test1NessunClienteUnProdottoUnaQuantità() {
		
		c1.aggiungiAlCarrello(g.getCatalogo().get(0), 1);
		g.effettuaPagamento(c1, 1,LocalDate.of(2019, Month.DECEMBER, 1), StatoSpesa.ORDINATA);
		c2.aggiungiAlCarrello(g.getCatalogo().get(0), 1);
		g.effettuaPagamento(c2,2, LocalDate.of(2019, Month.DECEMBER, 2), StatoSpesa.ORDINATA);
		
		int p;
		p = g.generaReport(); //output del programma
		assertEquals(0,p);    //output atteso

	}


/*............TEST2.............*/	
@Test
public void test2UnClienteNumeroSpeseUgualeAdNUnProdottoUnaQuantità() {
	
	c1.aggiungiAlCarrello(g.getCatalogo().get(0), 1);
	g.effettuaPagamento(c1, 1, LocalDate.of(2019, Month.DECEMBER, 4), StatoSpesa.ORDINATA);
	c1.aggiungiAlCarrello(g.getCatalogo().get(1), 1);
	g.effettuaPagamento(c1,2, LocalDate.of(2019, Month.DECEMBER, 3), StatoSpesa.ORDINATA);
	
	int p;
	p = g.generaReport(); //output del programma
	assertEquals(1,p);    //output atteso

}


/*............TEST3.............*/	
@Test
public void test3UnClienteNumeroSpeseMaggioriDiNUnProdottoUnaQuantità() {
	
	c1.aggiungiAlCarrello(g.getCatalogo().get(0), 1);
	g.effettuaPagamento(c1, 1, LocalDate.of(2019, Month.DECEMBER, 5), StatoSpesa.ORDINATA);
	c1.aggiungiAlCarrello(g.getCatalogo().get(1), 1);
	g.effettuaPagamento(c1, 1, LocalDate.of(2019, Month.DECEMBER, 6), StatoSpesa.ORDINATA);
	c1.aggiungiAlCarrello(g.getCatalogo().get(2), 1);
	g.effettuaPagamento(c1, 2,LocalDate.of(2019, Month.DECEMBER, 7), StatoSpesa.ORDINATA);
	
	int p;
	p = g.generaReport(); //output del programma
	assertEquals(1,p);    //output atteso

}
/*............TEST4.............*/	
@Test
public void test4UnClienteNumeroSpeseUgualiAdNPiùProdottiUnaQuantità() {
	
	c1.aggiungiAlCarrello(g.getCatalogo().get(0), 1);
	g.effettuaPagamento(c1, 1, LocalDate.of(2019, Month.DECEMBER, 8), StatoSpesa.ORDINATA);
	c1.aggiungiAlCarrello(g.getCatalogo().get(1), 1);
	g.effettuaPagamento(c1, 2, LocalDate.of(2019, Month.DECEMBER, 9), StatoSpesa.ORDINATA);
	
	int p;
	p = g.generaReport(); //output del programma
	assertEquals(1,p);    //output atteso

}

/*............TEST5.............*/	
@Test
public void test5UnClienteNumeroSpeseUgualiAdNPiùProdottiPiùQuantità() {
	
	c1.aggiungiAlCarrello(g.getCatalogo().get(0), 2);
	c1.aggiungiAlCarrello(g.getCatalogo().get(1), 2);
	
	g.effettuaPagamento(c1, 1,LocalDate.of(2019, Month.DECEMBER, 10), StatoSpesa.ORDINATA);
	c1.aggiungiAlCarrello(g.getCatalogo().get(1), 2);
	g.effettuaPagamento(c1, 2,LocalDate.of(2019, Month.DECEMBER, 11), StatoSpesa.ORDINATA);
	
	int p;
	p = g.generaReport(); //output del programma
	assertEquals(1,p);    //output atteso

}
/*............TEST6.............*/	
@Test
public void test6UnClienteNumeroSpeseUgualiAdNUnProdottoPiùQuantità() {
	
	c1.aggiungiAlCarrello(g.getCatalogo().get(0), 2);
	g.effettuaPagamento(c1, 1,LocalDate.of(2019, Month.DECEMBER, 12), StatoSpesa.ORDINATA);
	c1.aggiungiAlCarrello(g.getCatalogo().get(1), 1);
	g.effettuaPagamento(c1, 1, LocalDate.of(2019, Month.DECEMBER, 13), StatoSpesa.ORDINATA);
	
	
	int p;
	p = g.generaReport(); //output del programma
	assertEquals(1,p);    //output atteso

}

/*............TEST7.............*/	
@Test
public void test7PiùClientiNumeroSpeseUgualiAdNUnProdottoUnaQuantità() {
	
	c1.aggiungiAlCarrello(g.getCatalogo().get(0), 1);
	g.effettuaPagamento(c1, 1, LocalDate.of(2019, Month.DECEMBER, 14), StatoSpesa.ORDINATA);
	c2.aggiungiAlCarrello(g.getCatalogo().get(1), 1);
	g.effettuaPagamento(c2, 1, LocalDate.of(2019, Month.DECEMBER, 15), StatoSpesa.ORDINATA);
	c1.aggiungiAlCarrello(g.getCatalogo().get(2), 1);
	g.effettuaPagamento(c1, 1, LocalDate.of(2019, Month.DECEMBER, 16), StatoSpesa.ORDINATA);
	c2.aggiungiAlCarrello(g.getCatalogo().get(3), 1);
	g.effettuaPagamento(c2, 1, LocalDate.of(2019, Month.DECEMBER, 17), StatoSpesa.ORDINATA);
	
	
	int p;
	p = g.generaReport(); //output del programma
	assertEquals(2,p);    //output atteso

}
/*............TEST8.............*/	
@Test
public void test8PiùClientiNumeroSpeseUgualiAdNPiùProdottiUnaQuantità() {
	
	c1.aggiungiAlCarrello(g.getCatalogo().get(0), 1);
	c1.aggiungiAlCarrello(g.getCatalogo().get(1), 1);
	g.effettuaPagamento(c1, 1, LocalDate.of(2019, Month.DECEMBER, 18), StatoSpesa.ORDINATA);
	
	c1.aggiungiAlCarrello(g.getCatalogo().get(2), 1);
	c1.aggiungiAlCarrello(g.getCatalogo().get(3), 1);
	g.effettuaPagamento(c1, 1,LocalDate.of(2019, Month.DECEMBER, 19), StatoSpesa.ORDINATA);
	
	c2.aggiungiAlCarrello(g.getCatalogo().get(0), 1);
	c2.aggiungiAlCarrello(g.getCatalogo().get(1), 1);
	g.effettuaPagamento(c2, 1, LocalDate.of(2019, Month.DECEMBER, 20), StatoSpesa.ORDINATA);
	
	c2.aggiungiAlCarrello(g.getCatalogo().get(2), 1);
	c2.aggiungiAlCarrello(g.getCatalogo().get(3), 1);
	g.effettuaPagamento(c2, 1, LocalDate.of(2019, Month.DECEMBER, 21), StatoSpesa.ORDINATA);
	
	
	int p;
	p = g.generaReport(); //output del programma
	assertEquals(2,p);    //output atteso

}
/*............TEST9.............*/	
@Test
public void test9PiùClientiNumeroSpeseUgualiAdNPiùProdottiPiùQuantità() {
	
	c1.aggiungiAlCarrello(g.getCatalogo().get(0), 2);
	g.effettuaPagamento(c1, 1, LocalDate.of(2019, Month.DECEMBER, 22), StatoSpesa.ORDINATA);
	
	c1.aggiungiAlCarrello(g.getCatalogo().get(2), 2);
	g.effettuaPagamento(c1, 1, LocalDate.of(2019, Month.DECEMBER, 23), StatoSpesa.ORDINATA);
	
	c2.aggiungiAlCarrello(g.getCatalogo().get(0), 2);
	g.effettuaPagamento(c2, 1,LocalDate.of(2019, Month.DECEMBER, 24), StatoSpesa.ORDINATA);
	
	c2.aggiungiAlCarrello(g.getCatalogo().get(2), 2);
	g.effettuaPagamento(c2, 1,LocalDate.of(2019, Month.DECEMBER, 25), StatoSpesa.ORDINATA);
	
	
	int p;
	p = g.generaReport(); //output del programma
	assertEquals(2,p);    //output atteso

}
/*............TEST10.............*/	
@Test
public void test10PiùClientiNumeroSpeseUgualiAdNUnProdottoPiùQuantità() {
	
	c1.aggiungiAlCarrello(g.getCatalogo().get(0), 2);
	c1.aggiungiAlCarrello(g.getCatalogo().get(1), 2);
	g.effettuaPagamento(c1, 1, LocalDate.of(2019, Month.DECEMBER, 26), StatoSpesa.ORDINATA);
	
	c1.aggiungiAlCarrello(g.getCatalogo().get(2), 2);
	c1.aggiungiAlCarrello(g.getCatalogo().get(3), 2);
	g.effettuaPagamento(c1, 1,LocalDate.of(2019, Month.DECEMBER, 27), StatoSpesa.ORDINATA);
	
	c2.aggiungiAlCarrello(g.getCatalogo().get(0), 2);
	c2.aggiungiAlCarrello(g.getCatalogo().get(1), 2);
	g.effettuaPagamento(c2, 1, LocalDate.of(2019, Month.DECEMBER, 28), StatoSpesa.ORDINATA);
	
	c2.aggiungiAlCarrello(g.getCatalogo().get(2), 2);
	c2.aggiungiAlCarrello(g.getCatalogo().get(3), 2);
	g.effettuaPagamento(c2, 1,LocalDate.of(2019, Month.DECEMBER, 29), StatoSpesa.ORDINATA);
	
	
	int p;
	p = g.generaReport(); //output del programma
	assertEquals(2,p);    //output atteso

}
/*............TEST11.............*/	
@Test
public void test11UnClienteNumeroSpeseUgualiAdNNessunProdottoUnaQuantità() {
	

	g.effettuaPagamento(c1, 1,LocalDate.of(2019, Month.DECEMBER, 30), StatoSpesa.ORDINATA);
	g.effettuaPagamento(c1, 1,LocalDate.of(2019, Month.DECEMBER, 31), StatoSpesa.ORDINATA);
	
	int p;
	p = g.generaReport(); //output del programma
	assertEquals(1,p);    //output atteso

}
/*............TEST12.............*/	
@Test
public void test12UnClienteNumeroSpeseUgualiAdNUnProdottoZeroQuantità() {
	
	c1.aggiungiAlCarrello(g.getCatalogo().get(2), 0);
	c1.aggiungiAlCarrello(g.getCatalogo().get(0), 0);
	g.effettuaPagamento(c1, 1, LocalDate.of(2020, Month.JANUARY, 1 ) , StatoSpesa.ORDINATA);
	g.effettuaPagamento(c1, 1, LocalDate.of(2020, Month.JANUARY, 2), StatoSpesa.ORDINATA);
	
	int p;
	p = g.generaReport(); //output del programma
	assertEquals(1,p);    //output atteso

}
}

