package pow.actions.reactions;

import pow.actions.AttackAction;
import pow.basic.Board;

public interface AttackReactionInterface {
    /**
     * @param action Attack action that should be reacted to
     * @param board Game board on which action is taking place
     * @return <b>true</b> if action should be continued and <b>false</b> if action should be disrupted
     */
    boolean attackReaction(AttackAction action, Board board);
}
