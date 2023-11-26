package anmao.mc.ne.enchantment.neko.item.nekolove;

import anmao.mc.ne.enchantment.neko.NekoEI;
import net.minecraft.world.item.ItemStack;

public class NekoLove extends NekoEI {
    public NekoLove() {
        super(Rarity.VERY_RARE);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return true;
    }
}
