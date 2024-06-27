package anmao.mc.ne.enchant.zero.item.indestructible;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.zero.item.ZeroItemE;
import net.minecraft.world.item.ItemStack;

public class Indestructible extends ZeroItemE {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.Z_INDESTRUCTIBLE);
    public Indestructible() {
        super();
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return true;
    }
}
