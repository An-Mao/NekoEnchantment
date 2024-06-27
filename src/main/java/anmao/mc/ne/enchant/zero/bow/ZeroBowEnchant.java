package anmao.mc.ne.enchant.zero.bow;

import anmao.mc.ne.enchant.zero.ZeroEnchant;
import net.minecraft.world.item.ItemStack;

public class ZeroBowEnchant extends ZeroEnchant {
    public ZeroBowEnchant() {
        super();
    }
    @Override
    public boolean canEnchant(ItemStack stack) {
        if (isBow(stack)) {
            return true;
        }
        return super.canEnchant(stack);
    }
}
