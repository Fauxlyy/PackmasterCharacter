package thePackmaster.cards.armellopack;

import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cards.dimensiongatepack2.Channel;
import thePackmaster.powers.armellopack.BardPower;
import thePackmaster.powers.armellopack.WyldBornPower;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.applyToSelf;

public class Bard extends AbstractArmelloCard {
    public final static String ID = makeID("Bard");

    public Bard() {
        super(ID, 2, CardType.POWER, CardRarity.UNCOMMON, CardTarget.SELF);

        magicNumber = baseMagicNumber = 4;
        secondMagic = baseSecondMagic = 100;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new BardPower(magicNumber, secondMagic));
    }

    public void upp() {
        if (magicNumber > 1) {
            upgradeMagicNumber(-1);
        }
    }
}