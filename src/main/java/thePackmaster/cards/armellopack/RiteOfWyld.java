package thePackmaster.cards.armellopack;

import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cardmodifiers.armellopack.PerilousModifier;

import static thePackmaster.SpireAnniversary5Mod.MAGIC;
import static thePackmaster.SpireAnniversary5Mod.makeID;

public class RiteOfWyld extends AbstractArmelloCard {
    public final static String ID = makeID("RiteOfWyld");

    public RiteOfWyld() {
        super(ID, 3, CardType.ATTACK, CardRarity.RARE, CardTarget.ENEMY);

        baseDamage = 26;
        magicNumber = baseMagicNumber = 2;
        CardModifierManager.addModifier(this, new PerilousModifier());
        tags.add(MAGIC);
    }

    @Override
    public void calculateCardDamage(AbstractMonster mo)
    {
        super.calculateCardDamage(mo);

        calcDamage();
    }

    public void applyPowers() {
        super.applyPowers();

        calcDamage();
    }

    public void calcDamage() {
        for (AbstractCard card : AbstractDungeon.actionManager.cardsPlayedThisCombat) {
            if (card.hasTag(MAGIC) && card != this) {
                this.damage += magicNumber;
            }
        }

        isDamageModified = damage != baseDamage;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        dmg(m, AbstractGameAction.AttackEffect.LIGHTNING);
    }

    public void upp() {
        this.upgradeDamage(4);
        this.upgradeMagicNumber(1);
    }
}