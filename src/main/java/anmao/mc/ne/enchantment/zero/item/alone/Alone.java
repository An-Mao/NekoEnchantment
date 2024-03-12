package anmao.mc.ne.enchantment.zero.item.alone;

import anmao.mc.amlib.attribute.AttributeHelper;
import anmao.mc.amlib.math._Math;
import anmao.mc.ne.am._AM_Constant;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.zero.item.ZeroItemE;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

import java.util.Collection;

public class Alone extends ZeroItemE {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.Z_ALONE);
    private final float quota = EnchantmentsConfig.INSTANCE.getValue(EnchantmentRegister.Z_ALONE,"quota");
    public Alone() {
        super(Rarity.VERY_RARE);
    }
    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        if (enchantedItem.getAllEnchantments().size() == 1){
            float amount = 0;
            if (enchantedItem.getTag() != null) {
                amount = enchantedItem.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_ALONE);
            }
            Collection<AttributeModifier> att =
                    enchantedItem.getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE);

            amount = (float) (_Math.log(amount, (int) quota) * AttributeHelper.getAttributeModifierValue(att));
            return amount;
        }
        return super.getDamageBonus(level, mobType, enchantedItem);
    }
}
