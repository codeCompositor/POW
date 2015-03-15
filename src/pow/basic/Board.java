package pow.basic;

import pow.actions.Action;
import pow.actions.AttackAction;
import pow.actions.DamageAction;
import pow.actions.DeathAction;
import pow.actions.reactions.AttackReactionInterface;
import pow.actions.reactions.DamageReactionInterface;
import pow.actions.reactions.DeathReactionInterface;
import pow.cards.Card;
import pow.cards.Zone;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Card> cards[];
    private List<Card> play[];
    private List<Card> graveyard[];
    private byte currentPlayer;

    public Board() {
        cards = new List[2];
        cards[0] = new ArrayList<Card>();
        cards[1] = new ArrayList<Card>();
        play = new List[2];
        play[0] = new ArrayList<Card>();
        play[1] = new ArrayList<Card>();
        graveyard = new List[2];
        graveyard[0] = new ArrayList<Card>();
        graveyard[1] = new ArrayList<Card>();
    }

    public void endTurn() {
        currentPlayer = (byte) (1 - currentPlayer);
    }

    public byte getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(byte currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public List<Card>[] getCards() {
        return cards;
    }

    public void makeAction(Action action) {
        System.out.println(action.toString());
        if (action instanceof AttackAction) {
            AttackAction attackAction = (AttackAction) action;
            for (List<Card> list : cards)
                for (Card card : list) {
                    if (card instanceof AttackReactionInterface && !((AttackReactionInterface) card).attackReaction(attackAction, this)) {
                        return;
                    }
                }
            attackAction.getAttacker().attack(attackAction.getDefender(), this);
            attackAction.getDefender().defend(attackAction.getAttacker(), this);
            return;
        }
        if (action instanceof DamageAction && ((DamageAction) action).getDefender().getHealth() > 0) {
            DamageAction damageAction = (DamageAction) action;
            for (List<Card> list : cards)
                for (Card card : list) {
                    if (card instanceof DamageReactionInterface) {
                        ((DamageReactionInterface) card).damageReaction(damageAction, this);
                    }
                }
            damageAction.getDefender().takeDamage(damageAction.getAttacker(), damageAction.getDamage(), this);
            return;
        }
        if (action instanceof DeathAction) {
            DeathAction deathAction = (DeathAction) action;
            for (List<Card> list : cards)
                for (Card card : list) {
                    if (card instanceof DeathReactionInterface) {
                        ((DeathReactionInterface) card).deathReaction(deathAction, this);
                    }
                }
            Card target = deathAction.getTarget();
            target.die(this);
            moveCard(target.getZone(), target.getPlayer(), target.getZoneID(), Zone.GRAVEYARD, target.getPlayer());
        }
    }

    public void addCard(byte player, Zone zone, Card card) {
        switch (zone) {
            case PLAY:
                play[player].add(card);
                card.setZoneID(play[player].size() - 1);
                break;
            case GRAVEYARD:
                graveyard[player].add(card);
                card.setZoneID(graveyard[player].size() - 1);
                break;
        }
        cards[player].add(card);
        card.setPlayer(player);
        card.setZone(zone);
    }

    public void moveCard(Zone from, byte fromPlayer, int fromId, Zone to, byte toPlayer) {
        switch (to) {
            case PLAY:
                moveCard(from, fromPlayer, fromId, to, toPlayer, play[toPlayer].size());
                break;
            case GRAVEYARD:
                moveCard(from, fromPlayer, fromId, to, toPlayer, graveyard[toPlayer].size());
                break;
        }
    }

    public void moveCard(Zone from, byte fromPlayer, int fromId, Zone to, byte toPlayer, int toId) {
        Card card = null;
        switch (from) {
            case PLAY:
                card = play[fromPlayer].get(fromId);
                play[fromPlayer].remove(fromId);
                break;
            case GRAVEYARD:
                card = graveyard[fromPlayer].get(fromId);
                graveyard[fromPlayer].remove(fromId);
                break;
        }
        switch (to) {
            case PLAY:
                play[toPlayer].add(toId, card);
                break;
            case GRAVEYARD:
                graveyard[toPlayer].add(toId, card);
                break;
        }
        System.out.printf("Card %s moved from %s{player=%d, id=%d} to %s{player=%d, id=%d}\n", card.getName(), from, fromPlayer, fromId, to, toPlayer, toId);
    }
}
