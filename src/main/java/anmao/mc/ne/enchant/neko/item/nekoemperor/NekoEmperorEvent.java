package anmao.mc.ne.enchant.neko.item.nekoemperor;

import anmao.mc.ne.NE;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.Enchants;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

public class NekoEmperorEvent {
    @Mod.EventBusSubscriber(modid = NE.MOD_ID)
    public static class NEE{
        @SubscribeEvent
        public static void onDeath(LivingDeathEvent livingDeathEvent){
            if (NekoEmperor.ENABLE && livingDeathEvent.getSource().getEntity() instanceof ServerPlayer serverPlayer) {
                Iterable<ItemStack> handlist = serverPlayer.getHandSlots();
                for (ItemStack itemStack : handlist) {
                    if (EnchantHelper.hasEnchant(itemStack, Enchants.ni_emperor)) {
                        CompoundTag nbt = EnchantHelper.getEnchantData(itemStack).getTagCopy();
                        CompoundTag killData = nbt.getCompound("emperor.data");
                        int kill = killData.getInt(NekoEmperor.ENCHANTMENT_KEY_KILL);
                        killData.putInt(NekoEmperor.ENCHANTMENT_KEY_KILL, kill + 1);
                        nbt.put("emperor.data", killData);
                        EnchantHelper.setEnchantData(itemStack, nbt);
                    }
                }
            }
        }
    }
}
