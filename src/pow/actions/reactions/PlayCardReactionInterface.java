package pow.actions.reactions;

import pow.actions.DeathAction;
import pow.basic.Board;

public interface PlayCardReactionInterface {
    boolean playCardReaction(DeathAction action, Board board);
}
