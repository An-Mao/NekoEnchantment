package anmao.mc.ne.enchantment.curse.corrode;

import anmao.mc.ne.am._AM;
import anmao.mc.ne.enchantment.curse.CurseEnchantmentCore;
import anmao.mc.ne.enchantment.zero.item.ZeroItemE;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class Corrode extends CurseEnchantmentCore {
    public Corrode() {    }

    @Override
    public void doPostAttack(@NotNull LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (pAttacker instanceof ServerPlayer){
            if (_AM.getRandomNumber(1,100) < pLevel * 10) {
                ItemStack item = pAttacker.getMainHandItem();
                int damage = Math.max(1, (item.getMaxDamage() - item.getDamageValue()) / 2);
                damage += item.getDamageValue();
                item.setDamageValue(Math.min(damage, item.getMaxDamage()));

            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
}
