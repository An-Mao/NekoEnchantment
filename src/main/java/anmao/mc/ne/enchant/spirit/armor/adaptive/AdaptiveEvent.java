package anmao.mc.ne.enchant.spirit.armor.adaptive;

import anmao.mc.amlib.entity.player.PlayerInvasionSlotCDT;
import anmao.mc.ne.NE;
import anmao.mc.ne.cap.cooldown.PCDPro;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.core.Enchants;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class AdaptiveEvent {
    private static final float damageLimit = EnchantmentsConfig.INSTANCE.getValue(EnchantReg.E_ADAPTIVE,"damageLimit");
    private static final float minDamage = EnchantmentsConfig.INSTANCE.getValue(EnchantReg.E_ADAPTIVE,"minDamage");
    private static final int span = (int) EnchantmentsConfig.INSTANCE.getValue(EnchantReg.E_ADAPTIVE,"span");
    private static final int cooldown = (int)  EnchantmentsConfig.INSTANCE.getValue(EnchantReg.E_ADAPTIVE,"cooldown");
    private static final String INDEX_ITEM = "AdaptiveArmorCD";
    private static final String INDEX_TIME = "AdaptiveArmorTime";
    @Mod.EventBusSubscriber(modid = NE.MOD_ID)
    public static class AAE{
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if (Adaptive.ENABLE && event.getEntity() instanceof ServerPlayer serverPlayer){

                if (EnchantHelper.hasEnchant(serverPlayer.getSlot(PlayerInvasionSlotCDT.CHEST_SLOT).get(), Enchants.oa_adaptive)){
                    serverPlayer.getCapability(PCDPro.P_I_CD).ifPresent(playerCD -> {
                        if (playerCD.isData(INDEX_TIME)) {
                            serverPlayer.heal(event.getAmount());
                            event.setCanceled(true);
                        }else if (!playerCD.isData(INDEX_ITEM)){
                            if (event.getSource().getEntity() instanceof ServerPlayer player && player.getUUID() == serverPlayer.getUUID()) {
                                event.setCanceled(true);
                            } else {
                                float a = serverPlayer.getHealth() * damageLimit;
                                if (event.getAmount() > a) {
                                    event.setAmount(Math.max(a, minDamage));
                                }
                            }
                        }
                    });
                }
            }
        }
        @SubscribeEvent
        public static void onDeath(LivingDeathEvent event){
            if (Adaptive.ENABLE && event.getEntity() instanceof ServerPlayer player){
                if (EnchantHelper.hasEnchant(player.getSlot(PlayerInvasionSlotCDT.CHEST_SLOT).get(), Enchants.oa_adaptive)) {
                    player.getCapability(PCDPro.P_I_CD).ifPresent(playerCD -> {
                        if (playerCD.isData(INDEX_TIME)){
                            event.setCanceled(true);
                        }else if (!playerCD.isData(INDEX_ITEM)){
                            playerCD.setData(INDEX_ITEM, cooldown);
                            playerCD.setData(INDEX_TIME, span);
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
