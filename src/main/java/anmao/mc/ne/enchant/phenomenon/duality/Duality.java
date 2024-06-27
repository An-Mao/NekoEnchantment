package anmao.mc.ne.enchant.phenomenon.duality;

import anmao.mc.amlib.item.ItemHelper;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.phenomenon.PhenomenonEnchant;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Duality extends PhenomenonEnchant {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.DUALITY);
    private final float quota = EnchantmentsConfig.INSTANCE.getValue(EnchantReg.DUALITY,"quota");
    public Duality() {
        super();
    }


    @Override
    public int getMaxLevel() {
        return super.getMaxLevel();
    }
    @Override
    public float getDamageBonus(int level, Entity mobType, ItemStack enchantedItem) {
        CompoundTag nbt = EnchantHelper.getEnchantData(enchantedItem).getTagCopy();
        CompoundTag dualityData = nbt.getCompound("duality.data");
        float duality = dualityData.getInt("duality");
        if (duality < 0) {
            duality = (float) (ItemHelper.getItemDamage(enchantedItem) * -duality / quota);
            return duality;
        }
        return super.getDamageBonus(level, mobType, enchantedItem);
    }

    @Override
    public void doPostAttack(@NotNull LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
