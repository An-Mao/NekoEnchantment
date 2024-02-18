package anmao.mc.ne.enchantment.phenomenon.duality;

import anmao.mc.ne.am._AM_Item;
import anmao.mc.ne.enchantment.phenomenon.PhenomenonEnchantment;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import org.jetbrains.annotations.NotNull;

public class Duality extends PhenomenonEnchantment {
    public Duality() {
        super(EnchantmentCategory.WEAPON, EquipmentSlot.MAINHAND);
    }


    @Override
    public int getMaxLevel() {
        return super.getMaxLevel();
    }
    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        if (enchantedItem.getTag() != null){
            float duality = enchantedItem.getTag().getInt("duality");
            if (duality < 0) {
                duality = (float) (_AM_Item.getItemDamage(enchantedItem) * -duality / 10);
                return duality;
            }
        }
        return super.getDamageBonus(level, mobType, enchantedItem);
    }

    @Override
    public void doPostAttack(@NotNull LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
