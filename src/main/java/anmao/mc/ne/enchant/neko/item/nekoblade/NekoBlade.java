package anmao.mc.ne.enchant.neko.item.nekoblade;

import anmao.mc.amlib.item.ItemHelper;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.neko.item.NekoEI;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

import java.util.Collection;

public class NekoBlade extends NekoEI {
    private final float base = EnchantmentsConfig.INSTANCE.getConfig(EnchantReg.NEKO_BLADE).getParameters().get("baseDamage").getAsFloat();
    public NekoBlade() {
        super();
    }
    @Override
    public float getDamageBonus(int level, Entity mobType, ItemStack enchantedItem) {
        Collection<AttributeModifier> att =
                ItemHelper.getAttributeModifiers(enchantedItem, EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE);//enchantedItem.getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE);
        if (!att.isEmpty()){
            double addDamage = 0;
            for (AttributeModifier al : att) {

                if (al.operation() == AttributeModifier.Operation.ADD_VALUE) {
                    addDamage += al.amount();
                }
            }
            float x = enchantedItem.getDamageValue();
            float y = enchantedItem.getMaxDamage();
            return (float) (addDamage * (base + x / y));
        }
        return 0;
    }
}
