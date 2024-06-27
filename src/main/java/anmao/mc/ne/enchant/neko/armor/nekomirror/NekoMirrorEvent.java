package anmao.mc.ne.enchant.neko.armor.nekomirror;

import anmao.mc.amlib.math._Random;
import anmao.mc.ne.NE;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.Enchants;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class NekoMirrorEvent {
    @Mod.EventBusSubscriber(modid = NE.MOD_ID)
    public static class NME{
        @SubscribeEvent
        public static void onHurt(LivingHurtEvent event){
            if(NekoMirror.ENABLE && !event.getEntity().level().isClientSide){
                if (event.getEntity() instanceof ServerPlayer serverPlayer){
                    Iterable<ItemStack> slotlist = serverPlayer.getArmorSlots();
                    for (ItemStack slot : slotlist){
                        int lvl = EnchantHelper.getEnchantLevel(slot, Enchants.na_mirror);
                        if (lvl > 0){
                            if (lvl * 2 > _Random.getIntRandomNumber(1,100)){
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
