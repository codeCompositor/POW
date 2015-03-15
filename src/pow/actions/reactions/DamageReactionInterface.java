package pow.actions.reactions;

import pow.actions.DamageAction;
import pow.basic.Board;

public interface DamageReactionInterface {
    boolean damageReaction(DamageAction action, Board board);
}
