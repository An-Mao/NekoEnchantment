package anmao.mc.ne.enchantment.zero.item.unbreakable;

import anmao.mc.ne.enchantment.zero.item.ZeroItemE;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class Unbreakable extends ZeroItemE {
    private static final String TOOLTIPS_REFINE = "tooltips.ne.refine";
    public Unbreakable() {
        super(Rarity.VERY_RARE);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getMaxDamage()>0;
    }

    @Override
    public Component getFullname(int pLevel) {
        return super.getFullname(pLevel);
    }
}
