package west.tungsten_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementEntry;
import net.minecraft.advancement.AdvancementFrame;
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
                        InventoryChangedCriterion.Conditions.items(ModBlocks.TUNGSTEN_CLUMP)
                )
                .build(consumer, TungstenMod.MOD_ID + "/obtain_tungsten");

        AdvancementEntry SECOND = Advancement.Builder.create()
                .parent(ROOT)
                .display(
                        ModBlocks.TUNGSTEN_CLUMP,
                        Text.literal("Netherites Equal"),
                        Text.literal("Obtain a Tungsten Clump"),
                        bg,
                        AdvancementFrame.TASK,
                        true,
                        true,
                        false
                )
                .criterion(
                        "has_tungsten_clump",
                        InventoryChangedCriterion.Conditions.items(ModBlocks.TUNGSTEN_CLUMP)
                )
                .build(consumer, TungstenMod.MOD_ID + "/obtain_tungsten_clump");


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
    }
}