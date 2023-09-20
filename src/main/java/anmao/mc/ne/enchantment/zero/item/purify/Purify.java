package anmao.mc.ne.enchantment.zero.item.purify;

import anmao.mc.ne.enchantment.zero.item.ZeroItemE;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

public class Purify extends ZeroItemE {
    public Purify() {
        super(Enchantment.Rarity.VERY_RARE);
    }

    @Override
    public void doPostAttack(@NotNull LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (pAttacker instanceof ServerPlayer){
            if (pTarget instanceof LivingEntity livingEntity){
                CompoundTag nbt = new CompoundTag();
                livingEntity.load(nbt);
                livingEntity.save(nbt);
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
