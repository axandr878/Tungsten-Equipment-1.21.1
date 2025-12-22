package west.tungsten_mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import west.tungsten_mod.TungstenMod;

public class ModItems {
    public static final Item TUNGSTEN_INGOT = registerItem("tungsten_ingot", new Item(new Item.Settings().fireproof()));
    public static final Item TUNGSTEN_SCRAP = registerItem("tungsten_scrap", new Item(new Item.Settings().fireproof()));

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(TungstenMod.MOD_ID, name), item);
    }

    public static final Item TUNGSTEN_SWORD = registerItem("tungsten_sword",
            new SwordItem(ModToolMaterials.TUNGSTEN, new Item.Settings()
                    .fireproof()
                    .attributeModifiers(SwordItem.createAttributeModifiers(ModToolMaterials.TUNGSTEN, 3, -2.4f))));

    public static final Item TUNGSTEN_PICKAXE = registerItem("tungsten_pickaxe",
            new PickaxeItem(ModToolMaterials.TUNGSTEN, new Item.Settings()
                    .fireproof()
                    .attributeModifiers(PickaxeItem.createAttributeModifiers(ModToolMaterials.TUNGSTEN, 1, -2.8f))));
    public static final Item TUNGSTEN_SHOVEL = registerItem("tungsten_shovel",
            new ShovelItem(ModToolMaterials.TUNGSTEN, new Item.Settings()
                    .fireproof()
                    .attributeModifiers(ShovelItem.createAttributeModifiers(ModToolMaterials.TUNGSTEN, 1.5f, -3.0f))));
    public static final Item TUNGSTEN_AXE = registerItem("tungsten_axe",
            new AxeItem(ModToolMaterials.TUNGSTEN, new Item.Settings()
                    .fireproof()
                    .attributeModifiers(AxeItem.createAttributeModifiers(ModToolMaterials.TUNGSTEN, 5, -3.0f))));
    public static final Item TUNGSTEN_HOE = registerItem("tungsten_hoe",
            new HoeItem(ModToolMaterials.TUNGSTEN, new Item.Settings()
                    .fireproof()
                    .attributeModifiers(HoeItem.createAttributeModifiers(ModToolMaterials.TUNGSTEN, -4.0F, 0.0F))));

    public static void registerModItems() {
        TungstenMod.LOGGER.info("Registering Mod Items for " + TungstenMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(TUNGSTEN_INGOT);
            entries.add(TUNGSTEN_SCRAP);
        });
    }
}