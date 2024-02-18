package anmao.mc.ne.enchantment;

import anmao.mc.ne.NE;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.CommonComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class EnchantmentCore extends Enchantment {
    private final ChatFormatting nameColor;
    protected EnchantmentCore(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
        this.nameColor = ChatFormatting.GRAY;
    }
    public EnchantmentCore(ChatFormatting chatFormatting , Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots){
        super(pRarity, pCategory, pApplicableSlots);
        this.nameColor = chatFormatting;
    }
    @Override
    public Component getFullname(int pLevel) {
        MutableComponent mutablecomponent = Component.translatable(this.getDescriptionId());
        mutablecomponent.withStyle(nameColor);

        if (pLevel != 1 || this.getMaxLevel() != 1) {
            mutablecomponent.append(CommonComponents.SPACE).append(Component.translatable("enchantment.level." + pLevel));
        }


        if (!NE.ShowDesc) {
            MutableComponent tp = super.getFullname(pLevel).copy();
            tp.append(CommonComponents.NEW_LINE).append("(").append(Component.translatable(getDescriptionId() + ".desc").append(")"));
            return tp;
        }
        return mutablecomponent;
    }
}
