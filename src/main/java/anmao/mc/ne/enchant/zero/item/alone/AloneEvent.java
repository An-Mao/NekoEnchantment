package anmao.mc.ne.enchant.zero.item.alone;

import anmao.mc.ne.NE;
import anmao.mc.ne.core.EnchantData;
import anmao.mc.ne.core.EnchantDataReg;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.Enchants;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NE.MOD_ID)
public class AloneEvent {
    @SubscribeEvent
    public static void onAttack(LivingHurtEvent event){
        if (Alone.ENABLE && event.getSource().getEntity() instanceof ServerPlayer serverPlayer){
            ItemStack item = serverPlayer.getMainHandItem();
            if (EnchantHelper.hasEnchant(item, Enchants.zi_alone) && EnchantHelper.getEnchantCompound(item).size() == 1){
                int amount = 0;
                EnchantData enchantData = EnchantHelper.getEnchantData(item);
                CompoundTag nbt = EnchantHelper.getAllData(enchantData);
                CompoundTag aloneData = nbt.getCompound("alone.data");
                amount = aloneData.getInt(Alone.ENCHANTMENT_KEY_ALONE);
                aloneData.putInt(Alone.ENCHANTMENT_KEY_ALONE,amount+1);
                nbt.put("alone.data",aloneData);
                enchantData = new EnchantData(nbt);
                item.set(EnchantDataReg.Enchant_Data.get(),enchantData);
            }
        }
    }
}
