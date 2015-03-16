package pow.actions;

import pow.cards.Card;
import pow.cards.Minion;

public class SummonMinionAction extends Action {
    private Minion minion;
    private byte player;

    public SummonMinionAction(Minion minion) {
        this.minion = minion;
    }

    public Minion getMinion() {
        return minion;
    }

    public void setMinion(Minion minion) {
        this.minion = minion;
    }

    public byte getPlayer() {
        return player;
    }

    public void setPlayer(byte player) {
        this.player = player;
    }

    @Override
    public String toString() {
        return "SummonMinionAction{" +
                "minion=" + minion +
                "player=" + player +
                '}';
    }
}
