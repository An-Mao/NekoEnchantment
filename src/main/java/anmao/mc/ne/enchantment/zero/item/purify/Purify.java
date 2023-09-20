package anmao.mc.ne.enchantment.zero.item.purify;

import anmao.mc.ne.am._AM;
import anmao.mc.ne.config.C_E_O;
import anmao.mc.ne.enchantment.zero.item.ZeroItemE;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class Purify extends ZeroItemE {
    public Purify() {
        super(Enchantment.Rarity.VERY_RARE);
    }
    @Override
    public void doPostAttack(@NotNull LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (pAttacker instanceof ServerPlayer){
            if (pTarget instanceof LivingEntity livingEntity){
                if (_AM.getRandomNumber(1,100) < C_E_O.ziPurifyP) {

                    //CompoundTag nbt = new CompoundTag();
                    //double x = livingEntity.getX(), y = livingEntity.getY(), z = livingEntity.getZ();
                    /*
                    ListTag pos = new ListTag();
                    pos.add(0,);

                    //nbt.putDouble("X",livingEntity.getX());

                    CompoundTag pos= new CompoundTag();
                    pos.putDouble("X", livingEntity.getX());
                    pos.putDouble("Y", livingEntity.getY());
                    pos.putDouble("Z", livingEntity.getZ());
                    nbt.put("Pos",pos);


                    pos.set(0, livingEntity.getX());
                    nbt.putIntArray("Pos", new int[]{(int) livingEntity.getX(), (int) livingEntity.getY(), (int) livingEntity.getZ()});


                     */
                    /*
                    nbt.putFloat("Health", livingEntity.getHealth());
                    //System.out.println(nbt);
                    livingEntity.load(nbt);
                    //livingEntity.readAdditionalSaveData(nbt);
                    livingEntity.saveWithoutId(nbt);
                    //livingEntity.teleportTo(x, y, z);
                    livingEntity.invalidateCaps();

                     */

                    //nbt.putByte("NoAI", (byte) 1);
                    CompoundTag dat = livingEntity.getPersistentData();
                    Iterable<String> keys = dat.getAllKeys();
                    for (String k : keys){
                        if (k != "Health" && k != "Pos"){
                            dat.remove(k);
                        }
                    }
                }
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
