package anmao.mc.ne.enchantment.spirit.sword.moye;

import anmao.mc.ne.am._AM_Item;
import anmao.mc.ne.config.C_E_O;
import anmao.mc.ne.enchantment.N_E_S;
import anmao.mc.ne.enchantment.spirit.sword.SSE;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

public class MoYe extends SSE {
    public MoYe() {
        super(Enchantment.Rarity.VERY_RARE);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide) {
            if (pAttacker.getOffhandItem().getEnchantmentLevel(N_E_S.oi_gan_jiang) > 0) {
                if (_AM_Item.getRandomNumber(1, 100) <= C_E_O.gangjiang_moye_sp) {
                    pTarget.kill();
                }
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
