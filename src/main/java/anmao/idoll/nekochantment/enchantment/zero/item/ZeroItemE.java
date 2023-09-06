package anmao.idoll.nekochantment.enchantment.zero.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ZeroItemE extends Enchantment {
    protected ZeroItemE(Rarity pRarity) {
        super(pRarity, EnchantmentCategory.WEAPON, new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }
}
