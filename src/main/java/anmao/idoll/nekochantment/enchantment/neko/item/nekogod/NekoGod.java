package anmao.idoll.nekochantment.enchantment.neko.item.nekogod;

import anmao.idoll.nekochantment.am._AM;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class NekoGod extends Enchantment {
    public NekoGod(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide){
            if (pAttacker instanceof ServerPlayer serverPlayer && pTarget instanceof Mob mob){
                int p = pLevel;
                //0-100
                p += _AM.getLuckP(serverPlayer.getLuck());
                if (p > _AM.getRandomNumber(1,100)){
                    //32767
                    p = (serverPlayer.experienceLevel/999) * 10;
                    mob.setHealth(Math.max(0.0F,mob.getHealth() - mob.getMaxHealth() * p ));
                }
            }
        }
    }

    @Override
    public int getMaxLevel() {
        return 2;
    }
    @Override
    public boolean isTreasureOnly() {
        return true;
    }
}
