package anmao.mc.ne.enchantment.spirit.sword.judgment;

import anmao.mc.amlib.attribute.AttributeHelper;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
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
    private final float quota = EnchantmentsConfig.INSTANCE.getValue(EnchantmentRegister.E_JUDGMENT,"quota");
    public Judgment() {
        super(Enchantment.Rarity.VERY_RARE);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide && pTarget instanceof Mob mob){
            Collection<AttributeModifier> attack =
                    pAttacker.getMainHandItem().getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE);

            if (!attack.isEmpty()) {
                double damage = AttributeHelper.getAttributeModifierValue(attack);
                if (mob.getHealth() <= damage * quota) {
                    mob.kill();
                }
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
