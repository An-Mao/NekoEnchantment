package anmao.mc.ne.enchantment.spirit.armor.stance;

import anmao.mc.ne.NE;
import anmao.mc.ne.am._AM_Item;
import anmao.mc.ne.enchantment.N_E_S;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class StanceEvent {
    @Mod.EventBusSubscriber(modid = NE.MOD_ID)
    public static class SE{
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if (event.getEntity() instanceof ServerPlayer serverPlayer){
                ItemStack item =  serverPlayer.getSlot(_AM_Item.CHEST_SLOT).get();
                if (item.getEnchantmentLevel(N_E_S.oa_stance) > 0){
                    if (event.getSource().getEntity() != null) {
                        double dis = serverPlayer.getEyePosition().distanceTo(event.getSource().getEntity().getEyePosition());
                        if (dis > getPlayerAtkRange(serverPlayer)){
                            event.setAmount(event.getAmount() * 0.8F);
                        }else {
                            event.setAmount(event.getAmount() * 1.7F);
                        }
                    }
                }
            }
        }
        public static double getPlayerAtkRange(ServerPlayer serverPlayer){
            Attribute atkAtt = ForgeMod.ENTITY_REACH.get();
            double atkRange = serverPlayer.getAttributeBaseValue(atkAtt);
            atkRange += serverPlayer.getAttributeValue(atkAtt);

            return atkRange;
        }
    }
}
