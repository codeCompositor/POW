package pow.actions;

import pow.cards.Card;

public class DeathAction extends Action {
    private Card target;

    public DeathAction(Card target) {
        super(Type.DEATH);
        this.target = target;
    }

    public Card getTarget() {
        return target;
    }

    public void setTarget(Card target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "DeathAction{" +
                "target=" + target +
                '}';
    }
}
