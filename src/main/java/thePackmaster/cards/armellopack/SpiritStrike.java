package thePackmaster.cards.armellopack;

import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DiscardSpecificCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.actions.EasyXCostAction;
import thePackmaster.cardmodifiers.armellopack.PerilousModifier;
import thePackmaster.cards.dimensiongatepack2.Channel;

import static thePackmaster.SpireAnniversary5Mod.MAGIC;
import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.*;

public class SpiritStrike extends AbstractArmelloCard {
    public final static String ID = makeID("SpiritStrike");

    public SpiritStrike() {
        super(ID, -1, CardType.ATTACK, CardRarity.UNCOMMON, CardTarget.ENEMY);

        damage = baseDamage = 4;
        block = baseBlock = 4;
        exhaust = true;
        CardModifierManager.addModifier(this, new PerilousModifier());
        tags.add(MAGIC);
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        atb(new EasyXCostAction(this, (effect, params) -> {
            for (int i = 0; i < effect; i++) {
                dmg(m, AbstractGameAction.AttackEffect.LIGHTNING);
                blck();
            }

            return true;
        }));
    }

    public void upp() {
        this.upgradeDamage(1);
        this.upgradeBlock(1);
    }
}