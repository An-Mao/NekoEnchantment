package anmao.mc.ne.enchant.spirit.armor.natural;

import anmao.mc.amlib.entity.player.PlayerInvasionSlotCDT;
import anmao.mc.ne.NE;
import anmao.mc.ne.cap.cooldown.PCDPro;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.Enchants;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.living.LivingEquipmentChangeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class NaturalEvent {
    private static final String KEY_CD = "NaturalArmorCD";
    @Mod.EventBusSubscriber(modid = NE.MOD_ID,bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static   class  NAE{
        @SubscribeEvent
        public static void onEquipmentChange (LivingEquipmentChangeEvent event){
            if (Natural.ENABLE && event.getEntity() instanceof ServerPlayer serverPlayer){
                if (event.getSlot() == EquipmentSlot.CHEST){
                    ItemStack item = event.getFrom();
                    if (EnchantHelper.hasEnchant(item, Enchants.oa_natural)) {
                        serverPlayer.getAttribute(Attributes.MAX_HEALTH)
                                .setBaseValue(serverPlayer.getMaxHealth() - 10);
                    }
                    item = event.getTo();
                    if (EnchantHelper.hasEnchant(item, Enchants.oa_natural)) {
                        serverPlayer.getAttribute(Attributes.MAX_HEALTH)
                                .setBaseValue(serverPlayer.getMaxHealth() + 10);
                    }
                    if (serverPlayer.getHealth() > serverPlayer.getMaxHealth()) {
                        serverPlayer.setHealth(serverPlayer.getMaxHealth());
                    }
                }
            }
        }
        @SubscribeEvent
        public static void onServerTick (TickEvent.PlayerTickEvent event){
            if (Natural.ENABLE && event.player instanceof ServerPlayer serverPlayer){
                if (event.phase == TickEvent.Phase.END) {
                    if (EnchantHelper.hasEnchant(serverPlayer.getSlot(PlayerInvasionSlotCDT.CHEST_SLOT).get(), Enchants.oa_natural)) {
                        serverPlayer.getCapability(PCDPro.P_I_CD).ifPresent(playerCD -> {
                            if (!playerCD.isData(KEY_CD)){
                                playerCD.setData(KEY_CD,60);
                                serverPlayer.heal(serverPlayer.getMaxHealth() * 0.1f);
                            }
                        });
                    }
                }
            }
        }
    }
}
