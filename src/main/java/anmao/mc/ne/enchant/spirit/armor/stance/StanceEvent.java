package anmao.mc.ne.enchant.spirit.armor.stance;

import anmao.mc.amlib.entity.player.PlayerInvasionSlotCDT;
import anmao.mc.ne.NE;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.Enchants;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class StanceEvent {
    @Mod.EventBusSubscriber(modid = NE.MOD_ID)
    public static class SE{
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if (Stance.ENABLE && event.getEntity() instanceof ServerPlayer serverPlayer){
                ItemStack item =  serverPlayer.getSlot(PlayerInvasionSlotCDT.CHEST_SLOT).get();
                if (EnchantHelper.hasEnchant(item, Enchants.oa_stance)){
                    if (event.getSource().getEntity() != null) {
                        double dis = serverPlayer.getEyePosition().distanceTo(event.getSource().getEntity().getEyePosition());
                        if (dis > 3){
                            event.setAmount(event.getAmount() * 0.8F);
                        }else {
                            event.setAmount(event.getAmount() * 1.7F);
                        }
                    }
                }
            }
        }
        /*
        public static double getPlayerAtkRange(ServerPlayer serverPlayer){
            Attribute atkAtt = ForgeMod.ENTITY_REACH.get();
            double atkRange = serverPlayer.getAttributeBaseValue(Attributes.RE);
            atkRange += serverPlayer.getAttributeValue(atkAtt);

            return atkRange;
        }

         */
    }
}
