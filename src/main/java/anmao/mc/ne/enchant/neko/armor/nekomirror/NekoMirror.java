package anmao.mc.ne.enchant.neko.armor.nekomirror;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.neko.armor.NekoEA;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class NekoMirror extends NekoEA {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.NEKO_MIRROR);
    private final int maxLevel = EnchantmentsConfig.INSTANCE.getMaxLevel(EnchantReg.NEKO_MIRROR);
    public NekoMirror() {
        super();
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof ArmorItem || super.canEnchant(pStack);
    }

    @Override
    public int getMaxLevel() {
        return maxLevel;
    }
}
