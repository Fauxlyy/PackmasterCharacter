package thePackmaster.powers.armellopack;

import basemod.devcommands.power.Power;
import com.evacipated.cardcrawl.mod.stslib.powers.interfaces.NonStackablePower;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.powers.AbstractPower;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.cards.dimensiongatepack2.Channel;
import thePackmaster.powers.AbstractPackmasterPower;
import thePackmaster.powers.bardinspirepack.InspirationPower;

import static thePackmaster.util.Wiz.*;


public class BardPower extends AbstractPackmasterPower implements NonStackablePower {
    public static final String POWER_ID = SpireAnniversary5Mod.makeID("BardPower");
    public static final String NAME = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).NAME;
    public static final String[] DESCRIPTIONS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).DESCRIPTIONS;

    public int cards;
    public BardPower(int cards, int percent) {
        super(POWER_ID, NAME, PowerType.BUFF, false, p(), percent);
        isTwoAmount = true;
        amount2 = cards;
        this.cards = cards;
        updateDescription();
    }

    @Override
    public void onExhaust(AbstractCard card) {
        amount2--;

        if (amount2 == 0) {
            amount2 = cards;
            applyToSelf(new InspirationPower(p(), 1, amount));
        }
    }

    @Override
    public void stackPower(int stackAmount) {
        super.stackPower(stackAmount);
    }

    @Override
    public boolean isStackable(AbstractPower power)
    {
        if (power instanceof BardPower) {
            return cards == ((BardPower) power).cards;
        }
        return false;
    }

    @Override
    public void updateDescription() {
        this.description = DESCRIPTIONS[0] + cards + DESCRIPTIONS[1] + amount + DESCRIPTIONS[2];
    }
}
