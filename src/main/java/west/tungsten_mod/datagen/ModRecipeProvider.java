package west.tungsten_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;
import west.tungsten_mod.TungstenMod;
import west.tungsten_mod.block.ModBlocks;
import west.tungsten_mod.item.ModItems;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {

    public ModRecipeProvider(FabricDataOutput output,
                             CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter exporter) {

        offerSmelting(
                exporter,
                List.of(ModBlocks.TUNGSTEN_CLUMP),
                RecipeCategory.MISC,
                ModItems.TUNGSTEN_SCRAP,
                2.0f,
                200,
                "tungsten_scrap"
        );

        offerBlasting(
                exporter,
                List.of(ModBlocks.TUNGSTEN_CLUMP),
                RecipeCategory.MISC,
                ModItems.TUNGSTEN_SCRAP,
                2.0f,
                100,
                "tungsten_scrap"
        );

        offerReversibleCompactingRecipes(
                exporter,
                RecipeCategory.MISC,
                ModItems.TUNGSTEN_INGOT,
                RecipeCategory.MISC,
                ModBlocks.TUNGSTEN_BLOCK
        );

        // Scrap + Iron -> Ingot
        ShapelessRecipeJsonBuilder.create(
                        RecipeCategory.MISC,
                        ModItems.TUNGSTEN_INGOT
                )
                .input(ModItems.TUNGSTEN_SCRAP)
                .input(ModItems.TUNGSTEN_SCRAP)
                .input(ModItems.TUNGSTEN_SCRAP)
                .input(ModItems.TUNGSTEN_SCRAP)
                .input(Items.IRON_INGOT)
                .input(Items.IRON_INGOT)
                .input(Items.IRON_INGOT)
                .input(Items.IRON_INGOT)
                .criterion(
                        hasItem(ModItems.TUNGSTEN_SCRAP),
                        conditionsFromItem(ModItems.TUNGSTEN_SCRAP)
                )
                .offerTo(
                        exporter,
                        Identifier.of(TungstenMod.MOD_ID, "tungsten_ingot_from_scrap")
                );
    }
}