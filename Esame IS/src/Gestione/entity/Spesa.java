package Gestione.entity;

import java.time.LocalDate;
import java.util.ArrayList;

//import java.time.LocalDate;

public class Spesa {
	
	private int id;
	private LocalDate data;
	private int costo_tot;
	private StatoSpesa stato;
	private ArrayList<Carrello> prodotti_acq = new ArrayList<Carrello>();
	
	public Spesa(int id, LocalDate data, StatoSpesa stato, ArrayList<Carrello> prodotti) {
		this.id = id;
		this.data = data;
		this.stato = stato;
		for(int i = 0; i< prodotti.size(); i++)
			this.prodotti_acq.add(prodotti.get(i));
		
	}
	
	public ArrayList<Carrello> getPro(){
		return prodotti_acq;
	}
	
	public int getId() {
		return this.id;
	}
	
	public LocalDate getData() {
		return data;
	}
	
	public StatoSpesa getStato() {
		return stato;
	}
	
	public void setStato(StatoSpesa s) {
		this.stato = s;
	}
	
	public int calcolaPrezzo() {
		this.costo_tot = 0;
		int prezzo = 0;
		for(int i = 0; i < prodotti_acq.size(); i++) {
			prezzo = prodotti_acq.get(i).getProdotto().getPrezzo();
			prezzo *= prodotti_acq.get(i).getQta();
			costo_tot += prezzo;
		}
			return costo_tot;
			
	}
	

}
