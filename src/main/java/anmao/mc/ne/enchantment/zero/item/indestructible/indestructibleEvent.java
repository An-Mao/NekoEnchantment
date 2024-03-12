package anmao.mc.ne.enchantment.zero.item.indestructible;

import anmao.mc.ne.NE;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.NekoEnchantments;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NE.MOD_ID)
public class indestructibleEvent {
    @SubscribeEvent
    public static void onItemExpire(ItemExpireEvent event) {
        if (Indestructible.ENABLE) {
            ItemEntity itemEntity = event.getEntity();
            if (itemEntity != null && itemEntity.getItem().getEnchantmentLevel(NekoEnchantments.zi_indestructible) > 0) {
                event.setCanceled(true);
            }
        }
    }
}
