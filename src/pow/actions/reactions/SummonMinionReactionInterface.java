package pow.actions.reactions;

import pow.actions.SummonMinionAction;
import pow.basic.Board;

public interface SummonMinionReactionInterface {
    /**
     * @param action Summon minion action that should be reacted to
     * @param board Game board on which action is taking place
     * @return <b>true</b> if action should be continued and <b>false</b> if action should be disrupted
     */
    boolean summonMinionReaction(SummonMinionAction action, Board board);
}
