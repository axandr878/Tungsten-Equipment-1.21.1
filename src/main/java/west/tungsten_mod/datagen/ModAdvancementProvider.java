package west.tungsten_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
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
                        ModBlocks.TUNGSTEN_ORE,
                        Text.literal("Tungsten"),
                        Text.literal("Dabble in the Tungsten Mod"),
                        bg,
                        AdvancementFrame.TASK,
                        false,
                        false,
                        false
                )
                .criterion(
                        "has_tungsten_powder",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_POWDER)
                )
                .build(consumer, TungstenMod.MOD_ID + "/root");

        AdvancementEntry SECOND = Advancement.Builder.create()
                .parent(ROOT)
                .display(
                        ModItems.TUNGSTEN_POWDER,
                        Text.literal("Powder?"),
                        Text.literal("Get Tungsten Powder"),
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
                .parent(ROOT)
                .display(
                        ModItems.TUNGSTEN_INGOT,
                        Text.literal("Netherite’s Equal"),
                        Text.literal("Craft a Tungsten Ingot"),
                        bg,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion(
                        "has_tungsten_ingot",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_INGOT)
                )
                .build(consumer, TungstenMod.MOD_ID + "/obtain_tungsten_ingot");

        AdvancementEntry TUNGSTEN_SLOP = Advancement.Builder.create()
                .parent(SECOND)
                .display(
                        ModItems.TUNGSTEN_SLOP,
                        Text.literal("Yummy Slop"),
                        Text.literal("Obtain your first Tungsten Slop"),
                        bg,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion(
                        "has_tungsten_slop",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_SLOP)
                )
                .build(consumer, TungstenMod.MOD_ID + "/tungsten_slop");

        AdvancementEntry TUNGSTEN_JERKY = Advancement.Builder.create()
                .parent(SECOND)
                .display(
                        ModItems.TUNGSTEN_JERKY,
                        Text.literal("Metallic Munchies"),
                        Text.literal("Get Some Tungsten Jerky"),
                        bg,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion(
                        "has_tungsten_jerky",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_JERKY)
                )
                .build(consumer, TungstenMod.MOD_ID + "/tungsten_jerky");

        // BLOCK — unchanged
        AdvancementEntry BLOCK = Advancement.Builder.create()
                .parent(THIRD)
                .display(
                        ModBlocks.TUNGSTEN_BLOCK,
                        Text.literal("Rich in Tungsten"),
                        Text.literal("Obtain a block of Tungsten"),
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

        AdvancementEntry TEMPLATE = Advancement.Builder.create()
                .parent(THIRD)
                .display(
                        ModItems.TUNGSTEN_UPGRADE_TEMPLATE,
                        Text.literal("Hidden Treasure"),
                        Text.literal("Discover a Tungsten Smithing Template"),
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

        AdvancementEntry ANY_TUNGSTEN_ITEM = Advancement.Builder.create()
                .parent(TEMPLATE)
                .display(
                        ModItems.TUNGSTEN_SWORD,
                        Text.literal("Forged in Tungsten"),
                        Text.literal("Craft or obtain any Tungsten equipment"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR)

                .criterion("sword", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_SWORD))
                .criterion("pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_PICKAXE))
                .criterion("axe", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_AXE))
                .criterion("shovel", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_SHOVEL))
                .criterion("hoe", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_HOE))

                .criterion("helmet", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_HELMET))
                .criterion("chestplate", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_CHESTPLATE))
                .criterion("leggings", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_LEGGINGS))
                .criterion("boots", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_BOOTS))

                .criterion("horse_armor", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_HORSE_ARMOR))

                .build(consumer, TungstenMod.MOD_ID + "/craft_any_tungsten_item");

        // FULL ARMOR — now branches from ANY_TUNGSTEN_ITEM
        AdvancementEntry FULL_ARMOR = Advancement.Builder.create()
                .parent(ANY_TUNGSTEN_ITEM)
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
                .criterion("has_tungsten_helmet", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_HELMET))
                .criterion("has_tungsten_chestplate", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_CHESTPLATE))
                .criterion("has_tungsten_leggings", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_LEGGINGS))
                .criterion("has_tungsten_boots", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_BOOTS))
                .build(consumer, TungstenMod.MOD_ID + "/obtain_tungsten_armor");

        // FULL TOOLS — now branches from ANY_TUNGSTEN_ITEM
        AdvancementEntry FULL_TOOLS = Advancement.Builder.create()
                .parent(ANY_TUNGSTEN_ITEM)
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
                .criterion("has_tungsten_sword", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_SWORD))
                .criterion("has_tungsten_pickaxe", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_PICKAXE))
                .criterion("has_tungsten_axe", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_AXE))
                .criterion("has_tungsten_shovel", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_SHOVEL))
                .criterion("has_tungsten_hoe", InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_HOE))
                .build(consumer, TungstenMod.MOD_ID + "/obtain_tungsten_tools");

        AdvancementEntry HORSE_ARMOR = Advancement.Builder.create()
                .parent(ANY_TUNGSTEN_ITEM)
                .display(
                        ModItems.TUNGSTEN_HORSE_ARMOR,
                        Text.literal("Tungsten Steed"),
                        Text.literal("Obtain Tungsten Horse Armor"),
                        null,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion(
                        "has_tungsten_horse_armor",
                        InventoryChangedCriterion.Conditions.items(ModItems.TUNGSTEN_HORSE_ARMOR)
                )
                .build(consumer, TungstenMod.MOD_ID + "/obtain_tungsten_horse_armor");
    }
}