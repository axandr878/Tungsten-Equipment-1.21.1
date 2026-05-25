package west.tungsten_mod.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.world.World;

public class TungstenSlopItem extends Item {

    public TungstenSlopItem(Settings settings) {
        super(settings);
    }

    @Override
    public ItemStack finishUsing(ItemStack stack, World world, LivingEntity user) {
        ItemStack result = super.finishUsing(stack, world, user);

        if (user instanceof PlayerEntity player && !player.isCreative()) {
            ItemStack bowl = new ItemStack(Items.BOWL);

            if (!player.getInventory().insertStack(bowl)) {
                player.dropItem(bowl, false);
            }
        }

        return result;
    }
}
