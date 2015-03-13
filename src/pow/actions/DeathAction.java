package pow.actions;

import pow.cards.Card;

/**
 * Created by Helga on 13.03.15.
 */
public class DeathAction extends Action {
    private final Card card;

    public DeathAction(Card card) {
        super(Type.DEATH);
        this.card = card;
    }
}
