package anmao.mc.ne.enchant.spirit.armor;

import anmao.mc.ne.enchant.spirit.SpiritE;
import net.minecraft.world.item.ItemStack;

public class SAE extends SpiritE {
    protected SAE() {
        super();
    }
    @Override
    public boolean canEnchant(ItemStack stack) {
        if (isChest(stack)) {
            return true;
        }
        return super.canEnchant(stack);
    }
}
