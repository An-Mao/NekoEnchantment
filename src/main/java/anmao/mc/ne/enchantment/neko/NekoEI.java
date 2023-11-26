package anmao.mc.ne.enchantment.neko;

import anmao.mc.ne.enchantment.EnchantmentCore;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class NekoEI extends EnchantmentCore {
    protected NekoEI(Rarity pRarity) {
        super(pRarity, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
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
