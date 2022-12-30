package pharmacie;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import hopital.*;

public class Main {
	private static int NBPATIENTMAX = 20;
	private static Patient[] listePatient = new Patient[NBPATIENTMAX]; 
	private static int nbPatients;
	
	private static Medicament[] listeMedoc = new Medicament[50];
	private static Object[] listePatients;
	private int nbMedocs = 0;
	
	private static Medicament[] commande = new Medicament[100];
	private int nbMedocCommande = 0;
	
	public Main() {}
	
	public void mainMenu() {
		System.out.println("Bienvenu dans l'espace informatique de l'hopital LANSALOT!\n");
		
		System.out.println("\nLogIn:\n");
		System.out.println("\n1. Aide-Soignant(e)");
		System.out.println("\n2. Infirmier(e)");
		System.out.println("\n3. Medecin");
		System.out.println("\n0. Exit");
		
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 2) {
				if(userInput == 1) {
					menuAS();
				}
				if(userInput == 2) {
					menuInf();					
				}
				if(userInput == 3) {
					menuMed();
				}
				if(userInput == 0) {
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	mainMenu();
			}	
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 à 4");
        	mainMenu();
        }
	}
	public void menuAS() {
		System.out.println("\nEn tant qu'aide-soignant(e) vous pouvez effectuer les soins et voir les fiches des patients");
		System.out.println("\nQue voulez-vous faire?\n");
		System.out.println("\n1. Soins");
		System.out.println("\n2. Patient");
		System.out.println("\n3. LogOut");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 3) {
				if(userInput == 1) {
					menuSoinsAS();
				}
				if(userInput == 2) {
					menuPatientAS();
				}
				if(userInput == 3) {
					mainMenu();
				}
				if(userInput == 0) {
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	mainMenu();
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
        	mainMenu();
        }
	}
	
	public void menuInf() {
		System.out.println("\nEn tant qu'infirmier(e) vous pouvez effectuer les soins, libre acces aux commandes et a la pharmacie puis voir et modifier les fiches des patients");
		System.out.println("\nQue voulez-vous faire:\n");
		System.out.println("\n1. Soins");
		System.out.println("\n2. Commande");
		System.out.println("\n3. Pharmacie");
		System.out.println("\n4. Patient");
		System.out.println("\n5. LogOut");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 5) {
				if(userInput == 1) {
					menuSoinsI();
				}
				if(userInput == 2) {
					menuCommandeI();
				}
				if(userInput == 3) {
					menuPharmacieI();
				}
				if(userInput == 4) {
					menuPatientI();
				}
				if(userInput == 5) {
					mainMenu();
				}
				if(userInput == 0) {
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	mainMenu();
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
        	mainMenu();
        }
	}
	
	public void menuMed() {
		System.out.println("\nEn tant que medecin vous avez acces a tout");
		System.out.println("\nQue voulez-vous faire:\n");
		System.out.println("\n1. Soins");
		System.out.println("\n2. Commande");
		System.out.println("\n3. Pharmacie");
		System.out.println("\n4. Patient");
		System.out.println("\n5. LogOut");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 5) {
				if(userInput == 1) {
					menuSoins();
				}
				if(userInput == 2) {
					menuCommande();
				}
				if(userInput == 3) {
					menuPharmacie();
				}
				if(userInput == 4) {
					menuPatient();
				}
				if(userInput == 5) {
					mainMenu();
				}
				if(userInput == 0) {
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	mainMenu();
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
        	mainMenu();
        }
	}
	
	public void menuSoins() {
		System.out.println("\nQue voulez-vous faire?\n");
		System.out.println("\n1. Effectuer des soins a un patient");
		System.out.println("\n2. Retourner au menu precedent");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 2) {
				if(userInput == 1) {
					faireSoins();
				}
				if(userInput == 2) {
					menuMed();
				}if(userInput == 0) {
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	mainMenu();
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
        	mainMenu();
        }
	}
	
	public void menuSoinsI() {
		System.out.println("\nQue voulez-vous faire?\n");
		System.out.println("\n1. Effectuer des soins a un patient");
		System.out.println("\n2. Retourner au menu precedent");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 2) {
				if(userInput == 1) {
					faireSoins();
				}
				if(userInput == 2) {
					menuInf();
				}if(userInput == 0) {
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	menuInf();
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
        	menuInf();
        }	}
	
	public void menuSoinsAS() {
		System.out.println("\nQue voulez-vous faire?\n");
		System.out.println("\n1. Effectuer des soins a un patient");
		System.out.println("\n2. Retourner au menu precedent");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 2) {
				if(userInput == 1) {
					faireSoins();
				}
				if(userInput == 2) {
					menuAS();
				}if(userInput == 0) {
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	menuAS();
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
        	menuAS();
        }
	}
	
	public void menuPatient() {
		System.out.println("\nQue voulez-vous faire?\n");
		System.out.println("\n1. Afficher la liste des patients");
		System.out.println("\n2. Ajouter un patient");
		System.out.println("\n3. Supprimer un patient");
		System.out.println("\n4. Modifier un patient");
		System.out.println("\n5. Retour au menu precedent");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 5) {
				if(userInput == 1) {
					afficherPatients();
				}
				if(userInput == 2) {
					addPatient();
				}
				if(userInput == 3) {
					delPatient();
				}
				if(userInput == 4) {
					editPatient();
				}
				if(userInput == 5) {
					menuMed();
				}
				if(userInput == 0) {
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	menuMed();
			}
			
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
        	menuMed();
        }
	}
	
	public void menuPatientI() {
		System.out.println("\nQue voulez-vous faire?\n");
		System.out.println("\n1. Afficher la liste des patients");
		System.out.println("\n2. Modifier un patient");
		System.out.println("\n3. Retour au menu precedent");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 5) {
				if(userInput == 1) {
					afficherPatients();
				}
				if(userInput == 2) {
					editPatient();
				}
				if(userInput == 3) {
					menuInf();
				}
				if(userInput == 0) {
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	menuInf();
			}
			
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
        	menuInf();
        }
	}
	
	public void menuPatientAS() {
		System.out.println("\nQue voulez-vous faire?\n");
		System.out.println("\n1. Afficher la liste des patients");
		System.out.println("\n2. Retour au menu precedent");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 5) {
				if(userInput == 1) {
					afficherPatients();
				}
				if(userInput == 2) {
					menuAS();
				}
				if(userInput == 0) {
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	menuAS();
			}
			
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
        	menuAS();
        }
	}

	
	public void menuCommande() {
		System.out.println("\nQue voulez-vous faier?\n");
		System.out.println("\n1. Afficher la commande");
		System.out.println("\n2. Ajouter un medicament a la commande");
		System.out.println("\n3. Supprimer un medicament a la commande");
		System.out.println("\n4. Passer la commande");
		System.out.println("\n5. Supprimer toute la commande");
		System.out.println("\n6. Retour au menu precedent");
		System.out.println("\n0. Exit");
		
		try {
			
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 6) {
				if(userInput == 1) {
					afficherCommande();
				}
				if(userInput == 2) {
					add1ToCommande();
				}
				if(userInput == 3) {
					del1FromCommande();
				}
				if(userInput == 4) {
					makeCommande();
				}
				if(userInput == 5) {
					delAllCommande();
				}
				if(userInput == 6) {
					menuMed();
				}
				if(userInput == 0) {
					System.exit(0);
				}
			}else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	mainMenu();
			}
			
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
        	mainMenu();
        }
	}
	
	public void menuCommandeI() {
		System.out.println("\nQue voulez-vous faier?\n");
		System.out.println("\n1. Afficher la commande");
		System.out.println("\n2. Ajouter un medicament a la commande");
		System.out.println("\n3. Supprimer un medicament a la commande");
		System.out.println("\n4. Passer la commande");
		System.out.println("\n5. Supprimer toute la commande");
		System.out.println("\n6. Retour au menu precedent");
		System.out.println("\n0. Exit");
		
		try {
			
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 6) {
				if(userInput == 1) {
					afficherCommande();
				}
				if(userInput == 2) {
					add1ToCommande();
				}
				if(userInput == 3) {
					del1FromCommande();
				}
				if(userInput == 4) {
					makeCommande();
				}
				if(userInput == 5) {
					delAllCommande();
				}
				if(userInput == 6) {
					menuInf();
				}
				if(userInput == 0) {
					System.exit(0);
				}
			}else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	menuInf();
			}
			
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
        	menuInf();
        }
	}
	
	public void menuPharmacie() {
		System.out.println("\nSue voulez-vous faire?\n");
		System.out.println("\n1. Afficher le stock de medicament dans la pharmacie");
		System.out.println("\n2. Ajouter un ou plusieurs medicament(s) dans la pharmacie");
		System.out.println("\n3. Supprimer un ou plusieurs medicament(s) de la pharmacie");
		System.out.println("\n4. Retour au menu precedent");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 4) {
				if(userInput == 1) {
					afficherStock();
				}
				if(userInput == 2) {
					addMeds();
				}
				if(userInput == 3) {
					delMeds();
				}
				if(userInput == 4) {
					menuMed();
				}
				if(userInput == 0) {
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	menuMed();
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
        	menuMed();
        }
		
	}
	
	public void menuPharmacieI() {
		System.out.println("\nSue voulez-vous faire?\n");
		System.out.println("\n1. Afficher le stock de medicament dans la pharmacie");
		System.out.println("\n2. Ajouter un ou plusieurs medicament(s) dans la pharmacie");
		System.out.println("\n3. Supprimer un ou plusieurs medicament(s) de la pharmacie");
		System.out.println("\n4. Retour au menu precedent");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 4) {
				if(userInput == 1) {
					afficherStock();
				}
				if(userInput == 2) {
					addMeds();
				}
				if(userInput == 3) {
					delMeds();
				}
				if(userInput == 4) {
					menuInf();
				}
				if(userInput == 0) {
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	menuInf();
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
        	menuInf();
        }
		
	}

	public void faireSoins() {
		
	}
	
	public void afficherCommande() {
		
	}
	
	public void add1ToCommande() {
		
	}
	
	public void del1FromCommande() {
		
	}
	
	public void makeCommande() {
		
	}
	
	public void delAllCommande() {
		
	}
	
	public static void afficherPatients() {
		for(int i = 0; i<nbPatients; i++) {
			System.out.println((listePatients[i]).toString());
		}
	}
	
	public void addPatient() {
		Patient patient = null;
		String nom = inputOutput("Saisissez le nom du nouveau patient:\n");
		String prenom = inputOutput("Saisissez le prenom du nouveau patient:\n");
		int age = Integer.parseInt("Saississez l'age d nouveau patient");
		int quantite = Integer.parseInt("Saisissez le nombre de medicaments dont a besoin le nouveau patient:\n");
		for(int i = 0; i<quantite; i++) {
			String name = inputOutput("Saisissez le nom du medicament");
			int nombre = Integer.parseInt(inputOutput("Saisissez le nombre de medicament qu'il lui faut"));
			Medicament medoc = new Medicament(name, nombre);
			//Medicament prescription = patient.ajouterMedocAPrescr(medoc);
		}
		//patient = new Patient(nom, prenom, age, prescription);
	}
	
	public void delPatient(Patient patient) {
		
	}
	
	public void editPatient(Patient patient) {
		System.out.println("\nQue voulez-vou modifier?\n");
		System.out.println("\n1. Nom");
		System.out.println("\n2. Prenom");
		System.out.println("\n3. Age");
		System.out.println("\n4. Prescription");
		System.out.println("");
		//
	}
	
	public void afficherStock() {
		
	}
	
	public void addMeds() {
		
	}
	
	public void delMeds() {
		
	}
	/**
     * Passes a prompt to the user and returns the user specified 
     * string.
     * @param message
     * @return String
     */
    private static String inputOutput(String message) {
        System.out.println(message);
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    String returnString = "";
	    try {
	        returnString = br.readLine();
	    }
	    catch (IOException e){
	        System.out.println("Error reading in value");
	    }
	    return returnString;
    }
}
