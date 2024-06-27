package anmao.mc.ne.enchant.zero.item.indestructible;

import anmao.mc.ne.NE;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.Enchants;
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
            if (itemEntity != null && EnchantHelper.hasEnchant(itemEntity.getItem(), Enchants.zi_indestructible)) {
                event.setCanceled(true);
            }
        }
    }
}
