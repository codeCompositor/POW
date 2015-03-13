import pow.basic.Player;
import pow.cards.Hero;
import pow.cards.Minion;
import pow.cards.Zone;
import junit.framework.TestCase;

/**
 * Created by Olymp on 11.03.15.
 */
public class PlayerTest extends TestCase {
    Player player;
    Minion yeti;
    Minion grizzly;

    protected void setUp() {
        player = new Player();
        yeti = new Minion("Yeti", 4, 4, 5, player);
        grizzly = new Minion("Grizli", 3, 3, 3, player);
        player.play.add(yeti);
        yeti.setZone(Zone.PLAY);
        yeti.setZoneID(player.play.size() - 1);
        player.play.add(grizzly);
        grizzly.setZone(Zone.PLAY);
        grizzly.setZoneID(player.play.size() - 1);
        Hero hero = new Hero("Uther", 30, player);
        player.setHero(hero);
        /*Player player2 = new Player();
        player2.play.add(new Minion("Grizli", 3, 3, 3));
        hero = new Hero("Thrall", 30, player1);
        player2.setHero(hero);*/
    }

    public void runTest() {
        testAttack();
    }

    public void testAttack() {
        //yeti.attack(grizzly);
        System.out.printf("Yeti %d/%d\n", yeti.getAttack(), yeti.getHealth());
        System.out.printf("Grizzly %d/%d\n", grizzly.getAttack(), grizzly.getHealth());
    }
}
