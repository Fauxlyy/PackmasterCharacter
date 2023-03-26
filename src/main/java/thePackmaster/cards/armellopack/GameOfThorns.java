package thePackmaster.cards.armellopack;

import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cardmodifiers.armellopack.PerilousModifier;
import thePackmaster.powers.boardgamepack.DicePower;

import static thePackmaster.SpireAnniversary5Mod.MAGIC;
import static thePackmaster.SpireAnniversary5Mod.makeID;

public class GameOfThorns extends AbstractArmelloCard {
    public final static String ID = makeID("GameOfThorns");

    public GameOfThorns() {
        super(ID, 1, CardType.ATTACK, CardRarity.RARE, CardTarget.ALL_ENEMY);

        baseDamage = 0;
        CardModifierManager.addModifier(this, new PerilousModifier());
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
        this.baseDamage = DicePower.diceRolledThisCombat;
        this.rawDescription = (upgraded ? cardStrings.UPGRADE_DESCRIPTION : cardStrings.DESCRIPTION) + cardStrings.EXTENDED_DESCRIPTION[0];
        this.initializeDescription();
    }

    public void onMoveToDiscard() {
        this.rawDescription = cardStrings.DESCRIPTION;
        this.initializeDescription();
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        this.baseDamage = DicePower.diceRolledThisCombat;
        this.calculateCardDamage(null);
        allDmgTop(AbstractGameAction.AttackEffect.SLASH_HORIZONTAL);
    }

    public void upp() {
        this.isUnnate = true;
    }
}