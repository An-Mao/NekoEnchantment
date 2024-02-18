package anmao.mc.ne.effect.yanling;

import anmao.mc.ne.NE;
import anmao.mc.ne.effect.Effects;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class YanLingEvent {
    @Mod.EventBusSubscriber(modid = NE.MOD_ID)
    public static class YLE{
        @SubscribeEvent
        public static void onAttack(LivingAttackEvent event){
            if (event.getEntity().level().isClientSide){
                return;
            }
            if (event.getEntity().hasEffect(Effects.YAN_LING.get())){
                event.setCanceled(true);
            }
        }
    }
}
