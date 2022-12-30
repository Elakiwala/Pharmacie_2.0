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
	private static int nbMedocs = 0;
	private static int quantiteMeds;
	
	private static Medicament[] commande = new Medicament[100];
	private static int nbMedocCommande = 0;
	
	public Main() {}
	
	public static void mainMenu() {
		System.out.println("Bienvenu dans l'espace informatique de l'hopital LANSALOT!\n");
		
		System.out.println("\nLogIn:\n");
		System.out.println("\n1. Aide-Soignant(e)");
		System.out.println("\n2. Infirmier(e)");
		System.out.println("\n3. Medecin");
		System.out.println("\n0. Exit");
		
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 3) {
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
					System.out.println("\nAu Revoir!!");
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 3");
            	mainMenu();
			}	
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 a 3");
        	mainMenu();
        }
	}
	public static void menuAS() {
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
					System.out.println("\nAu Revoir!!");
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 3");
            	menuAS();
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 a 3");
        	menuAS();
        }
	}
	
	public static void menuInf() {
		System.out.println("\nEn tant qu'infirmier(e) vous pouvez effectuer les soins, libre acces aux commandes et a la pharmacie puis voir et modifier les patients");
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
					System.out.println("\nAu Revoir!!");
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 5");
            	menuInf();
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 a 5");
        	menuInf();
        }
	}
	
	public static void menuMed() {
		System.out.println("\nEn tant que medecin vous avez acces a tout sauf aux commandes");
		System.out.println("\nQue voulez-vous faire:\n");
		System.out.println("\n1. Soins");
		System.out.println("\n2. Pharmacie");
		System.out.println("\n3. Patient");
		System.out.println("\n4. LogOut");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 4) {
				if(userInput == 1) {
					menuSoins();
				}
				if(userInput == 2) {
					menuPharmacie();
				}
				if(userInput == 3) {
					menuPatient();
				}
				if(userInput == 4) {
					mainMenu();
				}
				if(userInput == 0) {
					System.out.println("\nAu Revoir!!");
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	menuMed();
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 a 4");
        	menuMed();
        }
	}
	
	public static void menuSoins() {
		System.out.println("\nQue voulez-vous faire?\n");
		System.out.println("\n1. Effectuer des soins a un patient");
		System.out.println("\n2. Retourner au menu precedent");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 2) {
				if(userInput == 1) {
					faireSoins();
					menuMed();
				}
				if(userInput == 2) {
					menuMed();
				}if(userInput == 0) {
					System.out.println("\nAu Revoir!!");
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 2");
            	menuMed();
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 a 2");
        	menuMed();
        }
	}
	
	public static void menuSoinsI() {
		System.out.println("\nQue voulez-vous faire?\n");
		System.out.println("\n1. Effectuer des soins a un patient");
		System.out.println("\n2. Retourner au menu precedent");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 2) {
				if(userInput == 1) {
					faireSoins();
					menuInf();
				}
				if(userInput == 2) {
					menuInf();
				}if(userInput == 0) {
					System.out.println("\nAu Revoir!!");
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 2");
            	menuInf();
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 a 2");
        	menuInf();
        }	}
	
	public static void menuSoinsAS() {
		System.out.println("\nQue voulez-vous faire?\n");
		System.out.println("\n1. Effectuer des soins a un patient");
		System.out.println("\n2. Retourner au menu precedent");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 2) {
				if(userInput == 1) {
					faireSoins();
					menuAS();
				}
				if(userInput == 2) {
					menuAS();
				}if(userInput == 0) {
					System.out.println("\nAu Revoir!!");
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 2");
            	menuAS();
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 a 2");
        	menuAS();
        }
	}
	
	public static void menuPatient() {
		System.out.println("\nQue voulez-vous faire?\n");
		System.out.println("\n1. Afficher la liste des patients");
		System.out.println("\n2. Ajouter un patient");
		System.out.println("\n3. Supprimer un patient");
		System.out.println("\n4. Modifier un patient");
		System.out.println("\n5. Retour au menu precedent");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 5) {
				if(userInput == 1) {
					afficherPatients();
					menuMed();
				}
				if(userInput == 2) {
					addPatient();
					menuMed();
				}
				if(userInput == 3) {
					delPatient();
					menuMed();
				}
				if(userInput == 4) {
					editPatient();
					menuMed();
				}
				if(userInput == 5) {
					menuMed();
				}
				if(userInput == 0) {
					System.out.println("\nAu Revoir!!");
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 5");
            	menuMed();
			}
			
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 a 5");
        	menuMed();
        }
	}
	
	public static void menuPatientI() {
		System.out.println("\nQue voulez-vous faire?\n");
		System.out.println("\n1. Afficher la liste des patients");
		System.out.println("\n2. Modifier un patient");
		System.out.println("\n3. Retour au menu precedent");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 3) {
				if(userInput == 1) {
					afficherPatients();
					menuInf();
				}
				if(userInput == 2) {
					editPatient();
					menuInf();
				}
				if(userInput == 3) {
					menuInf();
				}
				if(userInput == 0) {
					System.out.println("\nAu Revoir!!");
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 3");
            	menuInf();
			}
			
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 a 3");
        	menuInf();
        }
	}
	
	public static void menuPatientAS() {
		System.out.println("\nQue voulez-vous faire?\n");
		System.out.println("\n1. Afficher la liste des patients");
		System.out.println("\n2. Retour au menu precedent");
		System.out.println("\n0. Exit");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nVeuillez saisir parmis l'un des chiffres ci-dessus:"));
			
			if(userInput >= 0 && userInput <= 2) {
				if(userInput == 1) {
					afficherPatients();
					menuAS();
				}
				if(userInput == 2) {
					menuAS();
				}
				if(userInput == 0) {
					System.out.println("\nAu Revoir!!");
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 2");
            	menuAS();
			}
			
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 a 2");
        	menuAS();
        }
	}
	
	public static void menuCommandeI() {
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
					menuInf();
				}
				if(userInput == 2) {
					add1ToCommande();
					menuInf();
				}
				if(userInput == 3) {
					del1FromCommande();
					menuInf();
				}
				if(userInput == 4) {
					makeCommande();
					menuInf();
				}
				if(userInput == 5) {
					delAllCommande();
					menuInf();
				}
				if(userInput == 6) {
					menuInf();
				}
				if(userInput == 0) {
					System.out.println("\nAu Revoir!!");
					System.exit(0);
				}
			}else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 6");
            	menuInf();
			}
			
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 a 6");
        	menuInf();
        }
	}
	
	public static void menuPharmacie() {
		System.out.println("\nQue voulez-vous faire?\n");
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
					menuMed();
				}
				if(userInput == 2) {
					addMeds();
					menuMed();
				}
				if(userInput == 3) {
					delMeds();
					menuMed();
				}
				if(userInput == 4) {
					menuMed();
					menuMed();
				}
				if(userInput == 0) {
					System.out.println("\nAu Revoir!!");
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	menuMed();
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 a 4");
        	menuMed();
        }
		
	}
	
	public static void menuPharmacieI() {
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
					menuInf();
				}
				if(userInput == 2) {
					addMeds();
					menuInf();
				}
				if(userInput == 3) {
					delMeds();
					menuInf();
				}
				if(userInput == 4) {
					menuInf();
				}
				if(userInput == 0) {
					System.out.println("\nAu Revoir!!");
					System.exit(0);
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	menuInf();
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 a 4");
        	menuInf();
        }
		
	}

	public static void faireSoins() {
		String nom = inputOutput("\nSaisissez le patient a soigner:");
		int find = 0;
		for(int i = 0; i < nbPatients; i++) {
			if(listePatient[i].getNom() == nom) {
				find = 1;
				Medicament[] prescription = listePatient[i].getPrescription();
				for(int j = 0; j<prescription.length; j++) {
					//ajouter les medocs et la quantite dans la commande
					commande[nbMedocCommande] = prescription[j];
					nbMedocCommande++;
					//deduire les medocs et la quantite de la pharmacie 
					for(int k = 0; k<nbMedocs; k++) {
						if(prescription[j].getNom() == listeMedoc[k].getNom()) {
							if(prescription[j].getQuantite()>= listeMedoc[k].getQuantite()) {
								quantiteMeds -= prescription[j].getQuantite();
								listeMedoc[k] = null;
								nbMedocs --;
							} else {
								quantiteMeds -= prescription[j].getQuantite();
								listeMedoc[k].setQuantite(listeMedoc[k].getQuantite() - prescription[j].getQuantite());
							}
						}
					}
				}
			}
		} if(find == 0) {
			System.out.println("\n Le patient n'est pas dans la liste de cet hopital");
		}
	}
	
	public static void afficherCommande() {
		for(int i = 0; i<nbMedocCommande; i++) {
			System.out.println((commande[i]).toString());
		}
	}
	
	public static void add1ToCommande() {
		String nom = inputOutput("\nSaisir le nom du ou des medicament(s) a ajouter:");
		int quantite = Integer.parseInt(inputOutput("\nSaisir la quantite"));
		Medicament medicament = new Medicament(nom, quantite);
		commande[nbMedocCommande] = medicament;
		nbMedocCommande++;
	}
	
	public static void del1FromCommande() {
		String nom = inputOutput("\nSaissez le nom du medicament a supprimer:");
		int quantite = Integer.parseInt(inputOutput("\nSaisissez la quantite a supprimer:"));
		int find = 0;
		
		for (int i = 0; i<nbMedocCommande; i++) {
			if(commande[i].getNom() == nom) {
				find = 1;
				System.out.println("\nEtes vou sur de vouloir effacer " + commande[i].getNom() + "?\n");
				System.out.println("\n1. OUI");
				System.out.println("\n2. NON");
				
				try {
					int userInput = Integer.parseInt(inputOutput("\nSaisissez votre reponse:\n"));
					
					if(userInput >= 0 && userInput <= 1) {
						if(userInput == 1) {
							System.out.println("Suprression du medicament");
							if(quantite >= commande[i].getQuantite()) {
								commande[i] = null;
								nbMedocCommande --;
							} else {
								System.out.println("\nModification quantite a commander");
								commande[i].setQuantite(commande[i].getQuantite() - quantite);
							}
						}
						if(userInput == 2) {
							System.out.println("\nMedicaments comservé dans la commande");
						}
					} else {
						System.out.println("Merci de rentrer un chiffre entre 0 et 4");
					}
				} catch (NumberFormatException e) {
		        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
		        }
			}
		} if(find == 0) {
			System.out.println("\n Le patient n'est pas dans la liste de cet hopital");
		}
	}
	
	public static void makeCommande() {
		//la commande est passée donc la pharmacie se remplie
		for(int i = 0; i<nbMedocCommande; i ++) {
			listeMedoc[nbMedocs] = commande[i];
			quantiteMeds += commande[i].getQuantite();
			nbMedocs++;
		}
		System.out.println("\nLa pharmacie est remplie!!!");
		//suppression de la commande
		for(int i = 0; i<nbMedocCommande; i++) {
			commande[i] = null;
		}
	}
	
	public static void delAllCommande() {
		System.out.println("\nLa liste de commande va etre vidée, vous confirmez?\n");
		System.out.println("\n1. OUI");
		System.out.println("\n2. NON");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nSaisissez votre reponse:\n"));
			
			if(userInput >= 0 && userInput <= 1) {
				if(userInput == 1) {
					System.out.println("\nSuppression des commandes");
					for(int i = 0; i<nbMedocCommande; i++) {
						commande[i] = null;
					}
				}
				if(userInput == 2) {
					System.out.println("\nMaintient de la commande");
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
        }
	}
	
	public static void afficherPatients() {
		for(int i = 0; i<nbPatients; i++) {
			System.out.println((listePatient[i]).toString());
		}
	}
	
	public static void addPatient() {
		String nom = inputOutput("Saisissez le nom du nouveau patient:\n");
		String prenom = inputOutput("Saisissez le prenom du nouveau patient:\n");
		int age = Integer.parseInt(inputOutput("Saississez l'age d nouveau patient"));
		int quantite = Integer.parseInt(inputOutput("Saisissez le nombre de medicaments dont a besoin le nouveau patient:\n"));
		Medicament[] prescription = new Medicament[50];
		String ordonnance ="";
		for(int i = 0; i<quantite; i++) {
			String name = inputOutput("Saisissez le nom du medicament (forme: Nom)");
			int nombre = Integer.parseInt(inputOutput("Saisissez le dosage de medicament qu'il faut"));
			Medicament medoc = new Medicament(name, nombre);
			prescription[i] = medoc;
			ordonnance += prescription[i].getNom() + " " + prescription[i].getQuantite() + " ";
			//ajouter les medocs a la pharmacie
			int trouve = 0;
			for(int k = 0; k<nbMedocs; k++) {
				if(listeMedoc[k].getNom() == name) {
					trouve = 1;
					listeMedoc[k].setQuantite(listeMedoc[k].getQuantite()+nombre);
					quantiteMeds += nombre;
				}
			} if(trouve == 0) {
				listeMedoc[nbMedocs] = medoc;
				nbMedocs ++;
				quantiteMeds += nombre;
			}
		}
		System.out.println(ordonnance);
		Patient patient = new Patient(nom, prenom, age, prescription);
		patient.afficherPrescription(prescription);
		//ajouter a la liste des patients
		listePatient[nbPatients] = patient;
		nbPatients++;
	}
	
	public static void delPatient() {
		String nom = inputOutput("\nSaisissez le nom de patient qui quitte l'hopital:");
		int find = 0;
		for(int i = 0; i<nbPatients; i++) {
			if(listePatient[i].getNom() == nom) {
				find = 1;
				System.out.println("\nEtes vou sur de vouloir effacer " + listePatient[i].getPrenom() + listePatient[i].getNom() + "?\n");
				System.out.println("\n1. OUI");
				System.out.println("\n2. NON");
				
				try {
					int userInput = Integer.parseInt(inputOutput("\nSaisissez votre reponse:\n"));
					
					if(userInput >= 0 && userInput <= 1) {
						if(userInput == 1) {
							System.out.println("Suprression du patient");
							
							//deduire les medicament du patient de la pharmacie 
							Medicament[] prescription = listePatient[i].getPrescription();
							for(int j = 0; j<prescription.length; j++) {
								//ajouter les medocs et la quantite dans la commande
								commande[nbMedocCommande] = prescription[j];
								nbMedocCommande++;
								//deduire les medocs et la quantite de la pharmacie 
								for(int k = 0; k<nbMedocs; k++) {
									if(prescription[j].getNom() == listeMedoc[k].getNom()) {
										if(prescription[j].getQuantite()>= listeMedoc[k].getQuantite()) {
											quantiteMeds -= prescription[j].getQuantite();
											listeMedoc[k] = null;
											nbMedocs --;
										} else {
											quantiteMeds -= prescription[j].getQuantite();
											listeMedoc[k].setQuantite(listeMedoc[k].getQuantite() - prescription[j].getQuantite());
										}
									}
								}
							}
							listePatient[i] = null;
							nbPatients --;
						}
						if(userInput == 0) {
							System.out.println("\nPatient conservé");
						}
					} else {
						System.out.println("Merci de rentrer un chiffre entre 0 et 4");
					}
				} catch (NumberFormatException e) {
		        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
		        }
			}
		} if(find == 0) {
			System.out.println("\nPatient introuvable dans la liste");
		}
	}
	
	public static void editPatient() {
		String nom = inputOutput("\nSaisissez le nom du nouveau medicament");
		int find = 0;
		for(int i = 0; i < nbPatients; i ++) {
			if(listePatient[i].getNom() == nom) {
				find = 1;
				System.out.println("\nQue voulez-vou modifier?\n");
				System.out.println("\n1. Nom");
				System.out.println("\n2. Prenom");
				System.out.println("\n3. Age");
				System.out.println("\n4. Prescription");
				
				try {
					int userInput = Integer.parseInt(inputOutput("\nSaisissez votre reponse:"));
					
					if(userInput>= 1 && userInput <= 4) {
						if(userInput == 1) {
							String name = inputOutput("\nSaisissez le nouveau nom du patient");
							listePatient[i].setNom(name);
						}
						if(userInput == 2) {
							String prenom = inputOutput("\nSaisissez le nouveau prenom du patient");
							listePatient[i].setPrenom(prenom);
						}
						if(userInput == 3) {
							int age = Integer.parseInt(inputOutput("\nSaisissez le nouvel age du patient"));
							listePatient[i].setAge(age);
						}
						if(userInput == 4) {
							int nb = Integer.parseInt(inputOutput("\nSaisissez le nombre de medicament dont a besoin le patient"));
							Medicament[] prescription = new Medicament[50];
							for(int j = 0; j < nb; j ++) {
								String nomMed = inputOutput("\nSaisissez le nom du medicament:");
								int quantite = Integer.parseInt(inputOutput("\nSaisissez la quantite dont le patient a besoin"));
								Medicament medoc = new Medicament(nomMed, quantite);
								prescription[j] = medoc;
							}
							listePatient[i].setPrescription(prescription);
						}
					} else {
						System.out.println("Merci de rentrer un chiffre entre 0 et 4");
					}
				} catch (NumberFormatException e) {
		        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
		        }
			}
		} if(find == 0) {
			System.out.println("\nPatient introuvable dans la liste");
		}
	}
	
	public static void afficherStock() {
		for(int i = 0; i<nbMedocs; i++) {
			System.out.println((listeMedoc[i]).toString());
		}
	}
	
	public static void addMeds() {
		String nom = inputOutput("\nSaisissez le nom du nouveau medicament");
		int quantite = Integer.parseInt(inputOutput("\nSaisissez la quantite"));
		quantiteMeds += quantite;
		Medicament medoc = new Medicament(nom, quantite);
		listeMedoc[nbMedocs] = medoc;
		nbMedocs++;
	}
	
	public static void delMeds() {
		String nom = inputOutput("\nSaisissez le nom du medicament a effacer:");
		int find = 0;
		for (int i = 0; i < nbMedocs; i++) {
			if(listeMedoc[i].getNom()==nom) {
				find = 1;
				System.out.println("\nEtes vou sur de vouloir effacer " + listeMedoc[i].getNom() + "?\n");
				System.out.println("\n1. OUI");
				System.out.println("\n2. NON");
				
				try {
					int userInput = Integer.parseInt(inputOutput("\nSaisissez votre reponse:\n"));
					
					if(userInput >= 0 && userInput <= 1) {
						if(userInput == 1) {
							System.out.println("Suprression du medicament");
							quantiteMeds -= listeMedoc[i].getQuantite();
							listeMedoc[i] = null;
							nbMedocs --;
						}
						if(userInput == 0) {
							System.out.println("\nPatient conservé");
						}
					} else {
						System.out.println("Merci de rentrer un chiffre entre 0 et 4");
					}
				} catch (NumberFormatException e) {
		        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
		        }
			}
		} if(find == 0) {
			System.out.println("\nMedicament introuvable dans la liste");
		}
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
    
    public static void main(String[] args) {
    	//initialisation des medicaments deja presents dans les stocks de la pharamcie
    	Medicament doli = new Medicament("Doliprane", 20);
    	listeMedoc[nbMedocs] = doli;
    	nbMedocs ++;
    	quantiteMeds = doli.getQuantite();
    	
    	Medicament karde = new Medicament("Kardegic", 10);
    	listeMedoc[nbMedocs] = karde;
    	nbMedocs ++;
    	quantiteMeds = karde.getQuantite();
    	
    	Medicament keto = new Medicament("Ketoprofene", 12);
    	listeMedoc[nbMedocs] = keto;
    	nbMedocs ++;
    	quantiteMeds = keto.getQuantite();
    	
    	Medicament contra = new Medicament("Contramal", 17);
    	listeMedoc[nbMedocs] = contra;
    	nbMedocs ++;
    	quantiteMeds = contra.getQuantite();
    	
    	Medicament vog = new Medicament("Vogalene", 8);
    	listeMedoc[nbMedocs] = vog;
    	nbMedocs ++;
    	quantiteMeds = vog.getQuantite();
    	
    	Medicament primp = new Medicament("Primperan", 2);
    	listeMedoc[nbMedocs] = primp;
    	nbMedocs ++;
    	quantiteMeds = primp.getQuantite();
    	
    	Medicament spir = new Medicament("Spiriva", 13);
    	listeMedoc[nbMedocs] = spir;
    	nbMedocs ++;
    	quantiteMeds = spir.getQuantite();
    	
    	Medicament frag = new Medicament("Fragmin", 16);
    	listeMedoc[nbMedocs] = frag;
    	nbMedocs ++;
    	quantiteMeds = frag.getQuantite();
    	
    	Medicament frax = new Medicament("Fraxiparine", 4);
    	listeMedoc[nbMedocs] = frax;
    	nbMedocs ++;
    	quantiteMeds = frax.getQuantite();
    	
    	Medicament dompe = new Medicament("Domperidone", 9);
    	listeMedoc[nbMedocs] = dompe;
    	nbMedocs ++;
    	quantiteMeds = dompe.getQuantite();
    	
    	Medicament levo = new Medicament("Levothyrox", 18);
    	listeMedoc[nbMedocs] = levo;
    	nbMedocs ++;
    	quantiteMeds = levo.getQuantite();
    	
    	Medicament smec = new Medicament("Smecta", 14);
    	listeMedoc[nbMedocs] = smec;
    	nbMedocs ++;
    	quantiteMeds = smec.getQuantite();
    	
    	Medicament modo = new Medicament("Modopar", 7);
    	listeMedoc[nbMedocs] = modo;
    	nbMedocs ++;
    	quantiteMeds = modo.getQuantite();
    	
    	Medicament amlo = new Medicament("Amlor", 15);
    	listeMedoc[nbMedocs] = amlo;
    	nbMedocs ++;
    	quantiteMeds = amlo.getQuantite();
    	
    	Medicament coum = new Medicament("Coumadine", 19);
    	listeMedoc[nbMedocs] = coum;
    	nbMedocs ++;
    	quantiteMeds = coum.getQuantite();
    	
    	Medicament ster = new Medicament("Sterdex", 6);
    	listeMedoc[nbMedocs] = ster;
    	nbMedocs ++;
    	quantiteMeds = ster.getQuantite();
    	
    	Medicament top = new Medicament("Topalgic", 5);
    	listeMedoc[nbMedocs] = top;
    	nbMedocs ++;
    	quantiteMeds = top.getQuantite();
    	
    	Medicament temer = new Medicament("Temerite", 3);
    	listeMedoc[nbMedocs] = temer;
    	nbMedocs ++;
    	quantiteMeds = temer.getQuantite();
    	
    	Medicament tah = new Medicament("Tahor", 11);
    	listeMedoc[nbMedocs] = tah;
    	nbMedocs ++;
    	quantiteMeds = tah.getQuantite();
    	
    	Medicament fuc = new Medicament("Fucidine", 2);
    	listeMedoc[nbMedocs] = fuc;
    	nbMedocs ++;
    	quantiteMeds = fuc.getQuantite();
    	
    	//initialisation des patients deja presents dans l'hopital
    	
    	Patient lisa;
    	Medicament doliprane = new Medicament("Doliprane", 2);
    	Medicament[] prescriptionL = {doliprane};
    	lisa = new Patient("Manoban", "Lalisa", 25, prescriptionL);
    	listePatient[nbPatients] = lisa;
    	nbPatients ++;
    	
    	Patient jisoo;
    	Medicament fucidine = new Medicament("Fucidine", 1);
    	Medicament[] prescriptionJ = {doliprane, fucidine};
    	jisoo = new Patient("Kim", "Jisoo", 27, prescriptionJ);
    	listePatient[nbPatients] = jisoo;
    	nbPatients ++;
    	
    	Patient joe; 
    	Medicament tahor = new Medicament("Tahor", 1);
    	Medicament amlor = new Medicament("Amlor", 1);
    	Medicament fraxiparine = new Medicament("Fraxiparine", 1);
    	Medicament[] prescriptionJoe = {doliprane, tahor, amlor, fraxiparine};
    	joe = new Patient("Hisaichi", "Joe", 72, prescriptionJoe);
    	listePatient[nbPatients] = joe;
    	nbPatients ++;
    	
    	Patient eiichi;
    	Medicament spiriva = new Medicament("Sprivia", 1);
    	Medicament vogalene = new Medicament("Vogalene", 3);
    	Medicament contramal = new Medicament("Contramal", 2);
    	Medicament[] prescriptionE = {doliprane, spiriva, vogalene, contramal};
    	eiichi =  new Patient("Oda", "Eiichiro", 47 ,prescriptionE);
    	listePatient[nbPatients] = eiichi;
    	nbPatients ++;
    	
    	Patient emma;
    	Medicament kardegic = new Medicament("Kardegic", 1);
    	Medicament[] prescriptionEm = {doliprane, kardegic};
    	emma = new Patient("Watson", "Emma", 32, prescriptionEm);
    	listePatient[nbPatients] = emma;
    	nbPatients ++;
    	
    	Patient jenna;
    	Medicament[] prescriptionJenna = {doliprane};
    	jenna = new Patient("Ortega", "Jenna", 20, prescriptionJenna);
    	listePatient[nbPatients] = jenna;
    	nbPatients ++;
    	
    	
    	Patient jungkook;
    	Medicament ketoprofene = new Medicament("Ketoprofene", 2);
    	Medicament[] prescrptionKook = {doliprane, ketoprofene};
    	jungkook = new Patient("Jeon", "Jungkook", 25, prescrptionKook);
    	listePatient[nbPatients] = jungkook;
    	nbPatients++;
    	
    	Patient elon;
    	Medicament primperan = new Medicament("Primperan", 3);
    	Medicament fragmin = new Medicament("Fragmin", 1);
    	Medicament[] prescriptionElon = {doliprane, primperan, fragmin};
    	elon = new Patient("Musk", "Elon", 51, prescriptionElon);
    	listePatient[nbPatients] = elon;
    	nbPatients++;
    	
    	Patient hans;
    	Medicament domperidone = new Medicament("Domperidone", 3);
    	Medicament levothyrox = new Medicament("Levothyrox", 1);
    	Medicament smecta = new Medicament("Smecta", 3);
    	Medicament[] prescriptionHans = {doliprane, domperidone, levothyrox, smecta};
    	hans = new Patient("Zimmer", "Hans", 65, prescriptionHans);
    	listePatient[nbPatients] = hans;
    	nbPatients++;
    	
    	Patient jakub;
    	Medicament[] prescriptionO = {doliprane};
    	jakub = new Patient("Orlinski", "Jakub", 32, prescriptionO);
    	listePatient[nbPatients] = jakub;
    	nbPatients++;
    	
    	Patient alex;
    	Medicament coumadine = new Medicament("Coumadine", 1);
    	Medicament sterdex = new Medicament("Sterdex", 3);
    	Medicament topalgic = new Medicament("Topalgic", 3);
    	Medicament[] prescriptionD = {doliprane, coumadine, sterdex, topalgic};
    	alex = new Patient("Desplat", "Alexandre", 61, prescriptionD);
    	listePatient[nbPatients] = alex;
    	nbPatients++;
    	
		mainMenu();
	}
}
