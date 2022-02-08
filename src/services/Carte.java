package services;

import java.time.LocalDateTime;

public class Carte {
	private int [] code = new int[4];
	private Banque banque;
	private int numeroClient;
	private int numeroCompte;
	private Date dateValid;
	private int compteur = 3;
	
	
	/**
	 * @param code
	 * @param banque
	 * @param numeroClient
	 * @param numeroCompte
	 * @param dateValid
	 */
	public Carte(int[] code, Banque banque, int numeroClient, int numeroCompte, Date dateValid) {
		this.code = code;
		this.banque = banque;
		this.numeroClient = numeroClient;
		this.numeroCompte = numeroCompte;
		this.dateValid = dateValid;
	}

	/**
	 * Verifie que le code soit valide
	 * @param code
	 * @return
	 */
	public Boolean codeValide(int[] code) {
		if (compteur <= 0) {
			System.out.println("Carte bloqué, merci de contacter votre banque.");
			return false;
		}
		for (int i = 0; i < 4; i++) {
			if (this.code[i] != code[i]) {
				System.out.println("Code incorrect.");
				return false;
			}
		}
		return true;
	}
	
	/**
	 * @return the numeroClient
	 */
	public int getNumeroClient() {
		return numeroClient;
	}

	/**
	 * @return the numeroCompte
	 */
	public int getNumeroCompte() {
		return numeroCompte;
	}

	/**
	 * @return the banque
	 */
	public Banque getBanque() {
		return banque;
	}


	/**
	 * @return the validite
	 */
	public Date getDateValid() {
		return dateValid;
	}

	/**
	 * Permet de payer avec la carte.
	 * @param b
	 * @param numClient
	 * @param numCompte
	 * @param montant
	 */
	public void payer(Banque b, int numClient, int numCompte, float montant) {
		banque.getClient(numeroClient).getCompte(numeroCompte).virer(montant, b.getClient(numClient).getCompte(numCompte));
	}
	
	/**
	 * Verifie la validitée de la carte.
	 * @return
	 */
	public boolean isExpired() {
		LocalDateTime maintenant = LocalDateTime.now();
		LocalDateTime date = LocalDateTime.of(dateValid.getAns(), dateValid.getMois(), dateValid.getJour(), dateValid.getHeure(), dateValid.getMinute());
		return maintenant.isAfter(date);
	}
}
