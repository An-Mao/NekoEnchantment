package anmao.mc.ne.enchantment.neko.armor.nekosoul;

import anmao.mc.ne.am._AM_Constant;
import anmao.mc.ne.enchantment.neko.armor.NekoEA;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class NekoSoul extends NekoEA {
    public NekoSoul() {
        super(Rarity.VERY_RARE);
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
                    if (mitem.getTag() != null) {
                        int souls = mitem.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_SOUL);
                        if (souls >= 200) {
                            souls -= 200;
                            serverPlayer.heal(serverPlayer.getMaxHealth() * 0.1F);
                            mitem.getTag().putInt(_AM_Constant.ENCHANTMENT_KEY_SOUL, souls);
                        }
                    }
                }
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}
