package anmao.mc.ne.enchantment.neko.armor.nekoblessing;

import anmao.mc.ne.enchantment.neko.armor.NekoEA;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;

public class NekoBlessing extends NekoEA {
    public NekoBlessing() {
        super(Rarity.VERY_RARE);
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
    public boolean isTreasureOnly() {
        return true;
    }
    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof ArmorItem || super.canEnchant(pStack);
    }
    @Override
    public int getMaxLevel() {
        return 5;
    }
}
