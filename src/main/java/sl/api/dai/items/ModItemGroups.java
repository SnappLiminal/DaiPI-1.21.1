package sl.api.dai.items;

import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import sl.api.dai.DaiPI;
import sl.api.dai.block.ModBlocks;

import java.util.function.Supplier;

public class ModItemGroups {
    public static final ItemGroup SLIMINAL_ITEMS_GROUP = Registry.register(Registries.ITEM_GROUP,
    Identifier.of(DaiPI.MOD_ID, "sliminal_items"),
    FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModItems.AKSHARD))
            .displayName(Text.translatable("itemgroup.daipi.sliminal_items"))
            .entries((displayContext, entries) -> {
                entries.add(ModItems.AKSHARD);
                entries.add(ModItems.ROSE_APPLE);


            }).build());

    public static final ItemGroup SLIMINAL_BLOCK_GROUP = Registry.register(Registries.ITEM_GROUP,
    Identifier.of(DaiPI.MOD_ID, "sliminal_blocks"),
    FabricItemGroup.builder()
            .icon(() -> new ItemStack(ModBlocks.YAN_BLOCK))
            .displayName(Text.translatable("itemgroup.daipi.sliminal_blocks"))
            .entries((displayContext, entries) -> {
                entries.add(ModBlocks.YAN_BLOCK);
                entries.add(ModBlocks.COBBLE_YAN_BLOCK);
            }).build());


    public static void registerItemGroups() {
        DaiPI.LOGGER.info("Packing items and sending them out!");
    }
}
