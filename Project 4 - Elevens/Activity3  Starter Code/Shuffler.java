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
		int[] halfDeckOne = new int[VALUE_COUNT / 2];
		int[] halfDeckTwo = new int[VALUE_COUNT - VALUE_COUNT / 2];
		
		for(int i = 0; i < VALUE_COUNT - 2; i++)
		{
			halfDeckOne[i] = values[i];
		}
		
		for(int i = 0; i < VALUE_COUNT - VALUECOUNT / 2; i++)
		{
			halfDeckTwo[i] = values[i + VALUE_COUNT / 2];
		}
		
		for( int i = 0; i < VALUE_COUNT / 2; i++ ) 
		{
			values[ 2 * i ] = halfDeckTwo[i];
			values[ 2 * i + 1 ] = halfDeckOne[i];
		}
		if( VALUE_COUNT % 2 != 0 ) 
		{
			values[ VALUE_COUNT - 1 ] = halfDeckTwo[ VALUE_COUNT - VALUE_COUNT / 2 ];
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
		for( int i = VALUE_COUNT - 1; i >= 0; i-- ) 
		{
			int rand = (int)(Math.random() * i);
			int shuff = values[rand];
			values[rand] = values[i];
			values[i] = shuff;
	}
}
