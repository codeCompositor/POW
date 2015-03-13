package pow.actions;

import pow.cards.Creature;

public class CounterAttackAction extends Action {
    private Creature attacker;
    private Creature defender;

    public CounterAttackAction() {
        super(Type.COUNTER_ATTACK);
        attacker = null;
        defender = null;
    }

    public CounterAttackAction(Creature attacker, Creature defender) {
        super(Type.COUNTER_ATTACK);
        this.attacker = attacker;
        this.defender = defender;
    }

    public Creature getAttacker() {
        return attacker;
    }

    public void setAttacker(Creature attacker) {
        this.attacker = attacker;
    }

    public Creature getDefender() {
        return defender;
    }

    public void setDefender(Creature defender) {
        this.defender = defender;
    }

    @Override
    public String toString() {
        return "CounterAttackAction{" +
                "attacker=" + attacker +
                ", defender=" + defender +
                '}';
    }
}
