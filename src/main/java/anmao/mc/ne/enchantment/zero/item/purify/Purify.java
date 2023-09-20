package anmao.mc.ne.enchantment.zero.item.purify;

import anmao.mc.ne.enchantment.zero.item.ZeroItemE;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
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
                double x = livingEntity.getX(),y = livingEntity.getY(),z = livingEntity.getZ();
                /*
                ListTag pos = new ListTag();

                //nbt.putDouble("X",livingEntity.getX());

                CompoundTag pos= new CompoundTag();
                pos.putDouble("X", livingEntity.getX());
                pos.putDouble("Y", livingEntity.getY());
                pos.putDouble("Z", livingEntity.getZ());
                nbt.put("Pos",pos);


                pos.set(0, livingEntity.getX());
                nbt.putIntArray("Pos", new int[]{(int) livingEntity.getX(), (int) livingEntity.getY(), (int) livingEntity.getZ()});


                 */
                nbt.putFloat("Health",livingEntity.getHealth());
                System.out.println(nbt);
                livingEntity.load(nbt);
                livingEntity.teleportTo(x,y,z);
                livingEntity.save(nbt);

                //nbt.putByte("NoAI", (byte) 1);
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
