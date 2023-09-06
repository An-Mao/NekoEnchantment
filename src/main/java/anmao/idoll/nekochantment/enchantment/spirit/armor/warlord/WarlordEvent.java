package anmao.idoll.nekochantment.enchantment.spirit.armor.warlord;

import anmao.idoll.nekochantment.NekoEnchantment;
import anmao.idoll.nekochantment.am._AM_Item;
import anmao.idoll.nekochantment.cap.cooldown.PCDPro;
import anmao.idoll.nekochantment.enchantment.NE;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class WarlordEvent {

    private static final String KEY_CD = "WarlordArmorCD";
    @Mod.EventBusSubscriber(modid = NekoEnchantment.MODID)
    public static class WE {
        @SubscribeEvent
        public static void onDeath(LivingDeathEvent event){
            if (event.getEntity() instanceof ServerPlayer serverPlayer){
                ItemStack item =  serverPlayer.getSlot(_AM_Item.CHEST_SLOT).get();
                if (item.getEnchantmentLevel(NE.oa_warlord) > 0) {
                    serverPlayer.getCapability(PCDPro.P_I_CD).ifPresent(playerCD -> {
                        if (!playerCD.isData(KEY_CD)){
                            System.out.println("health:"+serverPlayer.getHealth());
                            if (serverPlayer.getHealth() == serverPlayer.getMaxHealth()) {
                                playerCD.setData(KEY_CD,2000);
                                serverPlayer.setHealth(3.0f);
                                event.setCanceled(true);
                            }
                        }
                    });
                }
            }
        }
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if (event.getSource().getEntity() instanceof ServerPlayer serverPlayer){
                ItemStack item =  serverPlayer.getSlot(_AM_Item.CHEST_SLOT).get();
                if (item.getEnchantmentLevel(NE.oa_warlord) > 0){
                    float sp = 2.0F  - serverPlayer.getHealth() / serverPlayer.getMaxHealth();
                    event.setAmount(event.getAmount() * Math.min(sp,1.75f));
                }
            }
            if (event.getEntity() instanceof ServerPlayer Player) {
                ItemStack oitem =  Player.getSlot(_AM_Item.CHEST_SLOT).get();
                if (oitem.getEnchantmentLevel(NE.oa_warlord) > 0){
                    event.setAmount(event.getAmount() * 1.3F);
                }
            }
        }
    }
}
