package anmao.mc.ne.enchantment.zero.bow.tori_no_uta;

import anmao.mc.ne.NE;
import anmao.mc.ne.enchantment.NekoEnchantments;
import anmao.mc.ne.gui.ToriNoUtaGui;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NE.MOD_ID)
public class ToriNoUtaEvent {
    public static boolean CanRun(Level level){return ToriNoUta.ENABLE && ToriNoUtaGui.showEffects && level.isClientSide();}
    @SubscribeEvent
    public static void onArrowNock(ArrowNockEvent event){
        if (CanRun(event.getLevel())) {
            ItemStack itemStack = event.getBow();
            if (!itemStack.isEmpty() && itemStack.getEnchantmentLevel(NekoEnchantments.toriNoUta) > 0 && event.getEntity().getOffhandItem().getItem() == Items.FEATHER) {
                ToriNoUtaGui.start = true;
            }

        }
    }
    @SubscribeEvent
    public static void onArrowLoose(ArrowLooseEvent event){
        if (CanRun(event.getLevel())) {
            ItemStack itemStack = event.getBow();
            if (!itemStack.isEmpty() && itemStack.getEnchantmentLevel(NekoEnchantments.toriNoUta) > 0 && event.getEntity().getOffhandItem().getItem() == Items.FEATHER) {
                ToriNoUtaGui.start = false;
            }

        }
    }

}
