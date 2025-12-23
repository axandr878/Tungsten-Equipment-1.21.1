package west.tungsten_mod.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import west.tungsten_mod.TungstenMod;
import net.minecraft.item.SmithingTemplateItem;
import java.util.List;


public class ModItems {
    public static final Item TUNGSTEN_INGOT = registerItem("tungsten_ingot", new Item(new Item.Settings().fireproof()));
    public static final Item TUNGSTEN_SCRAP = registerItem("tungsten_scrap", new Item(new Item.Settings().fireproof()));

    public static final Item TUNGSTEN_UPGRADE_TEMPLATE = Registry.register(
            Registries.ITEM,
            Identifier.of(TungstenMod.MOD_ID, "tungsten_upgrade_template"),
            new SmithingTemplateItem(
                    Text.translatable("item.tungsten_mod.tungsten_upgrade_template.applies_to"),
                    Text.translatable("item.tungsten_mod.tungsten_upgrade_template.ingredients"),
                    Text.translatable("item.tungsten_mod.tungsten_upgrade_template.title"),
                    Text.translatable("item.tungsten_mod.tungsten_upgrade_template.base_slot_description"),
                    Text.translatable("item.tungsten_mod.tungsten_upgrade_template.additions_slot_description"),
                    getTungstenBaseSlotTextures(),
                    getTungstenAdditionSlotTextures()
            )
    );

    private static List<Identifier> getTungstenBaseSlotTextures() {
        return List.of(
                Identifier.ofVanilla("item/empty_slot_sword"),
                Identifier.ofVanilla("item/empty_slot_pickaxe"),
                Identifier.ofVanilla("item/empty_slot_axe"),
                Identifier.ofVanilla("item/empty_slot_shovel"),
                Identifier.ofVanilla("item/empty_slot_hoe")
        );
    }

    private static List<Identifier> getTungstenAdditionSlotTextures() {
        return List.of(
                Identifier.ofVanilla("item/empty_slot_ingot")
        );
    }


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

    public static final Item TUNSGTEN_HELMET = registerItem("tungsten_helmet",
            new ArmorItem(ModArmorMaterials.TUNSGTEN, ArmorItem.Type.HELMET, new Item.Settings().fireproof()
                    .maxDamage(ArmorItem.Type.HELMET.getMaxDamage(37))));
    public static final Item TUNSGTEN_CHESTPLATE = registerItem("tungsten_chestplate",
            new ArmorItem(ModArmorMaterials.TUNSGTEN, ArmorItem.Type.CHESTPLATE, new Item.Settings().fireproof()
                    .maxDamage(ArmorItem.Type.CHESTPLATE.getMaxDamage(37))));
    public static final Item TUNSGTEN_LEGGINGS = registerItem("tungsten_leggings",
            new ArmorItem(ModArmorMaterials.TUNSGTEN, ArmorItem.Type.LEGGINGS, new Item.Settings().fireproof()
                    .maxDamage(ArmorItem.Type.LEGGINGS.getMaxDamage(37))));
    public static final Item TUNSGTEN_BOOTS = registerItem("tungsten_boots",
            new ArmorItem(ModArmorMaterials.TUNSGTEN, ArmorItem.Type.BOOTS, new Item.Settings().fireproof()
                    .maxDamage(ArmorItem.Type.BOOTS.getMaxDamage(37))));

    public static void registerModItems() {
        TungstenMod.LOGGER.info("Registering Mod Items for " + TungstenMod.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(entries -> {
            entries.add(TUNGSTEN_INGOT);
            entries.add(TUNGSTEN_SCRAP);
        });
    }
}