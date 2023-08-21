package anmao.idoll.nekochantment.enchantment.nekoemperor;

import anmao.idoll.nekochantment.NekoEnchantment;
import anmao.idoll.nekochantment.enchantment.EnchantmentRegister;
import com.google.common.eventbus.Subscribe;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class NekoEmperorEvent {
    @Mod.EventBusSubscriber(modid = NekoEnchantment.MODID)
    public static class NEE{
        @SubscribeEvent
        public static void onDeath(LivingDeathEvent livingDeathEvent){
            Iterable<ItemStack> handlist = livingDeathEvent.getSource().getEntity().getHandSlots();
            for (ItemStack itemStack : handlist){
                if (itemStack.getEnchantmentLevel(EnchantmentRegister.NEKO_EMPEROR.get()) >0){
                    if (itemStack.getTag() != null) {
                        itemStack.getTag().putInt("kills",itemStack.getTag().getInt("kills")+1);
                    }
                }
            }
        }
    }
}
