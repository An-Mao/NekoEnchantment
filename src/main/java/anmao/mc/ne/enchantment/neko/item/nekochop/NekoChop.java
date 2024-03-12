package anmao.mc.ne.enchantment.neko.item.nekochop;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.neko.item.NekoEI;

public class NekoChop extends NekoEI {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.NEKO_CHOP);
    private final int maxLevel = EnchantmentsConfig.INSTANCE.getMaxLevel(EnchantmentRegister.NEKO_CHOP);
    public NekoChop() {
        super(Rarity.RARE);
    }
    @Override
    public int getMaxLevel() {
        return maxLevel;
    }
}
