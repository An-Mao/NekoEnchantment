package anmao.mc.ne.enchantment.neko.armor.nekosoul;

import anmao.mc.ne.NE;
import anmao.mc.ne.am._AM_Constant;
import anmao.mc.ne.enchantment.N_E_S;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class NekoSoulEvent {
    @Mod.EventBusSubscriber(modid = NE.MOD_ID)
    public static class NSE{
        @SubscribeEvent
        public static void onAttack(LivingAttackEvent event){
            if(!event.getEntity().level().isClientSide){
                if (event.getSource().getEntity() instanceof ServerPlayer serverPlayer){
                    Iterable<ItemStack> slotlist = serverPlayer.getArmorSlots();
                    for (ItemStack slot : slotlist){
                        int lvl = slot.getEnchantmentLevel(N_E_S.na_soul);
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
