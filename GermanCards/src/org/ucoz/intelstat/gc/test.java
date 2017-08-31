package org.ucoz.intelstat.gc;

public class test {

	public static void main(String[] args) {
		GDeck deck = GDeck.shuffledDeck();
		System.out.println(deck.getInitialSize());
		for(int i = 0; i < deck.getInitialSize(); i++) {
			GCard card = deck.dealCard();
			System.out.println(card.toString() + ", " + deck.getSize());
		}
	}
}
