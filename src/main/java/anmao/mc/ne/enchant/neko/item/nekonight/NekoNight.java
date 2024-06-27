package anmao.mc.ne.enchant.neko.item.nekonight;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.neko.item.NekoEI;

public class NekoNight extends NekoEI {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.NEKO_NIGHT);
    private final int maxLevel = EnchantmentsConfig.INSTANCE.getMaxLevel(EnchantReg.NEKO_NIGHT);
    public NekoNight() {
        super();
    }

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }
}
