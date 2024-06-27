package anmao.mc.ne.core;

import anmao.mc.ne.NE;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.Registries;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class EnchantDataReg {

    public static final DeferredRegister<DataComponentType<?>> DATAS = DeferredRegister.create(Registries.DATA_COMPONENT_TYPE, NE.MOD_ID);
    public static final RegistryObject<DataComponentType<EnchantData>> Enchant_Data = DATAS.register("neko_enchant",()-> DataComponentType.<EnchantData>builder().persistent(EnchantData.CODEC).networkSynchronized(EnchantData.STREAM_CODEC).build());

    public static void register(IEventBus eventBus){
        DATAS.register(eventBus);
    }
}
