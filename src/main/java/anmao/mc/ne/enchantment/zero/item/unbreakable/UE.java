package anmao.mc.ne.enchantment.zero.item.unbreakable;

import anmao.mc.ne.NE;
import anmao.mc.ne.am._AM_Constant;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.enchantment.NekoEnchantments;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NE.MOD_ID)
public class UE {
    @SubscribeEvent
    public static void onAnvil(AnvilUpdateEvent anvilUpdateEvent) {
        if (Unbreakable.ENABLE && !anvilUpdateEvent.getPlayer().level().isClientSide && anvilUpdateEvent.getLeft().getEnchantmentLevel(NekoEnchantments.zi_unbreakable) > 0 ){
            if (anvilUpdateEvent.getLeft().getTag() != null && anvilUpdateEvent.getLeft().getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_UNBREAKABLE) >= 5){
                return;
            }
            Item ritem = anvilUpdateEvent.getRight().getItem();
            if (ritem == Items.NETHERITE_BLOCK){
                ItemStack oitem = anvilUpdateEvent.getLeft().copy();
                CompoundTag oitemnbt = oitem.getTag();
                if (oitemnbt != null) {
                    int unb = anvilUpdateEvent.getLeft().getTag().getInt(_AM_Constant.ENCHANTMENT_KEY_UNBREAKABLE) + 1;
                    oitemnbt.putInt(_AM_Constant.ENCHANTMENT_KEY_UNBREAKABLE,unb);
                    if (unb == 5){
                        oitemnbt.putBoolean("Unbreakable", true);
                    }
                }
                oitem.setTag(oitemnbt);
                anvilUpdateEvent.setOutput(oitem);
                anvilUpdateEvent.setCost(13);
                anvilUpdateEvent.setMaterialCost(1);
            }
        }
    }
}
