package west.tungsten_mod.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import west.tungsten_mod.TungstenMod;

public class ModBlocks {
    public static final Block TUNGSTEN_BLOCK = registerBlock(
            "tungsten_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(25f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.NETHERITE))
    );
    public static final Block TUNGSTEN_ORE = registerBlock(
            "tungsten_ore",
            new Block(AbstractBlock.Settings.create()
                    .strength(25f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.DEEPSLATE))
    );

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(TungstenMod.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(TungstenMod.MOD_ID, name),
                new BlockItem(block, new Item.Settings().fireproof()));
    }

    public static void registerModBlocks() {
        TungstenMod.LOGGER.info("Registering Mod Blocks for " + TungstenMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(ModBlocks.TUNGSTEN_BLOCK));
    }
}