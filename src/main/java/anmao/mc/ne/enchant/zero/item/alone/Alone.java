package anmao.mc.ne.enchant.zero.item.alone;

import anmao.mc.amlib.attribute.AttributeHelper;
import anmao.mc.amlib.item.ItemHelper;
import anmao.mc.amlib.math._Math;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.zero.item.ZeroItemE;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

import java.util.Collection;

public class Alone extends ZeroItemE {
    public static final String ENCHANTMENT_KEY_ALONE = "alone";
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.Z_ALONE);
    private final float quota = EnchantmentsConfig.INSTANCE.getValue(EnchantReg.Z_ALONE,"quota");
    public Alone() {
        super();
    }
    @Override
    public float getDamageBonus(int level, Entity mobType, ItemStack enchantedItem) {
        if (EnchantHelper.getEnchantCompound(enchantedItem).size() == 1){
            float amount = 0;
            CompoundTag nbt = EnchantHelper.getAllData(enchantedItem);
            CompoundTag aloneData = nbt.getCompound("alone.data");
            amount = aloneData.getInt(ENCHANTMENT_KEY_ALONE);

            Collection<AttributeModifier> att = ItemHelper.getAttributeModifiers(enchantedItem, EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE);
            amount = (float) (_Math.log(amount, (int) quota) * AttributeHelper.getAttributeModifierValue(att));
            return amount;
        }
        return super.getDamageBonus(level, mobType, enchantedItem);
    }
}
