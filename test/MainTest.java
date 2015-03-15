import org.junit.Before;
import org.junit.Test;
import pow.actions.AttackAction;
import pow.actions.DamageAction;
import pow.actions.reactions.DamageReactionInterface;
import pow.basic.Board;
import pow.cards.Card;
import pow.cards.Creature;

import java.util.List;

public class MainTest {
    Board board;
    Creature yeti;
    Creature grizzly;
    Creature damager;
    List<Card> cards;

    private class Damager extends Creature implements DamageReactionInterface {

        public Damager(String name, int cost, int attack, int health, int player) {
            super(name, cost, attack, health, player);
            setAttack(attack);
            setHealth(health);
        }

        @Override
        public boolean damageReaction(DamageAction action, Board board) {
            if (action.getAttacker() instanceof Creature && !action.getAttacker().equals(this))
                board.makeAction(new DamageAction(this, (Creature)action.getAttacker(), 1));
            return true;
        }
    }

    @Before
    public void setUp() {
        board = new Board();
        yeti = new Creature("Yeti", 4, 4, 5, 0);
        grizzly = new Creature("Grizzly", 3, 3, 3, 1);
        damager = new Damager("Damager", 1, 1, 1, 2);
        cards = board.getCards();
        cards.add(damager);
    }

    @Test
    public void test1() {
        System.out.println("Test #1:");
        cards.add(yeti);
        cards.add(grizzly);
        System.out.println("Attacker: " + yeti);
        System.out.println("Defender: " + grizzly + "\n");
        board.makeAction(new AttackAction(yeti, grizzly));
        System.out.println("\nAttacker: " + yeti);
        System.out.println("Defender: " + grizzly + "\n\n");
    }

    @Test
    public void test2() {
        System.out.println("Test #2:");
        cards.add(grizzly);
        cards.add(yeti);
        System.out.println("Attacker: " + yeti);
        System.out.println("Defender: " + grizzly + "\n");
        board.makeAction(new AttackAction(yeti, grizzly));
        System.out.println("\nAttacker: " + yeti);
        System.out.println("Defender: " + grizzly);
    }
}