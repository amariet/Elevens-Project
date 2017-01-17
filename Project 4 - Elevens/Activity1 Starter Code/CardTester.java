/**
 * This is a class that tests the Card class.
 */
public class CardTester {

	/**
	 * The main method in this class checks the Card operations for consistency.
	 *	@param args is not used.
	 */
	public static void main(String[] args) {
		Card cardOne = new Card("Spade", "3", 3);
		Card cardTwo = new Card("Spade", "3", 3);
		Card cardThree = new Card("Spade", "Club", 4);
		
		System.out.println(cardThree.toString());
		
		System.out.println("Card one and card two should match! : " + cardTwo.matches(cardOne));
		System.out.println("Card one and card two shouldn't match :( : " + !cardTwo.matches(cardThree));
	}
}
