package anmao.mc.ne.enchant.blood.coagulation;

import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.enchant.blood.BloodEnchant;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

public class Coagulation extends BloodEnchant {
    public static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantReg.B_COAGULATION);
    public Coagulation() {
        super();
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
