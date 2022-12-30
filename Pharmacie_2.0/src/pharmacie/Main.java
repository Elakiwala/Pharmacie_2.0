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
	
	public static void menuPatient() {
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
	
	public static void menuPatientI() {
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
	
	public static void menuPatientAS() {
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
	
	public static void menuPharmacie() {
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
			//retour a un menu
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
						if(userInput == 0) {
							System.out.println("\nMedicaments comservé dans la commande");
						}
					} else {
						System.out.println("Merci de rentrer un chiffre entre 0 et 4");
		            	//menu de quelque chose
					}
				} catch (NumberFormatException e) {
		        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
		        	//menu de quelque chose
		        }
			}
		} if(find == 0) {
			System.out.println("\n Le patient n'est pas dans la liste de cet hopital");
			//retour a un menu
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
		delAllCommande();
	}
	
	public static void delAllCommande() {
		System.out.println("\nLa liste de commande va etre vidée, vous confirmez?\n");
		System.out.println("\n1. OUI");
		System.out.println("\n2. NON");
		
		try {
			int userInput = Integer.parseInt(inputOutput("\nSaisissez votre reponse:\n"));
			
			if(userInput >= 0 && userInput <= 1) {
				if(userInput == 0) {
					System.out.println("\nSuppression des commandes");
					for(int i = 0; i<nbMedocCommande; i++) {
						commande[i] = null;
					}
				}
				if(userInput == 1) {
					System.out.println("\nMaintient de la commande");
				}
			} else {
				System.out.println("Merci de rentrer un chiffre entre 0 et 4");
            	//menu de quelque chose
			}
		} catch (NumberFormatException e) {
        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
        	//menu de quelque chose
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
		int age = Integer.parseInt("Saississez l'age d nouveau patient");
		int quantite = Integer.parseInt("Saisissez le nombre de medicaments dont a besoin le nouveau patient:\n");
		Medicament[] prescription = new Medicament[50];
		for(int i = 0; i<quantite; i++) {
			String name = inputOutput("Saisissez le nom du medicament");
			int nombre = Integer.parseInt(inputOutput("Saisissez le nombre de medicament qu'il lui faut"));
			Medicament medoc = new Medicament(name, nombre);
			prescription[i] = medoc;
			//ajouter les medocs a la pharmacie
			listeMedoc[nbMedocs] = medoc;
			quantiteMeds += nombre;
			nbMedocs++;
		}
		Patient patient = new Patient(nom, prenom, age, prescription);
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
		            	//menu de quelque chose
					}
				} catch (NumberFormatException e) {
		        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
		        	//menu de quelque chose
		        }
			}
		} if(find == 0) {
			System.out.println("\nPatient introuvable dans la liste");
			//retour a un menu
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
							String prenom = inputOutput("\nSaisissez le noouveau prenom du patient");
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
		            	//menu de quelque chose
					}
				} catch (NumberFormatException e) {
		        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
		        	//menu de quelque chose
		        }
			}
		} if(find == 0) {
			System.out.println("\nPatient introuvable dans la liste");
			//retour a un menu
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
		            	//menu de quelque chose
					}
				} catch (NumberFormatException e) {
		        	System.out.println("Merci de rentrer un chiffre de 0 à 3");
		        	//menu de quelque chose
		        }
			}
		} if(find == 0) {
			System.out.println("\nMedicament introuvable dans la liste");
			//retour a un menu
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
		mainMenu();
	}
}
