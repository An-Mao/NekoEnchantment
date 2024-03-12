package anmao.mc.ne.enchantment.zero.item.alone;

import anmao.mc.ne.NE;
import anmao.mc.ne.am._AM_Constant;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.NekoEnchantments;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NE.MOD_ID)
public class AloneEvent {
    @SubscribeEvent
    public static void onAttack(LivingHurtEvent event){
        if (Alone.ENABLE && event.getSource().getEntity() instanceof ServerPlayer serverPlayer){
            ItemStack item = serverPlayer.getMainHandItem();
            if (item.getEnchantmentLevel(NekoEnchantments.zi_alone) >0 && item.getAllEnchantments().size() == 1){
                int amount = 0;
                if (item.getTag() != null) {
                    amount = item.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_ALONE);
                }
                item.getTag().putInt(_AM_Constant.ENCHANTMENT_KEY_ALONE,amount+1);
            }
        }
    }
}
