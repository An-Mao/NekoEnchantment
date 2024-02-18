package anmao.mc.ne.enchantment.neko.item.nekogod;

import anmao.mc.ne.am._AM;
import anmao.mc.ne.enchantment.neko.item.NekoEI;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class NekoGod extends NekoEI {
    public NekoGod() {
        super(Rarity.VERY_RARE);
    }

    @Override
    public void doPostAttack(@NotNull LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (pAttacker instanceof ServerPlayer serverPlayer && pTarget instanceof LivingEntity mob && !(pTarget instanceof ServerPlayer)) {
            float p = pLevel * 2;
            //0-100
            p += _AM.getLuckP(serverPlayer.getLuck());
            if (p > _AM.getRandomNumber(1, 100)) {
                //32767
                p = Math.max(0.0F, mob.getHealth() - mob.getMaxHealth() * (serverPlayer.experienceLevel / 300F) * pLevel);
                //System.out.println("count:"+p);
                if (p == 0.0F) {
                    mob.setHealth(0.00001F);
                    //mob.hurt(serverPlayer.damageSources().genericKill(),Float.MAX_VALUE);
                    //mob.dropAllDeathLoot();
                    mob.die(serverPlayer.damageSources().genericKill());
                    mob.remove(Entity.RemovalReason.KILLED);
                } else {
                    mob.setHealth(p);
                }
            }
        }

    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
