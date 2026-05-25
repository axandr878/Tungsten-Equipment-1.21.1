package west.tungsten_mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentLevelEntry;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import west.tungsten_mod.TungstenMod;
import west.tungsten_mod.block.ModBlocks;
import west.tungsten_mod.enchantment.ModEnchantments;
import net.minecraft.item.EnchantedBookItem;

public class ModItemGroups {

    public static final ItemGroup TUNGSTEN_EQUIPMENT_GROUP = Registry.register(
            Registries.ITEM_GROUP,
            Identifier.of(TungstenMod.MOD_ID, "tungsten_equipment"),
            FabricItemGroup.builder()
                    .icon(() -> new ItemStack(ModItems.TUNGSTEN_INGOT))
                    .displayName(Text.translatable("itemgroup.tungsten_mod"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.TUNGSTEN_INGOT);
                        entries.add(ModItems.TUNGSTEN_SCRAP);
                        entries.add(ModItems.TUNGSTEN_POWDER);

                        entries.add(ModItems.TUNGSTEN_UPGRADE_TEMPLATE);

                        entries.add(ModBlocks.TUNGSTEN_ORE);
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

                        entries.add(ModItems.TUNGSTEN_HORSE_ARMOR);
                        entries.add(ModItems.TUNGSTEN_SLOP);
                        entries.add(ModItems.TUNGSTEN_JERKY);

                        RegistryEntry<Enchantment> heavyEntry = displayContext.lookup()
                                .getWrapperOrThrow(RegistryKeys.ENCHANTMENT)
                                .getOrThrow(ModEnchantments.HEAVY);

                        int maxLevel = heavyEntry.value().getMaxLevel();

                        for (int level = 1; level <= maxLevel; level++) {
                            entries.add(
                                    EnchantedBookItem.forEnchantment(
                                            new EnchantmentLevelEntry(heavyEntry, level)
                                    )
                            );
                        }

                    })
                    .build()
    );

    public static void registerItemGroups() {
        TungstenMod.LOGGER.info("Registering Item Groups for " + TungstenMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(ModItems.TUNGSTEN_INGOT);
            entries.add(ModItems.TUNGSTEN_SCRAP);
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

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FOOD_AND_DRINK).register(entries -> {
            entries.add(ModItems.TUNGSTEN_SLOP);
            entries.add(ModItems.TUNGSTEN_JERKY);
        });

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(entries -> entries.add(ModBlocks.TUNGSTEN_BLOCK));

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.NATURAL).register(entries -> entries.add(ModBlocks.TUNGSTEN_ORE));
    }
}