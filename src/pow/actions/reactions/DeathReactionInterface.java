package pow.actions.reactions;

import pow.actions.DeathAction;
import pow.basic.Board;

public interface DeathReactionInterface {
    /**
     * @param action Death action that should be reacted to
     * @param board Game board on which action is taking place
     * @return <b>true</b> if action should be continued and <b>false</b> if action should be disrupted
     */
    boolean deathReaction(DeathAction action, Board board);
}
