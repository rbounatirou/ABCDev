package utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import especes.Algue;
import especes.Poisson_Carnivore;
import especes.Poisson_Herbivore;

public class Jeu implements java.io.Serializable{
	private Aquarium aquarium;
	
	public Jeu() {
		aquarium = new Aquarium();
		File sauvegarde = new File("save.txt");
		if (sauvegarde.exists()) {
			try {
				sauvegarde.delete();
			} catch (Exception e) {}
		} 
	}
	
	public Jeu(Aquarium _aquarium) {
		aquarium = _aquarium;
	}
	
	public boolean serialize() {
		boolean rt = true;
		
		try {
			FileOutputStream fileOut = new FileOutputStream("save.ser");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(this);
			out.close();
			fileOut.close();
		} catch (Exception e) {
			//e.printStackTrace();
			rt= false;
		}
		return rt;
	}
	
	public void gererJeu() {
		Scanner sc = new Scanner(System.in);
		boolean veutQuitter = false;
		boolean saisieCorrecte;
		int debut;
		String str = "";
		String[] split;
		int nbrTmp, nbrTmp2; // INSERTION
		int currentInserted;
		int i;
		String poissonNom;
		while (!veutQuitter) {
			saisieCorrecte = false;
			aquarium.afficherContenu();
			do {
				System.out.println("Que voulez vous faire?");
				str = sc.nextLine().toLowerCase();
				split = str.split(" ");
				if (split[0].equals("quit") && split.length == 1) {
					saisieCorrecte = true;
					veutQuitter = true;
				} else if (split[0].equals("turn") && split.length == 1) {
					saisieCorrecte = true;
				} else if (split[0].equals("list") && split.length == 1) {
					aquarium.afficherCommands();
					aquarium.afficherContenu();
				} else if (split[0].equals("resume") && split.length == 1) {
					aquarium.afficherContenu();
				} else if (split[0].equals("insert") && split.length > 1) {
					if ((split[2].equals("algues") || split[2].equals("algue")) && split.length >= 4) {
						try {
							nbrTmp = Integer.parseInt(split[1]);
							nbrTmp2 = Integer.parseInt(split[3]);
							currentInserted = 0;
							for (i = 0; i < nbrTmp; i++) {
								if (aquarium.ajouterEtreVivant(new Algue(((byte)(10+nbrTmp2)),(byte)nbrTmp2),false)) {
									currentInserted++;
								}
							}
							if (currentInserted == nbrTmp2) {
								System.out.println("Ajout des algues avec succ�s");
							}
							i=0;
						} catch (Exception e) {
							System.out.println("Saisie invalide");
						}
					} else { // POISSON
						try {
							nbrTmp = Integer.parseInt(split[3]);
							nbrTmp2 = -1;
							poissonNom = split[1].toUpperCase().charAt(0) + split[1].substring(1,split[1].length());
							split[2] = split[2].toUpperCase().charAt(0) + split[2].substring(1,split[2].length());
							i=0;
							while(i < Poisson_Carnivore.getEspecesPossibles().length && nbrTmp2 == -1) {
								if (Poisson_Carnivore.getEspecesPossibles()[i].equals(split[2].replace(",", ""))){
									nbrTmp2 = i;
								}
								i++;
							}
							if (nbrTmp2<0) {
								i=0;
								
								while(i < Poisson_Herbivore.getEspecesPossibles().length && nbrTmp2 == -1 && split[2].length() >= 2) {
									
									if (Poisson_Herbivore.getEspecesPossibles()[i].equals(split[2].replace(",", ""))){
										nbrTmp2 = i;
									}
									i++;
								}
								if (nbrTmp2 < 0) {
									System.out.println("Le " + split[2].replace(",", "") + " n'est pas une race de poisson connue");
								}
								else {
									// POISSON HERBIVORE
									if (aquarium.ajouterEtreVivant(new Poisson_Herbivore(poissonNom.replace(",",""),(byte)nbrTmp2,(byte)nbrTmp),false)) {
										System.out.println("Ajout du poisson effectu�");
									}
										
								}
							} else {
								// POISSON CARNIVORE
								if (aquarium.ajouterEtreVivant(new Poisson_Carnivore(poissonNom.replace(",",""),(byte)nbrTmp2,(byte)nbrTmp),false)){
									System.out.println("Ajout du poisson effectu�");
								}
							}
						} catch (Exception e){
							System.out.println("Erreur de saisie");
						}
					}
					
				}
			} while (!saisieCorrecte);
			if (!veutQuitter) {
				// -- ON SAUVEGARDE
				aquarium.effectuerTour();
				if(serialize()) {
					System.out.println("Sauvegarde r�ussie");
				} else {
					System.out.println("Echec de la sauvagarde");
				}
			}
		}		
		sc.close();
	}
}
