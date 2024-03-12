package anmao.mc.ne.enchantment.spirit.sword.ganjiang;

import anmao.mc.amlib.math._Random;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.NekoEnchantments;
import anmao.mc.ne.enchantment.spirit.sword.SSE;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

public class GanJiang extends SSE {
    private final float probability = EnchantmentsConfig.INSTANCE.getValue(EnchantmentRegister.E_GAN_JIANG,"probability");

    public GanJiang() {
        super(Enchantment.Rarity.VERY_RARE);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide) {
            if (pAttacker.getOffhandItem().getEnchantmentLevel(NekoEnchantments.oi_mo_ye) >0) {
                if (_Random.getRandomNumber(1, 100) <= probability) {
                    pTarget.kill();
                }
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
