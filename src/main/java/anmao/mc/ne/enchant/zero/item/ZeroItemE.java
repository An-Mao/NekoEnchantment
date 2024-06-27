package anmao.mc.ne.enchant.zero.item;

import anmao.mc.ne.enchant.zero.ZeroEnchant;
import net.minecraft.world.item.ItemStack;

public class ZeroItemE extends ZeroEnchant {
    protected ZeroItemE() {
        super();
    }
    @Override
    public boolean canEnchant(ItemStack stack) {
        if (isWeapon(stack)) {
            return true;
        }
        return super.canEnchant(stack);
    }
}
