package pow.actions;

import pow.cards.Creature;

/**
 * Created by Olymp on 13.03.15.
 */
public class CounterAttackAction extends Action {
    private final Creature attacker;
    private final Creature defender;

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

    public Creature getDefender() {
        return defender;
    }

    @Override
    public String toString() {
        return "CounterAttackAction{" +
                "attacker=" + attacker +
                ", defender=" + defender +
                '}';
    }
}
