package thePackmaster.actions.armellopack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import static thePackmaster.util.Wiz.hand;

public class PlayAllOfCardAction extends AbstractGameAction {

    public String cardId;

    public PlayAllOfCardAction(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public void update() {
        for (AbstractCard card : hand().group) {
            if (card.cardID == cardId) {
                AbstractDungeon.actionManager.addCardQueueItem(new CardQueueItem(card, null, 0, true, true), true);
            }
        }
        this.isDone = true;
    }
}
