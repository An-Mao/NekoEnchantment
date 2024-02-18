package anmao.mc.ne.enchantment.spirit.sword.mahogany;

import anmao.mc.ne.enchantment.spirit.sword.SSE;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

public class Mahogany extends SSE {

    public Mahogany() {
        super(Enchantment.Rarity.VERY_RARE);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide){
            //ItemStack offitem = pAttacker.getOffhandItem();
            if (pTarget instanceof Zombie) {
                pTarget.hurt(pAttacker.damageSources().fellOutOfWorld(),9);
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
