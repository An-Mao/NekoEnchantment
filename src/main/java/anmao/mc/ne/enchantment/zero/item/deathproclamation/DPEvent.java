package anmao.mc.ne.enchantment.zero.item.deathproclamation;

import anmao.mc.ne.NE;
import anmao.mc.ne.am._AM_Color;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = NE.MOD_ID)
public class DPEvent {
    private static final String DEAD_TIP = "cn.ne.death_pro";
    @SubscribeEvent
    public static void onTick(LivingEvent.LivingTickEvent event){
        if (event != null && event.getEntity() instanceof Mob mob){
            int deathTime = mob.deathTime;
            if (deathTime == -1){
                if (mob.getLastDamageSource() == null) {
                    mob.die(mob.damageSources().fellOutOfWorld());
                }else {
                    mob.die(mob.getLastDamageSource());
                }
                event.getEntity().remove(Entity.RemovalReason.KILLED);
            }else if (deathTime < -1){
                //System.out.println(mob.deathTime);
                mob.deathTime ++;
                MutableComponent str = Component.translatable(DEAD_TIP).append(String.valueOf(mob.deathTime));
                mob.setCustomName(_AM_Color.RainbowTextColor(str.getString(),mob.level().getDayTime()));
            }
        }
    }
    @SubscribeEvent
    public static void onDead(LivingDeathEvent event){
        if (event.getEntity() instanceof Mob mob) {
            if (mob.deathTime < 0) {
                mob.setHealth(mob.getMaxHealth());
                event.setCanceled(true);
            }
        }
    }
}
