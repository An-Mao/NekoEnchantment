package anmao.mc.ne.enchantment.neko.item.nekoemperor;

import anmao.mc.ne.NE;
import anmao.mc.ne.am._AM_Constant;
import anmao.mc.ne.enchantment.N_E_S;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class NekoEmperorEvent {
    @Mod.EventBusSubscriber(modid = NE.MOD_ID)
    public static class NEE{
        @SubscribeEvent
        public static void onDeath(LivingDeathEvent livingDeathEvent){
            if (livingDeathEvent.getSource().getEntity() instanceof ServerPlayer serverPlayer) {
                Iterable<ItemStack> handlist = serverPlayer.getHandSlots();
                for (ItemStack itemStack : handlist) {
                    if (itemStack.getEnchantmentLevel(N_E_S.ni_emperor) > 0) {
                        if (itemStack.getTag() != null) {
                            itemStack.getTag().putInt(_AM_Constant.ENCHANTMENT_KEY_KILL, itemStack.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_KILL) + 1);
                        }
                    }
                }
            }
        }
    }
}
