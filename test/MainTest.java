import org.junit.Before;
import org.junit.Test;
import pow.actions.AttackAction;
import pow.basic.Board;
import pow.cards.Card;
import pow.cards.Creature;

import java.util.List;

public class MainTest {
    Board board;
    Creature yeti;
    Creature grizzly;
    List<Card> cards;

    @Before
    public void setUp() {
        board = new Board();
        yeti = new Creature("Yeti", 4, 4, 5, null);
        grizzly = new Creature("Grizzly", 3, 3, 3, null);
        cards = board.getCards();
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