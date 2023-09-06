package anmao.idoll.nekochantment.enchantment.neko.item.nekoemperor;

import anmao.idoll.nekochantment.NekoEnchantment;
import anmao.idoll.nekochantment.am._AM_Constant;
import anmao.idoll.nekochantment.enchantment.NE;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class NekoEmperorEvent {
    @Mod.EventBusSubscriber(modid = NekoEnchantment.MODID)
    public static class NEE{
        @SubscribeEvent
        public static void onDeath(LivingDeathEvent livingDeathEvent){
            if (livingDeathEvent.getSource().getEntity() instanceof ServerPlayer serverPlayer) {
                Iterable<ItemStack> handlist = serverPlayer.getHandSlots();
                for (ItemStack itemStack : handlist) {
                    if (itemStack.getEnchantmentLevel(NE.ni_emperor) > 0) {
                        if (itemStack.getTag() != null) {
                            itemStack.getTag().putInt(_AM_Constant.ENCHANTMENT_KEY_KILL, itemStack.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_KILL) + 1);
                        }
                    }
                }
            }
        }
    }
}
