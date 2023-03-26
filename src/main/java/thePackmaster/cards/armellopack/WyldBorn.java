package thePackmaster.cards.armellopack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.dimensiongatepack2.Channel;
import thePackmaster.powers.armellopack.WyldBornPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.*;

public class WyldBorn extends AbstractArmelloCard {
    public final static String ID = makeID("WyldBorn");

    public WyldBorn() {
        super(ID, 1, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);

        cardsToPreview = new Channel();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new WyldBornPower(1));
    }

    public void upp() {
        isInnate = true;
    }
}