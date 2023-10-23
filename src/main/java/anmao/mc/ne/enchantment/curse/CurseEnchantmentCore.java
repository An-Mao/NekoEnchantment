package anmao.mc.ne.enchantment.curse;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class CurseEnchantmentCore extends Enchantment {
    protected CurseEnchantmentCore() {
        super(Rarity.UNCOMMON, EnchantmentCategory.WEARABLE, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return true;
    }
}
