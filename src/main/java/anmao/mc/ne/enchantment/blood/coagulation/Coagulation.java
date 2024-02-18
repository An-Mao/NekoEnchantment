package anmao.mc.ne.enchantment.blood.coagulation;

import anmao.mc.ne.enchantment.blood.BloodEnchantment;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class Coagulation extends BloodEnchantment {
    public Coagulation() {
        super(Rarity.VERY_RARE);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        super.doPostAttack(pAttacker, pTarget, pLevel);
        if (pTarget instanceof LivingEntity livingEntity){
            CompoundTag dat = livingEntity.getPersistentData();
            long gt = livingEntity.level().getGameTime();
            /*
            if (gt - dat.getInt("coagulation") < 1200){
                return;
            }
             */
            dat.putLong("coagulation",gt);
            dat.putFloat("coagulationHealth",livingEntity.getHealth());
        }
    }
}
