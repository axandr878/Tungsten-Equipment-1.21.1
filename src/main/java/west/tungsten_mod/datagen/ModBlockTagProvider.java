package west.tungsten_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import west.tungsten_mod.block.ModBlocks;
import west.tungsten_mod.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.TUNGSTEN_BLOCK)
                .add(ModBlocks.TUNGSTEN_CLUMP);

        getOrCreateTagBuilder(BlockTags.NEEDS_DIAMOND_TOOL)
                .add(ModBlocks.TUNGSTEN_BLOCK)
                .add(ModBlocks.TUNGSTEN_CLUMP);

        getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
                .add(ModBlocks.TUNGSTEN_BLOCK);

        getOrCreateTagBuilder(ModTags.Blocks.NEEDS_TUNGSTEN_TOOL)
                .addTag(BlockTags.NEEDS_DIAMOND_TOOL);
    }
}