package thePackmaster.cards.clawpack;

import com.megacrit.cardcrawl.actions.defect.GashAction;
import com.megacrit.cardcrawl.cards.AbstractCard;
import com.megacrit.cardcrawl.cards.blue.Claw;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.ThePackmaster;
import thePackmaster.cards.AbstractPackmasterCard;
import thePackmaster.util.Wiz;

import java.util.Iterator;

public abstract class AbstractClawCard extends AbstractPackmasterCard {
    public AbstractClawCard(String cardID, int cost, CardType type, CardRarity rarity, CardTarget target, CardColor color) {
        super(cardID, cost, type, rarity, target, color);
        setBackgroundTexture(
                "anniv5Resources/images/512/claw/" + type.name().toLowerCase() + ".png",
                "anniv5Resources/images/1024/claw/" + type.name().toLowerCase() + ".png"
        );
    }

    public AbstractClawCard(String cardID, int cost, CardType type, CardRarity rarity, CardTarget target) {
        this(cardID, cost, type, rarity, target, ThePackmaster.Enums.PACKMASTER_RAINBOW);
    }


    public static void ClawUp(int value) {
    ClawUp(value, false);
    }

    public static void ClawUp(int value, boolean excludeClaws) {

        SpireAnniversary5Mod.CLAW_SHARP_TRACKER += value;

         List<AbstractCard> cards = new ArrayList<>();
        cards.addAll(AbstractDungeon.player.hand.group);
        cards.addAll(AbstractDungeon.player.drawPile.group);
        cards.addAll(AbstractDungeon.player.discardPile.group);
        
        for (AbstractCard c : cards) {
            if (!(excludeClaws && (c instanceof Claw)) && c.hasTag(SpireAnniversary5Mod.CLAW)) {
                c.baseDamage += value;
                c.applyPowers();
                if (c.cardsToPreview != null){
                    if (c.cardsToPreview instanceof GhostClaw){
                        ((GhostClaw)c.cardsToPreview).refreshDamage();
                    }
                }
            }
        }

    }
}
