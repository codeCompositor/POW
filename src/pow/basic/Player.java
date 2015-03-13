package pow.basic;

import pow.cards.Card;
import pow.cards.Hero;
import pow.cards.Zone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Olymp on 10.03.15.
 */
public class Player implements Cloneable {
    private Hero hero;
    private Board board;
    private String name;
    public List<Card> play;
    public List<Card> graveyard;
    public List<Card> deck;
    public List<Card> hand;
    private final byte id;

    public Player() {
        name = "ERROR: NO NAME";
        hand = new ArrayList<Card>();
        deck = new ArrayList<Card>();
        play = new ArrayList<Card>();
        graveyard = new ArrayList<Card>();
        id = 0;
    }

    public Player(List<Card> hand, byte id) {
        this.hand = hand;
        this.id = id;
    }

    public Player(Player player) {
        hand = player.hand;
        id = player.id;
    }

    public boolean isGoing() {
        return board.getCurrentPlayer() == id;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void moveCard(Zone from, int fromID, Zone to) {
        switch (to) {
            case PLAY:
                moveCard(from, fromID, to, play.size());
                break;
            case GRAVEYARD:
                moveCard(from, fromID, to, graveyard.size());
                break;
            case HAND:
                moveCard(from, fromID, to, hand.size());
                break;
            case DECK:
                moveCard(from, fromID, to, deck.size());
                break;
        }
    }

    public void moveCard(Zone from, int fromID, Zone to, int toID) {
        Card card = null;
        switch (from) {
            case PLAY:
                card = play.get(fromID);
                play.remove(fromID);
                break;
            case GRAVEYARD:
                card = graveyard.get(fromID);
                graveyard.remove(fromID);
                break;
            case HAND:
                card = hand.get(fromID);
                hand.remove(fromID);
                break;
            case DECK:
                card = deck.get(fromID);
                deck.remove(fromID);
                break;
        }
        switch (to) {
            case PLAY:
                play.add(toID, card);
                break;
            case GRAVEYARD:
                graveyard.add(toID, card);
                break;
            case HAND:
                hand.add(toID, card);
                break;
            case DECK:
                deck.add(toID, card);
                break;
        }
        System.out.printf("Card %s moved from %s (%d) to %s (%d)\n", card.getName(), from, fromID, to, toID);
    }

    @Override
    protected Player clone() {
        return new Player(this);
    }
}
