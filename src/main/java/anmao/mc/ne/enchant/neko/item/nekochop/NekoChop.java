package anmao.mc.ne.enchant.neko.item.nekochop;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.neko.item.NekoEI;

public class NekoChop extends NekoEI {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.NEKO_CHOP);
    private final int maxLevel = EnchantmentsConfig.INSTANCE.getMaxLevel(EnchantReg.NEKO_CHOP);
    public NekoChop() {
        super();
    }
    @Override
    public int getMaxLevel() {
        return maxLevel;
    }
}
