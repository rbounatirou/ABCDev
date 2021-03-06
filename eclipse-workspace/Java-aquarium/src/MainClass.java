import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Scanner;

import utils.Jeu;
// JAVAQUARIUM
public class MainClass {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String saisieTmp;
		Jeu monJeu = null;
		boolean load = false;
		File f1 = new File("save.ser");
		if (f1.exists() && !f1.isDirectory()) {
			// UN FICHIER EXISTE
			do {
				System.out.println("Reprendre la partie?");
				saisieTmp = sc.nextLine().toUpperCase();
				if (!saisieTmp.equals("OUI") && !saisieTmp.equals("NON"))
					System.out.println("Veuillez rentrer oui ou non");
			} while (!saisieTmp.equals("OUI") && !saisieTmp.equals("NON"));
			if (saisieTmp.equals("OUI")) {
				try {
					FileInputStream fIn = new FileInputStream("save.ser");
					ObjectInputStream in = new ObjectInputStream(fIn);
					monJeu = (Jeu) in.readObject();
					load = true;
					in.close();
					fIn.close();
					
				} catch (IOException e) {
					System.out.println("failed to load");
					System.out.println(e.getMessage());
					// IGNORE
				} catch (ClassNotFoundException c) {
					System.out.println("failed to load");
					System.out.println(c.getMessage());
					// IGNORE
				}
			}
			if (!load) {
				try {
					f1.delete();
				} catch (Exception e) {}
			}
		}
		if (!load) {
		
			monJeu = new Jeu();
		}
		monJeu.gererJeu();
		sc.close();

	}
}
