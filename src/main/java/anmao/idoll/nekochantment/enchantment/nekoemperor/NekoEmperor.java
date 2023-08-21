package anmao.idoll.nekochantment.enchantment.nekoemperor;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class NekoEmperor extends Enchantment {
    public NekoEmperor(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        float kill = 0;
        if (enchantedItem.getTag() != null) {
            kill += enchantedItem.getTag().getFloat("refine") / 50;
        }
        return kill + 1;
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}
