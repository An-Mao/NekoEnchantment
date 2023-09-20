package anmao.mc.ne.enchantment.spirit.sword;

import anmao.mc.ne.enchantment.spirit.SpiritE;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class SSE extends SpiritE {
    protected SSE(Enchantment.Rarity pRarity) {
        super(pRarity, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND);
    }
}
