package com.chenjunfu2.register;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;

import java.util.function.ToIntFunction;

import static net.minecraft.block.Blocks.COPPER_BLOCK;

public class RegistriesBlocks {

    //已弃用
    //
    ////    public static final Block COPPER_BLOCK = register(
    ////            "copper_block",
    ////            new OxidizableBlock(
    ////                    Oxidizable.OxidationLevel.UNAFFECTED,
    ////                    AbstractBlock.Settings.create().mapColor(MapColor.ORANGE).requiresTool().strength(3.0F, 6.0F).sounds(BlockSoundGroup.COPPER)
    ////            )
    ////    );
    //
    //    public static final Block COPPER_BULB = register(
    //            "copper_bulb",
    //            new OxidizableBlock(
    //                    Oxidizable.OxidationLevel.UNAFFECTED,
    //                    AbstractBlock.Settings.create()
    //                            .mapColor(COPPER_BLOCK.getDefaultMapColor())
    //                            .strength(3.0F, 6.0F)
    //                            // 音效
    //                            //.sounds(BlockSoundGroup.COPPER_BULB)
    //                            .requiresTool()
    //                            .solidBlock(Blocks::never)
    //                            .luminance(createLightLevelFromLitBlockState(15))
    //
    //            )
    //    );
    //
    //    public static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
    //
    ////        return (state) -> 0;
    //        return (state) -> state.get(MyBlockProperties.LIT) ? litLevel : 0;
    //    }
    //
    //    public static final Block WAXED_COPPER_BULB = register("waxed_copper_bulb", new BulbBlock(AbstractBlock.Settings.copy(COPPER_BULB)));
    //
    //    public static Block register(String id, Block block) {
    //        return Registry.register(Registries.BLOCK, id, block);
    //    }
    //
    //    public static Block register(RegistryKey<Block> key, Block block) {
    //        return Registry.register(Registries.BLOCK, key, block);
    //    }
    //
    //

    //public static final Block COPPER_BULB_BASE = register(
    //        "copper_bulb_base",
    //        new OxidizableBlock(
    //                Oxidizable.OxidationLevel.UNAFFECTED,
    //                AbstractBlock.Settings.create()
    //                        .mapColor(COPPER_BLOCK.getDefaultMapColor())
    //                        .strength(3.0F, 6.0F)
    //                        //.sounds(BlockSoundGroup.COPPER_BULB)
    //                        .requiresTool()
    //                        .solidBlock(Blocks::never)
    //                        .luminance(createLightLevelFromLitBlockState())

        /// /                        .luminance(createLightLevelFromLitBlockState(15))
    //        )
    //);

        //自定义 添加trycatch 防止首次加载崩力
    public static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel) {
        return state -> {
            try{
                return state.get(Properties.LIT) ? litLevel : 0;
            }catch(Exception e){
                return 0;
            }
        };
    }
    //直接使用BulbBlock Setting直接新建就好了
    //不会氧化的铜灯
    public static final Block COPPER_BULB = register("copper_bulb", new BulbBlock(AbstractBlock.Settings.create()
            .mapColor(COPPER_BLOCK.getDefaultMapColor())
            .strength(3.0F, 6.0F)
            .sounds(ModSoundEvents.COPPER_BULB)
            .requiresTool()
            .solidBlock(Blocks::never)
            .luminance(createLightLevelFromLitBlockState(15)
            )
    )
    );
    //已经氧化的铜灯
    public static final Block OXIDIZED_COPPER_BULB = register("oxidized_copper_bulb", new BulbBlock(AbstractBlock.Settings.create()
                    .mapColor(MapColor.TEAL)
                    .strength(3.0F, 6.0F)
                    .sounds(ModSoundEvents.COPPER_BULB)
                    .requiresTool()
                    .solidBlock(Blocks::never)
                    .luminance(createLightLevelFromLitBlockState(4)
                    )
            )
    );

    private static <T extends Block> T register(String path, T block) {
        Registry.register(Registries.BLOCK, Identifier.of("minecraft", path), block);
        Registry.register(Registries.ITEM, Identifier.of("minecraft", path), new BlockItem(block, new Item.Settings()));
//        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(cont->cont.add(new BlockItem(block, new Item.Settings())));
        return block;
    }


    public static void RegistriesBlocks() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content->content.addAfter(Blocks.DROPPER,RegistriesBlocks.COPPER_BULB));
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE).register(content->content.addAfter(Blocks.DROPPER,RegistriesBlocks.OXIDIZED_COPPER_BULB));
    }


}
