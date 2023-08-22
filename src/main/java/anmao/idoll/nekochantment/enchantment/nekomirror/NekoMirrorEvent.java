package anmao.idoll.nekochantment.enchantment.nekomirror;

import anmao.idoll.nekochantment.NekoEnchantment;
import anmao.idoll.nekochantment.am._AM;
import anmao.idoll.nekochantment.enchantment.EnchantmentRegister;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class NekoMirrorEvent {
    @Mod.EventBusSubscriber(modid = NekoEnchantment.MODID)
    public static class NME{
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if(!event.getEntity().level().isClientSide){
                if (event.getEntity() instanceof ServerPlayer serverPlayer){
                    Iterable<ItemStack> slotlist = serverPlayer.getArmorSlots();
                    for (ItemStack slot : slotlist){
                        int lvl = slot.getEnchantmentLevel(EnchantmentRegister.NEKO_MIRROR.get());
                        if (lvl > 0){
                            if (lvl * 2 > _AM.getRandomNumber(1,100)){
                                if (event.getSource().getEntity() instanceof LivingEntity livingEntity){
                                    livingEntity.hurt(event.getSource(),event.getAmount());
                                    event.setCanceled(true);
                                    break;
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}
