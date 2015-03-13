package pow.actions.reactions;

import pow.actions.DamageAction;
import pow.basic.Board;
import pow.cards.Card;
import pow.cards.Creature;

public interface DamageReactionInterface {
    void damageReaction(Card attacker, Creature defender, int damage, Board board);

    void damageReaction(DamageAction action, Board board);
}
