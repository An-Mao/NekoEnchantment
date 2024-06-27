package anmao.mc.ne.enchant.neko.item.nekolove;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.neko.item.NekoEI;
import net.minecraft.world.item.ItemStack;

public class NekoLove extends NekoEI {
    public static final String ENCHANTMENT_KEY_LOVE = "love";
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.NEKO_LOVE);
    public NekoLove() {
        super();
    }

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return true;
    }
}
