package west.tungsten_mod.util;

import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import west.tungsten_mod.TungstenMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_TUNGSTEN_TOOL = createTag("needs_tungsten_tool");
        public static final TagKey<Block> INCORRECT_FOR_TUNGSTEN_TOOL = createTag("incorrect_for_tungsten_tool");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, Identifier.of(TungstenMod.MOD_ID, name));
        }
    }
}