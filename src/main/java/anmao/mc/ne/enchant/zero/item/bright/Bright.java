package anmao.mc.ne.enchant.zero.item.bright;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.zero.item.ZeroItemE;

public class Bright extends ZeroItemE {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.Z_BRIGHT);
    public Bright() {
        super();
    }
}
