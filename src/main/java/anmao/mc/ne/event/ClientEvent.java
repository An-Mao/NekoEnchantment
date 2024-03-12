package anmao.mc.ne.event;

import anmao.mc.ne.NE;
import anmao.mc.ne.config.enchantments$config.EnchantmentsConfig;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import anmao.mc.ne.gui.ToriNoUtaGui;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NE.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientEvent {
    private static final boolean ENABLE = EnchantmentsConfig.INSTANCE.isEnable(EnchantmentRegister.TORI_NO_UTA);
    @SubscribeEvent
    public static void registerGuiOverlays(RegisterGuiOverlaysEvent event){
        if (ENABLE) {
            event.registerAboveAll(ToriNoUtaGui.id, ToriNoUtaGui::render);
        }
    }

}
