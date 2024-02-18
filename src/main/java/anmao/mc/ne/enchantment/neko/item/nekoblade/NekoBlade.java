package anmao.mc.ne.enchantment.neko.item.nekoblade;

import anmao.mc.ne.enchantment.neko.item.NekoEI;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;

import java.util.Collection;

public class NekoBlade extends NekoEI {
    public NekoBlade() {
        super(Rarity.VERY_RARE);
    }
    @Override
    public float getDamageBonus(int level, MobType mobType, ItemStack enchantedItem) {
        Collection<AttributeModifier> att =
                enchantedItem.getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE);
        if (!att.isEmpty()){
            double addDamage = 0;
            for (AttributeModifier al : att) {
                if (al.getOperation() == AttributeModifier.Operation.ADDITION) {
                    addDamage += al.getAmount();
                }
            }
            float x = enchantedItem.getDamageValue();
            float y = enchantedItem.getMaxDamage();
            return (float) (addDamage * (0.15F + x / y));
        }
        return 0;
    }
}
