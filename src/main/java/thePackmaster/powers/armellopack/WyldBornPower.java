package thePackmaster.powers.armellopack;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.cards.dimensiongatepack2.Channel;
import thePackmaster.powers.AbstractPackmasterPower;

import static thePackmaster.util.Wiz.*;


public class WyldBornPower extends AbstractPackmasterPower {
    public static final String POWER_ID = SpireAnniversary5Mod.makeID("WyldBornPower");
    public static final String NAME = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).NAME;
    public static final String[] DESCRIPTIONS = CardCrawlGame.languagePack.getPowerStrings(POWER_ID).DESCRIPTIONS;

    public WyldBornPower(int amount) {
        super(POWER_ID, NAME, PowerType.BUFF, true, p(), amount);
    }

    @Override
    public void atStartOfTurn() {
        makeInHand(new Channel(), amount);
    }

    @Override
    public void updateDescription() {
        if (this.amount == 1)
        {
            this.description = DESCRIPTIONS[0];
        }
        else
        {
            this.description = DESCRIPTIONS[1] + amount + DESCRIPTIONS[2];
        }
    }
}
