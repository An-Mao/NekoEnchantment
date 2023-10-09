package anmao.mc.ne.enchantment.curse.disease;

import anmao.mc.ne.am._AM_Effect;
import anmao.mc.ne.enchantment.curse.CurseEnchantmentCore;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class CurseDisease extends CurseEnchantmentCore {
    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        pAttacker.addEffect(_AM_Effect.getRandomEffectI(100,3));
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, Entity pAttacker, int pLevel) {
        pTarget.addEffect(_AM_Effect.getRandomEffectI(100,3));
        super.doPostHurt(pTarget, pAttacker, pLevel);
    }

}
