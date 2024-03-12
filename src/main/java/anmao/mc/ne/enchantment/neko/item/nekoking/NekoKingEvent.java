package anmao.mc.ne.enchantment.neko.item.nekoking;


import anmao.mc.ne.NE;
import anmao.mc.ne.enchantment.NekoEnchantments;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class NekoKingEvent {
    @Mod.EventBusSubscriber(modid = NE.MOD_ID)
    public static class ForgeEvent {
        @SubscribeEvent
        public static void onAnvil(AnvilUpdateEvent anvilUpdateEvent) {
            if (NekoKing.ENABLE && !anvilUpdateEvent.getPlayer().level().isClientSide && anvilUpdateEvent.getLeft().getEnchantmentLevel(NekoEnchantments.ni_king) > 0){
                //int sn = anvilUpdateEvent.getRight().getCount();
                //if (anvilUpdateEvent.getPlayer().experienceProgress < sn * 100){return;}
                Item ritem = anvilUpdateEvent.getRight().getItem();
                int re = 0;
                if (ritem == Items.IRON_INGOT){
                    re = 1;
                } else if (ritem == Items.DIAMOND) {
                    re = 5;
                } else if (ritem == Items.NETHERITE_INGOT) {
                    re = 20;
                }
                if (re > 0){
                    ItemStack oitem = anvilUpdateEvent.getLeft().copy();
                    CompoundTag oitemnbt = oitem.getTag();
                    if (oitemnbt != null) {
                        oitemnbt.putInt(NekoKing.ENCHANTMENT_KEY_REFINE,oitemnbt.getInt(NekoKing.ENCHANTMENT_KEY_REFINE) + re);
                    }
                    oitem.setTag(oitemnbt);
                    anvilUpdateEvent.setOutput(oitem);
                    anvilUpdateEvent.setCost(7 * re);
                    anvilUpdateEvent.setMaterialCost(1);
                }
            }
        }
    }
}
