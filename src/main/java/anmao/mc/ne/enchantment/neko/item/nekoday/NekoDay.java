package anmao.mc.ne.enchantment.neko.item.nekoday;

import anmao.mc.ne.enchantment.neko.NekoEC;
import anmao.mc.ne.enchantment.neko.item.NekoEI;
import anmao.mc.ne.enchantment.neko.item.nekonight.NekoNight;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

public class NekoDay extends NekoEI {
    public NekoDay() {
        super(Rarity.RARE);
    }
    @Override
    protected boolean checkCompatibility(@NotNull Enchantment pOther) {
        return !(pOther instanceof NekoNight);
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
