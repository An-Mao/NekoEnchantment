package anmao.mc.ne.enchantment.zero.item;

import anmao.mc.ne.enchantment.EnchantmentCore;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ZeroItemE extends EnchantmentCore {
    protected ZeroItemE(Rarity pRarity) {
        super(pRarity, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return false;
    }
}
