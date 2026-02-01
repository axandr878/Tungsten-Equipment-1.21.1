package west.tungsten_mod;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import west.tungsten_mod.block.ModBlocks;
import west.tungsten_mod.item.ModItemGroups;
import west.tungsten_mod.item.ModItems;
import west.tungsten_mod.world.gen.ModWorldGeneration;

public class TungstenMod implements ModInitializer {
	public static final String MOD_ID = "tungsten_mod";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModItemGroups.registerItemGroups();
		ModLootTables.register();
		ModWorldGeneration.generateModWorldGen();

		registerBuiltinResourcePack();
	}

	private static void registerBuiltinResourcePack() {
		Identifier packId = Identifier.of(MOD_ID, "legacy");

		ModContainer container = FabricLoader
				.getInstance()
				.getModContainer(MOD_ID)
				.orElseThrow();

		ResourceManagerHelper.registerBuiltinResourcePack(
				packId,
				container,
				ResourcePackActivationType.NORMAL
		);
	}
}