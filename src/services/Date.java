package services;

public class Date {
	private int jour;
	private int mois;
	private int ans;
	private int heure;
	private int minute;
	private int seconde;
	
	/**
	 * @param jour
	 * @param mois
	 * @param ans
	 */
	public Date(int jour, int mois, int ans) {
		this.jour = jour;
		this.mois = mois;
		this.ans = ans;
		this.heure = 0;
		this.minute = 0;
		this.seconde = 0;
	}

	/**
	 * @return the jour
	 */
	public int getJour() {
		return jour;
	}

	/**
	 * @return the mois
	 */
	public int getMois() {
		return mois;
	}

	/**
	 * @return the ans
	 */
	public int getAns() {
		return ans;
	}

	/**
	 * @return the heure
	 */
	public int getHeure() {
		return heure;
	}

	/**
	 * @return the minute
	 */
	public int getMinute() {
		return minute;
	}

	/**
	 * @return the seconde
	 */
	public int getSeconde() {
		return seconde;
	}
	
	@Override
	public String toString() {
		return "Date [" + heure + ":" + minute + ":" + seconde + " " + jour + "/" + mois + "/" + ans + "]";
	}
}
