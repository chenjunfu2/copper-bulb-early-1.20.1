package com.chenjunfu2.block;

import com.chenjunfu2.sounds.ModBlockSoundGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.registry.OxidizableBlocksRegistry;
import net.minecraft.block.*;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.state.property.Properties;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

import java.util.function.ToIntFunction;

public class CopperBulbBlocks
{
	public static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel)
	{
		return state -> state.get(Properties.LIT) ? litLevel : 0;
	}
	
	public static boolean never(BlockState state, BlockView world, BlockPos pos)
	{
		return false;
	}
	
	public static final Block COPPER_BULB = register(
		"copper_bulb",
		new OxidizableBulbBlock(
			Oxidizable.OxidationLevel.UNAFFECTED,
			AbstractBlock.Settings.create()
				.mapColor(MapColor.ORANGE)
				.strength(3.0F, 6.0F)
				.sounds(ModBlockSoundGroup.COPPER_BULB)
				.requiresTool()
				.solidBlock(CopperBulbBlocks::never)
				.luminance(createLightLevelFromLitBlockState(15)
			)
		)
	);
	public static final Block EXPOSED_COPPER_BULB = register(
		"exposed_copper_bulb",
		//settings -> new OxidizableBulbBlock(, settings),
		new OxidizableBulbBlock(
			Oxidizable.OxidationLevel.EXPOSED,
			AbstractBlock.Settings.copy(COPPER_BULB)
				.mapColor(MapColor.TERRACOTTA_LIGHT_GRAY)
				.solidBlock(CopperBulbBlocks::never)
				.luminance(createLightLevelFromLitBlockState(12)
				)
		)
	);
	
	public static final Block WEATHERED_COPPER_BULB = register(
		"weathered_copper_bulb",
		new OxidizableBulbBlock(
			Oxidizable.OxidationLevel.WEATHERED,
			AbstractBlock.Settings.copy(COPPER_BULB)
				.mapColor(MapColor.DARK_AQUA)
				.solidBlock(CopperBulbBlocks::never)
				.luminance(createLightLevelFromLitBlockState(8))
		)
	);
	public static final Block OXIDIZED_COPPER_BULB = register(
		"oxidized_copper_bulb",
		new OxidizableBulbBlock(
			Oxidizable.OxidationLevel.OXIDIZED,
			AbstractBlock.Settings.copy(COPPER_BULB)
				.mapColor(MapColor.TEAL)
				.solidBlock(CopperBulbBlocks::never)
				.luminance(createLightLevelFromLitBlockState(4))
		)
	);
	public static final Block WAXED_COPPER_BULB = register(
		"waxed_copper_bulb",
		new BulbBlock(
			AbstractBlock.Settings.copy(COPPER_BULB).solidBlock(CopperBulbBlocks::never)
		)
	);
	
	public static final Block WAXED_EXPOSED_COPPER_BULB = register(
		"waxed_exposed_copper_bulb",
		new BulbBlock(
			AbstractBlock.Settings.copy(EXPOSED_COPPER_BULB).solidBlock(CopperBulbBlocks::never)
		)
	);
	
	public static final Block WAXED_WEATHERED_COPPER_BULB = register(
		"waxed_weathered_copper_bulb",
		new BulbBlock(
			AbstractBlock.Settings.copy(WEATHERED_COPPER_BULB).solidBlock(CopperBulbBlocks::never)
		)
	);
	public static final Block WAXED_OXIDIZED_COPPER_BULB = register(
		"waxed_oxidized_copper_bulb",
		new BulbBlock(
			AbstractBlock.Settings.copy(OXIDIZED_COPPER_BULB).solidBlock(CopperBulbBlocks::never)
		)
	);
	
	private static <T extends Block> T register(String path, T block)
	{
		Registry.register(Registries.BLOCK, new Identifier(path), block);
		Registry.register(Registries.ITEM, new Identifier(path), new BlockItem(block, new Item.Settings()));
		return block;
	}
	
	public static void RegistriesBlocks()
	{
		//注册氧化阶段
		OxidizableBlocksRegistry.registerOxidizableBlockPair(CopperBulbBlocks.COPPER_BULB, CopperBulbBlocks.EXPOSED_COPPER_BULB);
		OxidizableBlocksRegistry.registerOxidizableBlockPair(CopperBulbBlocks.EXPOSED_COPPER_BULB, CopperBulbBlocks.WEATHERED_COPPER_BULB);
		OxidizableBlocksRegistry.registerOxidizableBlockPair(CopperBulbBlocks.WEATHERED_COPPER_BULB, CopperBulbBlocks.OXIDIZED_COPPER_BULB);

		//注册涂蜡转换
		OxidizableBlocksRegistry.registerWaxableBlockPair(CopperBulbBlocks.COPPER_BULB, CopperBulbBlocks.WAXED_COPPER_BULB);
		OxidizableBlocksRegistry.registerWaxableBlockPair(CopperBulbBlocks.EXPOSED_COPPER_BULB, CopperBulbBlocks.WAXED_EXPOSED_COPPER_BULB);
		OxidizableBlocksRegistry.registerWaxableBlockPair(CopperBulbBlocks.WEATHERED_COPPER_BULB, CopperBulbBlocks.WAXED_WEATHERED_COPPER_BULB);
		OxidizableBlocksRegistry.registerWaxableBlockPair(CopperBulbBlocks.OXIDIZED_COPPER_BULB, CopperBulbBlocks.WAXED_OXIDIZED_COPPER_BULB);
		
		//注册创造物品栏
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE)
			.register(content->
			{
				content.addAfter(Blocks.TARGET, CopperBulbBlocks.WAXED_COPPER_BULB);
				content.addAfter(CopperBulbBlocks.WAXED_COPPER_BULB, CopperBulbBlocks.WAXED_EXPOSED_COPPER_BULB);
				content.addAfter(CopperBulbBlocks.WAXED_EXPOSED_COPPER_BULB, CopperBulbBlocks.WAXED_WEATHERED_COPPER_BULB);
				content.addAfter(CopperBulbBlocks.WAXED_WEATHERED_COPPER_BULB, CopperBulbBlocks.WAXED_OXIDIZED_COPPER_BULB);
			});
		
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
			.register(content->
			{
				content.addAfter(Blocks.CUT_COPPER_SLAB, CopperBulbBlocks.COPPER_BULB);
				content.addAfter(Blocks.EXPOSED_CUT_COPPER_SLAB, CopperBulbBlocks.EXPOSED_COPPER_BULB);
				content.addAfter(Blocks.WEATHERED_CUT_COPPER_SLAB, CopperBulbBlocks.WEATHERED_COPPER_BULB);
				content.addAfter(Blocks.OXIDIZED_CUT_COPPER_SLAB, CopperBulbBlocks.OXIDIZED_COPPER_BULB);
				content.addAfter(Blocks.WAXED_CUT_COPPER_SLAB, CopperBulbBlocks.WAXED_COPPER_BULB);
				content.addAfter(Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB, CopperBulbBlocks.WAXED_EXPOSED_COPPER_BULB);
				content.addAfter(Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB, CopperBulbBlocks.WAXED_WEATHERED_COPPER_BULB);
				content.addAfter(Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB, CopperBulbBlocks.WAXED_OXIDIZED_COPPER_BULB);
			});
		
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
			.register(content->
			{
				content.addAfter(Blocks.REDSTONE_LAMP, CopperBulbBlocks.COPPER_BULB);
				content.addAfter(CopperBulbBlocks.COPPER_BULB, CopperBulbBlocks.EXPOSED_COPPER_BULB);
				content.addAfter(CopperBulbBlocks.EXPOSED_COPPER_BULB, CopperBulbBlocks.WEATHERED_COPPER_BULB);
				content.addAfter(CopperBulbBlocks.WEATHERED_COPPER_BULB, CopperBulbBlocks.OXIDIZED_COPPER_BULB);
				content.addAfter(CopperBulbBlocks.OXIDIZED_COPPER_BULB, CopperBulbBlocks.WAXED_COPPER_BULB);
				content.addAfter(CopperBulbBlocks.WAXED_COPPER_BULB, CopperBulbBlocks.WAXED_EXPOSED_COPPER_BULB);
				content.addAfter(CopperBulbBlocks.WAXED_EXPOSED_COPPER_BULB, CopperBulbBlocks.WAXED_WEATHERED_COPPER_BULB);
				content.addAfter(CopperBulbBlocks.WAXED_WEATHERED_COPPER_BULB, CopperBulbBlocks.WAXED_OXIDIZED_COPPER_BULB);
			});
	}
}
