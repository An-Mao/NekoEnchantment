package anmao.mc.ne.enchantment.spirit.sword.deathsickle;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.spirit.sword.SSE;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

public class DeathSickle extends SSE {
    private final float damage = EnchantmentsConfig.INSTANCE.getValue(EnchantmentRegister.E_DEATH_SICKLE,"damage");
    public DeathSickle() {
        super(Enchantment.Rarity.VERY_RARE);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide) {
            if (pTarget instanceof Villager) {
                pTarget.hurt(pAttacker.damageSources().magic(), damage);
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
