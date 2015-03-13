package pow.basic;

import pow.actions.*;
import pow.actions.reactions.AttackReactionInterface;
import pow.actions.reactions.CounterAttackReactionInterface;
import pow.actions.reactions.DamageReactionInterface;
import pow.actions.reactions.DeathReactionInterface;
import pow.cards.Card;

import java.util.ArrayList;
import java.util.List;

public class Board implements Cloneable {
    private Player players[];
    private List<Card> cards;
    private byte currentPlayer;

    public Board() {
        players = new Player[2];
        players[0] = new Player();
        players[1] = new Player();
        cards = new ArrayList<Card>();
    }

    public Board(Board board) {
        players = board.players.clone();
        currentPlayer = board.currentPlayer;
    }

    public void endTurn() {
        currentPlayer = (byte) (1 - currentPlayer);
    }

    public byte getCurrentPlayer() {
        return currentPlayer;
    }

    /*public void makeAction(Action action) {
        System.out.println(action.toString());
        switch (action.getType()) {
            case ATTACK:
                AttackAction attackAction = (AttackAction) action;
                for (Card card : cards) {
                    if (card instanceof AttackReactionInterface) {
                        ((AttackReactionInterface) card).attackReaction(attackAction, this);
                    }
                }
                break;
            case COUNTER_ATTACK:
                CounterAttackAction counterAttackAction = (CounterAttackAction) action;
                for (Card card : cards) {
                    if (card instanceof CounterAttackReactionInterface) {
                        ((CounterAttackReactionInterface) card).counterAttackReaction(counterAttackAction, this);
                    }
                }
                break;
            case DAMAGE:
                DamageAction damageAction = (DamageAction) action;
                for (Card card : cards) {
                    if (card instanceof DamageReactionInterface) {
                        ((DamageReactionInterface) card).damageReaction(damageAction, this);
                    }
                }
                break;
            case DEATH:
                DeathAction deathAction = (DeathAction) action;
                for (Card card : cards) {
                    if (card instanceof DeathReactionInterface) {
                        ((DeathReactionInterface) card).deathReaction(deathAction, this);
                    }
                }
                break;
        }
    }*/

    public void makeAction(Action action) {
        System.out.println(action.toString());
        if (action instanceof AttackAction) {
            for (Card card : cards) {
                if (card instanceof AttackReactionInterface) {
                    ((AttackReactionInterface) card).attackReaction((AttackAction) action, this);
                }
            }
            return;
        }
        if (action instanceof CounterAttackAction) {
            for (Card card : cards) {
                if (card instanceof CounterAttackReactionInterface) {
                    ((CounterAttackReactionInterface) card).counterAttackReaction((CounterAttackAction) action, this);
                }
            }
            return;
        }
        if (action instanceof DamageAction) {
            for (Card card : cards) {
                if (card instanceof DamageReactionInterface) {
                    ((DamageReactionInterface) card).damageReaction((DamageAction) action, this);
                }
            }
            return;
        }
        if (action instanceof DeathAction) {
            for (Card card : cards) {
                if (card instanceof DeathReactionInterface) {
                    ((DeathReactionInterface) card).deathReaction((DeathAction) action, this);
                }
            }
        }

    }

    public List<Card> getCards() {
        return cards;
    }

    @Override
    protected Board clone() {
        return new Board(this);
    }

}
