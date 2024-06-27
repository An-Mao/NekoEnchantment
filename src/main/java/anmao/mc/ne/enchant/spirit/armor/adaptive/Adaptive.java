package anmao.mc.ne.enchant.spirit.armor.adaptive;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.spirit.armor.SAE;

public class Adaptive extends SAE {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.E_ADAPTIVE);
    public Adaptive() {
        super();
    }
}
