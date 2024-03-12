package anmao.mc.ne.enchantment.neko.armor.nekosoul;

import anmao.mc.ne.NE;
import anmao.mc.ne.am._AM_Constant;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.NekoEnchantments;
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
            if(NekoSoul.ENABLE && !event.getEntity().level().isClientSide){
                if (event.getSource().getEntity() instanceof ServerPlayer serverPlayer){
                    Iterable<ItemStack> slotlist = serverPlayer.getArmorSlots();
                    for (ItemStack slot : slotlist){
                        int lvl = slot.getEnchantmentLevel(NekoEnchantments.na_soul);
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
