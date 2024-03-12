package anmao.mc.ne.enchantment.zero.item.unbreakable;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.zero.item.ZeroItemE;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

public class Unbreakable extends ZeroItemE {
    public static final String ENCHANTMENT_KEY_UNBREAKABLE = "unbreakable";
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.Z_UNBREAKABLE);
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
