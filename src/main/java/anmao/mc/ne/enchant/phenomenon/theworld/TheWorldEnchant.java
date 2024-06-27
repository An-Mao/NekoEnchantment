package anmao.mc.ne.enchant.phenomenon.theworld;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.phenomenon.PhenomenonEnchant;
import net.minecraft.world.item.ItemStack;

public class TheWorldEnchant extends PhenomenonEnchant {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.THE_WORLD);
    public TheWorldEnchant() {
        super();
    }
    @Override
    public boolean canEnchant(ItemStack stack) {
        if (isWeapon(stack) || isChest(stack)) {
            return true;
        }
        return super.canEnchant(stack);
    }
}
