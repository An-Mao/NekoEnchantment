package anmao.mc.ne.enchant.phenomenon.theworld;

import anmao.mc.amlib.amlib.the$world.TheWorld;
import anmao.mc.amlib.entity.EntityHelper;
import anmao.mc.ne.NE;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.Enchants;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NE.MOD_ID)
public class TheWorldEvent {
    @SubscribeEvent
    public static void onAttack(LivingAttackEvent event){
        if (TheWorldEnchant.ENABLE) {
            Entity entity = event.getEntity();
            Entity sEntity = event.getSource().getEntity();
            if (entity == null || sEntity == null) {
                return;
            }
            if (entity instanceof ServerPlayer player && !(sEntity instanceof ServerPlayer)) {

                if (EnchantHelper.getEnchantLevel(Enchants.the_world, player) > 0) {
                    setTheWorldTime(sEntity);
                }
            } else if (sEntity instanceof ServerPlayer serverPlayer) {
                if (EnchantHelper.hasEnchant(serverPlayer.getMainHandItem(), Enchants.the_world)) {
                    setTheWorldTime(entity);
                }
            }
        }
    }
    public static void setTheWorldTime(Entity e){
        TheWorld.SetTheWorldState(e,true);
        TheWorld.SetTheWorldTime(e, EntityHelper.getLevelTime(e));
    }
}
