package services;

import java.util.ArrayList;

public class Client {
	private int NB_MAX_COMPTE = 100;
	
	private String nom;
	private Date dateNaissance;
	private ArrayList<Compte> allCompte = new ArrayList<>(100);
	private int nbCompte;
	
	/**
	 * @param nom
	 * @param dateNaissance
	 */
	public Client(String nom, Date dateNaissance) {
		this.nom = nom;
		this.dateNaissance = dateNaissance;
		ajouterCompte();
	}

	/**
	 * renvoie le nom du client
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * renvoie la date de naissance du client
	 * @return the dateNaissance
	 */
	public Date getDateNaissance() {
		return dateNaissance;
	}
	
	/**
	 * renvoie le compte correspondant au numero
	 * @param numero
	 * @return
	 */
	public Compte getCompte(int numero) {
		return allCompte.get(numero);
	}
	
	/**
	 * affiche le solde de chaque compte
	 */
	public void afficherBilan() {
		for (int i = 0; i < nbCompte; i++) {
			System.out.println(getCompte(i).getSolde() + "€ dans le compte numéro " + i + " de " + nom + ".");
		}
	}
	
	/**
	 * calcule le solde total
	 * @return solde total
	 */
	public float soldeTotal() {
		float total=0;
		for (int i = 0; i < nbCompte; i++) {
			total+=getCompte(i).getSolde();
		}
		return total;
	}
	
	/**
	 * affiche le solde total
	 */
	public void afficherSolde() {
		System.out.println("Solde total :" + soldeTotal() + "€.");
	}
	
	/**
	 * ajoute un nouveau compte
	 * @return 0 si ajouté sans problème. 1 sinon.
	 */
	public int ajouterCompte() {
		if (nbCompte+1 <= NB_MAX_COMPTE) {
			allCompte.add(new Compte());
			nbCompte++;
			return 0;
		}
		else {
			System.out.println("Ajout de compte impossible, nombre de compte maximum atteint");
			return 1;
		}
	}
}
