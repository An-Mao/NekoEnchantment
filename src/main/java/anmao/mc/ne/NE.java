package anmao.mc.ne;

import anmao.mc.ne.core.EnchantDataReg;
import anmao.mc.ne.core.EnchantReg;
import anmao.mc.ne.effect.Effects;
import anmao.mc.ne.item.ItemReg;
import anmao.mc.ne.item.NUCreativeTabs;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(NE.MOD_ID)
public class NE
{
    public static final String MOD_ID = "ne";
    public NE(){
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EnchantDataReg.register(modEventBus);
        EnchantReg.register(modEventBus);
        Effects.register(modEventBus);
        ItemReg.register(modEventBus);
        NUCreativeTabs.reg(modEventBus);
    }
}
