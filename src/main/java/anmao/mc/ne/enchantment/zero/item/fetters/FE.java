package anmao.mc.ne.enchantment.zero.item.fetters;

import anmao.mc.ne.NE;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.LivingEntity;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NE.MOD_ID)
public class FE {
    @SubscribeEvent
    public static void onTick(LivingEvent.LivingTickEvent event){
        LivingEntity le = event.getEntity();
        CompoundTag dat = le.getPersistentData();
        long gt = le.level().getGameTime();
        if (gt - dat.getLong("Fetters") < 1200){
            le.teleportTo(dat.getDouble("Fx"),dat.getDouble("Fy"),dat.getDouble("Fz"));
        }
    }
}
