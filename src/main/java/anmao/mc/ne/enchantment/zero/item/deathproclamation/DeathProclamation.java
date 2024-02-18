package anmao.mc.ne.enchantment.zero.item.deathproclamation;

import anmao.mc.ne.enchantment.zero.item.ZeroItemE;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import org.jetbrains.annotations.NotNull;

public class DeathProclamation extends ZeroItemE {
    public DeathProclamation() {
        super(Rarity.VERY_RARE);
    }
    @Override
    public boolean isTreasureOnly() {
        return true;
    }

    @Override
    public void doPostAttack(@NotNull LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (pAttacker instanceof ServerPlayer){
            if (pTarget instanceof Mob livingEntity){
                if (livingEntity.deathTime == 0){
                    livingEntity.deathTime = (int) (livingEntity.getHealth() * -100);
                }
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
