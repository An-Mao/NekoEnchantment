package anmao.mc.ne.enchantment.phenomenon.myriadphenomena;

import anmao.mc.ne.NE;
import anmao.mc.ne.am._AM_Item;
import anmao.mc.ne.enchantment.N_E_S;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentInstance;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Map;

@Mod.EventBusSubscriber(modid = NE.MOD_ID)
public class MyriadPhenomenaEvent {
    @SubscribeEvent
    public static void onAnvil(AnvilUpdateEvent event){
        if (event.getPlayer() instanceof ServerPlayer){
            if (_AM_Item.hasEnchant(event.getLeft(),N_E_S.myriad_phenomena) && event.getRight().getItem() == Items.BAMBOO){
                ItemStack outItem = event.getLeft().copy();
                if (outItem.getTag() != null) {
                    Map<Enchantment, Integer> es = outItem.getAllEnchantments();
                    ListTag listTag = new ListTag();
                    //System.out.println("es::"+es);
                    //es.entrySet().removeIf(entry -> !entry.getKey().getDescriptionId().equals("enchantment.ne.myriad_phenomena"));
                    for (Map.Entry<Enchantment, Integer> entry : es.entrySet()) {
                        Enchantment enchantment = entry.getKey();
                        if (enchantment.getDescriptionId().equals("enchantment.ne.myriad_phenomena")){
                            continue;
                        }
                        CompoundTag compoundTag = new CompoundTag();
                        compoundTag.putString("id",enchantment.getDescriptionId());
                        compoundTag.putInt("lvl",entry.getValue());
                        listTag.add(compoundTag);
                        //es.remove(enchantment);
                    }
                    outItem.getTag().put("MyriadPhenomenaEnchantment", listTag);
                    outItem.getEnchantmentTags().clear();
                    outItem.enchant(N_E_S.myriad_phenomena,1);
                    event.setMaterialCost(1);
                    event.setCost(1);
                    event.setOutput(outItem);
                }
            }
        }
    }
}
