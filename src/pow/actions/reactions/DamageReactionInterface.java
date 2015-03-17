package pow.actions.reactions;

import pow.actions.DamageAction;
import pow.basic.Board;

public interface DamageReactionInterface {
    /**
     * @param action Damage action that should be reacted to
     * @param board Game board on which action is taking place
     * @return <b>true</b> if action should be continued and <b>false</b> if action should be disrupted
     */
    boolean reaction(DamageAction action, Board board);
}
