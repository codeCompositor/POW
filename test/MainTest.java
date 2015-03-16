import org.junit.Before;
import org.junit.Test;
import pow.actions.AttackAction;
import pow.actions.DamageAction;
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
        public boolean damageReaction(DamageAction action, Board board) {
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
        board.addCard((byte) 0, Zone.PLAY, damager);
    }

    @Test
    public void test1() {
        System.out.println("Test #1:");
        board.addCard((byte) 0, Zone.PLAY, yeti);
        board.addCard((byte) 0, Zone.PLAY, grizzly);
        System.out.println("Attacker: " + yeti);
        System.out.println("Defender: " + grizzly + "\n");
        board.makeAction(new AttackAction(yeti, grizzly));
        System.out.println("\nAttacker: " + yeti);
        System.out.println("Defender: " + grizzly + "\n\n");
    }

    @Test
    public void test2() {
        System.out.println("Test #2:");
        board.addCard((byte) 0, Zone.PLAY, grizzly);
        board.addCard((byte) 0, Zone.PLAY, yeti);
        System.out.println("Attacker: " + yeti);
        System.out.println("Defender: " + grizzly + "\n");
        board.makeAction(new AttackAction(yeti, grizzly));
        System.out.println("\nAttacker: " + yeti);
        System.out.println("Defender: " + grizzly);
    }
}