package anmao.mc.ne.enchant.neko.armor.nekoblessing;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.neko.armor.NekoEA;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class NekoBlessing extends NekoEA {
    public static final String ENCHANTMENT_KEY_BLESSING = "blessing";
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.NEKO_BLESSING);
    public NekoBlessing() {
        super();
    }

    /*
    @Override
    public int getDamageProtection(int pLevel, DamageSource pSource) {
        if (pSource.getEntity() instanceof ServerPlayer serverPlayer) {
            Iterable<ItemStack> slots = serverPlayer.getArmorSlots();
            int a = 1;
            for (ItemStack sl : slots) {
                int lvl = sl.getEnchantmentLevel(EnchantmentRegister.NEKO_BLESSING.get());
                a += lvl;
            }
            return a;
        }
        return 0;
    }
     */

    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof ArmorItem || super.canEnchant(pStack);
    }
    @Override
    public int getMaxLevel() {
        return 5;
    }
}
