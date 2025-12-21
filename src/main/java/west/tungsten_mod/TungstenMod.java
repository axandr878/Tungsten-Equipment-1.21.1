package west.tungsten_mod;

import net.fabricmc.api.ModInitializer;

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
		//ModWorldGeneration.generateModWorldGen();
	}
}