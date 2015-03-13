package pow.actions;

import pow.basic.Board;
import pow.cards.Card;
import pow.cards.Creature;

/**
 * Created by Helga on 13.03.15.
 */
public interface DeathReactionInterface {
    void datReaction(Card attacker, Creature defender, int damage, Board board);

    void deathReaction(DeathAction action, Board board);
}
