import junit.framework.TestCase;
import pow.actions.AttackAction;
import pow.basic.Board;
import pow.cards.Card;
import pow.cards.Creature;

import java.util.List;

public class MainTest extends TestCase {
    @Override
    public void setUp(){

    }

    @Override
    public void runTest() {
        test();
    }

    public void test() {
        Board board = new Board();
        Creature yeti = new Creature("Yeti", 4, 4, 5, null);
        Creature grizzly = new Creature("Grizzly", 3, 3, 3, null);
        List<Card> cards = board.getCards();
        cards.add(yeti);
        cards.add(grizzly);
        board.makeAction(new AttackAction(yeti, grizzly));
    }
}