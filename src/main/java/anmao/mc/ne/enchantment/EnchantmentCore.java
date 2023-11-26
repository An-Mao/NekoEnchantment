package anmao.mc.ne.enchantment;

import anmao.mc.ne.NE;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

import java.awt.*;

public class EnchantmentCore extends Enchantment {
    protected EnchantmentCore(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot[] pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public Component getFullname(int pLevel) {
        if (!NE.ShowDesc) {
            MutableComponent tp = super.getFullname(pLevel).copy();
            tp.append(CommonComponents.NEW_LINE).append("(").append(Component.translatable(getDescriptionId() + ".desc").append(")"));
            return tp;
        }
        return super.getFullname(pLevel);
    }
}
