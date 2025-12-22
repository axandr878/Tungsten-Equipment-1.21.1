package west.tungsten_mod;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.util.Identifier;
import west.tungsten_mod.item.ModItems;

public class ModLootTables {

    private static final Identifier STRONGHOLD_CORRIDOR = Identifier.ofVanilla("chests/stronghold_corridor");
    private static final Identifier STRONGHOLD_CROSSING = Identifier.ofVanilla("chests/stronghold_crossing");
    private static final Identifier STRONGHOLD_LIBRARY = Identifier.ofVanilla("chests/stronghold_library");

    public static void register() {
        LootTableEvents.MODIFY.register((id, tableBuilder, source, registries) -> {
            if (!source.isBuiltin()) return;

            LootPool.Builder pool;

            if (id.getValue().equals(STRONGHOLD_CORRIDOR)) {
                // One guaranteed chest
                pool = LootPool.builder()
                        .with(ItemEntry.builder(ModItems.TUNGSTEN_UPGRADE_TEMPLATE));
                tableBuilder.pool(pool);
            } else if (id.getValue().equals(STRONGHOLD_CROSSING) || id.getValue().equals(STRONGHOLD_LIBRARY)) {
                // All other chests 10% chance
                pool = LootPool.builder()
                        .conditionally(RandomChanceLootCondition.builder(0.1f))
                        .with(ItemEntry.builder(ModItems.TUNGSTEN_UPGRADE_TEMPLATE));
                tableBuilder.pool(pool);
            }
        });
    }
}
