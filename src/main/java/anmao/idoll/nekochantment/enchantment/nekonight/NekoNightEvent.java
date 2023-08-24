package anmao.idoll.nekochantment.enchantment.nekonight;

import anmao.idoll.nekochantment.NekoEnchantment;
import anmao.idoll.nekochantment.enchantment.EnchantmentRegister;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class NekoNightEvent {
    @Mod.EventBusSubscriber(modid = NekoEnchantment.MODID)
    public static class NNE{
        @SubscribeEvent
        public static void onAttack(LivingHurtEvent event){
            if (!event.getEntity().level().isClientSide){
                if (event.getSource().getEntity() != null && event.getSource().getEntity() instanceof LivingEntity livingEntity){
                    int lvl = livingEntity.getMainHandItem().getEnchantmentLevel(EnchantmentRegister.NEKO_NIGHT.get());
                    int daytime = (int) livingEntity.level().getDayTime();
                    float damage = 1 + lvl * 0.5F;
                    if (daytime < 7200 || daytime > 22800){
                        event.setAmount(event.getAmount() + damage);
                    }else {
                        event.setAmount(event.getAmount() - damage);
                    }
                }
            }
        }
    }
}
