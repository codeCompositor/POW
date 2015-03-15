package pow.basic;

import pow.actions.Action;
import pow.actions.AttackAction;
import pow.actions.DamageAction;
import pow.actions.DeathAction;
import pow.actions.reactions.AttackReactionInterface;
import pow.actions.reactions.DamageReactionInterface;
import pow.actions.reactions.DeathReactionInterface;
import pow.cards.Card;
import pow.cards.Minion;

import java.util.ArrayList;
import java.util.List;

public class Board implements Cloneable {
    private List<Card> cards;
    private List<Card> cards1;
    private List<Card> play[];
    private List<Minion> minionsInPlay[];
    private byte currentPlayer;

    public Board() {
        cards = new ArrayList<Card>();
    }

    public Board(Board board) {
        currentPlayer = board.currentPlayer;
    }

    public void endTurn() {
        currentPlayer = (byte) (1 - currentPlayer);
    }

    public byte getCurrentPlayer() {
        return currentPlayer;
    }

    public void makeAction(Action action) {
        System.out.println(action.toString());
        if (action instanceof AttackAction) {
            AttackAction attackAction = (AttackAction) action;
            for (Card card : cards) {
                if (card instanceof AttackReactionInterface && !((AttackReactionInterface) card).attackReaction(attackAction, this)){
                    return;
                }
            }
            attackAction.getAttacker().attack(attackAction.getDefender(), this);
            attackAction.getDefender().defend(attackAction.getAttacker(), this);
            return;
        }
        if (action instanceof DamageAction && ((DamageAction) action).getDefender().getHealth() > 0) {
            DamageAction damageAction = (DamageAction) action;
            for (Card card : cards) {
                if (card instanceof DamageReactionInterface) {
                    ((DamageReactionInterface) card).damageReaction(damageAction, this);
                }
            }
            damageAction.getDefender().takeDamage(damageAction.getAttacker(), damageAction.getDamage(), this);
            return;
        }
        if (action instanceof DeathAction) {
            DeathAction deathAction = (DeathAction) action;
            for (Card card : cards) {
                if (card instanceof DeathReactionInterface) {
                    ((DeathReactionInterface) card).deathReaction(deathAction, this);
                }
            }
            deathAction.getTarget().die(this);
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
