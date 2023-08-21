package anmao.idoll.nekochantment.enchantment.nekoking;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class NekoKing extends Enchantment {
    public NekoKing(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        float refine = 0;
        if (enchantedItem.getTag() != null) {
            refine += enchantedItem.getTag().getFloat("refine") / 20;
        }
        return refine + 1;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}
