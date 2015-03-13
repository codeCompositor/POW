package pow.cards;

import pow.basic.Player;

/**
 * Created by Olymp on 10.03.15.
 */
public class Hero extends Creature {
    protected Weapon weapon;

    public Hero(String name, int health, Player owner) {
        super(name, 0, 0, health, owner);
        weapon = null;
    }

    /*@Override
    public void takeCounterDamage(Creature attacker, int damage) {
        health -= damage;
        checkDeath();
        if (owner.isGoing())
            attacker.takeDamage(this, weapon.getAttack());
    }

    @Override
    public void takeDamage(Card attacker, int damage) {
        health -= damage;
        checkDeath();
    }

    @Override
    public void attack(Creature target) {
        target.takeCounterDamage(this, weapon.getAttack());
        weapon.decreaseDurability();
    }*/

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
