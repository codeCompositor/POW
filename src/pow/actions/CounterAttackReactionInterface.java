package pow.actions;

import pow.basic.Board;
import pow.cards.Creature;

/**
 * Created by Olymp on 13.03.15.
 */
public interface CounterAttackReactionInterface {
    void counterAttackReaction(Creature attacker, Creature defender, Board board);

    void counterAttackReaction(CounterAttackAction counterAttackAction, Board board);
}
