package thePackmaster.cards.armellopack;

import basemod.patches.com.megacrit.cardcrawl.cards.AbstractCard.MultiCardPreview;
import com.evacipated.cardcrawl.mod.stslib.actions.common.RefundAction;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.EasyXCostAction;
import thePackmaster.powers.boardgamepack.DicePower;

import static thePackmaster.SpireAnniversary5Mod.MAGIC;
import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.*;

public class ShimmerShield extends AbstractArmelloCard {
    public final static String ID = makeID("ShimmerShield");

    public ShimmerShield() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);

        block = baseBlock = 6;
        tags.add(MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        blck();
        applyToSelf(new DicePower(p, 8));
    }

    public void upp() {
        this.upgradeBlock(3);
    }
}