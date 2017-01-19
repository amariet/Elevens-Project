/**
 * This is a class that tests the Deck class.
 */
public class DeckTester {

	/**
	 * The main method in this class checks the Deck operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		String[] firstRank = {"King", "Queen", "Jack"};
		String[] firstSuit = {"Hearts", "Spades", "Diamonds"};
		int[] firstValue = {9, 10, 12};
		Deck firstDeck = new Deck(firstRank, firstSuit, firstValue);
	        System.out.println("This deck must have a size should of 3: " + firstDeck.size());
	    
	        String[] secondRank = {"King", "12", "Queen"};
	        String[] secondSuit= {"Clubs", "Hearts", "Diamonds"};
	        int[] secondValue = {1, 9, 13};
	        Deck secondDeck = new Deck(secondRank, secondSuit, secondValue);
	        System.out.println("This deck should be filled: " + !secondDeck.isEmpty());
	    
	        String[] thirdRank = {"King", "6", "2"};
	        String[] thirdSuit = {"Spades", "Diamonds", "Hearts"};
	        int[] thirdValue = {11, 4, 6};
	        Deck thirdDeck = new Deck(thirdRank, thirdSuit, thirdValue);
	        System.out.println("This card has dealt this card: " + thirdDeck.deal());
	}
}
