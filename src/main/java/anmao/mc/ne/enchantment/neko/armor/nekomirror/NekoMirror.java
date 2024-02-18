package anmao.mc.ne.enchantment.neko.armor.nekomirror;

import anmao.mc.ne.enchantment.neko.armor.NekoEA;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class NekoMirror extends NekoEA {
    public NekoMirror() {
        super(Rarity.VERY_RARE);
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof ArmorItem || super.canEnchant(pStack);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}
