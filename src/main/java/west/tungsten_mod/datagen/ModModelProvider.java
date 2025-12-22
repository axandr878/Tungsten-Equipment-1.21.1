package west.tungsten_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;
import west.tungsten_mod.item.ModItems;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerSimpleCubeAll(west.tungsten_mod.block.ModBlocks.TUNGSTEN_CLUMP);
        blockStateModelGenerator.registerSimpleCubeAll(west.tungsten_mod.block.ModBlocks.TUNGSTEN_BLOCK);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(west.tungsten_mod.item.ModItems.TUNGSTEN_INGOT, Models.GENERATED);
        itemModelGenerator.register(west.tungsten_mod.item.ModItems.TUNGSTEN_SCRAP, Models.GENERATED);

        itemModelGenerator.register(west.tungsten_mod.item.ModItems.TUNGSTEN_UPGRADE_TEMPLATE, Models.GENERATED);

        itemModelGenerator.register(ModItems.TUNGSTEN_SWORD, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TUNGSTEN_PICKAXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TUNGSTEN_SHOVEL, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TUNGSTEN_AXE, Models.HANDHELD);
        itemModelGenerator.register(ModItems.TUNGSTEN_HOE, Models.HANDHELD);
    }
}
