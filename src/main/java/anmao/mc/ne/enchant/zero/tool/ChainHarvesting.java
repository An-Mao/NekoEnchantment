package anmao.mc.ne.enchant.zero.tool;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.zero.ZeroEnchant;
import net.minecraft.world.item.ItemStack;

public class ChainHarvesting extends ZeroEnchant {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.ChainHarvesting);
    public static final int radius = (int) EnchantmentsConfig.INSTANCE.getValue(EnchantReg.ChainHarvesting,"radius");
    public static final int depths = (int) EnchantmentsConfig.INSTANCE.getValue(EnchantReg.ChainHarvesting,"depths");
    public ChainHarvesting() {
        super();
    }
    @Override
    public boolean canEnchant(ItemStack stack) {
        if (isDigger(stack)) {
            return true;
        }
        return super.canEnchant(stack);
    }
}
