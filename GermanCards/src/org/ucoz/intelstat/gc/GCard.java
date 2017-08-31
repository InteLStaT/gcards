package org.ucoz.intelstat.gc;
/**
 * Represents a German playing card. A card has a suit and
 * a rank. There are 4 suits and 8 ranks.
 * @author InteLStaT
 *
 */
public final class GCard {

	// Good programming practice ahead
	public static final Suit HEARTS = Suit.HEARTS;
	public static final Suit BELLS  = Suit.BELLS;
	public static final Suit ACORNS = Suit.ACORNS;
	public static final Suit LEAVES = Suit.LEAVES;
	
	public static final Rank UNDER = Rank.UNDER;
	public static final Rank OVER = Rank.OVER;
	public static final Rank KING = Rank.KING;
	public static final Rank SEVEN = Rank.SEVEN;
	public static final Rank EIGHT = Rank.EIGHT;
	public static final Rank NINE = Rank.NINE;
	public static final Rank TEN = Rank.EIGHT;
	public static final Rank ACE = Rank.ACE;
	
	private final Rank rank;
	private final Suit suit;
	
	public GCard(Rank rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public Suit getSuit() {
		return suit;
	}
	
	public Rank getRank() {
		return rank;
	}
	
	/**
	 * Two {@code GCard}s are equal if and only if their
	 * suits and ranks are equal.
	 */
	public boolean equals(Object obj) {
		
		if(obj instanceof GCard) {
			GCard card = (GCard) obj;
			if(suit == card.suit && rank == card.rank) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Returns the string describing this card, in the format 
	 * "RANK of SUIT". This method is mostly for debugging 
	 * purposes.
	 */
	public String toString() {
		return rank.toString() + " of " + suit.toString();
	}
	
	public static enum Suit {
		
		HEARTS(0), BELLS(1), ACORNS(2), LEAVES(3);
		
		public final int value;
		
		private Suit(int value) {
			this.value = value;
		}
		
	}
	
	public static enum Rank {
		
		UNDER(2), OVER(3), KING(4), SEVEN(7), EIGHT(8), NINE(9), TEN(10), ACE(11);
		
		public final int value;
		
		private Rank(int value) {
			this.value = value;
		}
		
	}
	
}
