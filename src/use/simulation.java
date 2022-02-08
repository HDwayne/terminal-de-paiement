package use;

import services.Banque;
import services.Carte;
import services.Client;
import services.Date;
import services.Terminal;

public class simulation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Banque PeopleBank = new Banque("PeopleBank");
		Banque GoldenBank = new Banque("GoldenBank");
		
		Client moi = new Client("Dwayne", new Date(30,12,2002));
		Client toi = new Client("Nathan", new Date(8,02,2002));
		toi.ajouterCompte();
		
		moi.getCompte(0).depot(300);
		toi.getCompte(0).depot(13450);
		toi.getCompte(1).depot(125000);
		
		moi.afficherBilan();
		moi.afficherSolde();
		
		System.out.println();
		
		toi.afficherBilan();
		toi.afficherSolde();
	
		Client Store1 = new Client("Store1", new Date(23,04,2000));

		PeopleBank.ajouterClient(moi);
		PeopleBank.ajouterClient(toi);
		GoldenBank.ajouterClient(Store1);

		int[] code1 = {1,2,3,4};
		int[] code2 = {4,3,2,1};
		
		Carte cbmoi = new Carte(code1, PeopleBank, PeopleBank.getNumClient(moi), 0, new Date(12, 3, 2050));
		Carte cbtoi = new Carte(code2, PeopleBank, PeopleBank.getNumClient(toi), 1, new Date(1, 1, 2023));

		Terminal term01 = new Terminal(GoldenBank, GoldenBank.getNumClient(Store1), 0);
		
		System.out.println();
		
		term01.payer(30, cbmoi, code1);
		PeopleBank.afficherBilan();
		GoldenBank.afficherBilan();
		
		System.out.println();
		
		term01.payer(999, cbtoi, code2);
		PeopleBank.afficherBilan();
		GoldenBank.afficherBilan();
		
		System.out.println();
		
		moi.afficherBilan();
		moi.afficherSolde();
		
		System.out.println();
		
		toi.afficherBilan();
		toi.afficherSolde();
	}

}
