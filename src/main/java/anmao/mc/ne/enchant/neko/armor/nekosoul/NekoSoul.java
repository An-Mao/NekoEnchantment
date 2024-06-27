package anmao.mc.ne.enchant.neko.armor.nekosoul;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.neko.armor.NekoEA;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class NekoSoul extends NekoEA {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.NEKO_SOUL);
    private final float consume = EnchantmentsConfig.INSTANCE.getValue(EnchantReg.NEKO_SOUL,"consume");
    private final float quota = EnchantmentsConfig.INSTANCE.getValue(EnchantReg.NEKO_SOUL,"quota");
    public static final String ENCHANTMENT_KEY_SOUL = "soul";
    public NekoSoul() {
        super();
    }


    @Override
    public boolean canEnchant(ItemStack pStack) {
        return pStack.getItem() instanceof ArmorItem || super.canEnchant(pStack);
    }
    /*
    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide){
            if (pTarget instanceof LivingEntity livingEntity){
                if (pAttacker instanceof ServerPlayer serverPlayer) {
                    int souls = serverPlayer.getMainHandItem().getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_SOUL);
                    souls++;
                    serverPlayer.getMainHandItem().getTag().putInt(_AM_Constant.ENCHANTMENT_KEY_SOUL, souls);
                }
            }
        }
    }

     */

    @Override
    public void doPostHurt(LivingEntity pTarget, @NotNull Entity pAttacker, int pLevel) {
        if (!pTarget.level().isClientSide){
            if (pTarget instanceof ServerPlayer serverPlayer){
                ItemStack mitem = serverPlayer.getMainHandItem();
                if (mitem.getItem() != Items.AIR) {
                    CompoundTag compoundTag = EnchantHelper.getEnchantData(mitem).getTagCopy();
                    CompoundTag soulData = compoundTag.getCompound("soul.data");
                    int souls = soulData.getInt(ENCHANTMENT_KEY_SOUL);
                    if (souls >= consume) {
                        souls -= (int) consume;
                        serverPlayer.heal(serverPlayer.getMaxHealth() * quota);
                        soulData.putInt(ENCHANTMENT_KEY_SOUL, souls);
                        compoundTag.put("soul.data", soulData);
                        EnchantHelper.setEnchantData(mitem, compoundTag);
                    }

                }
            }
        }
    }
}
