package anmao.mc.ne.enchantment.spirit;

import anmao.mc.ne.enchantment.EC;
import anmao.mc.ne.enchantment.EnchantmentCore;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class SpiritE extends EnchantmentCore {
    protected SpiritE(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack) {
        return false;
    }

    @Override
    protected boolean checkCompatibility(@NotNull Enchantment pOther) {
        return !(pOther instanceof SpiritE);
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}
