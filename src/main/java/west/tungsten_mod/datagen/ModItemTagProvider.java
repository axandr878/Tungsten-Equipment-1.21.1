package west.tungsten_mod.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import org.intellij.lang.annotations.Identifier;
import west.tungsten_mod.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public ModItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
                .add(west.tungsten_mod.item.ModItems.TUNGSTEN_INGOT);
        getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
                .add(west.tungsten_mod.item.ModItems.TUNGSTEN_INGOT);

        getOrCreateTagBuilder(ItemTags.SWORDS)
                .add(ModItems.TUNGSTEN_SWORD);
        getOrCreateTagBuilder(ItemTags.PICKAXES)
                .add(ModItems.TUNGSTEN_PICKAXE);
        getOrCreateTagBuilder(ItemTags.SHOVELS)
                .add(ModItems.TUNGSTEN_SHOVEL);
        getOrCreateTagBuilder(ItemTags.AXES)
                .add(ModItems.TUNGSTEN_AXE);
        getOrCreateTagBuilder(ItemTags.HOES)
                .add(ModItems.TUNGSTEN_HOE);

        getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
                .add(ModItems.TUNSGTEN_HELMET)
                .add(ModItems.TUNSGTEN_BOOTS)
                .add(ModItems.TUNSGTEN_CHESTPLATE)
                .add(ModItems.TUNSGTEN_LEGGINGS);
    }
}