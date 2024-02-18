package anmao.mc.ne.enchantment.zero.item.purify;

import anmao.mc.ne.am._AM;
import anmao.mc.ne.config.C_E_O;
import anmao.mc.ne.enchantment.zero.item.ZeroItemE;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Purify extends ZeroItemE {
    String[] SK={ "Health" ,"Pos"};
    public Purify() {
        super(Enchantment.Rarity.VERY_RARE);
    }
    @Override
    public void doPostAttack(@NotNull LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (pAttacker instanceof ServerPlayer){
            if (pTarget instanceof LivingEntity livingEntity){
                if (_AM.getRandomNumber(1,100) < C_E_O.ziPurifyP) {
                    //nbt.putByte("NoAI", (byte) 1);
                    CompoundTag dat = livingEntity.getPersistentData();
                    Iterable<String> keys = dat.getAllKeys();
                    for (String k : keys){
                        if (!Objects.equals(k, "Health") &&!Objects.equals(k, "Pos") ){
                            dat.remove(k);
                        }
                    }
                    livingEntity.invalidateCaps();
                    livingEntity.getTags().clear();
                }
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
