package pow.basic;

import pow.actions.*;
import pow.actions.reactions.*;
import pow.cards.Card;
import pow.cards.Minion;
import pow.cards.Zone;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private List<Card> cards[];
    private List<Card> play[];
    private List<Card> graveyard[];
    private List<Card> hand[];
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
        hand = new List[2];
        hand[0] = new ArrayList<Card>();
        hand[1] = new ArrayList<Card>();
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
            for (List<Card> list : play)
                for (Card card : list) {
                    if (card instanceof AttackReactionInterface && !((AttackReactionInterface) card).attackReaction(attackAction, this)) {
                        return;
                    }
                }
            attackAction.getAttacker().attack(attackAction.getDefender(), this);
            attackAction.getDefender().defend(attackAction.getAttacker(), this);
            return;
        }
        if (action instanceof DamageAction && !((DamageAction) action).getDefender().checkDeath()) {
            DamageAction damageAction = (DamageAction) action;
            for (List<Card> list : play)
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
            for (List<Card> list : play)
                for (Card card : list) {
                    if (card instanceof DeathReactionInterface) {
                        ((DeathReactionInterface) card).deathReaction(deathAction, this);
                    }
                }
            Card target = deathAction.getTarget();
            target.die(this);
            moveCard(target.getZone(), target.getPlayer(), target, Zone.GRAVEYARD, target.getPlayer());
        }
        if (action instanceof PlayCardAction) {
            PlayCardAction playCardAction = (PlayCardAction) action;
            for (List<Card> list : play)
                for (Card card : list) {
                    if (card instanceof PlayCardReactionInterface) {
                        ((PlayCardReactionInterface) card).playCardReaction(playCardAction, this);
                    }
                }
            playCardAction.getCard().play(this);
        }
        if (action instanceof SummonMinionAction) {
            SummonMinionAction summonMinionAction = (SummonMinionAction) action;
            for (List<Card> list : play)
                for (Card card : list) {
                    if (card instanceof SummonMinionReactionInterface) {
                        ((SummonMinionReactionInterface) card).summonMinionReaction(summonMinionAction, this);
                    }
                }
            summonMinionAction.getMinion().summon(summonMinionAction.getPlayer(), this);
        }
    }

    public void addCard(byte player, Zone zone, Card card) {
        addCard(player, zone, card, -1);
    }

    public void addCard(byte player, Zone zone, Card card, int index) {
        switch (zone) {
            case PLAY:
                play[player].add(index = index < 0 ? play[player].size() : index, card);
                card.setZoneID(play[player].size() - 1);
                break;
            case GRAVEYARD:
                graveyard[player].add(index = index < 0 ? graveyard[player].size() : index, card);
                card.setZoneID(graveyard[player].size() - 1);
                break;
            case HAND:
                hand[player].add(index = index < 0 ? hand[player].size() : index, card);
                card.setZoneID(hand[player].size() - 1);
                break;
        }
        cards[player].add(card);
        card.setPlayer(player);
        card.setZone(zone);
        System.out.printf("Card %s added to %s{player=%d, index=%d}\n", card.getName(), zone, player, index);
    }

    public void removeCard(byte player, Zone zone, Card card) {
        switch (zone) {
            case PLAY:
                play[player].remove(card);
                break;
            case GRAVEYARD:
                graveyard[player].remove(card);
                break;
            case HAND:
                hand[player].remove(card);
                break;
        }
        cards[player].remove(card);
        System.out.printf("Card %s removed from %s{player=%d}\n", card.getName(), zone, player);
    }

    public void moveCard(Zone from, byte fromPlayer, Card card, Zone to, byte toPlayer) {
        moveCard(from, fromPlayer, card, to, toPlayer, -1);
    }

    public void moveCard(Zone from, byte fromPlayer, Card card, Zone to, byte toPlayer, int toIndex) {
        switch (from) {
            case PLAY:
                play[fromPlayer].remove(card);
                break;
            case GRAVEYARD:
                graveyard[fromPlayer].remove(card);
                break;
            case HAND:
                hand[fromPlayer].remove(card);
                break;
        }
        switch (to) {
            case PLAY:
                play[toPlayer].add(toIndex = toIndex < 0 ? play[toPlayer].size() : toIndex, card);
                break;
            case GRAVEYARD:
                graveyard[toPlayer].add(toIndex = toIndex < 0 ? graveyard[toPlayer].size() : toIndex, card);
                break;
            case HAND:
                hand[toPlayer].add(toIndex = toIndex < 0 ? hand[toPlayer].size() : toIndex, card);
                break;
        }
        System.out.printf("Card %s moved from %s{player=%d} to %s{player=%d, index=%d}\n", card.getName(), from, fromPlayer, to, toPlayer, toIndex);
    }
}
