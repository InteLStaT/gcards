package org.ucoz.intelstat.gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Holds a list of {@code GCard}s. A GCard can appear only once in the deck.
 * Cards can be dealt, which are also removed from the deck, thus decrementing
 * its size. Cards can't be added after instantiation. Creating decks is done
 * via the static factory methods provided by this class.
 * 
 * @author InteLStaT
 *
 */
public class GDeck {

	public static final int DECK_MAX_SIZE = 32;

	private final int initSize;
	private int size;
	private int prevSize;
	private int dealtCardCt = 0;
	private List<GCard> deck;

	private GDeck(int size) {
		initSize = this.size = size;
		deck = new ArrayList<>(size);
	}

	/**
	 * Shuffles the deck, randomizing the order of the cards present in it.
	 */
	public void shuffle() {
		Random rgen = new Random();
		for (int i = 0; i < initSize; i++) {
			int rand = rgen.nextInt(initSize);
			GCard temp = deck.get(i);
			deck.set(i, deck.get(rand));
			deck.set(rand, temp);
		}
	}

	/**
	 * Creates an ordered deck of cards. Cards are ordered by suit first, then
	 * rank.
	 */
	public static GDeck orderedDeck() {
		GDeck deck = new GDeck(DECK_MAX_SIZE);
		for (GCard.Suit suit : GCard.Suit.values()) {
			for (GCard.Rank rank : GCard.Rank.values()) {
				deck.deck.add(new GCard(rank, suit));
			}
		}
		return deck;
	}

	/**
	 * Creates a shuffled deck. Equivalent (up to being random) to
	 * {@code GDeck.orderedDeck().shuffle()}
	 */
	public static GDeck shuffledDeck() {
		GDeck deck = orderedDeck();
		deck.shuffle();
		return deck;
	}

	/**
	 * Creates a deck of cards from an array.
	 */
	public static GDeck customDeck(GCard... cards) {
		GDeck deck = new GDeck(cards.length);
		for (GCard card : cards) {
			deck.deck.add(card);
		}
		return deck;
	}

	/**
	 * Creates a deck of cards from an {@code ArrayList}.
	 */
	public static GDeck customDeck(List<GCard> cards) {
		GDeck deck = new GDeck(cards.size());
		deck.deck.addAll(cards);
		return deck;
	}

	/**
	 * Removes the card from the top of the deck and returns it.
	 * 
	 * @return the card on top of the deck
	 */
	public GCard dealCard() {
		if (dealtCardCt < initSize) {
			dealtCardCt++;
			prevSize = size;
			size = initSize - dealtCardCt;
			return deck.get(initSize - dealtCardCt);
		} else {
			throw new IllegalStateException("The deck is empty; no cards left to deal.");
		}
	}

	/**
	 * Deals a specified number of cards to the specified hand.
	 */
	public void dealTo(GHand hand, int number) {
		if (number < size) {
			for (int i = 0; i < number; i++) {
				hand.addCard(dealCard());
			}
			prevSize = size + number;
		}
		else {
			throw new IllegalArgumentException("Not enough cards in deck");
		}
	}

	public int getSize() {
		return size;
	}

	public int getInitialSize() {
		return initSize;
	}

	/**
	 * Used to check if there are no cards left in the deck.
	 */
	public boolean isEmpty() {
		if (dealtCardCt == initSize) {
			return true;
		}
		return false;
	}
}
