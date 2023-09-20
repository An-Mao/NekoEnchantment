package anmao.mc.ne.enchantment;


import anmao.mc.ne.NE;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = NE.MOD_ID)
public class OtherEvents {
    @SubscribeEvent
    public static void onLootTableLoad (LootTableLoadEvent event){
        //event.getTable().removePool("");
    }
}
