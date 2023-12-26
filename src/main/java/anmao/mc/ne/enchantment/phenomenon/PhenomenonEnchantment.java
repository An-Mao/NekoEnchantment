package anmao.mc.ne.enchantment.phenomenon;

import anmao.mc.ne.am._AM_Color;
import anmao.mc.ne.enchantment.EnchantmentCore;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class PhenomenonEnchantment extends EnchantmentCore {
    protected PhenomenonEnchantment( EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(Rarity.VERY_RARE, pCategory, pApplicableSlots);
    }
    @Override
    public Component getFullname(int pLevel) {
        return _AM_Color.RainbowTextColor(Component.translatable(this.getDescriptionId()).getString(),System.currentTimeMillis()/300);
    }
    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}
