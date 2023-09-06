package anmao.idoll.nekochantment.enchantment.neko.item.nekoblade;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.util.Collection;

public class NekoBlade extends Enchantment {
    public NekoBlade(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }
    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        Collection<AttributeModifier> att =
                enchantedItem.getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE);
        if (!att.isEmpty()){
            double adddamage = 0;
            for (AttributeModifier al : att) {
                if (al.getOperation() == AttributeModifier.Operation.ADDITION) {
                    adddamage += al.getAmount();
                }
            }
            float x = enchantedItem.getDamageValue();
            float y = enchantedItem.getMaxDamage();
            return (float) (adddamage * (0.15F + x / y));
        }
        return 0;
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
