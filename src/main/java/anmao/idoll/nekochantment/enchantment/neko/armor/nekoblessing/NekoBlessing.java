package anmao.idoll.nekochantment.enchantment.neko.armor.nekoblessing;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class NekoBlessing extends Enchantment {
    public NekoBlessing(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
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
