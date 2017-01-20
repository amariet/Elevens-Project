/**
 * This class provides a convenient way to test shuffling methods.
 */
public class Shuffler {

	/**
	 * The number of consecutive shuffle steps to be performed in each call
	 * to each sorting procedure.
	 */
	private static final int SHUFFLE_COUNT = 1;


	/**
	 * Tests shuffling methods.
	 * @param args is not used.
	 */
	public static void main(String[] args) {
		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive perfect shuffles:");
		int[] values1 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			perfectShuffle(values1);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values1.length; k++) {
				System.out.print(" " + values1[k]);
			}
			System.out.println();
		}
		System.out.println();

		System.out.println("Results of " + SHUFFLE_COUNT +
								 " consecutive efficient selection shuffles:");
		int[] values2 = {0, 1, 2, 3};
		for (int j = 1; j <= SHUFFLE_COUNT; j++) {
			selectionShuffle(values2);
			System.out.print("  " + j + ":");
			for (int k = 0; k < values2.length; k++) {
				System.out.print(" " + values2[k]);
			}
			System.out.println();
		}
		System.out.println();
	}


	/**
	 * Apply a "perfect shuffle" to the argument.
	 * The perfect shuffle algorithm splits the deck in half, then interleaves
	 * the cards in one half with the cards in the other.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void perfectShuffle(int[] values) {
		int[] shuffled = new int[values.length]; //placeholder array
		int k = 0; //placeholder variables
		int i = 0;
		int halfDeck; //initialozes half the deck
		
		if(values.length % 2 == 0) //if the deck is even, split at the halfway point
		{
			halfDeck = values.length / 2;
		}
		else //if the deck is odd, split at halfway point
		{
			halfDeck = (values.length + 1) / 2;
		}
		
		while(i < halfDeck) //while in the first half of the deck
		{
			shuffled[k] = values[i]; //assigns i in values to k in shuffled
			k = k + 2; //increments location by two, leaving an empty space
			i++;
		}
		
		k = 1; //sets placeholder to 1, to fill odd positions
		i = halfDeck; //sets i placeholder to the halfway point of the deck
		while(i < values.length) //while in the second half
		{
			shuffled[k] = values[i]; //assigns i in values to k in shuffled
			k = k + 2;//increments location by two, filling the empty spaces
			i++; //increments counter
		}
		
		for( int j = 0; j < values.length; j++) //copies all elements from shuffled to original array
		{
			values[j] = shuffled[j];
		}
	}

	/**
	 * Apply an "efficient selection shuffle" to the argument.
	 * The selection shuffle algorithm conceptually maintains two sequences
	 * of cards: the selected cards (initially empty) and the not-yet-selected
	 * cards (initially the entire deck). It repeatedly does the following until
	 * all cards have been selected: randomly remove a card from those not yet
	 * selected and add it to the selected cards.
	 * An efficient version of this algorithm makes use of arrays to avoid
	 * searching for an as-yet-unselected card.
	 * @param values is an array of integers simulating cards to be shuffled.
	 */
	public static void selectionShuffle(int[] values) {
		for(int i = (values.length - 1);  i >= 0; i--) //array is traversed dtarting from last position
		{
			int rand = (int)(Math.random() * (values.length -1)); //random var in array
			int shuff = values[i]; //stores last element in a placeholder
			values[i] = values[rand]; //replaces the element with a random location
			values[rand] = shuff; //replaces the random location with the last element stored in shuff
		}
	}
}
