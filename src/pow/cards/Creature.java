package pow.cards;

import pow.actions.*;
import pow.basic.Board;
import pow.basic.Player;

/**
 * Created by Olymp on 11.03.15.
 */
public class Creature extends Card implements AttackReactionInterface, CounterAttackReactionInterface, DamageReactionInterface {
    protected int attack;
    protected int health;

    public Creature() {
        super("ERROR: NO NAME", -1, Type.CREATURE, null);
    }

    public Creature(String name, int cost, int attack, int health, Player owner) {
        super(name, cost, Type.CREATURE, owner);
        setAttack(attack);
        setHealth(health);
    }

    /*public void takeCounterDamage(Creature attacker, int damage) {
        System.out.printf("Creature %s (%d/%d) was attacked by creature %s (%d/%d) and took %d damage\n", name, attack, health, attacker.getName(), attacker.getAttack(), attacker.getHealth(), damage);
        health -= damage;
        checkDeath();
        if (attacker.getType() == Type.CREATURE)
            ((Creature)attacker).takeDamage(this, attack);
    }

    public void takeDamage(Card attacker, int damage) {
        System.out.printf("Creature %s (%d/%d) was attacked by %s and took %d damage\n", name, attack, health, attacker.getName(), damage);
        health -= damage;
        checkDeath();
    }

    public void attack(Creature target) {
        System.out.printf("Creature %s (%d/%d) is attacking creature %s (%d/%d)\n", name, attack, health, target.getName(), target.getAttack(), target.getHealth());
        target.takeCounterDamage(this, attack);
    }*/

    public void takeDamage(int damage) {
        health -= damage;
        checkDeath();
    }

    public void checkDeath() {
        if (health <= 0 && zone == Zone.PLAY) {
            owner.moveCard(zone, zoneID, Zone.GRAVEYARD);
            zone = Zone.GRAVEYARD;
            //zoneID = owner.graveyardSize() - 1;
        }
    }
    
    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    @Override
    public void attackReaction(Creature attacker, Creature defender, Board board) {
        if (attacker.equals(this))
            board.makeAction(new DamageAction(attacker, defender, attack));
        if (defender.equals(this))
            board.makeAction(new CounterAttackAction(defender, attacker));
    }

    @Override
    public void attackReaction(AttackAction action, Board board) {
        attackReaction(action.getAttacker(), action.getDefender(), board);
    }

    @Override
    public void counterAttackReaction(Creature attacker, Creature defender, Board board) {
        if (defender.equals(this))
            board.makeAction(new DamageAction(attacker, defender, attacker.getAttack()));
    }

    @Override
    public void counterAttackReaction(CounterAttackAction action, Board board) {
        counterAttackReaction(action.getAttacker(), action.getDefender(), board);
    }

    @Override
    public void damageReaction(Card attacker, Creature defender, int damage, Board board) {
        takeDamage(damage);
    }

    @Override
    public void damageReaction(DamageAction action, Board board) {
        damageReaction(action.getAttacker(), action.getDefender(), action.getDamage(), board);
    }

    @Override
    public String toString() {
        return "Creature{" +
                "name=" + name +
                ", attack=" + attack +
                ", health=" + health +
                '}';
    }
}
