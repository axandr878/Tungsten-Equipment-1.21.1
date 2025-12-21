package west.tungsten_mod.trim;

import net.minecraft.item.Item;
import net.minecraft.item.trim.ArmorTrimMaterial;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.text.TextColor;
import net.minecraft.util.Identifier;
import net.minecraft.util.Util;
import west.tungsten_mod.TungstenMod;
import west.tungsten_mod.item.ModItems;

import java.util.Map;

public class ModTrimMaterials {
    public static final RegistryKey<ArmorTrimMaterial> TUNGSTEN_INGOT = RegistryKey.of(RegistryKeys.TRIM_MATERIAL,
            Identifier.of(TungstenMod.MOD_ID, "tungsten_ingot"));

    public static void bootstrap(Registerable<ArmorTrimMaterial> registerable) {
        register(registerable, Registries.ITEM.getEntry(ModItems.TUNGSTEN_INGOT),
                Style.EMPTY.withColor(TextColor.parse("#b03fe0").getOrThrow()));

    }

    private static void register(Registerable<ArmorTrimMaterial> registerable,
                                 RegistryEntry<Item> item, Style style) {
        ArmorTrimMaterial trimMaterial = new ArmorTrimMaterial(ModTrimMaterials.TUNGSTEN_INGOT.getValue().getPath(), item, (float) 0.8, Map.of(),
                Text.translatable(Util.createTranslationKey("trim_material", ModTrimMaterials.TUNGSTEN_INGOT.getValue())).fillStyle(style));

        registerable.register(ModTrimMaterials.TUNGSTEN_INGOT, trimMaterial);
    }
}