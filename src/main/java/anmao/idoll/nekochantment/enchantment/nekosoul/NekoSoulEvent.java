package anmao.idoll.nekochantment.enchantment.nekosoul;

import anmao.idoll.nekochantment.NekoEnchantment;
import anmao.idoll.nekochantment.am._AM_Constant;
import anmao.idoll.nekochantment.enchantment.EnchantmentRegister;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class NekoSoulEvent {
    @Mod.EventBusSubscriber(modid = NekoEnchantment.MODID)
    public static class NSE{
        @SubscribeEvent
        public static void onAttack(LivingAttackEvent event){
            if(!event.getEntity().level().isClientSide){
                if (event.getSource().getEntity() instanceof ServerPlayer serverPlayer){
                    Iterable<ItemStack> slotlist = serverPlayer.getArmorSlots();
                    for (ItemStack slot : slotlist){
                        int lvl = slot.getEnchantmentLevel(EnchantmentRegister.NEKO_SOUL.get());
                        if (lvl > 0){
                            if (slot.getTag() != null) {
                                int soul = slot.getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_SOUL);
                                slot.getTag().putInt(_AM_Constant.ENCHANTMENT_KEY_SOUL, soul+1);
                            }
                        }
                    }
                }
            }
        }
    }
}
