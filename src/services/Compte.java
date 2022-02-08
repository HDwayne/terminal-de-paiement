package services;

public class Compte {
	private float solde;

	public Compte() {
		this.solde = 0;
	}

	/**
	 * @return the solde
	 */
	public float getSolde() {
		return solde;
	}
	
	/**
	 * affiche le solde du compte
	 */
	public void afficherSolde() {
		System.out.println("Solde du compte: " + solde);
	}
	
	/**
	 * pour faire un depot sur le compte 
	 * @param valeur
	 */
	public void depot(float valeur) {
		solde+=valeur;
	}
	
	/**
	 * pour faire un retrait sur le compte 
	 * @param valeur
	 */
	public void retrait(float valeur) {
		solde-=valeur;
	}
	
	
	/**
	 * pour virer de l’argent vers le compte destinataire
	 * @param valeur
	 * @param destinataire
	 */
	public void virer(float valeur, Compte destinataire) {
		destinataire.depot(valeur);
		retrait(valeur);
	}
}
