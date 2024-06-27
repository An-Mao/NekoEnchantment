package anmao.mc.ne.enchant.neko.armor.nekosoul;

import anmao.mc.ne.NE;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.Enchants;
import net.minecraft.nbt.CompoundTag;
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
                        if (EnchantHelper.hasEnchant(slot, Enchants.na_soul)) {
                            CompoundTag nbt = EnchantHelper.getEnchantData(slot).getTagCopy();
                            CompoundTag soulData = nbt.getCompound("soul.data");
                            int soul = soulData.getInt(NekoSoul.ENCHANTMENT_KEY_SOUL);
                            soulData.putInt(NekoSoul.ENCHANTMENT_KEY_SOUL, soul + 1);
                            nbt.put("soul.data", soulData);
                            EnchantHelper.setEnchantData(slot, nbt);
                        }
                    }
                }
            }
        }
    }
}
