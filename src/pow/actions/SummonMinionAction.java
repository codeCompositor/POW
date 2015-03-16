package pow.actions;

import pow.cards.Card;
import pow.cards.Minion;

public class SummonMinionAction extends Action {
    private Minion minion;

    public SummonMinionAction(Minion minion) {
        this.minion = minion;
    }

    public Minion getMinion() {
        return minion;
    }

    public void setMinion(Minion minion) {
        this.minion = minion;
    }

    @Override
    public String toString() {
        return "SummonMinionAction{" +
                "minion=" + minion +
                '}';
    }
}
