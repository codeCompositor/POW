package pow.actions;

import pow.cards.Card;
import pow.cards.Creature;

/**
 * Created by Olymp on 13.03.15.
 */
public class DamageAction extends Action {
    private final Card attacker;
    private final Creature defender;
    private final int damage;

    public DamageAction() {
        super(Type.DAMAGE);
        attacker = null;
        defender = null;
        damage = 0;
    }

    public DamageAction(Card attacker, Creature defender, int damage) {
        super(Type.DAMAGE);
        this.attacker = attacker;
        this.defender = defender;
        this.damage = damage;
    }

    public Card getAttacker() {
        return attacker;
    }

    public Creature getDefender() {
        return defender;
    }

    public int getDamage() {
        return damage;
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
