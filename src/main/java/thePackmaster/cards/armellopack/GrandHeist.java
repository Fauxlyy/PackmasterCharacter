package thePackmaster.cards.armellopack;

import basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.MultiCardPreview;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.powers.boardgamepack.DicePower;

import static thePackmaster.SpireAnniversary5Mod.MAGIC;
import static thePackmaster.SpireAnniversary5Mod.makeID;

import static thePackmaster.util.Wiz.*;

public class GrandHeist extends AbstractArmelloCard {
    public final static String ID = makeID("GrandHeist");

    public GrandHeist() {
        super(ID, 0, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);

        magicNumber = baseMagicNumber = 1;
        MultiCardPreview.add(this, new SpiritStone(), new SpiritWalker());
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        applyToSelf(new DicePower(p, 8));
        makeInHand(new SpiritStone(), magicNumber);
    }

    public void upp() {
        this.upgradeMagicNumber(1);
    }
}