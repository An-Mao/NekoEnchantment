package anmao.mc.ne.enchantment.spirit.armor.adaptive;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.spirit.armor.SAE;
import net.minecraft.world.item.enchantment.Enchantment;

public class Adaptive extends SAE {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.E_ADAPTIVE);
    public Adaptive() {
        super(Enchantment.Rarity.VERY_RARE);
    }
}
