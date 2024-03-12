package anmao.mc.ne.enchantment.neko.armor.nekoninja;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.neko.armor.NekoEA;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class NekoNinja extends NekoEA {
    private final int maxLevel = EnchantmentsConfig.INSTANCE.getMaxLevel(EnchantmentRegister.NEKO_NINJA);
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
        return maxLevel;
    }
}
