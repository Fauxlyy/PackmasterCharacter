package thePackmaster.cards.armellopack;

import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.CardQueueItem;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.armellopack.PlayAllOfCardAction;
import thePackmaster.powers.boardgamepack.DicePower;

import static thePackmaster.SpireAnniversary5Mod.MAGIC;
import static thePackmaster.SpireAnniversary5Mod.makeID;

import static thePackmaster.util.Wiz.*;

public class SpiritWalker extends AbstractArmelloCard {
    public final static String ID = makeID("SpiritWalker");

    public SpiritWalker() {
        super(ID, 1, CardType.SKILL, CardRarity.SPECIAL, CardTarget.SELF, CardColor.COLORLESS);

        selfRetain = true;

        //cardsToPreview = new SpiritStone();
        tags.add(MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        if (p.hasPower(DicePower.POWER_ID)) {
            DicePower power = (DicePower)p.getPower(DicePower.POWER_ID);

            power.diceRolledThisCombat += power.amount;
            power.amount *= 2;
            power.playApplyPowerSfx();
        }
    }

    @Override
    public void triggerWhenDrawn() {
        att(new PlayAllOfCardAction(SpiritStone.ID));
    }

    @Override
    public void triggerWhenCopied() {
        System.out.println("SPIRIT WALKER COPIED");
        att(new PlayAllOfCardAction(SpiritStone.ID));
    }

    @Override
    public void triggerOnOtherCardPlayed(AbstractCard c) {
        atb(new PlayAllOfCardAction(SpiritStone.ID));
    }

    public void upp() {
        this.upgradeBaseCost(0);
    }
}