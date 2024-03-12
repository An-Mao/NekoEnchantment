package anmao.mc.ne.enchantment.blood;

import anmao.mc.ne.enchantment.EnchantmentCore;
import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class BloodEnchantment extends EnchantmentCore {
    protected BloodEnchantment( Rarity pRarity) {
        super( ChatFormatting.DARK_RED,pRarity,EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND);
    }
    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}
