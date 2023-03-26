package thePackmaster.cards.armellopack;

import basemod.helpers.CardModifierManager;
import com.megacrit.cardcrawl.actions.AbstractGameAction;
import com.megacrit.cardcrawl.actions.common.DrawCardAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.characters.AbstractPlayer;
import com.megacrit.cardcrawl.monsters.AbstractMonster;
import thePackmaster.cardmodifiers.armellopack.PerilousModifier;

import static thePackmaster.SpireAnniversary5Mod.makeID;
import static thePackmaster.util.Wiz.*;

public class CursedLands extends AbstractArmelloCard {
    public final static String ID = makeID("CursedLands");

    public CursedLands() {
        super(ID, 1, CardType.SKILL, CardRarity.COMMON, CardTarget.SELF);

        magicNumber = baseMagicNumber = 3;
    }

    public void use(AbstractPlayer p, AbstractMonster m) {
        AbstractGameAction drawCallback = new AbstractGameAction() {
            @Override
            public void update() {
                for (AbstractCard card : DrawCardAction.drawnCards) {
                    PerilousModifier mod = new PerilousModifier();

                    mod.removeAtEndOfTurn = true;

                    CardModifierManager.addModifier(card, mod);
                }

                isDone = true;
            }
        };

        atb(new DrawCardAction(magicNumber, drawCallback));
    }

    public void upp() {
        this.upgradeMagicNumber(1);
    }
}