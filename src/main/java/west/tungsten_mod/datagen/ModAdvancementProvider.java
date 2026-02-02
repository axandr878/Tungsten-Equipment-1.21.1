package west.tungsten_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Item;
import net.minecraft.predicate.item.ItemPredicate;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import west.tungsten_mod.TungstenMod;
import west.tungsten_mod.block.ModBlocks;
import west.tungsten_mod.item.ModItems;


import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;


public class ModAdvancementProvider extends FabricAdvancementProvider {

    public ModAdvancementProvider(
            FabricDataOutput output,
            CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture
    ) {
        super(output, registriesFuture);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {

        Identifier bg = Identifier.tryParse("minecraft:textures/gui/advancements/backgrounds/stone.png");

        AdvancementEntry ROOT = Advancement.Builder.create()
                .display(
                        ModItems.TUNGSTEN_INGOT,
                        Text.literal("Tungsten"),
                        Text.literal("Dabble in the Tungsten Mod"),
                        bg,
                        AdvancementFrame.TASK,
                        false,
                        false,
                        false
                )
                .criterion(
                        "has_tungsten",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_POWDER)
                )
                .build(consumer, TungstenMod.MOD_ID + "/obtain_tungsten");

        AdvancementEntry SECOND = Advancement.Builder.create()
                .parent(ROOT)
                .display(
                        ModItems.TUNGSTEN_POWDER,
                        Text.literal("Netherites Equal"),
                        Text.literal("Obtain Tungsten Powder"),
                        bg,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion(
                        "has_tungsten_powder",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_POWDER)
                )
                .build(consumer, TungstenMod.MOD_ID + "/obtain_tungsten_powder");


        AdvancementEntry THIRD = Advancement.Builder.create()
                .parent(SECOND)
                .display(
                        ModBlocks.TUNGSTEN_BLOCK,
                        Text.literal("Rich in Tungsten"),
                        Text.literal("Obtain tungsten block"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion(
                        "has_tungsten_block",
                        InventoryChangedCriterion.Conditions.items(ModBlocks.TUNGSTEN_BLOCK)
                )
                .build(consumer, TungstenMod.MOD_ID + "/obtain_tungsten_block");

        AdvancementEntry SIXTH = Advancement.Builder.create()
                .parent(SECOND)
                .display(
                        ModItems.TUNGSTEN_UPGRADE_TEMPLATE,
                        Text.literal("Strongholds treasure"),
                        Text.literal("Find A Tungsten Smithing Template"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion(
                        "has_tungsten_template",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_UPGRADE_TEMPLATE)
                )
                .build(consumer, TungstenMod.MOD_ID + "/obtain_tungsten_template");

        AdvancementEntry FORTH = Advancement.Builder.create()
                .parent(SIXTH)
                .display(
                        ModItems.TUNGSTEN_CHESTPLATE,
                        Text.literal("Cover Me in Tungsten"),
                        Text.literal("Get a full suit of Tungsten armor"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criterion(
                        "has_tungsten_chestplate",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_CHESTPLATE)
                )
                .criterion("has_tungsten_boots",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_BOOTS)
                )
                .criterion(
                        "has_tungsten_leggings",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_LEGGINGS)
                )
                .criterion("has_tungsten_helmet",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_HELMET)
                )
                .build(consumer, TungstenMod.MOD_ID + "/obtain_tungsten_armor");

        AdvancementEntry FIFTH = Advancement.Builder.create()
                .parent(SIXTH)
                .display(
                        ModItems.TUNGSTEN_PICKAXE,
                        Text.literal("Tooled Up in Tungsten"),
                        Text.literal("Get a full set of Tungsten tools"),
                        null,
                        AdvancementFrame.CHALLENGE,
                        true,
                        true,
                        false
                )
                .criterion(
                        "has_tungsten_sword",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_SWORD)
                )
                .criterion(
                        "has_tungsten_pickaxe",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_PICKAXE)
                )
                .criterion(
                        "has_tungsten_axe",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_AXE)
                )
                .criterion(
                        "has_tungsten_shovel",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_SHOVEL)
                )
                .criterion(
                        "has_tungsten_hoe",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_HOE)
                )
                .build(consumer, TungstenMod.MOD_ID + "/obtain_tungsten_tools");

    }
}