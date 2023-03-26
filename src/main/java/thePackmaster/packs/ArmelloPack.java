package thePackmaster.packs;

import com.megacrit.cardcrawl.core.CardCrawlGame;
import com.megacrit.cardcrawl.localization.UIStrings;
import thePackmaster.SpireAnniversary5Mod;
import thePackmaster.cards.armellopack.*;

import java.util.ArrayList;

public class ArmelloPack extends AbstractCardPack {
    public static final String ID = SpireAnniversary5Mod.makeID("ArmelloPack");
    private static final UIStrings UI_STRINGS = CardCrawlGame.languagePack.getUIString(ID);
    public static final String NAME = UI_STRINGS.TEXT[0];
    public static final String DESC = UI_STRINGS.TEXT[1];
    public static final String AUTHOR = UI_STRINGS.TEXT[2];

    public ArmelloPack() {
        super(ID, NAME, DESC, AUTHOR);
    }

    @Override
    public ArrayList<String> getCards() {
        ArrayList<String> cards = new ArrayList<>();

        cards.add(Bard.ID);
        cards.add(CursedLands.ID);
        cards.add(GameOfThorns.ID);
        cards.add(GrandHeist.ID);
        cards.add(MaliceRising.ID);
        cards.add(RiteOfWyld.ID);
        cards.add(StoneWards.ID);
        cards.add(ShimmerShield.ID);
        cards.add(SpiritStrike.ID);
        cards.add(WyldBorn.ID);

        cards.add(SpiritStone.ID);
        cards.add(SpiritWalker.ID);

        return cards;
    }
}
