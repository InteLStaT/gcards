package org.ucoz.intelstat.gc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GHand {

	private List<GCard> cards;
	private List<GCard> view;

	public GHand() {
		cards = new ArrayList<>();
		view = Collections.unmodifiableList(cards);
	}

	public void addCard(GCard card) {
		if (card != null && !cards.contains(card)) {
			cards.add(card);
		} else {
			throw new IllegalArgumentException("The card is already present in this hand");
		}
	}

	public void removeCard(GCard card) {
		boolean isRemoved = cards.remove(card);
		if (!isRemoved) {
			throw new IllegalArgumentException("This hand doesn't contain the specified card");
		}
	}

	public void removeCard(int index) {
		if (index < cards.size()) {
			cards.remove(index);
		} else {
			throw new IndexOutOfBoundsException("The specified index is out of bounds");
		}
	}

	public int getSize() {
		return cards.size();
	}
	
	public GCard getCard(int index) {
		return cards.get(index);
	}
	
	public List<GCard> readonlyView() {
		return view;
	}
}
