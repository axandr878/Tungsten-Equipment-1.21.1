package west.tungsten_mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import west.tungsten_mod.TungstenMod;
import west.tungsten_mod.block.ModBlocks;

public class ModItemGroups {

    // Custom Tungsten mod tab
    public static final ItemGroup TUNGSTEN_MOD_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(TungstenMod.MOD_ID, "tungsten_mod"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.TUNGSTEN_INGOT))
                    .displayName(Text.translatable("itemgroup.tungsten_mod"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.TUNGSTEN_INGOT);
                        entries.add(ModItems.TUNGSTEN_SCRAP);
                        entries.add(ModItems.TUNGSTEN_POWDER);

                        entries.add(ModItems.TUNGSTEN_UPGRADE_TEMPLATE);

                        entries.add(ModBlocks.TUNGSTEN_CLUMP);
                        entries.add(ModBlocks.TUNGSTEN_BLOCK);

                        entries.add(ModItems.TUNGSTEN_SWORD);
                        entries.add(ModItems.TUNGSTEN_PICKAXE);
                        entries.add(ModItems.TUNGSTEN_AXE);
                        entries.add(ModItems.TUNGSTEN_SHOVEL);
                        entries.add(ModItems.TUNGSTEN_HOE);

                        entries.add(ModItems.TUNGSTEN_HELMET);
                        entries.add(ModItems.TUNGSTEN_CHESTPLATE);
                        entries.add(ModItems.TUNGSTEN_LEGGINGS);
                        entries.add(ModItems.TUNGSTEN_BOOTS);

                        /*entries.add(ModItems.TUNGSTEN_SLOP);*/
                    })
                    .build()
    );

    public static void registerItemGroups() {
        TungstenMod.LOGGER.info("Registering Item Groups for " + TungstenMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.TUNGSTEN_INGOT);
            entries.add(ModItems.TUNGSTEN_SCRAP);
            entries.add(ModBlocks.TUNGSTEN_CLUMP);
            entries.add(ModItems.TUNGSTEN_POWDER);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.TOOLS).register(entries -> {
            entries.add(ModItems.TUNGSTEN_PICKAXE);
            entries.add(ModItems.TUNGSTEN_AXE);
            entries.add(ModItems.TUNGSTEN_SHOVEL);
            entries.add(ModItems.TUNGSTEN_HOE);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.COMBAT).register(entries -> {
            entries.add(ModItems.TUNGSTEN_SWORD);
            entries.add(ModItems.TUNGSTEN_HELMET);
            entries.add(ModItems.TUNGSTEN_CHESTPLATE);
            entries.add(ModItems.TUNGSTEN_LEGGINGS);
            entries.add(ModItems.TUNGSTEN_BOOTS);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(ModBlocks.TUNGSTEN_BLOCK));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.add(ModBlocks.TUNGSTEN_CLUMP));
    }
}