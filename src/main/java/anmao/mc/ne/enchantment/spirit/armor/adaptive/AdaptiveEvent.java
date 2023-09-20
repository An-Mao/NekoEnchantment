package anmao.mc.ne.enchantment.spirit.armor.adaptive;

import anmao.mc.ne.NE;
import anmao.mc.ne.am._AM_Item;
import anmao.mc.ne.cap.cooldown.PCDPro;
import anmao.mc.ne.config.C_E_O;
import anmao.mc.ne.enchantment.N_E_S;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class AdaptiveEvent {
    private static final String INDEX_ITEM = "AdaptiveArmorCD";
    private static final String INDEX_TIME = "AdaptiveArmorTime";
    @Mod.EventBusSubscriber(modid = NE.MOD_ID)
    public static class AAE{
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if (event.getEntity() instanceof ServerPlayer serverPlayer){

                if (serverPlayer.getSlot(_AM_Item.CHEST_SLOT).get().getEnchantmentLevel(N_E_S.oa_adaptive) > 0 ){
                    serverPlayer.getCapability(PCDPro.P_I_CD).ifPresent(playerCD -> {
                        if (playerCD.isData(INDEX_TIME)) {
                            serverPlayer.heal(event.getAmount());
                            event.setCanceled(true);
                        }else if (!playerCD.isData(INDEX_ITEM)){
                            if (event.getSource().getEntity() instanceof ServerPlayer player && player.getUUID() == serverPlayer.getUUID()) {
                                event.setCanceled(true);
                            } else {
                                float a = serverPlayer.getHealth() * C_E_O.adaptive_armor_rr;
                                if (event.getAmount() > a) {
                                    event.setAmount(Math.max(a, C_E_O.adaptive_armor_min_damage));
                                }
                            }
                        }
                    });
                }
            }
        }
        @SubscribeEvent
        public static void onDeath(LivingDeathEvent event){
            if (event.getEntity() instanceof ServerPlayer player){
                if (player.getSlot(_AM_Item.CHEST_SLOT).get().getEnchantmentLevel(N_E_S.oa_adaptive) > 0) {
                    player.getCapability(PCDPro.P_I_CD).ifPresent(playerCD -> {
                        if (playerCD.isData(INDEX_TIME)){
                            event.setCanceled(true);
                        }else if (!playerCD.isData(INDEX_ITEM)){
                            playerCD.setData(INDEX_ITEM, C_E_O.adaptive_armor_cooldown);
                            playerCD.setData(INDEX_TIME, C_E_O.adaptive_armor_span);
                            player.clearFire();
                            player.removeAllEffects();
                            player.setHealth(1.0F);
                            event.setCanceled(true);
                        }
                    });
                }
            }
        }
    }
}
