package anmao.mc.ne.enchantment.zero.item.indestructible;

import anmao.mc.ne.NE;
import anmao.mc.ne.enchantment.N_E_S;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraftforge.event.entity.item.ItemExpireEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NE.MOD_ID)
public class indestructibleEvent {
    @SubscribeEvent
    public void onItemExpire(ItemExpireEvent event) {
        ItemEntity itemEntity = event.getEntity();
        if (itemEntity != null && itemEntity.getItem().getEnchantmentLevel(N_E_S.zi_indestructible) > 0) {
            event.setCanceled(true);
        }
    }
}
