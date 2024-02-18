package anmao.mc.ne.enchantment.phenomenon;

import anmao.mc.amlib.component.ComponentStyle;
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
        return ComponentStyle.Flash(Component.translatable(this.getDescriptionId()).getString(),System.currentTimeMillis()/50);
        //return _AM_Color.RainbowTextColor(Component.translatable(this.getDescriptionId()).getString(),System.currentTimeMillis()/50);
    }
    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}
