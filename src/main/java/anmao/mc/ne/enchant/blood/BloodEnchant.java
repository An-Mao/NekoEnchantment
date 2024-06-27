package anmao.mc.ne.enchant.blood;

import anmao.mc.ne.core.Enchant;
import net.minecraft.ChatFormatting;
import net.minecraft.world.item.ItemStack;

public class BloodEnchant extends Enchant {
    protected BloodEnchant() {
        super( ChatFormatting.DARK_RED);
    }

    @Override
    public boolean canEnchant(ItemStack stack) {
        if (isWeapon(stack)) {
            return true;
        }
        return super.canEnchant(stack);
    }
}
