package pow.cards;

import pow.basic.Player;

/**
 * Created by Olymp on 10.03.15.
 */
public class Minion extends Creature {
    public Minion(String name, int cost, int attack, int health, Player owner) {
        super(name, cost, attack, health, owner);
    }
}
