package west.tungsten_mod.enchantment;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import west.tungsten_mod.TungstenMod;

public class ModEnchantments {

    public static final RegistryKey<net.minecraft.enchantment.Enchantment> HEAVY =
            RegistryKey.of(RegistryKeys.ENCHANTMENT,
                    Identifier.of(TungstenMod.MOD_ID, "heavy"));

    public static void bootstrap() {
    }
}