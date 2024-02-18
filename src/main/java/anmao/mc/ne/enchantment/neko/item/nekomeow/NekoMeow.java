package anmao.mc.ne.enchantment.neko.item.nekomeow;

import anmao.mc.ne.enchantment.neko.item.NekoEI;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

import java.io.IOException;

public class NekoMeow extends NekoEI {
    public NekoMeow() {
        super(Rarity.COMMON);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide){
            if (pAttacker instanceof ServerPlayer serverPlayer) {
                try (ServerLevel serverLevel = serverPlayer.serverLevel()) {
                    serverLevel.playSound(null, serverPlayer.getOnPos(), SoundEvents.CAT_HISS, SoundSource.PLAYERS);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
    @Override
    public boolean isTreasureOnly() {
        return false;
    }
}
