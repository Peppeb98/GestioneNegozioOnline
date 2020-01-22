package Gestione.entity;


public class Prodotto {
		
		private int codice;
		private String nome;
		private int prezzo;
		private int qta_disponibile;
		
		//private ArrayList<Spesa> spese = new ArrayList<Spesa>();
		
		public Prodotto(int codice, String nome, int prezzo, int qta_disponibile) {
			
			this.codice = codice;
			this.nome = nome;
			this.prezzo = prezzo;
			this.qta_disponibile = qta_disponibile;
		}
		
		public void setCodice(int codice) {
			this.codice = codice;
		}
		
		public int getCodice() {
			return this.codice;
		}
		
		public void setNome(String nome) {
			this.nome = nome;
		}
		
		public String getNome() {
			return this.nome;
		}
		
		public void setPrezzo(int prezzo) {
			this.prezzo = prezzo;
		}
		
		public int getPrezzo() {
			return this.prezzo;
		}
		
		public void setQta(int qta) {
			this.qta_disponibile = qta;
		}
		
		public int getQta() {
			return this.qta_disponibile;
		}
		
		public void riduciQuantita(int r) {
			   this.qta_disponibile -= r;
			  }

}
