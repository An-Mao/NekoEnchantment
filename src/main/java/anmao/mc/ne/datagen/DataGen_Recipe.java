package anmao.mc.ne.datagen;

import anmao.mc.ne.item.ItemReg;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class DataGen_Recipe extends RecipeProvider implements IConditionBuilder {
    public DataGen_Recipe(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> lookup) {
        super(pOutput,lookup);
    }

    @Override
    protected void buildRecipes(@NotNull RecipeOutput consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemReg.RevelationStone.get(), 1)
                .pattern("ABA")
                .pattern("BCB")
                .pattern("ABA")
                .define('A',Items.STONE)
                .define('B',Items.LAPIS_LAZULI)
                .define('C', Items.DIAMOND)
                .unlockedBy(getHasName(Items.DIAMOND),has(Items.DIAMOND))
                .save(consumer);
    }
}
