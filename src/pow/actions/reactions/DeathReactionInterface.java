package pow.actions.reactions;

import pow.actions.DeathAction;
import pow.basic.Board;

public interface DeathReactionInterface {
    boolean deathReaction(DeathAction action, Board board);
}
