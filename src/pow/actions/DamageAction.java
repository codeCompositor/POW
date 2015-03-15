package pow.actions;

import pow.cards.Card;
import pow.cards.Creature;

public class DamageAction extends Action {
    private Card attacker;
    private Creature defender;
    private int damage;

    public DamageAction() {
        attacker = null;
        defender = null;
        damage = 0;
    }

    public DamageAction(Card attacker, Creature defender, int damage) {
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
    }

    public Card getAttacker() {
        return attacker;
    }

    public void setAttacker(Card attacker) {
        this.attacker = attacker;
    }

    public Creature getDefender() {
        return defender;
    }

    public void setDefender(Creature defender) {
        this.defender = defender;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return "DamageAction{" +
                "attacker=" + attacker +
                ", defender=" + defender +
                ", damage=" + damage +
                '}';
    }
}
