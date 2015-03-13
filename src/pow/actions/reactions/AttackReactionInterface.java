package pow.actions.reactions;

import pow.actions.AttackAction;
import pow.basic.Board;
import pow.cards.Creature;

public interface AttackReactionInterface {
    void attackReaction(Creature attacker, Creature defender, Board board);

    void attackReaction(AttackAction action, Board board);
}
