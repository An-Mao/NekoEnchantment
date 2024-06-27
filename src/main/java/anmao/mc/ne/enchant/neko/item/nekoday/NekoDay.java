package anmao.mc.ne.enchant.neko.item.nekoday;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.neko.item.NekoEI;

public class NekoDay extends NekoEI {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.NEKO_DAY);
    private final int maxLevel = EnchantmentsConfig.INSTANCE.getMaxLevel(EnchantReg.NEKO_DAY);
    public NekoDay() {
        super();
    }

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }

}
