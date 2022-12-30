package hopital;

import pharmacie.Medicament;

public class Patient {
	private String nom;
	private String prenom;
	private int age;
	private Medicament[] prescription = new Medicament[50];
	private int nbMedoc = 0;
	
	
	public Patient(String nom, String prenom, int age, Medicament[] prescription) {
		this.nom = nom;
		this.prenom = prenom;
		this.age = age;
		this.prescription = prescription;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAge(int age) {
		this.age = age;
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
	
	public String afficherPrescription(Medicament[] prescription) {
		String ordonnance = "";
		for(int i = 0; i<prescription.length; i++) {
			ordonnance += prescription[i].getNom() + " " + prescription[i].getQuantite() + " ";
		}
		return ordonnance;
	}
	@Override
	public String toString() {
		return nom + " " + prenom + " " + age + " " + afficherPrescription(prescription);
	}
	
	public static void main(String[] args) {
		Patient macron;
		Medicament smecta = new Medicament("Smecta", 20);
		Medicament doli = new Medicament("Doliprane", 6);
		Medicament[] prescri = {doli, smecta};
		macron = new Patient("Macron", "Emmanuel", 45, prescri);
		System.out.println(macron.toString());
	}
}
