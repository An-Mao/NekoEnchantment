package anmao.mc.ne.enchant.spirit.sword.moye;

import anmao.dev.core.math._Random;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.core.Enchants;
import anmao.mc.ne.enchant.spirit.sword.SSE;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class MoYe extends SSE {
    private final float probability = EnchantmentsConfig.INSTANCE.getValue(EnchantReg.E_MO_YE,"probability");
    public MoYe() {
        super();
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide) {
            if (EnchantHelper.hasEnchant(pAttacker.getOffhandItem(), Enchants.oi_gan_jiang)) {
                if (_Random.getRandomNumber(1, 100) <= probability) {
                    pTarget.kill();
                }
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
