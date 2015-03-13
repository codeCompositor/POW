package pow.actions;

import pow.basic.Board;
import pow.cards.Card;
import pow.cards.Creature;

/**
 * Created by Olymp on 13.03.15.
 */
public interface DamageReactionInterface {
    void damageReaction(Card attacker, Creature defender, int damage, Board board);

    void damageReaction(DamageAction action, Board board);
}
