package anmao.idoll.nekochantment.enchantment.nekomeow;

import net.minecraft.client.sounds.WeighedSoundEvents;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class NekoMeow extends Enchantment {
    public NekoMeow(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide){
            if (pAttacker instanceof ServerPlayer serverPlayer) {
                ServerLevel serverLevel = serverPlayer.serverLevel();
                serverLevel.playSound(null, serverPlayer.getOnPos(), SoundEvents.CAT_HISS,SoundSource.PLAYERS);
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }
}
