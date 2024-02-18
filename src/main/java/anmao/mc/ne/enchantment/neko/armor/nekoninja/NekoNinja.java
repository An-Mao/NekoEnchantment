package anmao.mc.ne.enchantment.neko.armor.nekoninja;

import anmao.mc.ne.enchantment.neko.armor.NekoEA;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class NekoNinja extends NekoEA {
    public NekoNinja() {
        super(Rarity.RARE);
    }

    @Override
    public void doPostHurt(LivingEntity pTarget, @NotNull Entity pAttacker, int pLevel) {
        if (!pTarget.level().isClientSide){
            pTarget.addEffect(new MobEffectInstance(MobEffects.DAMAGE_BOOST,pLevel*20,pLevel));
            pTarget.addEffect(new MobEffectInstance(MobEffects.INVISIBILITY,pLevel*20,pLevel));

        }
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
