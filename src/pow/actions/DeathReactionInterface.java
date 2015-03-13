package pow.actions;

import pow.basic.Board;
import pow.cards.Card;

public interface DeathReactionInterface {
    void deathReaction(Card target, Board board);

    void deathReaction(DeathAction action, Board board);
}
