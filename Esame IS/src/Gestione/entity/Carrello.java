package Gestione.entity;


public class Carrello {
	
	private Prodotto prodotto;
	private int qta;
	
	public Carrello(Prodotto p, int q) {
		this.prodotto = p;
		this.qta = q;
	}
	
	public Prodotto getProdotto() {
		return this.prodotto;
	}
	
	public int getQta() {
		return this.qta;
	}

}