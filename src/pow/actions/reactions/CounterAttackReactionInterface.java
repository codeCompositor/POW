package pow.actions.reactions;

import pow.actions.CounterAttackAction;
import pow.basic.Board;
import pow.cards.Creature;

public interface CounterAttackReactionInterface {
    void counterAttackReaction(Creature attacker, Creature defender, Board board);

    void counterAttackReaction(CounterAttackAction counterAttackAction, Board board);
}
