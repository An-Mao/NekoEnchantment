package anmao.mc.ne.enchant.spirit.armor.warlord;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.spirit.armor.SAE;

public class Warlord extends SAE {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.E_WARLORD);
    public Warlord() {
        super();
    }
}
