package anmao.mc.ne.item;

import anmao.mc.ne.NE;
import anmao.mc.ne.core.EnchantData;
import anmao.mc.ne.core.EnchantDataReg;
import anmao.mc.ne.core.EnchantHelper;
import anmao.mc.ne.core.EnchantReg;
import net.minecraft.core.registries.Registries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class NUCreativeTabs {
    private static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, NE.MOD_ID);
    public static final RegistryObject<CreativeModeTab> TAB = TABS.register("nu_tab",()-> CreativeModeTab.builder().icon(()->new ItemStack(ItemReg.RevelationStone.get()))
            .title(Component.translatable("tab.nu.create_tab"))
            .displayItems((pParameters, pOutput) -> {
                pOutput.accept(ItemReg.RevelationStone.get());
                EnchantHelper.getAllEnchants().forEach(enchant -> {
                    ItemStack itemStack = new ItemStack(ItemReg.RevelationStone.get());
                    CompoundTag nbt = new CompoundTag();
                    nbt.putString("revelation", EnchantReg.getResourceLocation(enchant).toString());

                    itemStack.set(EnchantDataReg.Enchant_Data.get(), new EnchantData(nbt));
                    pOutput.accept(itemStack);
                });
            })
            .build());

    public static void reg(IEventBus eventBus){
        TABS.register(eventBus);
    }
}
