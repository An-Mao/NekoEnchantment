package anmao.mc.ne.enchantment.phenomenon.theworld;

import anmao.mc.ne.enchantment.phenomenon.PhenomenonEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class TheWorld extends PhenomenonEnchantment {
    public TheWorld() {
        super(EnchantmentCategory.BREAKABLE, EquipmentSlot.MAINHAND,EquipmentSlot.MAINHAND,EquipmentSlot.HEAD,EquipmentSlot.CHEST,EquipmentSlot.LEGS,EquipmentSlot.FEET);
    }

}
