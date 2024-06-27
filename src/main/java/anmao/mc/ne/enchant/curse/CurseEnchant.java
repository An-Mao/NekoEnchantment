package anmao.mc.ne.enchant.curse;

import anmao.mc.ne.core.Enchant;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.ItemStack;

public class CurseEnchant extends Enchant {
    protected CurseEnchant() {
        super(ChatFormatting.RED);
    }
    @Override
    public boolean canEnchant(ItemStack pStack) {
        return true;
    }
}
