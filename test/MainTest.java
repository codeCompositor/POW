import org.junit.Before;
import org.junit.Test;
import pow.actions.AttackAction;
import pow.actions.DamageAction;
import pow.actions.PlayCardAction;
import pow.actions.reactions.DamageReactionInterface;
import pow.basic.Board;
import pow.cards.Creature;
import pow.cards.Minion;
import pow.cards.Zone;

public class MainTest {
    Board board;
    Minion yeti;
    Minion grizzly;
    Minion damager;

    private class Damager extends Minion implements DamageReactionInterface {

        public Damager(String name, int cost, int attack, int health) {
            super(name, cost, attack, health);
            setAttack(attack);
            setHealth(health);
        }

        @Override
        public boolean reaction(DamageAction action, Board board) {
            if (action.getAttacker() instanceof Creature && !action.getAttacker().equals(this))
                board.makeAction(new DamageAction(this, (Creature)action.getAttacker(), 1));
            return true;
        }
    }

    @Before
    public void setUp() {
        board = new Board();
        yeti = new Minion("Yeti", 4, 4, 5);
        grizzly = new Minion("Grizzly", 3, 3, 3);
        damager = new Damager("Damager", 1, 1, 1);
    }

    @Test
    public void test1() {
        System.out.printf("Test #1:\nAttacker: %s\nDefender: %s\n\n", yeti, grizzly);
        board.addCard((byte) 0, Zone.HAND, yeti);
        board.addCard((byte) 0, Zone.HAND, grizzly);
        board.makeAction(new PlayCardAction(yeti));
        board.makeAction(new PlayCardAction(grizzly));
        board.makeAction(new AttackAction(yeti, grizzly));
        System.out.printf("\nAttacker: %s\nDefender: %s\n\n\n", yeti, grizzly);
    }

    @Test
    public void test2() {
        System.out.printf("Test #2:\nAttacker: %s\nDefender: %s\n\n", grizzly, yeti);
        board.addCard((byte) 0, Zone.HAND, yeti);
        board.addCard((byte) 0, Zone.HAND, grizzly);
        board.makeAction(new PlayCardAction(yeti));
        board.makeAction(new PlayCardAction(grizzly));
        board.makeAction(new AttackAction(grizzly, yeti));
        System.out.printf("\nAttacker: %s\nDefender: %s\n", grizzly, yeti);
    }
}