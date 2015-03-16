package pow.cards;

import pow.actions.DamageAction;
import pow.actions.SummonMinionAction;
import pow.basic.Board;

public class Minion extends Creature {
    public Minion(String name, int cost, int attack, int health) {
        super(name, cost, attack, health);
    }

    public void play(Board board) {
        board.removeCard(player, zone, this);
        board.makeAction(new SummonMinionAction(this));
    }

    public void summon(byte player, Board board) {
        board.addCard(player, Zone.PLAY, this);
    }
}
