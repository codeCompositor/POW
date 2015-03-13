package pow.actions.reactions;

import pow.actions.DeathAction;
import pow.basic.Board;
import pow.cards.Card;

public interface PlayCardReactionInterface {
    void playCardReaction(Card card, Board board);

    void playCardReaction(DeathAction action, Board board);
}
