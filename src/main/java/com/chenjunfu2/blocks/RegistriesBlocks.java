package com.chenjunfu2.blocks;

import com.chenjunfu2.sounds.ModBlockSoundGroup;
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

public class RegistriesBlocks
{
	public static ToIntFunction<BlockState> createLightLevelFromLitBlockState(int litLevel)
	{
		return state -> state.get(Properties.LIT) ? litLevel : 0;
	}
	
	public static final Block COPPER_BULB = register(
		"copper_bulb",
		new OxidizableBulbBlock(
			Oxidizable.OxidationLevel.UNAFFECTED,
			AbstractBlock.Settings.create()
				.mapColor(COPPER_BLOCK.getDefaultMapColor())
				.strength(3.0F, 6.0F)
				.sounds(ModBlockSoundGroup.COPPER_BULB)
				.requiresTool()
				.solidBlock(Blocks::never)
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
				.luminance(createLightLevelFromLitBlockState(8))
		)
	);
	public static final Block OXIDIZED_COPPER_BULB = register(
		"oxidized_copper_bulb",
		new OxidizableBulbBlock(
			Oxidizable.OxidationLevel.OXIDIZED,
			AbstractBlock.Settings.copy(COPPER_BULB)
				.mapColor(MapColor.TEAL)
				.luminance(createLightLevelFromLitBlockState(4))
		)
	);
	public static final Block WAXED_COPPER_BULB = register(
		"waxed_copper_bulb",
		new BulbBlock(
			AbstractBlock.Settings.copy(COPPER_BULB)
		)
	);
	
	public static final Block WAXED_EXPOSED_COPPER_BULB = register(
		"waxed_exposed_copper_bulb",
		new BulbBlock(
			AbstractBlock.Settings.copy(EXPOSED_COPPER_BULB)
		)
	);
	
	public static final Block WAXED_WEATHERED_COPPER_BULB = register(
		"waxed_weathered_copper_bulb",
		new BulbBlock(
			AbstractBlock.Settings.copy(WEATHERED_COPPER_BULB)
		)
	);
	public static final Block WAXED_OXIDIZED_COPPER_BULB = register(
		"waxed_oxidized_copper_bulb",
		new BulbBlock(
			AbstractBlock.Settings.copy(OXIDIZED_COPPER_BULB)
		)
	);
	
	private static <T extends Block> T register(String path, T block)
	{
		Registry.register(Registries.ITEM, new Identifier(path), new BlockItem(block, new Item.Settings()));
		return Registry.register(Registries.BLOCK, new Identifier(path), block);
	}
	
	
	public static void RegistriesBlocks()
	{
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.REDSTONE)
			.register(content->
			{
				content.addAfter(Blocks.TARGET, RegistriesBlocks.WAXED_COPPER_BULB);
				content.addAfter(RegistriesBlocks.WAXED_COPPER_BULB, RegistriesBlocks.WAXED_EXPOSED_COPPER_BULB);
				content.addAfter(RegistriesBlocks.WAXED_EXPOSED_COPPER_BULB, RegistriesBlocks.WAXED_WEATHERED_COPPER_BULB);
				content.addAfter(RegistriesBlocks.WAXED_WEATHERED_COPPER_BULB, RegistriesBlocks.WAXED_OXIDIZED_COPPER_BULB);
			});
		
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS)
			.register(content->
			{
				content.addAfter(Blocks.CUT_COPPER_SLAB, RegistriesBlocks.COPPER_BULB);
				content.addAfter(Blocks.EXPOSED_CUT_COPPER_SLAB, RegistriesBlocks.EXPOSED_COPPER_BULB);
				content.addAfter(Blocks.WEATHERED_CUT_COPPER_SLAB, RegistriesBlocks.WEATHERED_COPPER_BULB);
				content.addAfter(Blocks.OXIDIZED_CUT_COPPER_SLAB, RegistriesBlocks.OXIDIZED_COPPER_BULB);
				content.addAfter(Blocks.WAXED_CUT_COPPER_SLAB, RegistriesBlocks.WAXED_COPPER_BULB);
				content.addAfter(Blocks.WAXED_EXPOSED_CUT_COPPER_SLAB, RegistriesBlocks.WAXED_EXPOSED_COPPER_BULB);
				content.addAfter(Blocks.WAXED_WEATHERED_CUT_COPPER_SLAB, RegistriesBlocks.WAXED_WEATHERED_COPPER_BULB);
				content.addAfter(Blocks.WAXED_OXIDIZED_CUT_COPPER_SLAB, RegistriesBlocks.WAXED_OXIDIZED_COPPER_BULB);
			});
		
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL)
			.register(content->
			{
				content.addAfter(Blocks.REDSTONE_LAMP, RegistriesBlocks.COPPER_BULB);
				content.addAfter(RegistriesBlocks.COPPER_BULB, RegistriesBlocks.EXPOSED_COPPER_BULB);
				content.addAfter(RegistriesBlocks.EXPOSED_COPPER_BULB, RegistriesBlocks.WEATHERED_COPPER_BULB);
				content.addAfter(RegistriesBlocks.WEATHERED_COPPER_BULB, RegistriesBlocks.OXIDIZED_COPPER_BULB);
				content.addAfter(RegistriesBlocks.OXIDIZED_COPPER_BULB, RegistriesBlocks.WAXED_COPPER_BULB);
				content.addAfter(RegistriesBlocks.WAXED_COPPER_BULB, RegistriesBlocks.WAXED_EXPOSED_COPPER_BULB);
				content.addAfter(RegistriesBlocks.WAXED_EXPOSED_COPPER_BULB, RegistriesBlocks.WAXED_WEATHERED_COPPER_BULB);
				content.addAfter(RegistriesBlocks.WAXED_WEATHERED_COPPER_BULB, RegistriesBlocks.WAXED_OXIDIZED_COPPER_BULB);
			});
	}
}
