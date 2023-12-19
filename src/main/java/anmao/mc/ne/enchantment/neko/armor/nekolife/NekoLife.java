package anmao.mc.ne.enchantment.neko.armor.nekolife;

import anmao.mc.ne.enchantment.EnchantmentCore;
import anmao.mc.ne.enchantment.neko.armor.NekoEA;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class NekoLife extends NekoEA {
    public NekoLife() {
        super(Rarity.VERY_RARE);
    }


    @Override
    public int getMaxLevel() {
        return 3;
    }

    @Override
    public boolean isTreasureOnly() {
        return true;
    }
    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof ArmorItem || super.canEnchant(pStack);
    }
}
