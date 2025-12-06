package sl.api.dai.items;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import sl.api.dai.DaiPI;

public class ModItems {
    public static final Item AKSHARD = registerItem("akshard", new Item(new Item.Settings()));
    public static final Item ROSE_APPLE = registerItem("rose_apple", new Item(new Item.Settings()));

    private static Item registerItem(String name, Item item){
        return Registry.register(Registries.ITEM, Identifier.of(DaiPI.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DaiPI.LOGGER.info("Importing powered by DaiPI!");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(AKSHARD);
            fabricItemGroupEntries.add(ROSE_APPLE);

        });
    }
}
