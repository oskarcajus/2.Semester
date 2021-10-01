package Lektion_11_Tidskompleksitet.nedboer;

public class Nedboer {
	private int[] nedboerPrUge = { 20, 10, 12, 12, 13, 14, 15, 10, 8, 7, 13, 15, 10, 9, 6, 8, 12, 22, 14, 16, 16, 18,
			23, 12, 0, 2, 0, 0, 78, 0, 0, 0, 34, 12, 34, 23, 23, 12, 44, 23, 12, 34, 22, 22, 22, 22, 18, 19, 21, 32, 24,
			13 };

	/**
	 * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien, hvis
	 * man ønsker den minimale nedbørsmængde i de tre uger
	 *
	 * @return
	 */

	public int bedsteTreFerieUger() {
		int bedsteUgeStart = 0;
		int minimum = Integer.MAX_VALUE;

		for (int i = 0; i < this.nedboerPrUge.length - 3; i++) {
			int actualSum = 0;
			for (int j = i; j <= i + 2; j++) {
				actualSum = actualSum + this.nedboerPrUge[j];
			}
			if (actualSum < minimum) {
				minimum = actualSum;
				bedsteUgeStart = i;
			}
		}

		return bedsteUgeStart;

	}

	/**
	 * Returnerer ugenummeret for den uge i året, hvor man skal starte ferien, hvis
	 * man ønsker den minimale nedbørsmængde i det "antal" uger, der er angivet i
	 * paramtereren
	 *
	 * @return
	 */

	public int bedsteFerieUgerStart(int antal) {
		int bedsteUgeStart = 0;
		int minimum = Integer.MAX_VALUE;

		for (int i = 0; i < this.nedboerPrUge.length - antal; i++) {
			int actualSum = 0;
			for (int j = i; j <= i + antal - 1; j++) {
				actualSum = actualSum + this.nedboerPrUge[j];
			}
			if (actualSum < minimum) {
				minimum = actualSum;
				bedsteUgeStart = i;
			}
		}

		return bedsteUgeStart;

	}

	/**
	 * Returnerer ugenummeret på den første uge hvor nedbøren har været præcis den
	 * samme flest uger i træk
	 *
	 * @return
	 */

	// Giver 40, men skal give 42 ????
	public int ensNedboer() {
		int flestEnsUgerStart = 0;
		int maximum = 1; // Starter på 1 da der altid er 1 ens
		int antalEns = 1; // Starter på 1 da der altid er 1 ens

		for (int i = 0; i < this.nedboerPrUge.length - 1; i++) {
			if (this.nedboerPrUge[i] == this.nedboerPrUge[i + 1]) {
				antalEns++;
				if (antalEns > maximum) {
					maximum = antalEns;
					flestEnsUgerStart = (i + 1) - maximum;
				}

			} 
			else {
				antalEns = 0;
			}

		}

		return flestEnsUgerStart;

	}
}
