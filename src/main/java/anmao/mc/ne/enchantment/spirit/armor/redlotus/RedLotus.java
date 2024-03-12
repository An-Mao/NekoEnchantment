package anmao.mc.ne.enchantment.spirit.armor.redlotus;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.spirit.armor.SAE;
import net.minecraft.world.item.enchantment.Enchantment;

public class RedLotus extends SAE {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.E_REDLOTUS);
    public RedLotus() {
        super(Enchantment.Rarity.VERY_RARE);
    }
}
