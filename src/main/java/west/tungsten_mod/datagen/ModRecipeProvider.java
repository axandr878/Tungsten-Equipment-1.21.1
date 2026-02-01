package west.tungsten_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.data.server.recipe.ShapelessRecipeJsonBuilder;
import net.minecraft.data.server.recipe.SmithingTransformRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
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
                List.of(ModItems.TUNGSTEN_POWDER),
                RecipeCategory.MISC,
                ModItems.TUNGSTEN_SCRAP,
                2.0f,
                200,
                "tungsten_scrap"
        );

        offerBlasting(
                exporter,
                List.of(ModItems.TUNGSTEN_POWDER),
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

        ShapedRecipeJsonBuilder.create(
                        RecipeCategory.MISC,
                        ModItems.TUNGSTEN_UPGRADE_TEMPLATE,
                        2
                )
                .pattern("DTD")
                .pattern("DSD")
                .pattern("DDD")
                .input('S', Items.DEEPSLATE)
                .input('T', ModItems.TUNGSTEN_UPGRADE_TEMPLATE)
                .input('D', Items.DIAMOND)
                .criterion(
                        hasItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        conditionsFromItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE)
                )
                .offerTo(
                        exporter,
                        Identifier.of(TungstenMod.MOD_ID, "tungsten_upgrade_template_duplication")
                );


        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_SWORD),
                        Ingredient.ofItems(ModItems.TUNGSTEN_INGOT),
                        RecipeCategory.MISC,
                        ModItems.TUNGSTEN_SWORD
                )
                .criterion(
                        hasItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        conditionsFromItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE)
                )
                .offerTo(exporter, Identifier.of(TungstenMod.MOD_ID, "tungsten_sword_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_PICKAXE),
                        Ingredient.ofItems(ModItems.TUNGSTEN_INGOT),
                        RecipeCategory.MISC,
                        ModItems.TUNGSTEN_PICKAXE
                )
                .criterion(
                        hasItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        conditionsFromItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE)
                )
                .offerTo(exporter, Identifier.of(TungstenMod.MOD_ID, "tungsten_pickaxe_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_AXE),
                        Ingredient.ofItems(ModItems.TUNGSTEN_INGOT),
                        RecipeCategory.MISC,
                        ModItems.TUNGSTEN_AXE
                )
                .criterion(
                        hasItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        conditionsFromItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE)
                )
                .offerTo(exporter, Identifier.of(TungstenMod.MOD_ID, "tungsten_axe_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_HOE),
                        Ingredient.ofItems(ModItems.TUNGSTEN_INGOT),
                        RecipeCategory.MISC,
                        ModItems.TUNGSTEN_HOE
                )
                .criterion(
                        hasItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        conditionsFromItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE)
                )
                .offerTo(exporter, Identifier.of(TungstenMod.MOD_ID, "tungsten_hoe_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_SHOVEL),
                        Ingredient.ofItems(ModItems.TUNGSTEN_INGOT),
                        RecipeCategory.MISC,
                        ModItems.TUNGSTEN_SHOVEL
                )
                .criterion(
                        hasItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        conditionsFromItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE)
                )
                .offerTo(exporter, Identifier.of(TungstenMod.MOD_ID, "tungsten_shovel_upgrade"));

        // armor not tools smithing


        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_BOOTS),
                        Ingredient.ofItems(ModItems.TUNGSTEN_INGOT),
                        RecipeCategory.MISC,
                        ModItems.TUNGSTEN_BOOTS
                )
                .criterion(
                        hasItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        conditionsFromItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE)
                )
                .offerTo(exporter, Identifier.of(TungstenMod.MOD_ID, "tungsten_boots_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_LEGGINGS),
                        Ingredient.ofItems(ModItems.TUNGSTEN_INGOT),
                        RecipeCategory.MISC,
                        ModItems.TUNGSTEN_LEGGINGS
                )
                .criterion(
                        hasItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        conditionsFromItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE)
                )
                .offerTo(exporter, Identifier.of(TungstenMod.MOD_ID, "tungsten_leggings_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_HELMET),
                        Ingredient.ofItems(ModItems.TUNGSTEN_INGOT),
                        RecipeCategory.MISC,
                        ModItems.TUNGSTEN_HELMET
                )
                .criterion(
                        hasItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        conditionsFromItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE)
                )
                .offerTo(exporter, Identifier.of(TungstenMod.MOD_ID, "tungsten_helmet_upgrade"));

        SmithingTransformRecipeJsonBuilder.create(
                        Ingredient.ofItems(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        Ingredient.ofItems(Items.DIAMOND_CHESTPLATE),
                        Ingredient.ofItems(ModItems.TUNGSTEN_INGOT),
                        RecipeCategory.MISC,
                        ModItems.TUNGSTEN_CHESTPLATE
                )
                .criterion(
                        hasItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE),
                        conditionsFromItem(ModItems.TUNGSTEN_UPGRADE_TEMPLATE)
                )
                .offerTo(exporter, Identifier.of(TungstenMod.MOD_ID, "tungsten_chestplate_upgrade"));
    }
}