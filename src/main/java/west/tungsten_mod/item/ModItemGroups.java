package west.tungsten_mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import west.tungsten_mod.TungstenMod;
import west.tungsten_mod.block.ModBlocks;

public class ModItemGroups {

    public static final ItemGroup TUNGSTEN_MOD_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(TungstenMod.MOD_ID, "tungsten_mod"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.TUNGSTEN_INGOT))
                    .displayName(Text.translatable("itemgroup.tungsten_mod"))
                    .entries((displayContext, entries) -> {
                        // Items
                        entries.add(ModItems.TUNGSTEN_INGOT);
                        entries.add(ModItems.TUNGSTEN_SCRAP);

                        // Blocks
                        entries.add(ModBlocks.TUNGSTEN_BLOCK);
                        entries.add(ModBlocks.TUNGSTEN_CLUMP);

                        // uh tools ig
                        entries.add(ModItems.TUNGSTEN_SWORD);
                        entries.add(ModItems.TUNGSTEN_PICKAXE);
                        entries.add(ModItems.TUNGSTEN_AXE);
                        entries.add(ModItems.TUNGSTEN_HOE);
                        entries.add(ModItems.TUNGSTEN_SHOVEL);

                    })
                    .build()
    );

    public static void registerItemGroups() {
        TungstenMod.LOGGER.info("Registering Item Groups for " + TungstenMod.MOD_ID);
    }
}
