package anmao.idoll.nekochantment.enchantment.spirit.sword.angel;

import anmao.idoll.nekochantment.am._AM_Item;
import anmao.idoll.nekochantment.enchantment.spirit.sword.SSE;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.enchantment.Enchantment;

import java.util.Collection;

public class Angel extends SSE {

    public Angel() {
        super(Enchantment.Rarity.VERY_RARE);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide && pAttacker instanceof ServerPlayer serverPlayer){
            Collection<AttributeModifier> attack =
                    serverPlayer.getMainHandItem().getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE);
            if (!attack.isEmpty()) {
                double damage = _AM_Item.getAdddamage(attack);
                if (pTarget instanceof Monster){
                    damage *= 1.5;
                }
                pTarget.hurt(pTarget.damageSources().magic(),(float) damage);
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
