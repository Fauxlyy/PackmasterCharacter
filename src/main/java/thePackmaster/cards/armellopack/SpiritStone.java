package thePackmaster.cards.armellopack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.armellopack.PlayAllOfCardAction;
import thePackmaster.powers.boardgamepack.DicePower;

import java.util.Iterator;

import static thePackmaster.SpireAnniversary5Mod.MAGIC;
import static thePackmaster.SpireAnniversary5Mod.makeID;

import static thePackmaster.util.Wiz.*;

public class SpiritStone extends AbstractArmelloCard {
    public final static String ID = makeID("SpiritStone");

    public SpiritStone() {
        super(ID, 1, CardType.SKILL, CardRarity.SPECIAL, CardTarget.SELF, CardColor.COLORLESS);

        selfRetain = true;
        magicNumber = baseMagicNumber = 8;
        exhaust = true;

        cardsToPreview = new SpiritWalker();
        tags.add(MAGIC);
    }

    public void checkSpiritStones() {
        long stonesInHand = hand().group.stream()
                .filter(c -> c.cardID == ID)
                .count();

        if (stonesInHand >= 4 && hand().findCardById(SpiritWalker.ID) == null) {
            att(new AbstractGameAction() {
                @Override
                public void update() {
                    Iterator<AbstractCard> iterator = hand().group.iterator();

                    while (iterator.hasNext()) {
                        AbstractCard card = iterator.next();

                        if (card.cardID == ID) {
                            AbstractDungeon.actionManager.addCardQueueItem(new CardQueueItem(card, null, 0, true, true), true);
                            iterator.remove();
                        }
                    }
                    atb(new AbstractGameAction() {
                        @Override
                        public void update() {
                            makeInHand(new SpiritWalker());
                            this.isDone = true;
                        }
                    });
                    this.isDone = true;
                }
            });
        }
    }

    @Override
    public void triggerWhenCopied() {
        checkSpiritStones();
    }

    @Override
    public void triggerWhenDrawn() {
        checkSpiritStones();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new DicePower(p, magicNumber));
    }

    public void upp() {
        this.upgradeMagicNumber(4);
    }
}