package anmao.mc.ne.item;

import anmao.mc.ne.NE;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ItemReg {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, NE.MOD_ID);
    public static final RegistryObject<Item> RevelationStone = ITEMS.register("revelation_stone",()->new RevelationStoneItem());
    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
