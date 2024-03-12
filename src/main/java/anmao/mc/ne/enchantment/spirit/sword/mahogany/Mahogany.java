package anmao.mc.ne.enchantment.spirit.sword.mahogany;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.spirit.sword.SSE;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

public class Mahogany extends SSE {
    private final float damage = EnchantmentsConfig.INSTANCE.getValue(EnchantmentRegister.E_MAHOGANY,"damage");
    public Mahogany() {
        super(Enchantment.Rarity.VERY_RARE);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide){
            if (pTarget instanceof Zombie zombie) {
                zombie.hurt(pAttacker.damageSources().fellOutOfWorld(),damage);
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
