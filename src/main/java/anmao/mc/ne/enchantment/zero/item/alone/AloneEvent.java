package anmao.mc.ne.enchantment.zero.item.alone;

import anmao.mc.ne.NE;
import anmao.mc.ne.am._AM_Constant;
import anmao.mc.ne.enchantment.N_E_S;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NE.MOD_ID)
public class AloneEvent {
    @SubscribeEvent
    public static void onAttack(LivingHurtEvent event){
        if (event.getSource().getEntity() instanceof ServerPlayer serverPlayer){
            ItemStack item = serverPlayer.getMainHandItem();
            if (item.getEnchantmentLevel(N_E_S.zi_alone) >0 && item.getAllEnchantments().size() == 1){
                int amount = 0;
                if (item.getTag() != null) {
                    amount = item.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_ALONE);
                }
                item.getTag().putInt(_AM_Constant.ENCHANTMENT_KEY_ALONE,amount+1);
            }
        }
    }
}
