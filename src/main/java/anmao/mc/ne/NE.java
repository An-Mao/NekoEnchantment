package anmao.mc.ne;

import anmao.mc.ne.config.ConfigCore;
import anmao.mc.ne.effect.Effects;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(NE.MOD_ID)
public class NE
{
    public static final String MOD_ID = "ne";
    public NE(){
        ConfigCore.init();
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Effects.register(modEventBus);
        EnchantmentRegister.register(modEventBus);
    }
}
