package hopital;

import pharmacie.Medicament;

public class Patient {
	private String nom;
	private String prenom;
	private int age;
	private Medicament[] prescription = new Medicament[20];
	private int nbMedoc = 0;
	
	
	public Patient(String nom, String prenom, int age, Medicament[] prescription) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.prescription = prescription;
	}

	public Medicament[] getPrescription() {
		return prescription;
	}

	public void ajouterMedocAPrescr(Medicament med) {
		prescription[nbMedoc] = med;
		nbMedoc++;
	}
	public void setPrescription(Medicament[] prescription) {
		this.prescription = prescription;
	}


	public String getNom() {
		return nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public int getAge() {
		return age;
	}
	
	@Override
	public String toString() {
		return nom + " " + prenom + " " + age + " " + prescription;
	}
	
	public static void main(String[] args) {
		
	}
}
