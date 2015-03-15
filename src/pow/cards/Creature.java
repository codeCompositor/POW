package pow.cards;

import pow.actions.DamageAction;
import pow.actions.DeathAction;
import pow.basic.Board;

public class Creature extends Card {
    protected int attack;
    protected int health;
    protected int attacksNum;
    protected int maxAttacksNum;

    public Creature() {
        super("ERROR: NO NAME", -1, Type.CREATURE, 0);
    }

    public Creature(String name, int cost, int attack, int health, int player) {
        super(name, cost, Type.CREATURE, player);
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

    public void takeDamage(Card attacker, int damage, Board board) {
        health -= damage;
        if (checkDeath())
            board.makeAction(new DeathAction(this));
    }

    public boolean checkDeath() {
        return health <= 0 || zone == Zone.GRAVEYARD;
    }

    @Override
    public void die(Board board) {
        zone = Zone.GRAVEYARD;
    }

    public void attack(Creature target, Board board) {
        board.makeAction(new DamageAction(this, target, attack));
    }

    public void defend(Creature attacker, Board board) {
        board.makeAction(new DamageAction(this, attacker, attack));
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
    public String toString() {
        return "Creature{" +
                "name=\"" + name +
                "\", attack=" + attack +
                ", health=" + health +
                '}';
    }
}
