package anmao.mc.ne.enchantment.neko.item.nekonight;

import anmao.mc.ne.enchantment.neko.NekoEI;
import anmao.mc.ne.enchantment.neko.item.nekoday.NekoDay;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

public class NekoNight extends NekoEI {
    //public ServerLevel SERVERLEVEL = null;
    public NekoNight() {
        super(Rarity.RARE);
    }
    @Override
    protected boolean checkCompatibility(@NotNull Enchantment pOther) {
        return !(pOther instanceof NekoDay);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
    @Override
    public boolean isTreasureOnly() {
        return false;
    }
}
