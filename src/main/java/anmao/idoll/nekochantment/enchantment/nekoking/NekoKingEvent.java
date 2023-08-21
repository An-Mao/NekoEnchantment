package anmao.idoll.nekochantment.enchantment.nekoking;

import anmao.idoll.nekochantment.NekoEnchantment;
import anmao.idoll.nekochantment.enchantment.EnchantmentRegister;
import net.minecraft.commands.arguments.NbtTagArgument;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;


public class NekoKingEvent {
    @Mod.EventBusSubscriber(modid = NekoEnchantment.MODID)
    public static class ForgeEvent {
        @SubscribeEvent
        public static void onAnvil(AnvilUpdateEvent anvilUpdateEvent) {
            if (anvilUpdateEvent.getLeft().getEnchantmentLevel(EnchantmentRegister.NEKO_KING.get()) > 0){
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
                        oitemnbt.putInt("refine",oitemnbt.getInt("refine") + re);
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
