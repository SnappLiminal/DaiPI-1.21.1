package sl.api.dai.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.block.Block;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import sl.api.dai.DaiPI;

public class ModBlocks {
    public static final Block YAN_BLOCK = registerBlock("yan_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(20f)
                    .resistance(15f)
                    .requiresTool()
                    .luminance(state -> 10)
                    .sounds(BlockSoundGroup.STONE)));

    public static final Block COBBLE_YAN_BLOCK = registerBlock("cobble_yan_block",
            new Block(AbstractBlock.Settings.create()
                    .strength(4f)
                    .requiresTool()
                    .sounds(BlockSoundGroup.STONE)));

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(DaiPI.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(DaiPI.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        DaiPI.LOGGER.info("Getting blocks from Tindalos!");

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(ModBlocks.YAN_BLOCK);
            fabricItemGroupEntries.add(ModBlocks.COBBLE_YAN_BLOCK);
        });
    }
}
