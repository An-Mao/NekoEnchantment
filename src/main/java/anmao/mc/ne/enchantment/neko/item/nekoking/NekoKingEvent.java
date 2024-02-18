package anmao.mc.ne.enchantment.neko.item.nekoking;


import anmao.mc.ne.NE;
import anmao.mc.ne.am._AM_Constant;
import anmao.mc.ne.enchantment.N_E_S;
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
            if (!anvilUpdateEvent.getPlayer().level().isClientSide && anvilUpdateEvent.getLeft().getEnchantmentLevel(N_E_S.ni_king) > 0){
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
                        oitemnbt.putInt(_AM_Constant.ENCHANTMENT_KEY_REFINE,oitemnbt.getInt(_AM_Constant.ENCHANTMENT_KEY_REFINE) + re);
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
