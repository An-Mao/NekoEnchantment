package anmao.mc.ne;

import anmao.mc.ne.config.C_E_O;
import anmao.mc.ne.effect.Effects;
import anmao.mc.ne.enchantment.EnchantmentRegister;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(NE.MOD_ID)
public class NE
{
    public static final String MOD_ID = "ne";
    public static Boolean ShowDesc;

    public NE()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        MinecraftForge.EVENT_BUS.register(this);
        Effects.register(modEventBus);
        EnchantmentRegister.register(modEventBus);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, C_E_O.SPEC);
        if (C_E_O.showDesc) {
            ShowDesc = isModLoaded("net.darkhax.enchdesc");
        }else {
            ShowDesc = true;
        }
    }
    public static boolean isModLoaded(String modId) {
        try {
            Class.forName(modId);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
