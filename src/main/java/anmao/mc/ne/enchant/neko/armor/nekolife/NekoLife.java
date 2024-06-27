package anmao.mc.ne.enchant.neko.armor.nekolife;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.neko.armor.NekoEA;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class NekoLife extends NekoEA {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.NEKO_LIFE);
    private final int maxLevel = EnchantmentsConfig.INSTANCE.getMaxLevel(EnchantReg.NEKO_LIFE);
    public NekoLife() {
        super();
    }


    @Override
    public int getMaxLevel() {
        return maxLevel;
    }
    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof ArmorItem || super.canEnchant(pStack);
    }
}
