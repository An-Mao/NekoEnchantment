package anmao.mc.ne.enchantment.zero.item.breakdefense;

import anmao.mc.ne.am._AM;
import anmao.mc.ne.effect.Effects;
import anmao.mc.ne.enchantment.zero.item.ZeroItemE;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class BreakDefense extends ZeroItemE {
    private static final MobEffectInstance BreakDefense = new MobEffectInstance(Effects.BREAK_DEFENSE.get(),1,200);
    public BreakDefense() {
        super(Rarity.VERY_RARE);
    }

    @Override
    public void doPostAttack(@NotNull LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (pAttacker instanceof ServerPlayer){
            if (pTarget instanceof LivingEntity livingEntity) {
                if (_AM.getRandomNumber(1,100) < pLevel * 12 ) {
                    livingEntity.addEffect(BreakDefense);
                }
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
}
