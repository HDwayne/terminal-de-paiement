package services;

import java.util.ArrayList;

public class Banque {
	private int NB_MAX_Client = 100;
	
	private String nom;
	private int nbClient;
	private ArrayList<Client> allClient = new ArrayList<>(100);
	
	/**
	 * @param nom
	 */
	public Banque(String nom) {
		this.nom=nom;
		this.nbClient=0;
	}
	
	/**
	 * ajoute un nouveau Client.
	 * @param client
	 * @return 0 si ajouté sans problème. 1 sinon.
	 */
	public void ajouterClient(Client client) {
		if (nbClient+1 <= NB_MAX_Client) {
			allClient.add(client);
			nbClient++;
		}
		else {
			System.out.println("Ajout de compte impossible, nombre de compte maximum atteint");
		}
	}
	
	/**
	 * renvoie le client correspondant au numero
	 * @param numero
	 * @return
	 */
	public Client getClient(int numero) {
		return allClient.get(numero);
	}
	
	/**
	 * affiche le solde total de chaque Client
	 */
	public void afficherBilan() {
		System.out.println("---------- Bilan " + nom + " ----------");
		for (int i = 0; i < nbClient; i++) {
			System.out.println(getClient(i).getNom() + " possède au total " + getClient(i).soldeTotal() + "€.");
		}
		System.out.println("---------------- " + nom + " -----------");
	}
	
	/**
	 * la banque autorise ou non la transaction.
	 * @param cb
	 * @param montant
	 * @return
	 */
	public String genererAutorisation(Carte cb, float montant){
		if (getClient(cb.getNumeroClient()).getCompte(cb.getNumeroCompte()).getSolde() >= montant && montant <= 1000) {
			if (!cb.isExpired()) {
				return "OK";
			}
		}
		return "KO";
	}
	
	/**
	 * Cherche le numero client d'une personne
	 * @param client
	 * @return
	 */
	public int getNumClient(Client client) {
		for (int i = 0; i < nbClient; i++) {
			if (getClient(i).getNom().compareTo(client.getNom()) == 0) {
				return i;
			}
		}
		return -1;
	}
}
