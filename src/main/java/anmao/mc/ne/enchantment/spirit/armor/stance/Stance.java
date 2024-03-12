package anmao.mc.ne.enchantment.spirit.armor.stance;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.spirit.armor.SAE;
import net.minecraft.world.item.enchantment.Enchantment;

public class Stance extends SAE {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.E_STANCE);
    public Stance() {
        super(Enchantment.Rarity.VERY_RARE);
    }
}
