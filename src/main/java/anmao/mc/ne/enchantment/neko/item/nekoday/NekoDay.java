package anmao.mc.ne.enchantment.neko.item.nekoday;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.neko.item.NekoEI;
import anmao.mc.ne.enchantment.neko.item.nekonight.NekoNight;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

public class NekoDay extends NekoEI {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.NEKO_DAY);
    private final int maxLevel = EnchantmentsConfig.INSTANCE.getMaxLevel(EnchantmentRegister.NEKO_DAY);
    public NekoDay() {
        super(Rarity.RARE);
    }
    @Override
    protected boolean checkCompatibility(@NotNull Enchantment pOther) {
        return !(pOther instanceof NekoNight);
    }

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }

    @Override
    public boolean isTreasureOnly() {
        return false;
    }
}
