package anmao.mc.ne.enchantment.spirit.sword.cross;

import anmao.mc.amlib.attribute.AttributeHelper;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.spirit.sword.SSE;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.item.enchantment.Enchantment;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;

public class Cross extends SSE {
    private final float multiplier = EnchantmentsConfig.INSTANCE.getValue(EnchantmentRegister.E_CROSS,"multiplier");
    public Cross() {
        super(Enchantment.Rarity.VERY_RARE);
    }

    @Override
    public void doPostAttack(LivingEntity pAttacker, @NotNull Entity pTarget, int pLevel) {
        if (!pAttacker.level().isClientSide  && pAttacker instanceof ServerPlayer serverPlayer){
            if (pTarget instanceof Bat){
                Collection<AttributeModifier> attack =
                        serverPlayer.getMainHandItem().getAttributeModifiers(EquipmentSlot.MAINHAND).get(Attributes.ATTACK_DAMAGE);
                if (!attack.isEmpty()){
                    double damage = AttributeHelper.getAttributeModifierValue(attack) * multiplier;
                    pTarget.hurt(pAttacker.damageSources().fellOutOfWorld(), (float) damage);
                }
            }
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }
}
