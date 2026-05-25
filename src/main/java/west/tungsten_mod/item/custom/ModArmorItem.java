package west.tungsten_mod.item.custom;

import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.component.type.AttributeModifiersComponent;
import net.minecraft.component.type.AttributeModifiersComponent.Entry;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;
import west.tungsten_mod.TungstenMod;

import java.util.ArrayList;
import java.util.List;

public class ModArmorItem extends ArmorItem {

    private static final double SPEED_REDUCTION = -0.04; // -5% per piece

    public ModArmorItem(RegistryEntry<ArmorMaterial> material, Type type, Settings settings) {
        super(material, type, settings);
    }

    @Override
    public AttributeModifiersComponent getAttributeModifiers() {

        AttributeModifiersComponent vanilla = super.getAttributeModifiers();

        List<Entry> entries = new ArrayList<>(vanilla.modifiers());

        Identifier modifierId = Identifier.of(
                TungstenMod.MOD_ID,
                "tungsten_speed_penalty_" + this.getSlotType().getName()
        );

        entries.add(new Entry(
                EntityAttributes.GENERIC_MOVEMENT_SPEED,
                new EntityAttributeModifier(
                        modifierId,
                        SPEED_REDUCTION,
                        EntityAttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
                ),
                AttributeModifierSlot.forEquipmentSlot(this.getSlotType())
        ));

        return new AttributeModifiersComponent(entries, vanilla.showInTooltip());
    }
}