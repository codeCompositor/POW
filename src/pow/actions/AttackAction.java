package pow.actions;

import pow.cards.Creature;

public class AttackAction extends Action {
    private Creature attacker;
    private Creature defender;

    public AttackAction() {
        attacker = null;
        defender = null;
    }

    public AttackAction(Creature attacker, Creature defender) {
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
        return "AttackAction{" +
                "attacker=" + attacker +
                ", defender=" + defender +
                '}';
    }
}
