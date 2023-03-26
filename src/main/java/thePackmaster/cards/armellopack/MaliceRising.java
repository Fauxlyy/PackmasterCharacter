package thePackmaster.cards.armellopack;

import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cardmodifiers.armellopack.PerilousModifier;

import java.util.ArrayList;
import java.util.List;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.*;

public class MaliceRising extends AbstractArmelloCard {
    public final static String ID = makeID("MaliceRising");

    public MaliceRising() {
        super(ID, 1, CardType.SKILL, CardRarity.UNCOMMON, CardTarget.ALL_ENEMY);
        isMultiDamage = true;
        damage = baseDamage = 12;
        magicNumber = baseMagicNumber = 2;
        CardModifierManager.addModifier(this, new PerilousModifier());
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        allDmg(AbstractGameAction.AttackEffect.FIRE);
        List<AbstractCard> eligible = new ArrayList(discardPile().group);
        int remaining = magicNumber;

        while (!eligible.isEmpty() && remaining > 0) {
            AbstractCard card = eligible.get(AbstractDungeon.cardRng.random(eligible.size() - 1));
            PerilousModifier modifier = new PerilousModifier();

            if (modifier.shouldApply(card)) {
                CardModifierManager.addModifier(card, new PerilousModifier());

                remaining--;
            }

            eligible.remove(card);
        }
    }

    public void upp() {
        this.upgradeDamage(4);
    }
}