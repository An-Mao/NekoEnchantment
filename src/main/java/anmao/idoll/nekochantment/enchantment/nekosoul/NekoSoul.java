package anmao.idoll.nekochantment.enchantment.nekosoul;

import anmao.idoll.nekochantment.am._AM_Constant;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageSources;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class NekoSoul extends Enchantment {
    public NekoSoul(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }


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

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        if (!pTarget.level().isClientSide){
            if (pTarget instanceof ServerPlayer serverPlayer){
                int souls = serverPlayer.getMainHandItem().getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_SOUL);
                if (souls>= 200){
                    souls -= 200;
                    serverPlayer.heal(serverPlayer.getMaxHealth() * 0.1F);
                    serverPlayer.getMainHandItem().getTag().putInt(_AM_Constant.ENCHANTMENT_KEY_SOUL, souls);
                }
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}
