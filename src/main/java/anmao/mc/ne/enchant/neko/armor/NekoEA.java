package anmao.mc.ne.enchant.neko.armor;

import anmao.mc.ne.core.Enchant;
import anmao.mc.ne.enchant.neko.NekoEC;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.ItemStack;

public class NekoEA extends NekoEC {
    protected NekoEA() {
        super();
    }@Override
    public boolean canEnchant(ItemStack stack) {
        if (isArmor(stack)) {
            return true;
        }
        return super.canEnchant(stack);
    }
}
