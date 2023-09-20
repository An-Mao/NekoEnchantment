package anmao.mc.ne.enchantment.neko.item.nekoday;

import anmao.mc.ne.NE;
import anmao.mc.ne.enchantment.N_E_S;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class NekoDayEvent {
    @Mod.EventBusSubscriber(modid = NE.MOD_ID)
    public static class NDE{
        @SubscribeEvent
        public static void onAttack(LivingHurtEvent event){
            if (!event.getEntity().level().isClientSide){
                if (event.getSource().getEntity() != null && event.getSource().getEntity() instanceof LivingEntity livingEntity){
                    int lvl = livingEntity.getMainHandItem().getEnchantmentLevel(N_E_S.ni_day);
                    int daytime = (int) livingEntity.level().getDayTime();
                    float damage = 1 + lvl * 0.5F;
                    if (daytime < 7200 || daytime > 22800){
                        event.setAmount(event.getAmount() - damage);
                    }else {
                        event.setAmount(event.getAmount() + damage);
                    }
                }
            }
        }
    }
}
