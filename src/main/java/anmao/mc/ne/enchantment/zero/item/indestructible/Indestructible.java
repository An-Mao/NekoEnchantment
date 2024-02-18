package anmao.mc.ne.enchantment.zero.item.indestructible;

import anmao.mc.ne.enchantment.zero.item.ZeroItemE;
import net.minecraft.world.item.ItemStack;

public class Indestructible extends ZeroItemE {
    public Indestructible() {
        super(Rarity.VERY_RARE);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return true;
    }
}
