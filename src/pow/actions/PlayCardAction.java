package pow.actions;

import pow.cards.Card;

public class PlayCardAction extends Action {
    private Card card;

    public PlayCardAction(Card card) {
        this.card = card;
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    @Override
    public String toString() {
        return "PlayCardAction{" +
                "card=" + card +
                '}';
    }
}
