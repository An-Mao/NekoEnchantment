package anmao.mc.ne.enchantment.zero.item;

import anmao.mc.ne.enchantment.EnchantmentCore;
import anmao.mc.ne.enchantment.zero.ZeroEnchantmentCore;
import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ZeroItemE extends ZeroEnchantmentCore {
    protected ZeroItemE(Rarity pRarity) {
        super(pRarity, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND);
    }
    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}
