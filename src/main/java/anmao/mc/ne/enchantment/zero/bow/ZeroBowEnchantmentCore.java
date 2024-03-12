package anmao.mc.ne.enchantment.zero.bow;

import anmao.mc.ne.enchantment.EnchantmentCore;
import anmao.mc.ne.enchantment.zero.ZeroEnchantmentCore;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ZeroBowEnchantmentCore extends ZeroEnchantmentCore {
    public ZeroBowEnchantmentCore() {
        super(Rarity.VERY_RARE, EnchantmentCategory.BOW, EquipmentSlot.MAINHAND);
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}
