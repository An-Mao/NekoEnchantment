package anmao.mc.ne.enchantment.zero.item;

import anmao.mc.ne.enchantment.EnchantmentCore;
import net.minecraft.ChatFormatting;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ZeroItemE extends EnchantmentCore {
    protected ZeroItemE(Rarity pRarity) {
        super(ChatFormatting.DARK_PURPLE,pRarity, EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND);
    }
    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}
