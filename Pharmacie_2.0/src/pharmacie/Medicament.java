package pharmacie;

public class Medicament {
	private String nom;
	private int quantite;
	
	public Medicament(String nom, int quantite) {
		this.nom = nom;
		this.quantite = quantite;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	public String getNom() {
		return nom;
	}
	
	@Override
	public String toString() {
		return nom + " " + quantite;
	}
	
	public static void main(String[] args) {
		
	}
}
