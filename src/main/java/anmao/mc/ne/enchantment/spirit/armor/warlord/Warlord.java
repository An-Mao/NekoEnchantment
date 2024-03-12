package anmao.mc.ne.enchantment.spirit.armor.warlord;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.spirit.armor.SAE;
import net.minecraft.world.item.enchantment.Enchantment;

public class Warlord extends SAE {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.E_WARLORD);
    public Warlord() {
        super(Enchantment.Rarity.VERY_RARE);
    }
}
