package pow.cards;

public class Weapon extends Card {
    protected int attack;
    protected int durability;

    public Weapon(String name, int cost, int attack, int durability) {
        super(name, cost, Type.WEAPON);
        setAttack(attack);
        setDurability(durability);
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }

//    public void decreaseDurability() {
//        --durability;
//        if (durability <= 0)
//            destroy();
//    }
//
//    public void destroy() {
//        owner.getHero().setWeapon(null);
//    }
}
