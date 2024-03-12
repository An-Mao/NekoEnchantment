package anmao.mc.ne.enchantment.curse.disease;

import anmao.mc.amlib.effect.EffectHelper;
import anmao.mc.ne.enchantment.curse.CurseEnchantmentCore;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class CurseDisease extends CurseEnchantmentCore {

    @Override
    public void doPostAttack(LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        pAttacker.addEffect(EffectHelper.getDeBuffInstance(100,3));
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, @NotNull Entity pAttacker, int pLevel) {
        pTarget.addEffect(EffectHelper.getDeBuffInstance(100,3));
        super.doPostHurt(pTarget, pAttacker, pLevel);
    }

}
