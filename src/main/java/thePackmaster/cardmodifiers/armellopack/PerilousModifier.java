package thePackmaster.cardmodifiers.armellopack;

import basemod.abstracts.AbstractCardModifier;
import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.common.ExhaustSpecificCardAction;
import com.megacrit.cardcrawl.actions.utility.UseCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardGroup;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.powers.boardgamepack.DicePower;

import static thePackmaster.util.Wiz.*;

public class PerilousModifier extends AbstractCardModifier {
    public static String ID = SpireAnniversary5Mod.makeID("PerilousModifier");
    public static final String[] TEXT = CardCrawlGame.languagePack.getUIString(ID).TEXT;

    public boolean removeAtEndOfTurn = false;

    @Override
    public boolean removeAtEndOfTurn(AbstractCard card) {
        return super.removeAtEndOfTurn(card) || removeAtEndOfTurn;
    }

    @Override
    public boolean shouldApply(AbstractCard card) {
        return !CardModifierManager.hasModifier(card, PerilousModifier.ID);
    }

    public void onUse(AbstractCard card, AbstractCreature target, UseCardAction action) {
        if (!p().hasPower(DicePower.POWER_ID)) {
            int index = hand().group.lastIndexOf(card);

            if (index > 0) {
                atb(new ExhaustSpecificCardAction(hand().group.get(index-1), hand(), true));
            }

            if (index < hand().size() - 1) {
                atb(new ExhaustSpecificCardAction(hand().group.get(index+1), hand(), true));
            }
        }
    }

    @Override
    public String identifier(AbstractCard card) {
        return ID;
    }

    public String modifyDescription(String rawDescription, AbstractCard card) {
        return rawDescription + TEXT[0];
    }

    public AbstractCardModifier makeCopy() {
        return new PerilousModifier();
    }
}
