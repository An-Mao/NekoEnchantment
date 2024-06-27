package anmao.mc.ne.datagen;

import anmao.mc.ne.NE;
import anmao.mc.ne.item.ItemReg;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class DataGen_ItemModelProvider extends ItemModelProvider {
    public DataGen_ItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, NE.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        simpleItem(ItemReg.RevelationStone);
    }
    private ItemModelBuilder simpleItem(RegistryObject<Item> item){
        return withExistingParent(item.getId().getPath(),ResourceLocation.tryParse("item/generated")).texture("layer0",ResourceLocation.tryBuild(NE.MOD_ID,"item/"+item.getId().getPath()));
    }
}
