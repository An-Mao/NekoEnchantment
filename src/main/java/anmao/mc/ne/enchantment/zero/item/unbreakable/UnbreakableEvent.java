package anmao.mc.ne.enchantment.zero.item.unbreakable;

import anmao.mc.ne.NE;
import anmao.mc.ne.enchantment.NekoEnchantments;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NE.MOD_ID)
public class UnbreakableEvent {
    @SubscribeEvent
    public static void onAnvil(AnvilUpdateEvent anvilUpdateEvent) {
        if (Unbreakable.ENABLE && !anvilUpdateEvent.getPlayer().level().isClientSide && anvilUpdateEvent.getLeft().getEnchantmentLevel(NekoEnchantments.zi_unbreakable) > 0 ){
            if (anvilUpdateEvent.getLeft().getTag() != null && anvilUpdateEvent.getLeft().getTag().getInt(Unbreakable.ENCHANTMENT_KEY_UNBREAKABLE) >= 5){
                return;
            }
            Item ritem = anvilUpdateEvent.getRight().getItem();
            if (ritem == Items.NETHERITE_BLOCK){
                ItemStack leftCopy = anvilUpdateEvent.getLeft().copy();
                CompoundTag oitemnbt = leftCopy.getTag();
                if (oitemnbt != null) {
                    int unb = anvilUpdateEvent.getLeft().getTag().getInt(Unbreakable.ENCHANTMENT_KEY_UNBREAKABLE) + 1;
                    oitemnbt.putInt(Unbreakable.ENCHANTMENT_KEY_UNBREAKABLE,unb);
                    if (unb == 5){
                        oitemnbt.putBoolean("Unbreakable", true);
                    }
                }
                leftCopy.setTag(oitemnbt);
                anvilUpdateEvent.setOutput(leftCopy);
                anvilUpdateEvent.setCost(13);
                anvilUpdateEvent.setMaterialCost(1);
            }
        }
    }
}
