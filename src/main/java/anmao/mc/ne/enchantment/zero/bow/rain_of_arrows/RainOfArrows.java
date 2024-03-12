package anmao.mc.ne.enchantment.zero.bow.rain_of_arrows;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.zero.bow.ZeroBowEnchantmentCore;

public class RainOfArrows extends ZeroBowEnchantmentCore {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.Z_UNBREAKABLE);
    public RainOfArrows(){}
}
