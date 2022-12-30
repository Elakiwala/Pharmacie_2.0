package hopital;

public class Medecin {
	private String nom;
	private String prenom;
	
	public Medecin(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}
	
	@Override
	public String toString() {
		return nom + " " + prenom;
	}
	
	public static void main(String[] args) {
		Medecin mbeleck = new Medecin("Mbeleck", "Denis");
		System.out.println(mbeleck);
	}
}
