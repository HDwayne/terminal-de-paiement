package services;

public class Terminal {
	private Banque banque;
	private int numClient;
	private int numCompte;
	
	/**
	 * @param banque
	 * @param numClient
	 * @param numCompte
	 */
	public Terminal(Banque banque, int numClient, int numCompte) {
		this.banque = banque;
		this.numClient = numClient;
		this.numCompte = numCompte;
	}
	
	/**
	 * Permet de payer dans un terminal
	 * @param montant
	 * @param cb
	 * @param code
	 */
	public int payer(float montant, Carte cb, int[] code) {
		if (cb.codeValide(code)) {
			if (cb.getBanque().genererAutorisation(cb, montant).equals("OK")) {
				cb.payer(banque, numClient, numCompte, montant);
				return 0;
			} else {
				System.out.println("Versement refusé par la banque !");
			}
		} else {
			System.out.println("Code invalide !");
		}
		return 1;
	}
}
