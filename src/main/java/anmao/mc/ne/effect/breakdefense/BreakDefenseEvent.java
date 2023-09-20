package anmao.mc.ne.effect.breakdefense;

import anmao.mc.ne.NE;
import anmao.mc.ne.effect.Effects;
import net.minecraftforge.event.entity.living.LivingDamageEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class BreakDefenseEvent {
    @Mod.EventBusSubscriber(modid = NE.MOD_ID)
    public static class BDE{
        @SubscribeEvent
        public static void onDamage(LivingDamageEvent event){
            if (event.getEntity().level().isClientSide){
                return;
            }
            if (event.getEntity().hasEffect(Effects.BREAK_DEFENSE.get())){
                event.setAmount(event.getAmount()*2);
            }
        }
    }
}
