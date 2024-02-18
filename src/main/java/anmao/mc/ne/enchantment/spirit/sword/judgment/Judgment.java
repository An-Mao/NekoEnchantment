package anmao.mc.ne.enchantment.spirit.sword.judgment;

import anmao.mc.ne.am._AM_Item;
import anmao.mc.ne.enchantment.spirit.sword.SSE;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class Judgment extends SSE {

    public Judgment() {
        super(Enchantment.Rarity.VERY_RARE);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide && pTarget instanceof Mob mob){
            Collection<AttributeModifier> attack =
                    pAttacker.getMainHandItem().getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE);

            if (!attack.isEmpty()) {
                double damage = _AM_Item.getAddDamage(attack);
                if (mob.getHealth() <= damage * 2) {
                    mob.kill();
                }
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
