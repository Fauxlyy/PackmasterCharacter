package thePackmaster.cards.armellopack;

import basemod.helpers.CardModifierManager;
import basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.MultiCardPreview;
import com.evacipated.cardcrawl.mod.stslib.actions.common.RefundAction;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.EasyXCostAction;
import thePackmaster.actions.basicpack.ConjureCardsAction;
import thePackmaster.cardmodifiers.armellopack.PerilousModifier;
import thePackmaster.util.creativitypack.JediUtil;

import static thePackmaster.SpireAnniversary5Mod.MAGIC;
import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.atb;
import static thePackmaster.util.Wiz.makeInHand;

public class StoneWards extends AbstractArmelloCard {
    public final static String ID = makeID("StoneWards");

    public StoneWards() {
        super(ID, -1, CardType.SKILL, CardRarity.RARE, CardTarget.SELF);

        magicNumber = baseMagicNumber = 1;
        MultiCardPreview.add(this, new SpiritStone(), new SpiritWalker());
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new EasyXCostAction(this, (effect, params) -> {
            makeInHand(new SpiritStone(), effect);
            atb(new RefundAction(this, magicNumber));
            return true;
        }));
    }

    public void upp() {
        this.upgradeMagicNumber(1);
    }
}