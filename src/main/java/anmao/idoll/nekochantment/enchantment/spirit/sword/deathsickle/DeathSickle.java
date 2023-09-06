package anmao.idoll.nekochantment.enchantment.spirit.sword.deathsickle;

import anmao.idoll.nekochantment.config.C_E_O;
import anmao.idoll.nekochantment.enchantment.spirit.sword.SSE;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

public class DeathSickle extends SSE {
    public DeathSickle() {
        super(Enchantment.Rarity.VERY_RARE);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide) {
            if (pTarget instanceof Villager) {
                pTarget.hurt(pAttacker.damageSources().magic(), C_E_O.village_add_damage);
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
