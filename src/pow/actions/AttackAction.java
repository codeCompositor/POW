package pow.actions;

import pow.cards.Creature;

/**
 * Created by Olymp on 13.03.15.
 */
public class AttackAction extends Action {
    private final Creature attacker;
    private final Creature defender;

    public AttackAction() {
        super(Type.ATTACK);
        attacker = null;
        defender = null;
    }

    public AttackAction(Creature attacker, Creature defender) {
        super(Type.ATTACK);
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
        return "AttackAction{" +
                "attacker=" + attacker +
                ", defender=" + defender +
                '}';
    }
}
