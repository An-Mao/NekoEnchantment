package anmao.mc.ne.enchantment.neko.armor.nekolife;

import anmao.mc.ne.NE;
import anmao.mc.ne.am._AM;
import anmao.mc.ne.enchantment.N_E_S;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class NekoLifeEvent {
    @Mod.EventBusSubscriber(modid = NE.MOD_ID)
    public static class NLE {
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if ( event.getEntity() instanceof ServerPlayer player && !player.level().isClientSide){
                Iterable<ItemStack> slotlist = player.getArmorSlots();
                for (ItemStack slot : slotlist){
                    int lvl = slot.getEnchantmentLevel(N_E_S.na_life);
                    if (lvl > 0){
                        if (lvl * 15 > _AM.getRandomNumber(1,100)){
                            double min_damage = player.getMaxHealth() * 0.2;
                            if (event.getAmount() > min_damage && event.getAmount() < player.getMaxHealth() * 1.5 ){
                                event.setAmount((float) (min_damage));
                            }
                        }

                    }
                }
            }
        }
    }
}
