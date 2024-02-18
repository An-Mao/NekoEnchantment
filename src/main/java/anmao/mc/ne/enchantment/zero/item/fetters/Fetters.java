package anmao.mc.ne.enchantment.zero.item.fetters;

import anmao.mc.ne.enchantment.zero.item.ZeroItemE;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class Fetters extends ZeroItemE {
    public Fetters() {
        super(Rarity.VERY_RARE);
    }

    @Override
    public void doPostAttack(@NotNull LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        super.doPostAttack(pAttacker, pTarget, pLevel);
        if (pTarget instanceof LivingEntity livingEntity){
            CompoundTag dat = livingEntity.getPersistentData();
            long gt = livingEntity.level().getGameTime();
            //System.out.println("gt:"+gt);
            if (gt - dat.getInt("Fetters") < 1200){
                return;
            }
            dat.putLong("Fetters",gt);
            dat.putDouble("Fx",livingEntity.getX());
            dat.putDouble("Fy",livingEntity.getY());
            dat.putDouble("Fz",livingEntity.getZ());
        }
    }
}
