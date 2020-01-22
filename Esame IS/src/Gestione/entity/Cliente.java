package Gestione.entity;

import java.util.ArrayList;

public class Cliente {
	
	private String nome;
	private String password;
	private String nr_cell;
	private String cartaDiCredito;
	private int numero_spese;
	private ArrayList<Spesa> spese = new ArrayList<Spesa>();
	private ArrayList<Carrello> carrelli = new ArrayList<Carrello>();
	
	public Cliente(String nome, String password, String nr_cell, String cartaDiCredito) {
		this.nome = nome;
		this.password = password;
		this.nr_cell = nr_cell;
		this.cartaDiCredito = cartaDiCredito;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getNome() {
		return this.nome;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setNumero(String nr_cell) {
		this.nr_cell = nr_cell;
	}
	
	public String getNumero() {
		return this.nr_cell;
	}
	
	public void setCarta(String carta) {
		this.cartaDiCredito = carta;
	}
	
	public String getCarta() {
		return this.cartaDiCredito;
	}
	
	public void aggiungiSpesa(Spesa s) {
		spese.add(s);
	}
	
	public int getNumeroSpese() {
		numero_spese = spese.size();
		return numero_spese;
	}
	
	public void count() {
		this.numero_spese++;
	}
	
	public ArrayList<Spesa> getSpesa() {
		return this.spese;
		
	}
	
	public ArrayList<Carrello> getCarrelli(){
		return this.carrelli;
	}
	
	public void aggiungiAlCarrello(Prodotto p, int q) {
		carrelli.add(new Carrello(p,q));
	}
	

}
